package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a jXI;

    public static synchronized a cIl() {
        a aVar;
        synchronized (b.class) {
            if (jXI == null) {
                jXI = new a();
            }
            aVar = jXI;
        }
        return aVar;
    }
}
