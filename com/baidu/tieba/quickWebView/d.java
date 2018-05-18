package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fWV;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fWU = new HashMap<>();

    public static d biS() {
        if (fWV == null) {
            synchronized (d.class) {
                if (fWV == null) {
                    fWV = new d();
                }
            }
        }
        return fWV;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rQ(String str) {
        if (this.fWU == null) {
            return null;
        }
        return this.fWU.get(str);
    }

    public void l(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fWU = hashMap;
    }
}
