package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class d {
    private static volatile c nbN;

    public static synchronized c dLP() {
        c cVar;
        synchronized (d.class) {
            if (nbN == null) {
                nbN = new c();
            }
            cVar = nbN;
        }
        return cVar;
    }
}
