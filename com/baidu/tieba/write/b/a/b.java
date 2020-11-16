package com.baidu.tieba.write.b.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a nIV;

    public static synchronized a dTN() {
        a aVar;
        synchronized (b.class) {
            if (nIV == null) {
                nIV = new a();
            }
            aVar = nIV;
        }
        return aVar;
    }
}
