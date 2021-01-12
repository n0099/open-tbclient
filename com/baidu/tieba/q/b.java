package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class b {
    private static volatile a ncM;

    public static synchronized a dHP() {
        a aVar;
        synchronized (b.class) {
            if (ncM == null) {
                ncM = new a();
            }
            aVar = ncM;
        }
        return aVar;
    }
}
