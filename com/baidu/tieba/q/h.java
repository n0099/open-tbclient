package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class h {
    private static volatile g lDo;

    public static synchronized g dhZ() {
        g gVar;
        synchronized (h.class) {
            if (lDo == null) {
                lDo = new g();
            }
            gVar = lDo;
        }
        return gVar;
    }
}
