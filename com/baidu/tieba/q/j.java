package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i lvY;

    public static synchronized i deS() {
        i iVar;
        synchronized (j.class) {
            if (lvY == null) {
                lvY = new i();
            }
            iVar = lvY;
        }
        return iVar;
    }
}
