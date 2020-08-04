package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lVh;
    private a lVi = dnU();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dnT() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dnU() {
        CustomResponsedMessage runTask;
        if (!dnT() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dnV() {
        if (lVh == null) {
            synchronized (c.class) {
                if (lVh == null) {
                    lVh = new c();
                }
            }
        }
        return lVh;
    }

    public void autoTrace(Context context) {
        if (!brb() && this.lVi != null) {
            this.lVi.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!brb() && this.lVi != null) {
            this.lVi.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!brb() && this.lVi != null) {
            this.lVi.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean brb() {
        return !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_secret_is_show", false);
    }
}
