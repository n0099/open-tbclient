package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gmd;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gmc = new HashMap<>();

    public static d boq() {
        if (gmd == null) {
            synchronized (d.class) {
                if (gmd == null) {
                    gmd = new d();
                }
            }
        }
        return gmd;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a sH(String str) {
        if (this.gmc == null) {
            return null;
        }
        return this.gmc.get(str);
    }

    public void m(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gmc = hashMap;
    }
}
