package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h oTa;

    public static synchronized h ehA() {
        h hVar;
        synchronized (i.class) {
            if (oTa == null) {
                oTa = new h();
            }
            hVar = oTa;
        }
        return hVar;
    }
}
