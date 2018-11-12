package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gDL;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gDK = new HashMap<>();

    public static d bsn() {
        if (gDL == null) {
            synchronized (d.class) {
                if (gDL == null) {
                    gDL = new d();
                }
            }
        }
        return gDL;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a tT(String str) {
        if (this.gDK == null) {
            return null;
        }
        return this.gDK.get(str);
    }

    public void q(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gDK = hashMap;
    }
}
