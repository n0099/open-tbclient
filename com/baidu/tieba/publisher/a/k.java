package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j jBG;

    public static synchronized j cAX() {
        j jVar;
        synchronized (k.class) {
            if (jBG == null) {
                jBG = new j();
            }
            jVar = jBG;
        }
        return jVar;
    }
}
