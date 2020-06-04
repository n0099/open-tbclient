package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d lUH;

    public static synchronized d dnu() {
        d dVar;
        synchronized (e.class) {
            if (lUH == null) {
                lUH = new d();
            }
            dVar = lUH;
        }
        return dVar;
    }
}
