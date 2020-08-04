package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class f {
    private static volatile e lDp;

    public static synchronized e dhX() {
        e eVar;
        synchronized (f.class) {
            if (lDp == null) {
                lDp = new e();
            }
            eVar = lDp;
        }
        return eVar;
    }
}
