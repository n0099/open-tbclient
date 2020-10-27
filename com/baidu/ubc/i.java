package com.baidu.ubc;
/* loaded from: classes20.dex */
public class i {
    private static volatile h ohz;

    public static synchronized h dZy() {
        h hVar;
        synchronized (i.class) {
            if (ohz == null) {
                ohz = new h();
            }
            hVar = ohz;
        }
        return hVar;
    }
}
