package com.baidu.tieba.publisher.a;
/* loaded from: classes4.dex */
public class c {
    private static volatile b jxd;

    public static synchronized b cyn() {
        b bVar;
        synchronized (c.class) {
            if (jxd == null) {
                jxd = new b();
            }
            bVar = jxd;
        }
        return bVar;
    }
}
