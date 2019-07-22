package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iEQ;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iEP = new HashMap<>();

    public static d chk() {
        if (iEQ == null) {
            synchronized (d.class) {
                if (iEQ == null) {
                    iEQ = new d();
                }
            }
        }
        return iEQ;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a DA(String str) {
        if (this.iEP == null) {
            return null;
        }
        return this.iEP.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iEP = hashMap;
    }
}
