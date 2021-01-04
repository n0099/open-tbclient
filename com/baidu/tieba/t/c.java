package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class c {
    private static c nAe;
    private a nAf = dSr();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dSq() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dSr() {
        CustomResponsedMessage runTask;
        if (!dSq() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dSs() {
        if (nAe == null) {
            synchronized (c.class) {
                if (nAe == null) {
                    nAe = new c();
                }
            }
        }
        return nAe;
    }

    public void autoTrace(Context context) {
        if (ad.bvY() && this.nAf != null) {
            this.nAf.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ad.bvY() && this.nAf != null) {
            this.nAf.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ad.bvY() && this.nAf != null) {
            this.nAf.trackWebView(context, webView, webChromeClient);
        }
    }
}
