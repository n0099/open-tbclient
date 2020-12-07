package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class h {
    private static volatile g nbQ;

    public static synchronized g dLR() {
        g gVar;
        synchronized (h.class) {
            if (nbQ == null) {
                nbQ = new g();
            }
            gVar = nbQ;
        }
        return gVar;
    }
}
