package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iyy;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iyx = new HashMap<>();

    public static d cet() {
        if (iyy == null) {
            synchronized (d.class) {
                if (iyy == null) {
                    iyy = new d();
                }
            }
        }
        return iyy;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a CN(String str) {
        if (this.iyx == null) {
            return null;
        }
        return this.iyx.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iyx = hashMap;
    }
}
