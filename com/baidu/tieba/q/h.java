package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class h {
    private static volatile g lVj;

    public static synchronized g dtz() {
        g gVar;
        synchronized (h.class) {
            if (lVj == null) {
                lVj = new g();
            }
            gVar = lVj;
        }
        return gVar;
    }
}
