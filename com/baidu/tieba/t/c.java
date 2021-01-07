package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class c {
    private static c nAd;
    private a nAe = dSs();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dSr() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dSs() {
        CustomResponsedMessage runTask;
        if (!dSr() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dSt() {
        if (nAd == null) {
            synchronized (c.class) {
                if (nAd == null) {
                    nAd = new c();
                }
            }
        }
        return nAd;
    }

    public void autoTrace(Context context) {
        if (ad.bvZ() && this.nAe != null) {
            this.nAe.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ad.bvZ() && this.nAe != null) {
            this.nAe.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ad.bvZ() && this.nAe != null) {
            this.nAe.trackWebView(context, webView, webChromeClient);
        }
    }
}
