package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a kIt;

    public static synchronized a cTd() {
        a aVar;
        synchronized (b.class) {
            if (kIt == null) {
                kIt = new a();
            }
            aVar = kIt;
        }
        return aVar;
    }
}
