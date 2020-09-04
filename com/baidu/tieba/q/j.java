package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class j {
    private static volatile i lVk;

    public static synchronized i dtB() {
        i iVar;
        synchronized (j.class) {
            if (lVk == null) {
                lVk = new i();
            }
            iVar = lVk;
        }
        return iVar;
    }
}
