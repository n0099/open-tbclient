package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class f {
    private static volatile e nbQ;

    public static synchronized e dLR() {
        e eVar;
        synchronized (f.class) {
            if (nbQ == null) {
                nbQ = new e();
            }
            eVar = nbQ;
        }
        return eVar;
    }
}
