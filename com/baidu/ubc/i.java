package com.baidu.ubc;
/* loaded from: classes14.dex */
public class i {
    private static volatile h nfk;

    public static synchronized h dLO() {
        h hVar;
        synchronized (i.class) {
            if (nfk == null) {
                nfk = new h();
            }
            hVar = nfk;
        }
        return hVar;
    }
}
