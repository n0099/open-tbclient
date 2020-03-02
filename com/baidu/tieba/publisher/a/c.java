package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class c {
    private static volatile b jBC;

    public static synchronized b cAT() {
        b bVar;
        synchronized (c.class) {
            if (jBC == null) {
                jBC = new b();
            }
            bVar = jBC;
        }
        return bVar;
    }
}
