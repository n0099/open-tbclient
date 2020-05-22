package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lsY;
    private a lsZ = dgj();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dgi() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dgj() {
        CustomResponsedMessage runTask;
        if (!dgi() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dgk() {
        if (lsY == null) {
            synchronized (c.class) {
                if (lsY == null) {
                    lsY = new c();
                }
            }
        }
        return lsY;
    }

    public void autoTrace(Context context) {
        if (!bkF() && this.lsZ != null) {
            this.lsZ.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!bkF() && this.lsZ != null) {
            this.lsZ.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!bkF() && this.lsZ != null) {
            this.lsZ.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean bkF() {
        return !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_secret_is_show", false);
    }
}
