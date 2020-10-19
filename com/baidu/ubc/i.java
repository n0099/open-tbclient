package com.baidu.ubc;
/* loaded from: classes20.dex */
public class i {
    private static volatile h nEX;

    public static synchronized h dTG() {
        h hVar;
        synchronized (i.class) {
            if (nEX == null) {
                nEX = new h();
            }
            hVar = nEX;
        }
        return hVar;
    }
}
