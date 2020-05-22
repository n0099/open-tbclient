package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i laS;

    public static synchronized i dal() {
        i iVar;
        synchronized (j.class) {
            if (laS == null) {
                laS = new i();
            }
            iVar = laS;
        }
        return iVar;
    }
}
