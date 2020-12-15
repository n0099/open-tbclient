package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c mGt;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mGq = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mGr = null;
    private boolean mGs = false;

    public static c dEI() {
        if (mGt == null) {
            synchronized (c.class) {
                if (mGt == null) {
                    mGt = new c();
                }
            }
        }
        return mGt;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a RO(String str) {
        if (this.mGq == null || !this.mGs) {
            return null;
        }
        return this.mGq.get(str);
    }

    public List<String> RP(String str) {
        if (this.mGr == null || this.mGr.mGx == null || !this.mGs) {
            return null;
        }
        return this.mGr.mGx.get(str);
    }

    public void G(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mGq = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dEJ() {
        return this.mGq;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mGr = bVar;
    }

    public boolean dEK() {
        return this.mGs;
    }

    public void xj(boolean z) {
        this.mGs = z;
    }
}
