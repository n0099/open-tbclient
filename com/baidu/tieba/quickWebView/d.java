package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d lZt;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> lZq = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b lZr = null;
    private boolean lZs = false;

    public static d duh() {
        if (lZt == null) {
            synchronized (d.class) {
                if (lZt == null) {
                    lZt = new d();
                }
            }
        }
        return lZt;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Qv(String str) {
        if (this.lZq == null || !this.lZs) {
            return null;
        }
        return this.lZq.get(str);
    }

    public List<String> Qw(String str) {
        if (this.lZr == null || this.lZr.lZx == null || !this.lZs) {
            return null;
        }
        return this.lZr.lZx.get(str);
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.lZq = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dui() {
        return this.lZq;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.lZr = bVar;
    }

    public boolean duj() {
        return this.lZs;
    }

    public void wc(boolean z) {
        this.lZs = z;
    }
}
