package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c jXx;

    public static synchronized c cIl() {
        c cVar;
        synchronized (d.class) {
            if (jXx == null) {
                jXx = new c();
            }
            cVar = jXx;
        }
        return cVar;
    }
}
