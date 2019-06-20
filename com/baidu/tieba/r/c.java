package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c jgL;
    private a jgM = cpt();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cps() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cpt() {
        CustomResponsedMessage runTask;
        if (!cps() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cpu() {
        if (jgL == null) {
            synchronized (c.class) {
                if (jgL == null) {
                    jgL = new c();
                }
            }
        }
        return jgL;
    }

    public void autoTrace(Context context) {
        if (this.jgM != null) {
            this.jgM.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.jgM != null) {
            this.jgM.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.jgM != null) {
            this.jgM.trackWebView(context, webView, webChromeClient);
        }
    }
}
