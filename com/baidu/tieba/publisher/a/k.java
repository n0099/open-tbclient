package com.baidu.tieba.publisher.a;
/* loaded from: classes4.dex */
public class k {
    private static volatile j jxj;

    public static synchronized j cyt() {
        j jVar;
        synchronized (k.class) {
            if (jxj == null) {
                jxj = new j();
            }
            jVar = jxj;
        }
        return jVar;
    }
}
