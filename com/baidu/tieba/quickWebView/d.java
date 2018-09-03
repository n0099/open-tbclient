package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gnq;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gnp = new HashMap<>();

    public static d bmV() {
        if (gnq == null) {
            synchronized (d.class) {
                if (gnq == null) {
                    gnq = new d();
                }
            }
        }
        return gnq;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a sG(String str) {
        if (this.gnp == null) {
            return null;
        }
        return this.gnp.get(str);
    }

    public void o(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gnp = hashMap;
    }
}
