package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c kIv;

    public static synchronized c cTe() {
        c cVar;
        synchronized (d.class) {
            if (kIv == null) {
                kIv = new c();
            }
            cVar = kIv;
        }
        return cVar;
    }
}
