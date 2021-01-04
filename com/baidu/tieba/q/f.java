package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e nhv;

    public static synchronized e dLI() {
        e eVar;
        synchronized (f.class) {
            if (nhv == null) {
                nhv = new e();
            }
            eVar = nhv;
        }
        return eVar;
    }
}
