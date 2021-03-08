package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class h {
    private static volatile g npe;

    public static synchronized g dKt() {
        g gVar;
        synchronized (h.class) {
            if (npe == null) {
                npe = new g();
            }
            gVar = npe;
        }
        return gVar;
    }
}
