package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gJW;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gJV = new HashMap<>();

    public static d btg() {
        if (gJW == null) {
            synchronized (d.class) {
                if (gJW == null) {
                    gJW = new d();
                }
            }
        }
        return gJW;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rZ(String str) {
        if (this.gJV == null) {
            return null;
        }
        return this.gJV.get(str);
    }

    public void g(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gJV = hashMap;
    }
}
