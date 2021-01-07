package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i nhx;

    public static synchronized i dLL() {
        i iVar;
        synchronized (j.class) {
            if (nhx == null) {
                nhx = new i();
            }
            iVar = nhx;
        }
        return iVar;
    }
}
