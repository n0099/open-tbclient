package com.baidu.ubc;
/* loaded from: classes19.dex */
public class i {
    private static volatile h osi;

    public static synchronized h edf() {
        h hVar;
        synchronized (i.class) {
            if (osi == null) {
                osi = new h();
            }
            hVar = osi;
        }
        return hVar;
    }
}
