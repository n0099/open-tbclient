package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    private static c mMv;
    private a mMw = dHe();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dHd() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dHe() {
        CustomResponsedMessage runTask;
        if (!dHd() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dHf() {
        if (mMv == null) {
            synchronized (c.class) {
                if (mMv == null) {
                    mMv = new c();
                }
            }
        }
        return mMv;
    }

    public void autoTrace(Context context) {
        if (ae.bmC() && this.mMw != null) {
            this.mMw.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (ae.bmC() && this.mMw != null) {
            this.mMw.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (ae.bmC() && this.mMw != null) {
            this.mMw.trackWebView(context, webView, webChromeClient);
        }
    }
}
