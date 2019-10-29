package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iGH;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iGG = new HashMap<>();

    public static d cfo() {
        if (iGH == null) {
            synchronized (d.class) {
                if (iGH == null) {
                    iGH = new d();
                }
            }
        }
        return iGH;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Cu(String str) {
        if (this.iGG == null) {
            return null;
        }
        return this.iGG.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iGG = hashMap;
    }
}
