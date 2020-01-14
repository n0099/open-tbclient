package com.baidu.tieba.s;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c knq;
    private a knr = cMi();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cMh() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cMi() {
        CustomResponsedMessage runTask;
        if (!cMh() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cMj() {
        if (knq == null) {
            synchronized (c.class) {
                if (knq == null) {
                    knq = new c();
                }
            }
        }
        return knq;
    }

    public void autoTrace(Context context) {
        if (!aTM() && this.knr != null) {
            this.knr.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aTM() && this.knr != null) {
            this.knr.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aTM() && this.knr != null) {
            this.knr.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aTM() {
        return !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_secret_is_show", false);
    }
}
