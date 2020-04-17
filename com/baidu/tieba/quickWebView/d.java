package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d kql;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> kqk = new HashMap<>();

    public static d cMT() {
        if (kql == null) {
            synchronized (d.class) {
                if (kql == null) {
                    kql = new d();
                }
            }
        }
        return kql;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Jl(String str) {
        if (this.kqk == null) {
            return null;
        }
        return this.kqk.get(str);
    }

    public void G(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.kqk = hashMap;
    }
}
