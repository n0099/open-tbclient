package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class f {
    private static volatile e lDn;

    public static synchronized e dhX() {
        e eVar;
        synchronized (f.class) {
            if (lDn == null) {
                lDn = new e();
            }
            eVar = lDn;
        }
        return eVar;
    }
}
