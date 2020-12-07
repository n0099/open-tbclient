package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d nXh;

    public static synchronized d dZj() {
        d dVar;
        synchronized (e.class) {
            if (nXh == null) {
                nXh = new d();
            }
            dVar = nXh;
        }
        return dVar;
    }
}
