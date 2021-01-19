package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c mHa;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mGX = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mGY = null;
    private boolean mGZ = false;

    public static c dAG() {
        if (mHa == null) {
            synchronized (c.class) {
                if (mHa == null) {
                    mHa = new c();
                }
            }
        }
        return mHa;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a Qm(String str) {
        if (this.mGX == null || !this.mGZ) {
            return null;
        }
        return this.mGX.get(str);
    }

    public List<String> Qn(String str) {
        if (this.mGY == null || this.mGY.mHe == null || !this.mGZ) {
            return null;
        }
        return this.mGY.mHe.get(str);
    }

    public void F(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mGX = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dAH() {
        return this.mGX;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mGY = bVar;
    }

    public boolean dAI() {
        return this.mGZ;
    }

    public void xg(boolean z) {
        this.mGZ = z;
    }
}
