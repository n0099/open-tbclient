package com.baidu.ubc;
/* loaded from: classes6.dex */
public class i {
    private static volatile h oIS;

    public static synchronized h efi() {
        h hVar;
        synchronized (i.class) {
            if (oIS == null) {
                oIS = new h();
            }
            hVar = oIS;
        }
        return hVar;
    }
}
