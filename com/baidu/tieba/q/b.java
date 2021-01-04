package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a nhs;

    public static synchronized a dLG() {
        a aVar;
        synchronized (b.class) {
            if (nhs == null) {
                nhs = new a();
            }
            aVar = nhs;
        }
        return aVar;
    }
}
