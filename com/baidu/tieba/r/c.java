package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c jgG;
    private a jgH = cpq();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cpp() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cpq() {
        CustomResponsedMessage runTask;
        if (!cpp() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cpr() {
        if (jgG == null) {
            synchronized (c.class) {
                if (jgG == null) {
                    jgG = new c();
                }
            }
        }
        return jgG;
    }

    public void autoTrace(Context context) {
        if (this.jgH != null) {
            this.jgH.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.jgH != null) {
            this.jgH.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.jgH != null) {
            this.jgH.trackWebView(context, webView, webChromeClient);
        }
    }
}
