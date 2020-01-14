package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class k {
    private static volatile j jAQ;

    public static synchronized j czC() {
        j jVar;
        synchronized (k.class) {
            if (jAQ == null) {
                jAQ = new j();
            }
            jVar = jAQ;
        }
        return jVar;
    }
}
