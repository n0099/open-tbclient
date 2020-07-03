package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d mpb;

    public static synchronized d drG() {
        d dVar;
        synchronized (e.class) {
            if (mpb == null) {
                mpb = new d();
            }
            dVar = mpb;
        }
        return dVar;
    }
}
