package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gOx;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gOw = new HashMap<>();

    public static d bvA() {
        if (gOx == null) {
            synchronized (d.class) {
                if (gOx == null) {
                    gOx = new d();
                }
            }
        }
        return gOx;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a uN(String str) {
        if (this.gOw == null) {
            return null;
        }
        return this.gOw.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gOw = hashMap;
    }
}
