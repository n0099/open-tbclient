package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class c {
    private static volatile b jAF;

    public static synchronized b czu() {
        b bVar;
        synchronized (c.class) {
            if (jAF == null) {
                jAF = new b();
            }
            bVar = jAF;
        }
        return bVar;
    }
}
