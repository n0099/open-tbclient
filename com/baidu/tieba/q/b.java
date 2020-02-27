package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a jXu;

    public static synchronized a cIi() {
        a aVar;
        synchronized (b.class) {
            if (jXu == null) {
                jXu = new a();
            }
            aVar = jXu;
        }
        return aVar;
    }
}
