package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gAP;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gAO = new HashMap<>();

    public static d bnM() {
        if (gAP == null) {
            synchronized (d.class) {
                if (gAP == null) {
                    gAP = new d();
                }
            }
        }
        return gAP;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rH(String str) {
        if (this.gAO == null) {
            return null;
        }
        return this.gAO.get(str);
    }

    public void k(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gAO = hashMap;
    }
}
