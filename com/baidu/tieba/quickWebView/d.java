package com.baidu.tieba.quickWebView;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static d kqp;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> kqo = new HashMap<>();

    public static d cMQ() {
        if (kqp == null) {
            synchronized (d.class) {
                if (kqp == null) {
                    kqp = new d();
                }
            }
        }
        return kqp;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Jo(String str) {
        if (this.kqo == null) {
            return null;
        }
        return this.kqo.get(str);
    }

    public void G(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.kqo = hashMap;
    }
}
