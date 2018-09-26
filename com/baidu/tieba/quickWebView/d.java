package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d guI;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> guH = new HashMap<>();

    public static d bpC() {
        if (guI == null) {
            synchronized (d.class) {
                if (guI == null) {
                    guI = new d();
                }
            }
        }
        return guI;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a tn(String str) {
        if (this.guH == null) {
            return null;
        }
        return this.guH.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.guH = hashMap;
    }
}
