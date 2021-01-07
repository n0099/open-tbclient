package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e nhu;

    public static synchronized e dLJ() {
        e eVar;
        synchronized (f.class) {
            if (nhu == null) {
                nhu = new e();
            }
            eVar = nhu;
        }
        return eVar;
    }
}
