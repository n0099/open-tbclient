package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fKt;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fKs = new HashMap<>();

    public static d biT() {
        if (fKt == null) {
            synchronized (d.class) {
                if (fKt == null) {
                    fKt = new d();
                }
            }
        }
        return fKt;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a ro(String str) {
        if (this.fKs == null) {
            return null;
        }
        return this.fKs.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fKs = hashMap;
    }
}
