package com.baidu.ubc;
/* loaded from: classes20.dex */
public class i {
    private static volatile h oqE;

    public static synchronized h edg() {
        h hVar;
        synchronized (i.class) {
            if (oqE == null) {
                oqE = new h();
            }
            hVar = oqE;
        }
        return hVar;
    }
}
