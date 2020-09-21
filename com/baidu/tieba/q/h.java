package com.baidu.tieba.q;
/* loaded from: classes19.dex */
public class h {
    private static volatile g meL;

    public static synchronized g dxs() {
        g gVar;
        synchronized (h.class) {
            if (meL == null) {
                meL = new g();
            }
            gVar = meL;
        }
        return gVar;
    }
}
