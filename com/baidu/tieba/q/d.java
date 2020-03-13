package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c jXJ;

    public static synchronized c cIm() {
        c cVar;
        synchronized (d.class) {
            if (jXJ == null) {
                jXJ = new c();
            }
            cVar = jXJ;
        }
        return cVar;
    }
}
