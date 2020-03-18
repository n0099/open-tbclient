package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jGs;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jGr = new HashMap<>();

    public static d cCu() {
        if (jGs == null) {
            synchronized (d.class) {
                if (jGs == null) {
                    jGs = new d();
                }
            }
        }
        return jGs;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a HG(String str) {
        if (this.jGr == null) {
            return null;
        }
        return this.jGr.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jGr = hashMap;
    }
}
