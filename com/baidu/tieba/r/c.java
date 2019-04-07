package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c iNM;
    private a iNN = chn();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean chm() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a chn() {
        CustomResponsedMessage runTask;
        if (!chm() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c cho() {
        if (iNM == null) {
            synchronized (c.class) {
                if (iNM == null) {
                    iNM = new c();
                }
            }
        }
        return iNM;
    }

    public void autoTrace(Context context) {
        if (this.iNN != null) {
            this.iNN.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.iNN != null) {
            this.iNN.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.iNN != null) {
            this.iNN.trackWebView(context, webView, webChromeClient);
        }
    }
}
