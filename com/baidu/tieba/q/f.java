package com.baidu.tieba.q;
/* loaded from: classes19.dex */
public class f {
    private static volatile e meK;

    public static synchronized e dxq() {
        e eVar;
        synchronized (f.class) {
            if (meK == null) {
                meK = new e();
            }
            eVar = meK;
        }
        return eVar;
    }
}
