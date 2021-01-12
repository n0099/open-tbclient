package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class f {
    private static volatile e ncP;

    public static synchronized e dHR() {
        e eVar;
        synchronized (f.class) {
            if (ncP == null) {
                ncP = new e();
            }
            eVar = ncP;
        }
        return eVar;
    }
}
