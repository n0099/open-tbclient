package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f jBG;

    public static synchronized f cAX() {
        f fVar;
        synchronized (g.class) {
            if (jBG == null) {
                jBG = new f();
            }
            fVar = jBG;
        }
        return fVar;
    }
}
