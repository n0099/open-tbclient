package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h lNL;

    public static synchronized h dkz() {
        h hVar;
        synchronized (i.class) {
            if (lNL == null) {
                lNL = new h();
            }
            hVar = lNL;
        }
        return hVar;
    }
}
