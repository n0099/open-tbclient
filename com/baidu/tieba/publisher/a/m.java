package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l jBH;

    public static synchronized l cAY() {
        l lVar;
        synchronized (m.class) {
            if (jBH == null) {
                jBH = new l();
            }
            lVar = jBH;
        }
        return lVar;
    }
}
