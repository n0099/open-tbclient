package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class d {
    private static volatile c npb;

    public static synchronized c dKr() {
        c cVar;
        synchronized (d.class) {
            if (npb == null) {
                npb = new c();
            }
            cVar = npb;
        }
        return cVar;
    }
}
