package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f lAf;

    public static synchronized f dfQ() {
        f fVar;
        synchronized (g.class) {
            if (lAf == null) {
                lAf = new f();
            }
            fVar = lAf;
        }
        return fVar;
    }
}
