package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gOw;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gOv = new HashMap<>();

    public static d bvA() {
        if (gOw == null) {
            synchronized (d.class) {
                if (gOw == null) {
                    gOw = new d();
                }
            }
        }
        return gOw;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a uN(String str) {
        if (this.gOv == null) {
            return null;
        }
        return this.gOv.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gOv = hashMap;
    }
}
