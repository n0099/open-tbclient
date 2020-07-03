package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c lvV;

    public static synchronized c deM() {
        c cVar;
        synchronized (d.class) {
            if (lvV == null) {
                lvV = new c();
            }
            cVar = lvV;
        }
        return cVar;
    }
}
