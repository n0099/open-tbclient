package com.baidu.tieba.r;
/* loaded from: classes19.dex */
public class f {
    private static volatile e mNM;

    public static synchronized e dGC() {
        e eVar;
        synchronized (f.class) {
            if (mNM == null) {
                mNM = new e();
            }
            eVar = mNM;
        }
        return eVar;
    }
}
