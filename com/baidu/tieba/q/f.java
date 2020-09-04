package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class f {
    private static volatile e lVi;

    public static synchronized e dtx() {
        e eVar;
        synchronized (f.class) {
            if (lVi == null) {
                lVi = new e();
            }
            eVar = lVi;
        }
        return eVar;
    }
}
