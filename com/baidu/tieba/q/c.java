package com.baidu.tieba.q;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c hlJ;
    private a hlK = bEi();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean bEh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a bEi() {
        CustomResponsedMessage runTask;
        if (!bEh() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c bEj() {
        if (hlJ == null) {
            synchronized (c.class) {
                if (hlJ == null) {
                    hlJ = new c();
                }
            }
        }
        return hlJ;
    }

    public void autoTrace(Context context) {
        if (this.hlK != null) {
            this.hlK.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.hlK != null) {
            this.hlK.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.hlK != null) {
            this.hlK.trackWebView(context, webView, webChromeClient);
        }
    }
}
