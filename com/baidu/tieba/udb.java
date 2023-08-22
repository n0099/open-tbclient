package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface udb {

    /* loaded from: classes8.dex */
    public interface a {
        void a(String str, udb udbVar);
    }

    void cancel();

    boolean isRunning();

    void pause();

    void start();
}
