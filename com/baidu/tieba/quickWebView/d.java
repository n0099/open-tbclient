package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d igc;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> igb = new HashMap<>();

    public static d bWo() {
        if (igc == null) {
            synchronized (d.class) {
                if (igc == null) {
                    igc = new d();
                }
            }
        }
        return igc;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Bt(String str) {
        if (this.igb == null) {
            return null;
        }
        return this.igb.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.igb = hashMap;
    }
}
