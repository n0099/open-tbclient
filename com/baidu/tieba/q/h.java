package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g nhw;

    public static synchronized g dLJ() {
        g gVar;
        synchronized (h.class) {
            if (nhw == null) {
                nhw = new g();
            }
            gVar = nhw;
        }
        return gVar;
    }
}
