package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e laQ;

    public static synchronized e dah() {
        e eVar;
        synchronized (f.class) {
            if (laQ == null) {
                laQ = new e();
            }
            eVar = laQ;
        }
        return eVar;
    }
}
