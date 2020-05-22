package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h lTy;

    public static synchronized h dnf() {
        h hVar;
        synchronized (i.class) {
            if (lTy == null) {
                lTy = new h();
            }
            hVar = lTy;
        }
        return hVar;
    }
}
