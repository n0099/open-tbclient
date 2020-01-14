package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class i {
    private static volatile h jAP;

    public static synchronized h czB() {
        h hVar;
        synchronized (i.class) {
            if (jAP == null) {
                jAP = new h();
            }
            hVar = jAP;
        }
        return hVar;
    }
}
