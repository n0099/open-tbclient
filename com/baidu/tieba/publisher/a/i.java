package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h jBT;

    public static synchronized h cAZ() {
        h hVar;
        synchronized (i.class) {
            if (jBT == null) {
                jBT = new h();
            }
            hVar = jBT;
        }
        return hVar;
    }
}
