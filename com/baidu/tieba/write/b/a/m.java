package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l mpf;

    public static synchronized l drK() {
        l lVar;
        synchronized (m.class) {
            if (mpf == null) {
                mpf = new l();
            }
            lVar = mpf;
        }
        return lVar;
    }
}
