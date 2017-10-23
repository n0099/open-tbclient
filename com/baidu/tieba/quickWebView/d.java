package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fAH;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fAG = new HashMap<>();

    public static d bfw() {
        if (fAH == null) {
            synchronized (d.class) {
                if (fAH == null) {
                    fAH = new d();
                }
            }
        }
        return fAH;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a qA(String str) {
        if (this.fAG == null) {
            return null;
        }
        return this.fAG.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fAG = hashMap;
    }
}
