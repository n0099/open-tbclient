package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c iOg;
    private a iOh = chm();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean chl() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a chm() {
        CustomResponsedMessage runTask;
        if (!chl() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c chn() {
        if (iOg == null) {
            synchronized (c.class) {
                if (iOg == null) {
                    iOg = new c();
                }
            }
        }
        return iOg;
    }

    public void autoTrace(Context context) {
        if (this.iOh != null) {
            this.iOh.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.iOh != null) {
            this.iOh.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.iOh != null) {
            this.iOh.trackWebView(context, webView, webChromeClient);
        }
    }
}
