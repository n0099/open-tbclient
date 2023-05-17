package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
@Deprecated
/* loaded from: classes8.dex */
public class WebIconDatabase {
    public static final WebIconDatabase mInstance = new WebIconDatabase();

    @Deprecated
    /* loaded from: classes8.dex */
    public interface IconListener {
        void onReceivedIcon(String str, Bitmap bitmap);
    }

    public static WebIconDatabase getInstance() {
        return mInstance;
    }

    public void close() {
        WebViewFactory.getProvider().getWebIconDatabase().close();
    }

    public void open(String str) {
        WebViewFactory.getProvider().getWebIconDatabase().open(str);
    }

    public void releaseIconForPageUrl(String str) {
        WebViewFactory.getProvider().getWebIconDatabase().releaseIconForPageUrl(str);
    }

    public void removeAllIcons() {
        WebViewFactory.getProvider().getWebIconDatabase().removeAllIcons();
    }

    public void requestIconForPageUrl(String str, IconListener iconListener) {
        WebViewFactory.getProvider().getWebIconDatabase().requestIconForPageUrl(str, iconListener);
    }

    public void retainIconForPageUrl(String str) {
        WebViewFactory.getProvider().getWebIconDatabase().retainIconForPageUrl(str);
    }
}
