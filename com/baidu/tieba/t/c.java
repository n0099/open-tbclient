package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes2.dex */
public class c {
    private static c mmU;
    private a mmV = dzp();

    /* loaded from: classes2.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dzo() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dzp() {
        CustomResponsedMessage runTask;
        if (!dzo() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dzq() {
        if (mmU == null) {
            synchronized (c.class) {
                if (mmU == null) {
                    mmU = new c();
                }
            }
        }
        return mmU;
    }

    public void autoTrace(Context context) {
        if (ae.biY() && this.mmV != null) {
            this.mmV.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.biY() && this.mmV != null) {
            this.mmV.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.biY() && this.mmV != null) {
            this.mmV.trackWebView(context, webView, webChromeClient);
        }
    }
}
