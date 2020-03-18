package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f jDr;

    public static synchronized f cBs() {
        f fVar;
        synchronized (g.class) {
            if (jDr == null) {
                jDr = new f();
            }
            fVar = jDr;
        }
        return fVar;
    }
}
