package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class h {
    private static volatile g muo;

    public static synchronized g dBd() {
        g gVar;
        synchronized (h.class) {
            if (muo == null) {
                muo = new g();
            }
            gVar = muo;
        }
        return gVar;
    }
}
