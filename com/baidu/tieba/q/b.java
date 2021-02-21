package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a nmU;

    public static synchronized a dKi() {
        a aVar;
        synchronized (b.class) {
            if (nmU == null) {
                nmU = new a();
            }
            aVar = nmU;
        }
        return aVar;
    }
}
