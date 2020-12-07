package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class f {
    private static volatile e nbO;

    public static synchronized e dLQ() {
        e eVar;
        synchronized (f.class) {
            if (nbO == null) {
                nbO = new e();
            }
            eVar = nbO;
        }
        return eVar;
    }
}
