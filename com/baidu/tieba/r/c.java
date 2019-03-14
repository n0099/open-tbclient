package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c iNY;
    private a iNZ = chp();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean cho() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a chp() {
        CustomResponsedMessage runTask;
        if (!cho() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c chq() {
        if (iNY == null) {
            synchronized (c.class) {
                if (iNY == null) {
                    iNY = new c();
                }
            }
        }
        return iNY;
    }

    public void autoTrace(Context context) {
        if (this.iNZ != null) {
            this.iNZ.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.iNZ != null) {
            this.iNZ.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.iNZ != null) {
            this.iNZ.trackWebView(context, webView, webChromeClient);
        }
    }
}
