package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class m {
    private static volatile l jAR;

    public static synchronized l czD() {
        l lVar;
        synchronized (m.class) {
            if (jAR == null) {
                jAR = new l();
            }
            lVar = jAR;
        }
        return lVar;
    }
}
