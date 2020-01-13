package com.baidu.tieba.s;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c knl;
    private a knm = cMg();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cMf() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cMg() {
        CustomResponsedMessage runTask;
        if (!cMf() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cMh() {
        if (knl == null) {
            synchronized (c.class) {
                if (knl == null) {
                    knl = new c();
                }
            }
        }
        return knl;
    }

    public void autoTrace(Context context) {
        if (!aTM() && this.knm != null) {
            this.knm.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aTM() && this.knm != null) {
            this.knm.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aTM() && this.knm != null) {
            this.knm.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aTM() {
        return !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_secret_is_show", false);
    }
}
