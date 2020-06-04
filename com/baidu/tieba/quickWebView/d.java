package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d kJr;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> kJq = new HashMap<>();

    public static d cUh() {
        if (kJr == null) {
            synchronized (d.class) {
                if (kJr == null) {
                    kJr = new d();
                }
            }
        }
        return kJr;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Lb(String str) {
        if (this.kJq == null) {
            return null;
        }
        return this.kJq.get(str);
    }

    public void I(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.kJq = hashMap;
    }
}
