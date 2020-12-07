package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class p {
    private static volatile o nbT;

    public static synchronized o dLV() {
        o oVar;
        synchronized (p.class) {
            if (nbT == null) {
                nbT = new o();
            }
            oVar = nbT;
        }
        return oVar;
    }
}
