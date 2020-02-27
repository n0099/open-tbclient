package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h jBF;

    public static synchronized h cAW() {
        h hVar;
        synchronized (i.class) {
            if (jBF == null) {
                jBF = new h();
            }
            hVar = jBF;
        }
        return hVar;
    }
}
