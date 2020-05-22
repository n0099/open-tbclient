package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a laN;

    public static synchronized a daf() {
        a aVar;
        synchronized (b.class) {
            if (laN == null) {
                laN = new a();
            }
            aVar = laN;
        }
        return aVar;
    }
}
