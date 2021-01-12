package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class d {
    private static volatile c ncN;

    public static synchronized c dHQ() {
        c cVar;
        synchronized (d.class) {
            if (ncN == null) {
                ncN = new c();
            }
            cVar = ncN;
        }
        return cVar;
    }
}
