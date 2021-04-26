package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes5.dex */
public class SSWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29545a;

    public SSWebView(Context context) {
        super(a(context));
        this.f29545a = false;
        b(a(context));
    }

    public static Context a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    private void b(Context context) {
        c(context);
        b();
        a();
    }

    public static void c(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Throwable unused) {
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = getSettings()) == null) {
                return;
            }
            if (str.startsWith("file://")) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        try {
            return super.canGoBack();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i2) {
        try {
            return super.canGoBackOrForward(i2);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        try {
            super.clearCache(z);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        try {
            super.clearFormData();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        try {
            super.clearHistory();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        try {
            super.computeScroll();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        try {
            return super.getContentHeight();
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        String url;
        try {
            String originalUrl = super.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = super.getUrl()) == null) ? originalUrl : url.startsWith("file://") ? url : originalUrl;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        try {
            return super.getProgress();
        } catch (Exception unused) {
            return 100;
        }
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        try {
            return super.getUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        try {
            super.goBack();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i2) {
        try {
            super.goBackOrForward(i2);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        try {
            super.goForward();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        try {
            super.loadData(str, str2, str3);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public void loadUrl(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            super.loadUrl(str, map);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent a2;
        try {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (motionEvent.getActionMasked() == 0 && this.f29545a && (a2 = a(this)) != null) {
                a2.requestDisallowInterceptTouchEvent(true);
            }
            return onTouchEvent;
        } catch (Throwable unused) {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        try {
            setJavaScriptEnabled(str);
            super.postUrl(str, bArr);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        try {
            super.reload();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int i2) {
        try {
            super.setBackgroundColor(i2);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            super.setDownloadListener(downloadListener);
        } catch (Exception unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.f29545a = z;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setLayerType(int i2, Paint paint) {
        try {
            super.setLayerType(i2, paint);
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean z) {
        try {
            super.setNetworkAvailable(z);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i2) {
        try {
            super.setOverScrollMode(i2);
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            super.setWebChromeClient(webChromeClient);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            super.setWebViewClient(webViewClient);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    private ViewParent a(View view) {
        ViewParent parent = view.getParent();
        return ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof ScrollingView) || !(parent instanceof View)) ? parent : a((View) parent);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            setJavaScriptEnabled(str);
            super.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    public SSWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
        this.f29545a = false;
        b(a(context));
    }

    private void b() {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
        }
    }

    public SSWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
        this.f29545a = false;
        b(a(context));
    }

    private void a() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
