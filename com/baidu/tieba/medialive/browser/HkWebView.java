package com.baidu.tieba.medialive.browser;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.medialive.browser.HkMWebView;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class HkWebView extends HkMWebView {

    /* renamed from: f  reason: collision with root package name */
    public HkWebView f18941f;

    /* renamed from: g  reason: collision with root package name */
    public Context f18942g;

    /* loaded from: classes3.dex */
    public class a extends HkMWebView.c {
        public a(HkMWebView hkMWebView, Activity activity) {
            super(hkMWebView, activity);
        }

        @Override // com.baidu.tieba.medialive.browser.HkMWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.baidu.tieba.medialive.browser.HkMWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (-10 == i2) {
            }
        }

        @Override // com.baidu.tieba.medialive.browser.HkMWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.toLowerCase().trim().startsWith("tmall://")) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public HkWebView(Context context) {
        super(context);
        this.f18941f = this;
        this.f18942g = context;
        init();
    }

    public final void b(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public String getUserAgent() {
        return getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion();
    }

    public final void init() {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f18941f.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f18941f.removeJavascriptInterface("accessibility");
                this.f18941f.removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b(this.f18942g);
        getSettings().setCacheMode(-1);
        getSettings().setUserAgentString(getUserAgent());
        setDownloadListener(new HkMWebView.b(this.f18941f, (Activity) this.f18942g));
        setWebViewClient(new a(this.f18941f, (Activity) this.f18942g));
    }

    public HkWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18941f = this;
        this.f18942g = context;
        init();
    }
}
