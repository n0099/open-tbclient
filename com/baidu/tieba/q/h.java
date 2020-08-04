package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class h {
    private static volatile g lDq;

    public static synchronized g dhZ() {
        g gVar;
        synchronized (h.class) {
            if (lDq == null) {
                lDq = new g();
            }
            gVar = lDq;
        }
        return gVar;
    }
}
