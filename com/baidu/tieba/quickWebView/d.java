package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jDJ;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jDI = new HashMap<>();

    public static d cAz() {
        if (jDJ == null) {
            synchronized (d.class) {
                if (jDJ == null) {
                    jDJ = new d();
                }
            }
        }
        return jDJ;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Hs(String str) {
        if (this.jDI == null) {
            return null;
        }
        return this.jDI.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jDI = hashMap;
    }
}
