package com.baidu.tieba.u;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c nuh;
    private a nui = dSg();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dSf() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dSg() {
        CustomResponsedMessage runTask;
        if (!dSf() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dSh() {
        if (nuh == null) {
            synchronized (c.class) {
                if (nuh == null) {
                    nuh = new c();
                }
            }
        }
        return nuh;
    }

    public void autoTrace(Context context) {
        if (ae.btD() && this.nui != null) {
            this.nui.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.btD() && this.nui != null) {
            this.nui.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.btD() && this.nui != null) {
            this.nui.trackWebView(context, webView, webChromeClient);
        }
    }
}
