package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c kop;
    private a koq = cNF();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cNE() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cNF() {
        CustomResponsedMessage runTask;
        if (!cNE() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cNG() {
        if (kop == null) {
            synchronized (c.class) {
                if (kop == null) {
                    kop = new c();
                }
            }
        }
        return kop;
    }

    public void autoTrace(Context context) {
        if (!aWe() && this.koq != null) {
            this.koq.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aWe() && this.koq != null) {
            this.koq.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aWe() && this.koq != null) {
            this.koq.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aWe() {
        return !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_secret_is_show", false);
    }
}
