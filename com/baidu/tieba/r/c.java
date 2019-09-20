package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c jqx;
    private a jqy = ctm();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean ctl() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a ctm() {
        CustomResponsedMessage runTask;
        if (!ctl() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c ctn() {
        if (jqx == null) {
            synchronized (c.class) {
                if (jqx == null) {
                    jqx = new c();
                }
            }
        }
        return jqx;
    }

    public void autoTrace(Context context) {
        if (this.jqy != null) {
            this.jqy.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.jqy != null) {
            this.jqy.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.jqy != null) {
            this.jqy.trackWebView(context, webView, webChromeClient);
        }
    }
}
