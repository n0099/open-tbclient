package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c mnm;
    private a mnn = dzy();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dzx() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dzy() {
        CustomResponsedMessage runTask;
        if (!dzx() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dzz() {
        if (mnm == null) {
            synchronized (c.class) {
                if (mnm == null) {
                    mnm = new c();
                }
            }
        }
        return mnm;
    }

    public void autoTrace(Context context) {
        if (ae.biY() && this.mnn != null) {
            this.mnn.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.biY() && this.mnn != null) {
            this.mnn.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.biY() && this.mnn != null) {
            this.mnn.trackWebView(context, webView, webChromeClient);
        }
    }
}
