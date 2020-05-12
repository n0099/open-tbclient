package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c kIz;

    public static synchronized c cTc() {
        c cVar;
        synchronized (d.class) {
            if (kIz == null) {
                kIz = new c();
            }
            cVar = kIz;
        }
        return cVar;
    }
}
