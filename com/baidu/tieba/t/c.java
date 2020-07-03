package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lNP;
    private a lNQ = dkG();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dkF() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dkG() {
        CustomResponsedMessage runTask;
        if (!dkF() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dkH() {
        if (lNP == null) {
            synchronized (c.class) {
                if (lNP == null) {
                    lNP = new c();
                }
            }
        }
        return lNP;
    }

    public void autoTrace(Context context) {
        if (!bng() && this.lNQ != null) {
            this.lNQ.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!bng() && this.lNQ != null) {
            this.lNQ.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!bng() && this.lNQ != null) {
            this.lNQ.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean bng() {
        return !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_secret_is_show", false);
    }
}
