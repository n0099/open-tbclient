package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f jBS;

    public static synchronized f cAY() {
        f fVar;
        synchronized (g.class) {
            if (jBS == null) {
                jBS = new f();
            }
            fVar = jBS;
        }
        return fVar;
    }
}
