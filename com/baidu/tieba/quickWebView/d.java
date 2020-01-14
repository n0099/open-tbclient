package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jDO;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jDN = new HashMap<>();

    public static d cAB() {
        if (jDO == null) {
            synchronized (d.class) {
                if (jDO == null) {
                    jDO = new d();
                }
            }
        }
        return jDO;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Hs(String str) {
        if (this.jDN == null) {
            return null;
        }
        return this.jDN.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jDN = hashMap;
    }
}
