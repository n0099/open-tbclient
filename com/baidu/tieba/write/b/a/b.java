package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a nBA;

    public static synchronized a dRo() {
        a aVar;
        synchronized (b.class) {
            if (nBA == null) {
                nBA = new a();
            }
            aVar = nBA;
        }
        return aVar;
    }
}
