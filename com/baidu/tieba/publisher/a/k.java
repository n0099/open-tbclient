package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class k {
    private static volatile j jAL;

    public static synchronized j czA() {
        j jVar;
        synchronized (k.class) {
            if (jAL == null) {
                jAL = new j();
            }
            jVar = jAL;
        }
        return jVar;
    }
}
