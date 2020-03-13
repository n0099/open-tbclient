package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c koB;
    private a koC = cNG();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cNF() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cNG() {
        CustomResponsedMessage runTask;
        if (!cNF() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cNH() {
        if (koB == null) {
            synchronized (c.class) {
                if (koB == null) {
                    koB = new c();
                }
            }
        }
        return koB;
    }

    public void autoTrace(Context context) {
        if (!aWf() && this.koC != null) {
            this.koC.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aWf() && this.koC != null) {
            this.koC.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aWf() && this.koC != null) {
            this.koC.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aWf() {
        return !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_secret_is_show", false);
    }
}
