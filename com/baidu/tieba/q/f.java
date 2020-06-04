package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e lbZ;

    public static synchronized e dax() {
        e eVar;
        synchronized (f.class) {
            if (lbZ == null) {
                lbZ = new e();
            }
            eVar = lbZ;
        }
        return eVar;
    }
}
