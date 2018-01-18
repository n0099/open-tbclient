package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gzf;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gze = new HashMap<>();

    public static d bmz() {
        if (gzf == null) {
            synchronized (d.class) {
                if (gzf == null) {
                    gzf = new d();
                }
            }
        }
        return gzf;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rt(String str) {
        if (this.gze == null) {
            return null;
        }
        return this.gze.get(str);
    }

    public void g(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gze = hashMap;
    }
}
