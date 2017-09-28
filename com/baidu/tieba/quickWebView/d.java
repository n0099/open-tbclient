package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fAW;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fAV = new HashMap<>();

    public static d bfC() {
        if (fAW == null) {
            synchronized (d.class) {
                if (fAW == null) {
                    fAW = new d();
                }
            }
        }
        return fAW;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a qB(String str) {
        if (this.fAV == null) {
            return null;
        }
        return this.fAV.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fAV = hashMap;
    }
}
