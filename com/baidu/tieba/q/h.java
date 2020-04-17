package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g kIx;

    public static synchronized g cTh() {
        g gVar;
        synchronized (h.class) {
            if (kIx == null) {
                kIx = new g();
            }
            gVar = kIx;
        }
        return gVar;
    }
}
