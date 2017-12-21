package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fWi;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fWh = new HashMap<>();

    public static d blz() {
        if (fWi == null) {
            synchronized (d.class) {
                if (fWi == null) {
                    fWi = new d();
                }
            }
        }
        return fWi;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rN(String str) {
        if (this.fWh == null) {
            return null;
        }
        return this.fWh.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fWh = hashMap;
    }
}
