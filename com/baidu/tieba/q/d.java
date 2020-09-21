package com.baidu.tieba.q;
/* loaded from: classes19.dex */
public class d {
    private static volatile c meJ;

    public static synchronized c dxp() {
        c cVar;
        synchronized (d.class) {
            if (meJ == null) {
                meJ = new c();
            }
            cVar = meJ;
        }
        return cVar;
    }
}
