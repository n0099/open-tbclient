package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lNS;
    private a lNT = dkK();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dkJ() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dkK() {
        CustomResponsedMessage runTask;
        if (!dkJ() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dkL() {
        if (lNS == null) {
            synchronized (c.class) {
                if (lNS == null) {
                    lNS = new c();
                }
            }
        }
        return lNS;
    }

    public void autoTrace(Context context) {
        if (!bnh() && this.lNT != null) {
            this.lNT.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!bnh() && this.lNT != null) {
            this.lNT.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!bnh() && this.lNT != null) {
            this.lNT.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean bnh() {
        return !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_secret_is_show", false);
    }
}
