package com.baidu.tieba.q;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c hjY;
    private a hjZ = bEJ();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean bEI() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a bEJ() {
        CustomResponsedMessage runTask;
        if (!bEI() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c bEK() {
        if (hjY == null) {
            synchronized (c.class) {
                if (hjY == null) {
                    hjY = new c();
                }
            }
        }
        return hjY;
    }

    public void autoTrace(Context context) {
        if (this.hjZ != null) {
            this.hjZ.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.hjZ != null) {
            this.hjZ.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.hjZ != null) {
            this.hjZ.trackWebView(context, webView, webChromeClient);
        }
    }
}
