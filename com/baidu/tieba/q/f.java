package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e nmx;

    public static synchronized e dKc() {
        e eVar;
        synchronized (f.class) {
            if (nmx == null) {
                nmx = new e();
            }
            eVar = nmx;
        }
        return eVar;
    }
}
