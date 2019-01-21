package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c hxp;
    private a hxq = bHK();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean bHJ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a bHK() {
        CustomResponsedMessage runTask;
        if (!bHJ() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c bHL() {
        if (hxp == null) {
            synchronized (c.class) {
                if (hxp == null) {
                    hxp = new c();
                }
            }
        }
        return hxp;
    }

    public void autoTrace(Context context) {
        if (this.hxq != null) {
            this.hxq.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.hxq != null) {
            this.hxq.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.hxq != null) {
            this.hxq.trackWebView(context, webView, webChromeClient);
        }
    }
}
