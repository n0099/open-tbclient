package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class d {
    private static volatile c nbP;

    public static synchronized c dLQ() {
        c cVar;
        synchronized (d.class) {
            if (nbP == null) {
                nbP = new c();
            }
            cVar = nbP;
        }
        return cVar;
    }
}
