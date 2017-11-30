package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fTx;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fTw = new HashMap<>();

    public static d bkT() {
        if (fTx == null) {
            synchronized (d.class) {
                if (fTx == null) {
                    fTx = new d();
                }
            }
        }
        return fTx;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rJ(String str) {
        if (this.fTw == null) {
            return null;
        }
        return this.fTw.get(str);
    }

    public void h(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fTw = hashMap;
    }
}
