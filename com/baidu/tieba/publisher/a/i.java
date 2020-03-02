package com.baidu.tieba.publisher.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h jBH;

    public static synchronized h cAY() {
        h hVar;
        synchronized (i.class) {
            if (jBH == null) {
                jBH = new h();
            }
            hVar = jBH;
        }
        return hVar;
    }
}
