package com.baidu.webkit.sdk;

import android.webkit.ValueCallback;
/* loaded from: classes8.dex */
public class CookieManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final CookieManager mInstance = new CookieManager();
    public volatile boolean mFlushAsyncing;

    public static boolean allowFileSchemeCookies() {
        return getInstance().allowFileSchemeCookiesImpl();
    }

    public static CookieManager getInstance() {
        return mInstance;
    }

    public static void setAcceptFileSchemeCookies(boolean z) {
        if (WebViewFactory.hasProvider()) {
            getInstance().setAcceptFileSchemeCookiesImpl(z);
        }
    }

    public boolean acceptCookie() {
        if (WebViewFactory.hasProvider()) {
            return WebViewFactory.getProvider().getCookieManager().acceptCookie();
        }
        return false;
    }

    public boolean acceptThirdPartyCookies(WebView webView) {
        if (WebViewFactory.hasProvider()) {
            return WebViewFactory.getProvider().getCookieManager().acceptThirdPartyCookies(webView);
        }
        return false;
    }

    public boolean allowFileSchemeCookiesImpl() {
        if (WebViewFactory.hasProvider()) {
            return WebViewFactory.getProvider().getCookieManager().allowFileSchemeCookiesImpl();
        }
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public void flush() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().flush();
        }
    }

    public void flushAsync() {
        if (this.mFlushAsyncing) {
            return;
        }
        this.mFlushAsyncing = true;
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().flushAsync();
        }
        this.mFlushAsyncing = false;
    }

    public String getCookie(String str) {
        return !WebViewFactory.hasProvider() ? "" : WebViewFactory.getProvider().getCookieManager().getCookie(str);
    }

    public void getCookieAsync(String str, ValueCallback<String> valueCallback) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().getCookieAsync(str, valueCallback);
        } else {
            valueCallback.onReceiveValue("");
        }
    }

    public boolean hasCookies() {
        if (WebViewFactory.hasProvider()) {
            return WebViewFactory.getProvider().getCookieManager().hasCookies();
        }
        return false;
    }

    @Deprecated
    public void removeAllCookie() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeAllCookie();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeAllCookies(valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeExpiredCookie();
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeSessionCookie();
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeSessionCookies(valueCallback);
        }
    }

    public void setAcceptCookie(boolean z) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setAcceptCookie(z);
        }
    }

    public void setAcceptFileSchemeCookiesImpl(boolean z) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setAcceptFileSchemeCookiesImpl(z);
        }
    }

    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setAcceptThirdPartyCookies(webView, z);
        }
    }

    public void setCookie(String str, String str2) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setCookie(str, str2);
        }
    }

    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setCookie(str, str2, valueCallback);
        }
    }

    public void setCookieAsync(String str, String str2, ValueCallback<Boolean> valueCallback) {
        setCookie(str, str2, valueCallback);
    }
}
