package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lao;
    private a lap = cYV();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cYU() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cYV() {
        CustomResponsedMessage runTask;
        if (!cYU() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cYW() {
        if (lao == null) {
            synchronized (c.class) {
                if (lao == null) {
                    lao = new c();
                }
            }
        }
        return lao;
    }

    public void autoTrace(Context context) {
        if (!bet() && this.lap != null) {
            this.lap.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!bet() && this.lap != null) {
            this.lap.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!bet() && this.lap != null) {
            this.lap.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean bet() {
        return !com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_secret_is_show", false);
    }
}
