package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jET;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jES = new HashMap<>();

    public static d cCa() {
        if (jET == null) {
            synchronized (d.class) {
                if (jET == null) {
                    jET = new d();
                }
            }
        }
        return jET;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a HH(String str) {
        if (this.jES == null) {
            return null;
        }
        return this.jES.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jES = hashMap;
    }
}
