package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j jDt;

    public static synchronized j cBu() {
        j jVar;
        synchronized (k.class) {
            if (jDt == null) {
                jDt = new j();
            }
            jVar = jDt;
        }
        return jVar;
    }
}
