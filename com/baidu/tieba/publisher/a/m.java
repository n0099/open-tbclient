package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l jDu;

    public static synchronized l cBv() {
        l lVar;
        synchronized (m.class) {
            if (jDu == null) {
                jDu = new l();
            }
            lVar = jDu;
        }
        return lVar;
    }
}
