package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class b {
    private static volatile a mMQ;

    public static synchronized a dGJ() {
        a aVar;
        synchronized (b.class) {
            if (mMQ == null) {
                mMQ = new a();
            }
            aVar = mMQ;
        }
        return aVar;
    }
}
