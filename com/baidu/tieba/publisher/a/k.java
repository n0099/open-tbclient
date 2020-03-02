package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j jBI;

    public static synchronized j cAZ() {
        j jVar;
        synchronized (k.class) {
            if (jBI == null) {
                jBI = new j();
            }
            jVar = jBI;
        }
        return jVar;
    }
}
