package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l jBV;

    public static synchronized l cBb() {
        l lVar;
        synchronized (m.class) {
            if (jBV == null) {
                jBV = new l();
            }
            lVar = jBV;
        }
        return lVar;
    }
}
