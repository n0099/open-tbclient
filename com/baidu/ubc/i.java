package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h oNw;

    public static synchronized h eja() {
        h hVar;
        synchronized (i.class) {
            if (oNw == null) {
                oNw = new h();
            }
            hVar = oNw;
        }
        return hVar;
    }
}
