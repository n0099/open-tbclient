package com.baidu.tieba.u;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c ngb;
    private a ngc = dMN();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dMM() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dMN() {
        CustomResponsedMessage runTask;
        if (!dMM() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dMO() {
        if (ngb == null) {
            synchronized (c.class) {
                if (ngb == null) {
                    ngb = new c();
                }
            }
        }
        return ngb;
    }

    public void autoTrace(Context context) {
        if (ae.bqi() && this.ngc != null) {
            this.ngc.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bqi() && this.ngc != null) {
            this.ngc.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bqi() && this.ngc != null) {
            this.ngc.trackWebView(context, webView, webChromeClient);
        }
    }
}
