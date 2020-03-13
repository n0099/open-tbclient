package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class c {
    private static volatile b jBO;

    public static synchronized b cAU() {
        b bVar;
        synchronized (c.class) {
            if (jBO == null) {
                jBO = new b();
            }
            bVar = jBO;
        }
        return bVar;
    }
}
