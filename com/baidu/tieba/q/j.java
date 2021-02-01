package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i nmA;

    public static synchronized i dKe() {
        i iVar;
        synchronized (j.class) {
            if (nmA == null) {
                nmA = new i();
            }
            iVar = nmA;
        }
        return iVar;
    }
}
