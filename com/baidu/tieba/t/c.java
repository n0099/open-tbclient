package com.baidu.tieba.t;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class c {
    private static c lui;
    private a luj = dgy();

    /* loaded from: classes.dex */
    public interface a {
        void autoTrace(Context context);

        void setAppChannel(Context context, String str, boolean z);

        void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient);
    }

    private boolean dgx() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("pref_key_stat_sdk_enable", 1) != 0;
    }

    private c() {
    }

    private a dgy() {
        CustomResponsedMessage runTask;
        if (!dgx() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static c dgz() {
        if (lui == null) {
            synchronized (c.class) {
                if (lui == null) {
                    lui = new c();
                }
            }
        }
        return lui;
    }

    public void autoTrace(Context context) {
        if (!bkH() && this.luj != null) {
            this.luj.autoTrace(context);
        }
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (!bkH() && this.luj != null) {
            this.luj.setAppChannel(context, str, z);
        }
    }

    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (!bkH() && this.luj != null) {
            this.luj.trackWebView(context, webView, webChromeClient);
        }
    }

    private static boolean bkH() {
        return !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_secret_is_show", false);
    }
}
