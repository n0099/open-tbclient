package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class c {
    private static volatile b jAK;

    public static synchronized b czw() {
        b bVar;
        synchronized (c.class) {
            if (jAK == null) {
                jAK = new b();
            }
            bVar = jAK;
        }
        return bVar;
    }
}
