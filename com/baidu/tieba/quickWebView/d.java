package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gNs;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gNr = new HashMap<>();

    public static d buR() {
        if (gNs == null) {
            synchronized (d.class) {
                if (gNs == null) {
                    gNs = new d();
                }
            }
        }
        return gNs;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a ux(String str) {
        if (this.gNr == null) {
            return null;
        }
        return this.gNr.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gNr = hashMap;
    }
}
