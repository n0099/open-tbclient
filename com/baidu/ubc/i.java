package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h oTA;

    public static synchronized h ehI() {
        h hVar;
        synchronized (i.class) {
            if (oTA == null) {
                oTA = new h();
            }
            hVar = oTA;
        }
        return hVar;
    }
}
