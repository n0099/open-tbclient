package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e kIA;

    public static synchronized e cTc() {
        e eVar;
        synchronized (f.class) {
            if (kIA == null) {
                kIA = new e();
            }
            eVar = kIA;
        }
        return eVar;
    }
}
