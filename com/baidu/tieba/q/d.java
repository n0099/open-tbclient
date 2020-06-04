package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c lbY;

    public static synchronized c daw() {
        c cVar;
        synchronized (d.class) {
            if (lbY == null) {
                lbY = new c();
            }
            cVar = lbY;
        }
        return cVar;
    }
}
