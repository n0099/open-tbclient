package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class g {
    private static volatile f jAJ;

    public static synchronized f czy() {
        f fVar;
        synchronized (g.class) {
            if (jAJ == null) {
                jAJ = new f();
            }
            fVar = jAJ;
        }
        return fVar;
    }
}
