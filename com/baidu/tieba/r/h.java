package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class h {
    private static volatile g nbS;

    public static synchronized g dLS() {
        g gVar;
        synchronized (h.class) {
            if (nbS == null) {
                nbS = new g();
            }
            gVar = nbS;
        }
        return gVar;
    }
}
