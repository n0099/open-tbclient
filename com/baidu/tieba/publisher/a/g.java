package com.baidu.tieba.publisher.a;
/* loaded from: classes5.dex */
public class g {
    private static volatile f jAO;

    public static synchronized f czA() {
        f fVar;
        synchronized (g.class) {
            if (jAO == null) {
                jAO = new f();
            }
            fVar = jAO;
        }
        return fVar;
    }
}
