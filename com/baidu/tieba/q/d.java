package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c nmV;

    public static synchronized c dKj() {
        c cVar;
        synchronized (d.class) {
            if (nmV == null) {
                nmV = new c();
            }
            cVar = nmV;
        }
        return cVar;
    }
}
