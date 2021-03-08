package com.baidu.ubc;
/* loaded from: classes6.dex */
public class i {
    private static volatile h oVF;

    public static synchronized h ehQ() {
        h hVar;
        synchronized (i.class) {
            if (oVF == null) {
                oVF = new h();
            }
            hVar = oVF;
        }
        return hVar;
    }
}
