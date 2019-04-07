package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d ifI;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> ifH = new HashMap<>();

    public static d bWm() {
        if (ifI == null) {
            synchronized (d.class) {
                if (ifI == null) {
                    ifI = new d();
                }
            }
        }
        return ifI;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Bq(String str) {
        if (this.ifH == null) {
            return null;
        }
        return this.ifH.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.ifH = hashMap;
    }
}
