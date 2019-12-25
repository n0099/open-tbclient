package com.baidu.tieba.publisher.a;
/* loaded from: classes4.dex */
public class g {
    private static volatile f jxh;

    public static synchronized f cyr() {
        f fVar;
        synchronized (g.class) {
            if (jxh == null) {
                jxh = new f();
            }
            fVar = jxh;
        }
        return fVar;
    }
}
