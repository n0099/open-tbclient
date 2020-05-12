package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h lAk;

    public static synchronized h dfP() {
        h hVar;
        synchronized (i.class) {
            if (lAk == null) {
                lAk = new h();
            }
            hVar = lAk;
        }
        return hVar;
    }
}
