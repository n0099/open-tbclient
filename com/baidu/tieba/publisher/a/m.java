package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l jBJ;

    public static synchronized l cBa() {
        l lVar;
        synchronized (m.class) {
            if (jBJ == null) {
                jBJ = new l();
            }
            lVar = jBJ;
        }
        return lVar;
    }
}
