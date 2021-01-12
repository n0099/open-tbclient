package com.baidu.ubc;
/* loaded from: classes6.dex */
public class i {
    private static volatile h oIR;

    public static synchronized h efi() {
        h hVar;
        synchronized (i.class) {
            if (oIR == null) {
                oIR = new h();
            }
            hVar = oIR;
        }
        return hVar;
    }
}
