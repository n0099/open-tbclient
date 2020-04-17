package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h lAg;

    public static synchronized h dfR() {
        h hVar;
        synchronized (i.class) {
            if (lAg == null) {
                lAg = new h();
            }
            hVar = lAg;
        }
        return hVar;
    }
}
