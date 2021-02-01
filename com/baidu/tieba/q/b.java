package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a nmu;

    public static synchronized a dKa() {
        a aVar;
        synchronized (b.class) {
            if (nmu == null) {
                nmu = new a();
            }
            aVar = nmu;
        }
        return aVar;
    }
}
