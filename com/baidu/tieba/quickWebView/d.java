package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jEF;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jEE = new HashMap<>();

    public static d cBX() {
        if (jEF == null) {
            synchronized (d.class) {
                if (jEF == null) {
                    jEF = new d();
                }
            }
        }
        return jEF;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a HG(String str) {
        if (this.jEE == null) {
            return null;
        }
        return this.jEE.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jEE = hashMap;
    }
}
