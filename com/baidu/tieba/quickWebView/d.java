package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fWd;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fWc = new HashMap<>();

    public static d blz() {
        if (fWd == null) {
            synchronized (d.class) {
                if (fWd == null) {
                    fWd = new d();
                }
            }
        }
        return fWd;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rN(String str) {
        if (this.fWc == null) {
            return null;
        }
        return this.fWc.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fWc = hashMap;
    }
}
