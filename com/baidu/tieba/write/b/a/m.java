package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l lAm;

    public static synchronized l dfQ() {
        l lVar;
        synchronized (m.class) {
            if (lAm == null) {
                lAm = new l();
            }
            lVar = lAm;
        }
        return lVar;
    }
}
