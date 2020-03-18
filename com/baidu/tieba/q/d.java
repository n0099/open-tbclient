package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c jZl;

    public static synchronized c cIG() {
        c cVar;
        synchronized (d.class) {
            if (jZl == null) {
                jZl = new c();
            }
            cVar = jZl;
        }
        return cVar;
    }
}
