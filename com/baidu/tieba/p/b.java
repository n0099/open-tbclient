package com.baidu.tieba.p;
/* loaded from: classes5.dex */
public class b {
    private static volatile a jWu;

    public static synchronized a cGE() {
        a aVar;
        synchronized (b.class) {
            if (jWu == null) {
                jWu = new a();
            }
            aVar = jWu;
        }
        return aVar;
    }
}
