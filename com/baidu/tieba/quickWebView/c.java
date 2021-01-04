package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c mLK;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mLH = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mLI = null;
    private boolean mLJ = false;

    public static c dEx() {
        if (mLK == null) {
            synchronized (c.class) {
                if (mLK == null) {
                    mLK = new c();
                }
            }
        }
        return mLK;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a Ru(String str) {
        if (this.mLH == null || !this.mLJ) {
            return null;
        }
        return this.mLH.get(str);
    }

    public List<String> Rv(String str) {
        if (this.mLI == null || this.mLI.mLO == null || !this.mLJ) {
            return null;
        }
        return this.mLI.mLO.get(str);
    }

    public void F(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mLH = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dEy() {
        return this.mLH;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mLI = bVar;
    }

    public boolean dEz() {
        return this.mLJ;
    }

    public void xk(boolean z) {
        this.mLJ = z;
    }
}
