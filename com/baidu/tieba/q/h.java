package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g nmy;

    public static synchronized g dKd() {
        g gVar;
        synchronized (h.class) {
            if (nmy == null) {
                nmy = new g();
            }
            gVar = nmy;
        }
        return gVar;
    }
}
