package com.baidu.tieba.q;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c hsV;
    private a hsW = bGm();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean bGl() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a bGm() {
        CustomResponsedMessage runTask;
        if (!bGl() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c bGn() {
        if (hsV == null) {
            synchronized (c.class) {
                if (hsV == null) {
                    hsV = new c();
                }
            }
        }
        return hsV;
    }

    public void autoTrace(Context context) {
        if (this.hsW != null) {
            this.hsW.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.hsW != null) {
            this.hsW.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.hsW != null) {
            this.hsW.trackWebView(context, webView, webChromeClient);
        }
    }
}
