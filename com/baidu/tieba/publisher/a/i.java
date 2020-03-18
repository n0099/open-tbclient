package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h jDs;

    public static synchronized h cBt() {
        h hVar;
        synchronized (i.class) {
            if (jDs == null) {
                jDs = new h();
            }
            hVar = jDs;
        }
        return hVar;
    }
}
