package com.baidu.ubc;
/* loaded from: classes14.dex */
public class i {
    private static volatile h mMm;

    public static synchronized h dAa() {
        h hVar;
        synchronized (i.class) {
            if (mMm == null) {
                mMm = new h();
            }
            hVar = mMm;
        }
        return hVar;
    }
}
