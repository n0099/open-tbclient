package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    private static c mQx;
    private ConcurrentHashMap<String, com.baidu.tieba.quickWebView.data.a> mQv = new ConcurrentHashMap<>();
    private boolean mQw = false;

    public static c dCT() {
        if (mQx == null) {
            synchronized (c.class) {
                if (mQx == null) {
                    mQx = new c();
                }
            }
        }
        return mQx;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a Rh(String str) {
        if (this.mQv == null) {
            return null;
        }
        return this.mQv.get(str);
    }

    public ConcurrentHashMap<String, com.baidu.tieba.quickWebView.data.a> dCU() {
        return this.mQv;
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mQv.clear();
        if (hashMap != null) {
            this.mQv.putAll(hashMap);
        }
    }

    public void e(String str, HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        if (this.mQv == null) {
            this.mQv = new ConcurrentHashMap<>();
        }
        Ri(str);
        this.mQv.putAll(hashMap);
    }

    public void Ri(String str) {
        if (!TextUtils.isEmpty(str) && this.mQv != null) {
            Iterator<String> it = this.mQv.keySet().iterator();
            while (it.hasNext()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mQv.get(it.next());
                if (aVar != null && str.equals(aVar.kug)) {
                    it.remove();
                }
            }
        }
    }

    public void M(boolean z, String str) {
        if (!TextUtils.isEmpty(str) && this.mQv != null) {
            for (String str2 : this.mQv.keySet()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mQv.get(str2);
                if (aVar != null && str.equals(aVar.kug)) {
                    aVar.mQw = z;
                }
            }
        }
    }

    public void xy(boolean z) {
        if (this.mQv != null) {
            for (String str : this.mQv.keySet()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mQv.get(str);
                if (aVar != null) {
                    aVar.mQw = z;
                }
            }
        }
    }
}
