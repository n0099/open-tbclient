package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d iyv;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> iyu = new HashMap<>();

    public static d ceq() {
        if (iyv == null) {
            synchronized (d.class) {
                if (iyv == null) {
                    iyv = new d();
                }
            }
        }
        return iyv;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a CL(String str) {
        if (this.iyu == null) {
            return null;
        }
        return this.iyu.get(str);
    }

    public void s(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.iyu = hashMap;
    }
}
