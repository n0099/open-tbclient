package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c mZe;
    private a mZf = dKm();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dKl() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dKm() {
        CustomResponsedMessage runTask;
        if (!dKl() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dKn() {
        if (mZe == null) {
            synchronized (c.class) {
                if (mZe == null) {
                    mZe = new c();
                }
            }
        }
        return mZe;
    }

    public void autoTrace(Context context) {
        if (ae.bov() && this.mZf != null) {
            this.mZf.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bov() && this.mZf != null) {
            this.mZf.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bov() && this.mZf != null) {
            this.mZf.trackWebView(context, webView, webChromeClient);
        }
    }
}
