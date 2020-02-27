package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f jBE;

    public static synchronized f cAV() {
        f fVar;
        synchronized (g.class) {
            if (jBE == null) {
                jBE = new f();
            }
            fVar = jBE;
        }
        return fVar;
    }
}
