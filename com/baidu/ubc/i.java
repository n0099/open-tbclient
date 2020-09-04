package com.baidu.ubc;
/* loaded from: classes14.dex */
public class i {
    private static volatile h nfC;

    public static synchronized h dLX() {
        h hVar;
        synchronized (i.class) {
            if (nfC == null) {
                nfC = new h();
            }
            hVar = nfC;
        }
        return hVar;
    }
}
