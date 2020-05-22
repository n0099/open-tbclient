package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g laR;

    public static synchronized g daj() {
        g gVar;
        synchronized (h.class) {
            if (laR == null) {
                laR = new g();
            }
            gVar = laR;
        }
        return gVar;
    }
}
