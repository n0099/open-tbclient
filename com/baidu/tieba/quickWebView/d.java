package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fAV;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fAU = new HashMap<>();

    public static d bfB() {
        if (fAV == null) {
            synchronized (d.class) {
                if (fAV == null) {
                    fAV = new d();
                }
            }
        }
        return fAV;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a qB(String str) {
        if (this.fAU == null) {
            return null;
        }
        return this.fAU.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fAU = hashMap;
    }
}
