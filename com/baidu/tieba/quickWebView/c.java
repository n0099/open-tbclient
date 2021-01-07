package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c mLJ;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mLG = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mLH = null;
    private boolean mLI = false;

    public static c dEy() {
        if (mLJ == null) {
            synchronized (c.class) {
                if (mLJ == null) {
                    mLJ = new c();
                }
            }
        }
        return mLJ;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a Rt(String str) {
        if (this.mLG == null || !this.mLI) {
            return null;
        }
        return this.mLG.get(str);
    }

    public List<String> Ru(String str) {
        if (this.mLH == null || this.mLH.mLN == null || !this.mLI) {
            return null;
        }
        return this.mLH.mLN.get(str);
    }

    public void F(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mLG = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dEz() {
        return this.mLG;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mLH = bVar;
    }

    public boolean dEA() {
        return this.mLI;
    }

    public void xk(boolean z) {
        this.mLI = z;
    }
}
