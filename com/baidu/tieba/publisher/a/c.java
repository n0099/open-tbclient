package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class c {
    private static volatile b jBA;

    public static synchronized b cAR() {
        b bVar;
        synchronized (c.class) {
            if (jBA == null) {
                jBA = new b();
            }
            bVar = jBA;
        }
        return bVar;
    }
}
