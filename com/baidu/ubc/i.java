package com.baidu.ubc;
/* loaded from: classes20.dex */
public class i {
    private static volatile h oHl;

    public static synchronized h eiO() {
        h hVar;
        synchronized (i.class) {
            if (oHl == null) {
                oHl = new h();
            }
            hVar = oHl;
        }
        return hVar;
    }
}
