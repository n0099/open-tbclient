package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class c {
    private static c nvz;
    private a nvA = dOA();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dOz() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dOA() {
        CustomResponsedMessage runTask;
        if (!dOz() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dOB() {
        if (nvz == null) {
            synchronized (c.class) {
                if (nvz == null) {
                    nvz = new c();
                }
            }
        }
        return nvz;
    }

    public void autoTrace(Context context) {
        if (ad.bsf() && this.nvA != null) {
            this.nvA.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ad.bsf() && this.nvA != null) {
            this.nvA.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ad.bsf() && this.nvA != null) {
            this.nvA.trackWebView(context, webView, webChromeClient);
        }
    }
}
