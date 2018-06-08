package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d gil;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> gik = new HashMap<>();

    public static d bnQ() {
        if (gil == null) {
            synchronized (d.class) {
                if (gil == null) {
                    gil = new d();
                }
            }
        }
        return gil;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a sI(String str) {
        if (this.gik == null) {
            return null;
        }
        return this.gik.get(str);
    }

    public void m(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.gik = hashMap;
    }
}
