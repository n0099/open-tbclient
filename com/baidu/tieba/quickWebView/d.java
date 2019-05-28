package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iyx;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iyw = new HashMap<>();

    public static d ces() {
        if (iyx == null) {
            synchronized (d.class) {
                if (iyx == null) {
                    iyx = new d();
                }
            }
        }
        return iyx;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a CL(String str) {
        if (this.iyw == null) {
            return null;
        }
        return this.iyw.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iyw = hashMap;
    }
}
