package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c nHP;
    private a nHQ = dRc();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dRb() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dRc() {
        CustomResponsedMessage runTask;
        if (!dRb() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dRd() {
        if (nHP == null) {
            synchronized (c.class) {
                if (nHP == null) {
                    nHP = new c();
                }
            }
        }
        return nHP;
    }

    public void autoTrace(Context context) {
        if (ae.bsC() && this.nHQ != null) {
            this.nHQ.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bsC() && this.nHQ != null) {
            this.nHQ.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bsC() && this.nHQ != null) {
            this.nHQ.trackWebView(context, webView, webChromeClient);
        }
    }
}
