package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lak;
    private a lal = cYX();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cYW() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a cYX() {
        CustomResponsedMessage runTask;
        if (!cYW() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cYY() {
        if (lak == null) {
            synchronized (c.class) {
                if (lak == null) {
                    lak = new c();
                }
            }
        }
        return lak;
    }

    public void autoTrace(Context context) {
        if (!bev() && this.lal != null) {
            this.lal.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!bev() && this.lal != null) {
            this.lal.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!bev() && this.lal != null) {
            this.lal.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean bev() {
        return !com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_secret_is_show", false);
    }
}
