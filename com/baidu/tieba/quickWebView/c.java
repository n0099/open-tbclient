package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c mGr;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mGo = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mGp = null;
    private boolean mGq = false;

    public static c dEH() {
        if (mGr == null) {
            synchronized (c.class) {
                if (mGr == null) {
                    mGr = new c();
                }
            }
        }
        return mGr;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a RO(String str) {
        if (this.mGo == null || !this.mGq) {
            return null;
        }
        return this.mGo.get(str);
    }

    public List<String> RP(String str) {
        if (this.mGp == null || this.mGp.mGv == null || !this.mGq) {
            return null;
        }
        return this.mGp.mGv.get(str);
    }

    public void G(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mGo = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dEI() {
        return this.mGo;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mGp = bVar;
    }

    public boolean dEJ() {
        return this.mGq;
    }

    public void xj(boolean z) {
        this.mGq = z;
    }
}
