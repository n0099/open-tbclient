package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d jEH;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> jEG = new HashMap<>();

    public static d cBZ() {
        if (jEH == null) {
            synchronized (d.class) {
                if (jEH == null) {
                    jEH = new d();
                }
            }
        }
        return jEH;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a HG(String str) {
        if (this.jEG == null) {
            return null;
        }
        return this.jEG.get(str);
    }

    public void r(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.jEG = hashMap;
    }
}
