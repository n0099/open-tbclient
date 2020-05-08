package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a lAb;

    public static synchronized a dfK() {
        a aVar;
        synchronized (b.class) {
            if (lAb == null) {
                lAb = new a();
            }
            aVar = lAb;
        }
        return aVar;
    }
}
