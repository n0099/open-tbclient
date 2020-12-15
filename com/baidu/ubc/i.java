package com.baidu.ubc;
/* loaded from: classes20.dex */
public class i {
    private static volatile h oHn;

    public static synchronized h eiP() {
        h hVar;
        synchronized (i.class) {
            if (oHn == null) {
                oHn = new h();
            }
            hVar = oHn;
        }
        return hVar;
    }
}
