package com.baidu.ubc;
/* loaded from: classes14.dex */
public class i {
    private static volatile h mMo;

    public static synchronized h dAb() {
        h hVar;
        synchronized (i.class) {
            if (mMo == null) {
                mMo = new h();
            }
            hVar = mMo;
        }
        return hVar;
    }
}
