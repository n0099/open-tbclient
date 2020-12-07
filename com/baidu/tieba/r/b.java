package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class b {
    private static volatile a nbM;

    public static synchronized a dLO() {
        a aVar;
        synchronized (b.class) {
            if (nbM == null) {
                nbM = new a();
            }
            aVar = nbM;
        }
        return aVar;
    }
}
