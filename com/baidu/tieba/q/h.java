package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class h {
    private static volatile g ncQ;

    public static synchronized g dHS() {
        g gVar;
        synchronized (h.class) {
            if (ncQ == null) {
                ncQ = new g();
            }
            gVar = ncQ;
        }
        return gVar;
    }
}
