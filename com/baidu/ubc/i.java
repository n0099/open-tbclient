package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h mEf;

    public static synchronized h dwJ() {
        h hVar;
        synchronized (i.class) {
            if (mEf == null) {
                mEf = new h();
            }
            hVar = mEf;
        }
        return hVar;
    }
}
