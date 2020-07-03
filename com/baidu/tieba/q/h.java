package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g lvX;

    public static synchronized g deP() {
        g gVar;
        synchronized (h.class) {
            if (lvX == null) {
                lvX = new g();
            }
            gVar = lvX;
        }
        return gVar;
    }
}
