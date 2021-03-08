package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    private static c mSA;
    private ConcurrentHashMap<String, com.baidu.tieba.quickWebView.data.a> mSy = new ConcurrentHashMap<>();
    private boolean mSz = false;

    public static c dDb() {
        if (mSA == null) {
            synchronized (c.class) {
                if (mSA == null) {
                    mSA = new c();
                }
            }
        }
        return mSA;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a Rn(String str) {
        if (this.mSy == null) {
            return null;
        }
        return this.mSy.get(str);
    }

    public ConcurrentHashMap<String, com.baidu.tieba.quickWebView.data.a> dDc() {
        return this.mSy;
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mSy.clear();
        if (hashMap != null) {
            this.mSy.putAll(hashMap);
        }
    }

    public void e(String str, HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        if (this.mSy == null) {
            this.mSy = new ConcurrentHashMap<>();
        }
        Ro(str);
        this.mSy.putAll(hashMap);
    }

    public void Ro(String str) {
        if (!TextUtils.isEmpty(str) && this.mSy != null) {
            Iterator<String> it = this.mSy.keySet().iterator();
            while (it.hasNext()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mSy.get(it.next());
                if (aVar != null && str.equals(aVar.kwi)) {
                    it.remove();
                }
            }
        }
    }

    public void M(boolean z, String str) {
        if (!TextUtils.isEmpty(str) && this.mSy != null) {
            for (String str2 : this.mSy.keySet()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mSy.get(str2);
                if (aVar != null && str.equals(aVar.kwi)) {
                    aVar.mSz = z;
                }
            }
        }
    }

    public void xy(boolean z) {
        if (this.mSy != null) {
            for (String str : this.mSy.keySet()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mSy.get(str);
                if (aVar != null) {
                    aVar.mSz = z;
                }
            }
        }
    }
}
