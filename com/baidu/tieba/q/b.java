package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a jXw;

    public static synchronized a cIk() {
        a aVar;
        synchronized (b.class) {
            if (jXw == null) {
                jXw = new a();
            }
            aVar = jXw;
        }
        return aVar;
    }
}
