package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c nfa;
    private a nfb = dMO();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dMN() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dMO() {
        CustomResponsedMessage runTask;
        if (!dMN() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dMP() {
        if (nfa == null) {
            synchronized (c.class) {
                if (nfa == null) {
                    nfa = new c();
                }
            }
        }
        return nfa;
    }

    public void autoTrace(Context context) {
        if (ae.bqV() && this.nfb != null) {
            this.nfb.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bqV() && this.nfb != null) {
            this.nfb.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bqV() && this.nfb != null) {
            this.nfb.trackWebView(context, webView, webChromeClient);
        }
    }
}
