package com.baidu.tieba.publisher.a;
/* loaded from: classes4.dex */
public class i {
    private static volatile h jxi;

    public static synchronized h cys() {
        h hVar;
        synchronized (i.class) {
            if (jxi == null) {
                jxi = new h();
            }
            hVar = jxi;
        }
        return hVar;
    }
}
