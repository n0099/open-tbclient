package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class b {
    private static volatile a nbO;

    public static synchronized a dLP() {
        a aVar;
        synchronized (b.class) {
            if (nbO == null) {
                nbO = new a();
            }
            aVar = nbO;
        }
        return aVar;
    }
}
