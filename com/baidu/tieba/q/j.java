package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class j {
    private static volatile i npg;

    public static synchronized i dKu() {
        i iVar;
        synchronized (j.class) {
            if (npg == null) {
                npg = new i();
            }
            iVar = npg;
        }
        return iVar;
    }
}
