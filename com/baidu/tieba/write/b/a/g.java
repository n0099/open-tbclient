package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f lUI;

    public static synchronized f dnv() {
        f fVar;
        synchronized (g.class) {
            if (lUI == null) {
                lUI = new f();
            }
            fVar = lUI;
        }
        return fVar;
    }
}
