package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gzA;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gzz = new HashMap<>();

    public static d bmA() {
        if (gzA == null) {
            synchronized (d.class) {
                if (gzA == null) {
                    gzA = new d();
                }
            }
        }
        return gzA;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rB(String str) {
        if (this.gzz == null) {
            return null;
        }
        return this.gzz.get(str);
    }

    public void g(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gzz = hashMap;
    }
}
