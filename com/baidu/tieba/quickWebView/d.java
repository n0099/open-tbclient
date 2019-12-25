package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jAh;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jAg = new HashMap<>();

    public static d czs() {
        if (jAh == null) {
            synchronized (d.class) {
                if (jAh == null) {
                    jAh = new d();
                }
            }
        }
        return jAh;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Hi(String str) {
        if (this.jAg == null) {
            return null;
        }
        return this.jAg.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jAg = hashMap;
    }
}
