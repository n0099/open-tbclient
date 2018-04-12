package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fVS;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fVR = new HashMap<>();

    public static d biT() {
        if (fVS == null) {
            synchronized (d.class) {
                if (fVS == null) {
                    fVS = new d();
                }
            }
        }
        return fVS;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rN(String str) {
        if (this.fVR == null) {
            return null;
        }
        return this.fVR.get(str);
    }

    public void l(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fVR = hashMap;
    }
}
