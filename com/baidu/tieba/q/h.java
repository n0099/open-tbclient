package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class h {
    private static volatile g lUU;

    public static synchronized g dtu() {
        g gVar;
        synchronized (h.class) {
            if (lUU == null) {
                lUU = new g();
            }
            gVar = lUU;
        }
        return gVar;
    }
}
