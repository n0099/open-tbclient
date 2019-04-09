package com.baidu.tieba.r;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c iNN;
    private a iNO = chn();

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
        if (iNN == null) {
            synchronized (c.class) {
                if (iNN == null) {
                    iNN = new c();
                }
            }
        }
        return iNN;
    }

    public void autoTrace(Context context) {
        if (this.iNO != null) {
            this.iNO.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (this.iNO != null) {
            this.iNO.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (this.iNO != null) {
            this.iNO.trackWebView(context, webView, webChromeClient);
        }
    }
}
