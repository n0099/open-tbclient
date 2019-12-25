package com.baidu.tieba.s;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c kjI;
    private a kjJ = cLb();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cLa() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cLb() {
        CustomResponsedMessage runTask;
        if (!cLa() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cLc() {
        if (kjI == null) {
            synchronized (c.class) {
                if (kjI == null) {
                    kjI = new c();
                }
            }
        }
        return kjI;
    }

    public void autoTrace(Context context) {
        if (!aTs() && this.kjJ != null) {
            this.kjJ.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aTs() && this.kjJ != null) {
            this.kjJ.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aTs() && this.kjJ != null) {
            this.kjJ.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aTs() {
        return !com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_secret_is_show", false);
    }
}
