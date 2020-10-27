package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class h {
    private static volatile g mGU;

    public static synchronized g dEl() {
        g gVar;
        synchronized (h.class) {
            if (mGU == null) {
                mGU = new g();
            }
            gVar = mGU;
        }
        return gVar;
    }
}
