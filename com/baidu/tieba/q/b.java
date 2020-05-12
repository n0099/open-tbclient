package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a kIx;

    public static synchronized a cTb() {
        a aVar;
        synchronized (b.class) {
            if (kIx == null) {
                kIx = new a();
            }
            aVar = kIx;
        }
        return aVar;
    }
}
