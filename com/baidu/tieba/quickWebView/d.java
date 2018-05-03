package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d fVP;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> fVO = new HashMap<>();

    public static d biT() {
        if (fVP == null) {
            synchronized (d.class) {
                if (fVP == null) {
                    fVP = new d();
                }
            }
        }
        return fVP;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a rN(String str) {
        if (this.fVO == null) {
            return null;
        }
        return this.fVO.get(str);
    }

    public void l(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.fVO = hashMap;
    }
}
