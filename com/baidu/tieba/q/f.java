package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class f {
    private static volatile e npd;

    public static synchronized e dKs() {
        e eVar;
        synchronized (f.class) {
            if (npd == null) {
                npd = new e();
            }
            eVar = npd;
        }
        return eVar;
    }
}
