package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class c {
    private static c nvy;
    private a nvz = dOA();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dOz() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dOA() {
        CustomResponsedMessage runTask;
        if (!dOz() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dOB() {
        if (nvy == null) {
            synchronized (c.class) {
                if (nvy == null) {
                    nvy = new c();
                }
            }
        }
        return nvy;
    }

    public void autoTrace(Context context) {
        if (ad.bsf() && this.nvz != null) {
            this.nvz.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ad.bsf() && this.nvz != null) {
            this.nvz.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ad.bsf() && this.nvz != null) {
            this.nvz.trackWebView(context, webView, webChromeClient);
        }
    }
}
