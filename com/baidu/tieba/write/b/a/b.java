package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a nXb;

    public static synchronized a dZh() {
        a aVar;
        synchronized (b.class) {
            if (nXb == null) {
                nXb = new a();
            }
            aVar = nXb;
        }
        return aVar;
    }
}
