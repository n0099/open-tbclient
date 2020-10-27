package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class f {
    private static volatile e mGT;

    public static synchronized e dEj() {
        e eVar;
        synchronized (f.class) {
            if (mGT == null) {
                mGT = new e();
            }
            eVar = mGT;
        }
        return eVar;
    }
}
