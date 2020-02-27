package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c jXv;

    public static synchronized c cIj() {
        c cVar;
        synchronized (d.class) {
            if (jXv == null) {
                jXv = new c();
            }
            cVar = jXv;
        }
        return cVar;
    }
}
