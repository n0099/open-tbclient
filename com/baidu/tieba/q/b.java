package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a jZk;

    public static synchronized a cIF() {
        a aVar;
        synchronized (b.class) {
            if (jZk == null) {
                jZk = new a();
            }
            aVar = jZk;
        }
        return aVar;
    }
}
