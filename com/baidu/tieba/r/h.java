package com.baidu.tieba.r;
/* loaded from: classes19.dex */
public class h {
    private static volatile g mNN;

    public static synchronized g dGE() {
        g gVar;
        synchronized (h.class) {
            if (mNN == null) {
                mNN = new g();
            }
            gVar = mNN;
        }
        return gVar;
    }
}
