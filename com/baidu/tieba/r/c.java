package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c jpy;
    private a jpz = cqZ();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cqY() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cqZ() {
        CustomResponsedMessage runTask;
        if (!cqY() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cra() {
        if (jpy == null) {
            synchronized (c.class) {
                if (jpy == null) {
                    jpy = new c();
                }
            }
        }
        return jpy;
    }

    public void autoTrace(Context context) {
        if (!aBF() && this.jpz != null) {
            this.jpz.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!aBF() && this.jpz != null) {
            this.jpz.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!aBF() && this.jpz != null) {
            this.jpz.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean aBF() {
        return !com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_secret_is_show", false);
    }
}
