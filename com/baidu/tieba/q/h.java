package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g kIB;

    public static synchronized g cTf() {
        g gVar;
        synchronized (h.class) {
            if (kIB == null) {
                kIB = new g();
            }
            gVar = kIB;
        }
        return gVar;
    }
}
