package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lVf;
    private a lVg = dnT();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dnS() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dnT() {
        CustomResponsedMessage runTask;
        if (!dnS() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dnU() {
        if (lVf == null) {
            synchronized (c.class) {
                if (lVf == null) {
                    lVf = new c();
                }
            }
        }
        return lVf;
    }

    public void autoTrace(Context context) {
        if (!brb() && this.lVg != null) {
            this.lVg.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!brb() && this.lVg != null) {
            this.lVg.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!brb() && this.lVg != null) {
            this.lVg.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean brb() {
        return !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_secret_is_show", false);
    }
}
