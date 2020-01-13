package com.baidu.tieba.p;
/* loaded from: classes5.dex */
public class b {
    private static volatile a jWp;

    public static synchronized a cGC() {
        a aVar;
        synchronized (b.class) {
            if (jWp == null) {
                jWp = new a();
            }
            aVar = jWp;
        }
        return aVar;
    }
}
