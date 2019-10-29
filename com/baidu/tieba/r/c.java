package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c jqp;
    private a jqq = crb();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cra() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a crb() {
        CustomResponsedMessage runTask;
        if (!cra() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c crc() {
        if (jqp == null) {
            synchronized (c.class) {
                if (jqp == null) {
                    jqp = new c();
                }
            }
        }
        return jqp;
    }

    public void autoTrace(Context context) {
        if (this.jqq != null) {
            this.jqq.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.jqq != null) {
            this.jqq.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.jqq != null) {
            this.jqq.trackWebView(context, webView, webChromeClient);
        }
    }
}
