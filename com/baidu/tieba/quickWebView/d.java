package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gnn;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gnm = new HashMap<>();

    public static d bmU() {
        if (gnn == null) {
            synchronized (d.class) {
                if (gnn == null) {
                    gnn = new d();
                }
            }
        }
        return gnn;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a sC(String str) {
        if (this.gnm == null) {
            return null;
        }
        return this.gnm.get(str);
    }

    public void o(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gnm = hashMap;
    }
}
