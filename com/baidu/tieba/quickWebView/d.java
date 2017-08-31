package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fDD;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fDC = new HashMap<>();

    public static d bgL() {
        if (fDD == null) {
            synchronized (d.class) {
                if (fDD == null) {
                    fDD = new d();
                }
            }
        }
        return fDD;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a qP(String str) {
        if (this.fDC == null) {
            return null;
        }
        return this.fDC.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fDC = hashMap;
    }
}
