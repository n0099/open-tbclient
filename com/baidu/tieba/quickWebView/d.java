package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gCk;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gCj = new HashMap<>();

    public static d bsR() {
        if (gCk == null) {
            synchronized (d.class) {
                if (gCk == null) {
                    gCk = new d();
                }
            }
        }
        return gCk;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a tP(String str) {
        if (this.gCj == null) {
            return null;
        }
        return this.gCj.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gCj = hashMap;
    }
}
