package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class h {
    private static volatile g mMU;

    public static synchronized g dGN() {
        g gVar;
        synchronized (h.class) {
            if (mMU == null) {
                mMU = new g();
            }
            gVar = mMU;
        }
        return gVar;
    }
}
