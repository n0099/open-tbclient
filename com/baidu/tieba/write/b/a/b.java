package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a nXd;

    public static synchronized a dZi() {
        a aVar;
        synchronized (b.class) {
            if (nXd == null) {
                nXd = new a();
            }
            aVar = nXd;
        }
        return aVar;
    }
}
