package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class h {
    private static volatile g lca;

    public static synchronized g daz() {
        g gVar;
        synchronized (h.class) {
            if (lca == null) {
                lca = new g();
            }
            gVar = lca;
        }
        return gVar;
    }
}
