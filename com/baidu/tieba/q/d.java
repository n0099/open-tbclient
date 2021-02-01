package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c nmv;

    public static synchronized c dKb() {
        c cVar;
        synchronized (d.class) {
            if (nmv == null) {
                nmv = new c();
            }
            cVar = nmv;
        }
        return cVar;
    }
}
