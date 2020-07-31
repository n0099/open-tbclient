package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d lkA;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> lkz = new HashMap<>();

    public static d dbF() {
        if (lkA == null) {
            synchronized (d.class) {
                if (lkA == null) {
                    lkA = new d();
                }
            }
        }
        return lkA;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Mk(String str) {
        if (this.lkz == null) {
            return null;
        }
        return this.lkz.get(str);
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.lkz = hashMap;
    }
}
