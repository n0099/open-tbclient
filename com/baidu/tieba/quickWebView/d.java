package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gBe;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gBd = new HashMap<>();

    public static d bnN() {
        if (gBe == null) {
            synchronized (d.class) {
                if (gBe == null) {
                    gBe = new d();
                }
            }
        }
        return gBe;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rH(String str) {
        if (this.gBd == null) {
            return null;
        }
        return this.gBd.get(str);
    }

    public void k(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gBd = hashMap;
    }
}
