package com.example.test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getApplicationContext(), "메시지 출력", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 100);
        toast.show();

        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("익명클래스 구현부1");
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(getApplicationContext(), "메시지 출력", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 200);
                        toast.show();
                    }
                });

            }
        });
        t.start();


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("익명클래스 구현부2");
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(getApplicationContext(), "메시지 출력", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 300);
                        toast.show();
                    }
                });


            }
        });
        t2.start();

//        Thread t3 = new Thread(new Runnable() {
//            public void run() {
//                System.out.println("익명클래스 구현부3");
//                Handler handler = new Handler(Looper.getMainLooper());
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(parallelSum()), Toast.LENGTH_SHORT);
//                        toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 500);
//                        toast.show();
//                    }
//                });
//
//
//            }
//        });
//        t3.start();
//
//        Log.d("parallelSum():", String.valueOf(parallelSum()));

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                System.out.println("익명클래스 구현부3");
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(parallelSub()), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 600);
                        toast.show();
                    }
                });


            }
        });
        t4.start();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(parallelSub()), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 10, 600);
                toast.show();
            }
        });


        // parallelSum()
        Handler handler1 = new Handler(Looper.getMainLooper());
        handler1.post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(parallelSum(3)), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 50, 800);
                toast.show();
            }
        });

        Handler handler2 = new Handler(Looper.getMainLooper());
        handler2.post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(parallelSum(33333)), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 50, 800);
                toast.show();
            }
        });
    }


    public void test(String msg) {
        Log.d("test()",msg);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public long parallelSum(int n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public long parallelSub() {
        return Stream.iterate(1L, i -> i - 1).limit(5522).parallel().reduce(0L, Long::sum);
    }

}