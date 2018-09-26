package com.baidu.tieba.q;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c hcH;
    private a hcI = bBv();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean bBu() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a bBv() {
        CustomResponsedMessage runTask;
        if (!bBu() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c bBw() {
        if (hcH == null) {
            synchronized (c.class) {
                if (hcH == null) {
                    hcH = new c();
                }
            }
        }
        return hcH;
    }

    public void autoTrace(Context context) {
        if (this.hcI != null) {
            this.hcI.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.hcI != null) {
            this.hcI.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.hcI != null) {
            this.hcI.trackWebView(context, webView, webChromeClient);
        }
    }
}
