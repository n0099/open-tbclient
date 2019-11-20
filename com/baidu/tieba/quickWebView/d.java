package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iFQ;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iFP = new HashMap<>();

    public static d cfm() {
        if (iFQ == null) {
            synchronized (d.class) {
                if (iFQ == null) {
                    iFQ = new d();
                }
            }
        }
        return iFQ;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Cu(String str) {
        if (this.iFP == null) {
            return null;
        }
        return this.iFP.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iFP = hashMap;
    }
}
