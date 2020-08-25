package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class f {
    private static volatile e lUT;

    public static synchronized e dts() {
        e eVar;
        synchronized (f.class) {
            if (lUT == null) {
                lUT = new e();
            }
            eVar = lUT;
        }
        return eVar;
    }
}
