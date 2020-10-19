package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class f {
    private static volatile e mun;

    public static synchronized e dBb() {
        e eVar;
        synchronized (f.class) {
            if (mun == null) {
                mun = new e();
            }
            eVar = mun;
        }
        return eVar;
    }
}
