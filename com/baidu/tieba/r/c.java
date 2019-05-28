package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c jgH;
    private a jgI = cps();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cpr() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cps() {
        CustomResponsedMessage runTask;
        if (!cpr() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cpt() {
        if (jgH == null) {
            synchronized (c.class) {
                if (jgH == null) {
                    jgH = new c();
                }
            }
        }
        return jgH;
    }

    public void autoTrace(Context context) {
        if (this.jgI != null) {
            this.jgI.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.jgI != null) {
            this.jgI.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.jgI != null) {
            this.jgI.trackWebView(context, webView, webChromeClient);
        }
    }
}
