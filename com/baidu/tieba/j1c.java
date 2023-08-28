package com.baidu.tieba;

import android.os.Message;
/* loaded from: classes6.dex */
public interface j1c {

    /* loaded from: classes6.dex */
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
