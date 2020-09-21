package com.baidu.ubc;
/* loaded from: classes19.dex */
public class i {
    private static volatile h npD;

    public static synchronized h dPV() {
        h hVar;
        synchronized (i.class) {
            if (npD == null) {
                npD = new h();
            }
            hVar = npD;
        }
        return hVar;
    }
}
