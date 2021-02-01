package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    private static c mQh;
    private ConcurrentHashMap<String, com.baidu.tieba.quickWebView.data.a> mQf = new ConcurrentHashMap<>();
    private boolean mQg = false;

    public static c dCM() {
        if (mQh == null) {
            synchronized (c.class) {
                if (mQh == null) {
                    mQh = new c();
                }
            }
        }
        return mQh;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a Rg(String str) {
        if (this.mQf == null) {
            return null;
        }
        return this.mQf.get(str);
    }

    public ConcurrentHashMap<String, com.baidu.tieba.quickWebView.data.a> dCN() {
        return this.mQf;
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mQf.clear();
        if (hashMap != null) {
            this.mQf.putAll(hashMap);
        }
    }

    public void e(String str, HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        if (this.mQf == null) {
            this.mQf = new ConcurrentHashMap<>();
        }
        Rh(str);
        this.mQf.putAll(hashMap);
    }

    public void Rh(String str) {
        if (!TextUtils.isEmpty(str) && this.mQf != null) {
            Iterator<String> it = this.mQf.keySet().iterator();
            while (it.hasNext()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mQf.get(it.next());
                if (aVar != null && str.equals(aVar.ktS)) {
                    it.remove();
                }
            }
        }
    }

    public void M(boolean z, String str) {
        if (!TextUtils.isEmpty(str) && this.mQf != null) {
            for (String str2 : this.mQf.keySet()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mQf.get(str2);
                if (aVar != null && str.equals(aVar.ktS)) {
                    aVar.mQg = z;
                }
            }
        }
    }

    public void xy(boolean z) {
        if (this.mQf != null) {
            for (String str : this.mQf.keySet()) {
                com.baidu.tieba.quickWebView.data.a aVar = this.mQf.get(str);
                if (aVar != null) {
                    aVar.mQg = z;
                }
            }
        }
    }
}
