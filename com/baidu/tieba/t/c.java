package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c nFJ;
    private a nFK = dQT();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dQS() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dQT() {
        CustomResponsedMessage runTask;
        if (!dQS() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dQU() {
        if (nFJ == null) {
            synchronized (c.class) {
                if (nFJ == null) {
                    nFJ = new c();
                }
            }
        }
        return nFJ;
    }

    public void autoTrace(Context context) {
        if (ae.bsz() && this.nFK != null) {
            this.nFK.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bsz() && this.nFK != null) {
            this.nFK.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bsz() && this.nFK != null) {
            this.nFK.trackWebView(context, webView, webChromeClient);
        }
    }
}
