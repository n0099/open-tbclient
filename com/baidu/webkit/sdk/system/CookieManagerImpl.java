package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
final class CookieManagerImpl extends CookieManager {
    static final /* synthetic */ boolean $assertionsDisabled;
    private HandlerThread cookieThread;

    static {
        $assertionsDisabled = !CookieManagerImpl.class.desiredAssertionStatus();
    }

    @TargetApi(18)
    private void postCookieThreadTask(Runnable runnable) {
        try {
            if (this.cookieThread == null) {
                this.cookieThread = new HandlerThread("T7@cookie_manager_impl");
                this.cookieThread.start();
            }
            new Handler(this.cookieThread.getLooper()).post(runnable);
        } catch (Throwable th) {
            if (this.cookieThread != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.cookieThread.quitSafely();
                    } else {
                        this.cookieThread.quit();
                    }
                } catch (Throwable th2) {
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
        if ($assertionsDisabled || (webView.getWebViewProvider() instanceof android.webkit.WebView)) {
            android.webkit.CookieManager.getInstance().acceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewProvider());
            return false;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean allowFileSchemeCookiesImpl() {
        if (Build.VERSION.SDK_INT >= 12) {
            return android.webkit.CookieManager.allowFileSchemeCookies();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(true);
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
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(true);
                    }
                }
            });
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptCookie(boolean z) {
        android.webkit.CookieManager.getInstance().setAcceptCookie(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        if (!$assertionsDisabled && !(webView.getWebViewProvider() instanceof android.webkit.WebView)) {
            throw new AssertionError();
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
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(true);
                    }
                }
            });
        }
    }
}
