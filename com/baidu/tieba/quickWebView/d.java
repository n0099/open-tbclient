package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fEw;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fEv = new HashMap<>();

    public static d bgW() {
        if (fEw == null) {
            synchronized (d.class) {
                if (fEw == null) {
                    fEw = new d();
                }
            }
        }
        return fEw;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a qR(String str) {
        if (this.fEv == null) {
            return null;
        }
        return this.fEv.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fEv = hashMap;
    }
}
