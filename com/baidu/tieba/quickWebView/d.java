package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d ifJ;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> ifI = new HashMap<>();

    public static d bWm() {
        if (ifJ == null) {
            synchronized (d.class) {
                if (ifJ == null) {
                    ifJ = new d();
                }
            }
        }
        return ifJ;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Bq(String str) {
        if (this.ifI == null) {
            return null;
        }
        return this.ifI.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.ifI = hashMap;
    }
}
