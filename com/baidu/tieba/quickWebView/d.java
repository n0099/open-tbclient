package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iIl;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iIk = new HashMap<>();

    public static d ciq() {
        if (iIl == null) {
            synchronized (d.class) {
                if (iIl == null) {
                    iIl = new d();
                }
            }
        }
        return iIl;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Ea(String str) {
        if (this.iIk == null) {
            return null;
        }
        return this.iIk.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iIk = hashMap;
    }
}
