package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h mEi;

    public static synchronized h dwN() {
        h hVar;
        synchronized (i.class) {
            if (mEi == null) {
                mEi = new h();
            }
            hVar = mEi;
        }
        return hVar;
    }
}
