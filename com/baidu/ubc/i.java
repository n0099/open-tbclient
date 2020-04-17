package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h lNH;

    public static synchronized h dkC() {
        h hVar;
        synchronized (i.class) {
            if (lNH == null) {
                lNH = new h();
            }
            hVar = lNH;
        }
        return hVar;
    }
}
