package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gKB;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gKA = new HashMap<>();

    public static d buf() {
        if (gKB == null) {
            synchronized (d.class) {
                if (gKB == null) {
                    gKB = new d();
                }
            }
        }
        return gKB;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a uu(String str) {
        if (this.gKA == null) {
            return null;
        }
        return this.gKA.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gKA = hashMap;
    }
}
