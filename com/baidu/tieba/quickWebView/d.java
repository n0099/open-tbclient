package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iFU;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iFT = new HashMap<>();

    public static d chC() {
        if (iFU == null) {
            synchronized (d.class) {
                if (iFU == null) {
                    iFU = new d();
                }
            }
        }
        return iFU;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a DB(String str) {
        if (this.iFT == null) {
            return null;
        }
        return this.iFT.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iFT = hashMap;
    }
}
