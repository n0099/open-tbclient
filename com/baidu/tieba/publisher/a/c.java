package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class c {
    private static volatile b jDn;

    public static synchronized b cBo() {
        b bVar;
        synchronized (c.class) {
            if (jDn == null) {
                jDn = new b();
            }
            bVar = jDn;
        }
        return bVar;
    }
}
