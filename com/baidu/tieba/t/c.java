package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c kon;
    private a koo = cND();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cNC() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cND() {
        CustomResponsedMessage runTask;
        if (!cNC() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cNE() {
        if (kon == null) {
            synchronized (c.class) {
                if (kon == null) {
                    kon = new c();
                }
            }
        }
        return kon;
    }

    public void autoTrace(Context context) {
        if (!aWc() && this.koo != null) {
            this.koo.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aWc() && this.koo != null) {
            this.koo.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aWc() && this.koo != null) {
            this.koo.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aWc() {
        return !com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_secret_is_show", false);
    }
}
