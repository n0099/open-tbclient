package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j jBU;

    public static synchronized j cBa() {
        j jVar;
        synchronized (k.class) {
            if (jBU == null) {
                jBU = new j();
            }
            jVar = jBU;
        }
        return jVar;
    }
}
