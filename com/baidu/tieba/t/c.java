package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c mwL;
    private a mwM = dDs();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dDr() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dDs() {
        CustomResponsedMessage runTask;
        if (!dDr() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dDt() {
        if (mwL == null) {
            synchronized (c.class) {
                if (mwL == null) {
                    mwL = new c();
                }
            }
        }
        return mwL;
    }

    public void autoTrace(Context context) {
        if (ae.bjT() && this.mwM != null) {
            this.mwM.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bjT() && this.mwM != null) {
            this.mwM.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bjT() && this.mwM != null) {
            this.mwM.trackWebView(context, webView, webChromeClient);
        }
    }
}
