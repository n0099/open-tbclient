package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class p {
    private static volatile o nbV;

    public static synchronized o dLW() {
        o oVar;
        synchronized (p.class) {
            if (nbV == null) {
                nbV = new o();
            }
            oVar = nbV;
        }
        return oVar;
    }
}
