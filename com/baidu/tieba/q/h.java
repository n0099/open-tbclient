package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g nmY;

    public static synchronized g dKl() {
        g gVar;
        synchronized (h.class) {
            if (nmY == null) {
                nmY = new g();
            }
            gVar = nmY;
        }
        return gVar;
    }
}
