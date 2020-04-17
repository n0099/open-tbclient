package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i kIy;

    public static synchronized i cTj() {
        i iVar;
        synchronized (j.class) {
            if (kIy == null) {
                kIy = new i();
            }
            iVar = kIy;
        }
        return iVar;
    }
}
