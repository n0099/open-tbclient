package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class m {
    private static volatile l jAM;

    public static synchronized l czB() {
        l lVar;
        synchronized (m.class) {
            if (jAM == null) {
                jAM = new l();
            }
            lVar = jAM;
        }
        return lVar;
    }
}
