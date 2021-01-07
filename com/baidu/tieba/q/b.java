package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a nhr;

    public static synchronized a dLH() {
        a aVar;
        synchronized (b.class) {
            if (nhr == null) {
                nhr = new a();
            }
            aVar = nhr;
        }
        return aVar;
    }
}
