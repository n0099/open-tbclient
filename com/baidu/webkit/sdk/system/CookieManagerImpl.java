package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes8.dex */
public final class CookieManagerImpl extends CookieManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public HandlerThread cookieThread;

    @TargetApi(18)
    private void postCookieThreadTask(Runnable runnable) {
        try {
            if (this.cookieThread == null) {
                HandlerThread handlerThread = new HandlerThread("T7@cookie_manager_impl");
                this.cookieThread = handlerThread;
                handlerThread.start();
            }
            new Handler(this.cookieThread.getLooper()).post(runnable);
        } catch (Throwable unused) {
            HandlerThread handlerThread2 = this.cookieThread;
            if (handlerThread2 != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        handlerThread2.quitSafely();
                    } else {
                        handlerThread2.quit();
                    }
                } catch (Throwable unused2) {
                }
            }
            this.cookieThread = null;
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean acceptCookie() {
        return android.webkit.CookieManager.getInstance().acceptCookie();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean acceptThirdPartyCookies(WebView webView) {
        if (Build.VERSION.SDK_INT < 21 || webView == null) {
            return false;
        }
        android.webkit.CookieManager.getInstance().acceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewProvider());
        return false;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean allowFileSchemeCookiesImpl() {
        if (Build.VERSION.SDK_INT >= 12) {
            return android.webkit.CookieManager.allowFileSchemeCookies();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void flush() {
        if (Build.VERSION.SDK_INT >= 21) {
            android.webkit.CookieManager.getInstance().flush();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void flushAsync() {
        flush();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final String getCookie(String str) {
        return android.webkit.CookieManager.getInstance().getCookie(str);
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void getCookieAsync(final String str, final ValueCallback<String> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        postCookieThreadTask(new Runnable() { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                valueCallback.onReceiveValue(CookieManagerImpl.this.getCookie(str));
            }
        });
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean hasCookies() {
        return android.webkit.CookieManager.getInstance().hasCookies();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeAllCookie() {
        android.webkit.CookieManager.getInstance().removeAllCookie();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeAllCookies(final ValueCallback<Boolean> valueCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.webkit.CookieManager.getInstance().removeAllCookies(valueCallback);
        } else {
            postCookieThreadTask(new Runnable() { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    CookieManagerImpl.this.removeAllCookie();
                    ValueCallback valueCallback2 = valueCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(Boolean.TRUE);
                    }
                }
            });
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeExpiredCookie() {
        android.webkit.CookieManager.getInstance().removeExpiredCookie();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeSessionCookie() {
        android.webkit.CookieManager.getInstance().removeSessionCookie();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeSessionCookies(final ValueCallback<Boolean> valueCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.webkit.CookieManager.getInstance().removeSessionCookies(valueCallback);
        } else {
            postCookieThreadTask(new Runnable() { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    CookieManagerImpl.this.removeSessionCookie();
                    ValueCallback valueCallback2 = valueCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(Boolean.TRUE);
                    }
                }
            });
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptCookie(boolean z) {
        android.webkit.CookieManager.getInstance().setAcceptCookie(z);
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptFileSchemeCookiesImpl(boolean z) {
        if (Build.VERSION.SDK_INT >= 12) {
            android.webkit.CookieManager.setAcceptFileSchemeCookies(z);
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        if (Build.VERSION.SDK_INT < 21 || webView == null) {
            return;
        }
        android.webkit.CookieManager.getInstance().setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewProvider(), z);
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setCookie(String str, String str2) {
        android.webkit.CookieManager.getInstance().setCookie(str, str2);
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setCookie(final String str, final String str2, final ValueCallback<Boolean> valueCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.webkit.CookieManager.getInstance().setCookie(str, str2, valueCallback);
        } else {
            postCookieThreadTask(new Runnable() { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    CookieManagerImpl.this.setCookie(str, str2);
                    ValueCallback valueCallback2 = valueCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(Boolean.TRUE);
                    }
                }
            });
        }
    }
}
