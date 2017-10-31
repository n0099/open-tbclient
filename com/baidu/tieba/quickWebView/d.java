package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fJu;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fJt = new HashMap<>();

    public static d biI() {
        if (fJu == null) {
            synchronized (d.class) {
                if (fJu == null) {
                    fJu = new d();
                }
            }
        }
        return fJu;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rh(String str) {
        if (this.fJt == null) {
            return null;
        }
        return this.fJt.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fJt = hashMap;
    }
}
