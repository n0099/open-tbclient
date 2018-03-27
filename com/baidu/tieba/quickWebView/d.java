package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gBf;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gBe = new HashMap<>();

    public static d bnN() {
        if (gBf == null) {
            synchronized (d.class) {
                if (gBf == null) {
                    gBf = new d();
                }
            }
        }
        return gBf;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rH(String str) {
        if (this.gBe == null) {
            return null;
        }
        return this.gBe.get(str);
    }

    public void k(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gBe = hashMap;
    }
}
