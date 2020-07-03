package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d ldl;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> ldk = new HashMap<>();

    public static d cYx() {
        if (ldl == null) {
            synchronized (d.class) {
                if (ldl == null) {
                    ldl = new d();
                }
            }
        }
        return ldl;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a LC(String str) {
        if (this.ldk == null) {
            return null;
        }
        return this.ldk.get(str);
    }

    public void I(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.ldk = hashMap;
    }
}
