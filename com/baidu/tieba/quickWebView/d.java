package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d ifW;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> ifV = new HashMap<>();

    public static d bWq() {
        if (ifW == null) {
            synchronized (d.class) {
                if (ifW == null) {
                    ifW = new d();
                }
            }
        }
        return ifW;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Br(String str) {
        if (this.ifV == null) {
            return null;
        }
        return this.ifV.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.ifV = hashMap;
    }
}
