package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a lTq;

    public static synchronized a dnb() {
        a aVar;
        synchronized (b.class) {
            if (lTq == null) {
                lTq = new a();
            }
            aVar = lTq;
        }
        return aVar;
    }
}
