package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface wdb {

    /* loaded from: classes8.dex */
    public interface a {
        void a(String str, wdb wdbVar);
    }

    void cancel();

    boolean isRunning();

    void pause();

    void start();
}
