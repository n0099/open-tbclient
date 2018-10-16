package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gCj;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gCi = new HashMap<>();

    public static d bsR() {
        if (gCj == null) {
            synchronized (d.class) {
                if (gCj == null) {
                    gCj = new d();
                }
            }
        }
        return gCj;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a tP(String str) {
        if (this.gCi == null) {
            return null;
        }
        return this.gCi.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gCi = hashMap;
    }
}
