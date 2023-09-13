package com.baidu.tieba;

import android.os.Message;
/* loaded from: classes7.dex */
public interface m4c {

    /* loaded from: classes7.dex */
    public interface a {
        void handleMessage(Message message);

        void onPause();

        void onResume();

        void onStart();

        void onStop();
    }

    boolean a(int i, long j);

    void b(a aVar);

    void c();

    void d(int i);

    boolean e(Runnable runnable);

    boolean f(int i);

    void g(int i);

    int getStatus();

    boolean sendMessage(Message message);

    void setName(String str);

    void start();
}
