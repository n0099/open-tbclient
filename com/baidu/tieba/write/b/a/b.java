package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a nHu;

    public static synchronized a dTO() {
        a aVar;
        synchronized (b.class) {
            if (nHu == null) {
                nHu = new a();
            }
            aVar = nHu;
        }
        return aVar;
    }
}
