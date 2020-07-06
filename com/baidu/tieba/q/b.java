package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a lvT;

    public static synchronized a deM() {
        a aVar;
        synchronized (b.class) {
            if (lvT == null) {
                lvT = new a();
            }
            aVar = lvT;
        }
        return aVar;
    }
}
