package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l lAi;

    public static synchronized l dfT() {
        l lVar;
        synchronized (m.class) {
            if (lAi == null) {
                lAi = new l();
            }
            lVar = lAi;
        }
        return lVar;
    }
}
