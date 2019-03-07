package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d igb;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iga = new HashMap<>();

    public static d bWn() {
        if (igb == null) {
            synchronized (d.class) {
                if (igb == null) {
                    igb = new d();
                }
            }
        }
        return igb;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Bs(String str) {
        if (this.iga == null) {
            return null;
        }
        return this.iga.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iga = hashMap;
    }
}
