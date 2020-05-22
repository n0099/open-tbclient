package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d kIj;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> kIi = new HashMap<>();

    public static d cTR() {
        if (kIj == null) {
            synchronized (d.class) {
                if (kIj == null) {
                    kIj = new d();
                }
            }
        }
        return kIj;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a La(String str) {
        if (this.kIi == null) {
            return null;
        }
        return this.kIi.get(str);
    }

    public void I(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.kIi = hashMap;
    }
}
