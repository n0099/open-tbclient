package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e nmX;

    public static synchronized e dKk() {
        e eVar;
        synchronized (f.class) {
            if (nmX == null) {
                nmX = new e();
            }
            eVar = nmX;
        }
        return eVar;
    }
}
