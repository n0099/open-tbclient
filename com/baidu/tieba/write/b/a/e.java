package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d mpe;

    public static synchronized d drK() {
        d dVar;
        synchronized (e.class) {
            if (mpe == null) {
                mpe = new d();
            }
            dVar = mpe;
        }
        return dVar;
    }
}
