package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h mil;

    public static synchronized h dse() {
        h hVar;
        synchronized (i.class) {
            if (mil == null) {
                mil = new h();
            }
            hVar = mil;
        }
        return hVar;
    }
}
