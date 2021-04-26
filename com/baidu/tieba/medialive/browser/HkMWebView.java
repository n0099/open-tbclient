package com.baidu.tieba.medialive.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import d.a.c.e.p.l;
import java.util.Map;
/* loaded from: classes3.dex */
public class HkMWebView extends BaseWebView {

    /* renamed from: e  reason: collision with root package name */
    public String f18935e;

    /* loaded from: classes3.dex */
    public class a extends c {
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
    }

    /* loaded from: classes3.dex */
    public static class b implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        public HkMWebView f18937a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f18938b;

        public b(HkMWebView hkMWebView, Activity activity) {
            this.f18937a = hkMWebView;
            this.f18938b = activity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (this.f18938b.getPackageManager().resolveActivity(intent, 0) == null) {
                l.N(this.f18938b, "您的手机未安装任何浏览器应用，无法完成下载", 0);
            } else {
                this.f18938b.startActivity(intent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public HkMWebView f18939a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f18940b;

        public c(HkMWebView hkMWebView, Activity activity) {
            this.f18939a = hkMWebView;
            this.f18940b = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.f18939a.setLightTouchEnabled();
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f18939a.f18935e = str;
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (this.f18940b != null) {
                    if (str.startsWith("tel:")) {
                        this.f18940b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } else if (str.startsWith(OpenAppUtils.SCHEME_WTAI_MC)) {
                        this.f18940b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring(13))));
                        return true;
                    } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                        this.f18940b.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public HkMWebView(Context context) {
        super(context);
        a();
    }

    public void a() {
        setScrollbarFadingEnabled(true);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(false);
        getSettings().setLightTouchEnabled(true);
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setSupportZoom(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setAllowFileAccess(false);
        getSettings().setUseWideViewPort(true);
        getSettings().setSupportMultipleWindows(true);
        getSettings().setPluginState(WebSettings.PluginState.ON);
        getSettings().setCacheMode(-1);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowContentAccess(true);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        }
        getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        setWebViewClient(new a(this, (Activity) getContext()));
        clearFocus();
        clearHistory();
        clearView();
        setScrollBarStyle(0);
        initCommonJsBridge(getContext());
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        super.removeAllViews();
        super.destroy();
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return this.f18935e;
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void setLightTouchEnabled() {
        loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {   var bodystyle = document.body.style.cssText;   if (bodystyle == undefined || bodystyle == null)      bodystyle = '';   var tapstylekey = '-webkit-tap-highlight-color';   if (bodystyle.indexOf(tapstylekey) < 0) {      bodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';      document.body.style.cssText = bodystyle;   }}\");");
        loadUrl("javascript:SetBodyStyleTapColor();");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
    }

    public HkMWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
