package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d lkC;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> lkB = new HashMap<>();

    public static d dbF() {
        if (lkC == null) {
            synchronized (d.class) {
                if (lkC == null) {
                    lkC = new d();
                }
            }
        }
        return lkC;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Mk(String str) {
        if (this.lkB == null) {
            return null;
        }
        return this.lkB.get(str);
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.lkB = hashMap;
    }
}
