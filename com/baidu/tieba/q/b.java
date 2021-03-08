package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class b {
    private static volatile a npa;

    public static synchronized a dKq() {
        a aVar;
        synchronized (b.class) {
            if (npa == null) {
                npa = new a();
            }
            aVar = npa;
        }
        return aVar;
    }
}
