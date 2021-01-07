package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c nhs;

    public static synchronized c dLI() {
        c cVar;
        synchronized (d.class) {
            if (nhs == null) {
                nhs = new c();
            }
            cVar = nhs;
        }
        return cVar;
    }
}
