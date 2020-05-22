package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c laP;

    public static synchronized c dag() {
        c cVar;
        synchronized (d.class) {
            if (laP == null) {
                laP = new c();
            }
            cVar = laP;
        }
        return cVar;
    }
}
