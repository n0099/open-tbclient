package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class j {
    private static volatile i lUV;

    public static synchronized i dtw() {
        i iVar;
        synchronized (j.class) {
            if (lUV == null) {
                lUV = new i();
            }
            iVar = lUV;
        }
        return iVar;
    }
}
