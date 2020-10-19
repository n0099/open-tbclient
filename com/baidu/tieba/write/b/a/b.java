package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a npb;

    public static synchronized a dOg() {
        a aVar;
        synchronized (b.class) {
            if (npb == null) {
                npb = new a();
            }
            aVar = npb;
        }
        return aVar;
    }
}
