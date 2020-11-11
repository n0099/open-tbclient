package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class f {
    private static volatile e mMT;

    public static synchronized e dGL() {
        e eVar;
        synchronized (f.class) {
            if (mMT == null) {
                mMT = new e();
            }
            eVar = mMT;
        }
        return eVar;
    }
}
