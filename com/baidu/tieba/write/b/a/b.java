package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a lUB;

    public static synchronized a dnr() {
        a aVar;
        synchronized (b.class) {
            if (lUB == null) {
                lUB = new a();
            }
            aVar = lUB;
        }
        return aVar;
    }
}
