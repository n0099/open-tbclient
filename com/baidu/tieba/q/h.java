package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g nhv;

    public static synchronized g dLK() {
        g gVar;
        synchronized (h.class) {
            if (nhv == null) {
                nhv = new g();
            }
            gVar = nhv;
        }
        return gVar;
    }
}
