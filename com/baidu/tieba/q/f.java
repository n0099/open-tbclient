package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e kIw;

    public static synchronized e cTf() {
        e eVar;
        synchronized (f.class) {
            if (kIw == null) {
                kIw = new e();
            }
            eVar = kIw;
        }
        return eVar;
    }
}
