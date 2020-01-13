package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class i {
    private static volatile h jAK;

    public static synchronized h czz() {
        h hVar;
        synchronized (i.class) {
            if (jAK == null) {
                jAK = new h();
            }
            hVar = jAK;
        }
        return hVar;
    }
}
