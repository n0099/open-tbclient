package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import java.net.URLEncoder;
import java.util.Arrays;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes5.dex */
public abstract class BaseWebViewActivity extends DxmPayBaseActivity {
    public static final String CHANNEL_DISCOUNT_PARAMS = "channel_discount_params";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String JUMP_URL = "jump_url";
    public static final String WEBVIEW_TITLE = "webview_title";
    public static final String WEBVIEW_TITLE_STRING = "webview_title_string";

    /* renamed from: a  reason: collision with root package name */
    public static final String f25589a = BaseWebViewActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public SafeWebView f25590b;
    public boolean mIsSuccessFlag = false;

    /* loaded from: classes5.dex */
    public class a extends SafeWebView.SafeChromeClient {

        /* renamed from: b  reason: collision with root package name */
        public boolean f25593b;

        public a() {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i <= 25) {
                this.f25593b = false;
            } else if (!this.f25593b) {
                BaseWebViewActivity.this.f25590b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                this.f25593b = true;
                if (BeanConstants.DEBUG) {
                    String str = BaseWebViewActivity.f25589a;
                    LogUtil.d(str, " inject js interface completely on progress " + i);
                }
            }
            super.onProgressChanged(webView, i);
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (!this.f25593b) {
                if (BeanConstants.DEBUG) {
                    String str2 = BaseWebViewActivity.f25589a;
                    LogUtil.i(str2, "onReceivedTitle: " + str);
                }
                BaseWebViewActivity.this.f25590b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.onReceivedTitle(webView, str);
            this.f25593b = true;
            BaseWebViewActivity baseWebViewActivity = BaseWebViewActivity.this;
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(BaseWebViewActivity.this.getActivity(), "ebpay_bd_my_wallet");
            }
            baseWebViewActivity.a(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends SafeWebView.SafeWebViewClient {

        /* renamed from: b  reason: collision with root package name */
        public boolean f25595b;

        public b() {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (!this.f25595b) {
                if (BeanConstants.DEBUG) {
                    String str2 = BaseWebViewActivity.f25589a;
                    LogUtil.i(str2, "doUpdateVisitedHistory: " + str);
                }
                BaseWebViewActivity.this.f25590b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.doUpdateVisitedHistory(webView, str, z);
            this.f25595b = true;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (!this.f25595b && BeanConstants.DEBUG) {
                String str2 = BaseWebViewActivity.f25589a;
                LogUtil.i(str2, "onLoadResource: " + str);
            }
            super.onLoadResource(webView, str);
            this.f25595b = true;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!this.f25595b) {
                if (BeanConstants.DEBUG) {
                    String str2 = BaseWebViewActivity.f25589a;
                    LogUtil.i(str2, "onPageFinished: " + str);
                }
                BaseWebViewActivity.this.f25590b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.onPageFinished(webView, str);
            WalletGlobalUtils.safeDismissDialog(BaseWebViewActivity.this, -1);
            this.f25595b = false;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!this.f25595b) {
                if (BeanConstants.DEBUG) {
                    String str2 = BaseWebViewActivity.f25589a;
                    LogUtil.i(str2, "onPageStarted: " + str);
                }
                BaseWebViewActivity.this.f25590b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.onPageStarted(webView, str, bitmap);
            this.f25595b = true;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            int primaryError = sslError == null ? 5000 : sslError.getPrimaryError();
            String url = sslError == null ? null : sslError.getUrl();
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.H5_CASHIER_SSL_ERROR, Arrays.asList(primaryError + "", url));
            if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String host;
            Uri parse = Uri.parse(str);
            if (parse == null || !"baiduwalletsimplepay".equals(parse.getScheme()) || (host = parse.getHost()) == null) {
                return false;
            }
            if (host.startsWith(WapPayActivity.SUCCESS_NOTIFY_METHOD)) {
                BaseWebViewActivity.this.mIsSuccessFlag = true;
            } else if (host.startsWith(WapPayActivity.CLOSE_VIEW_METHOD)) {
                BaseWebViewActivity.this.notifyResultMsg();
            }
            return true;
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public abstract void notifyResultMsg();

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        SafeWebView safeWebView = this.f25590b;
        if (safeWebView != null && safeWebView.canGoBack()) {
            this.f25590b.goBack();
            return;
        }
        notifyResultMsg();
        super.onBackPressed();
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_base_webview_layout"));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("webview_title");
            if (TextUtils.isEmpty(string)) {
                str2 = extras.getString("webview_title_string");
            } else {
                str2 = ResUtils.getString(getActivity(), string);
            }
            str = extras.getString("jump_url");
        } else {
            str = DomainConfig.getInstance().getCOHost() + "/content/resource/HTML5/eptos.html";
            str2 = "";
        }
        this.mIsSuccessFlag = false;
        String ua = BussinessUtils.getUA(this);
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("?")) {
                str3 = str + "&ua=" + ua;
            } else {
                str3 = str + "?ua=" + ua;
            }
            String encryptProxy = SafePay.getInstance().encryptProxy(PayUtils.getCookie(this));
            str = str3 + "&atbc=" + (!TextUtils.isEmpty(encryptProxy) ? URLEncoder.encode(encryptProxy) : "") + "&key=" + URLEncoder.encode(SafePay.getInstance().getpwProxy());
            if (extras != null) {
                String string2 = extras.getString("extra_param");
                if (!TextUtils.isEmpty(string2)) {
                    str = str + "&" + string2;
                }
            }
        }
        WalletGlobalUtils.safeShowDialog(this, -1, "");
        SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(getActivity(), "cust_webview"));
        this.f25590b = safeWebView;
        safeWebView.setWebViewClient(new b());
        if (TextUtils.isEmpty(str2)) {
            this.f25590b.setWebChromeClient(new a());
        }
        this.f25590b.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT <= 18) {
            this.f25590b.getSettings().setSavePassword(false);
        }
        this.f25590b.setScrollBarStyle(0);
        this.f25590b.clearCache(false);
        this.f25590b.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.f25590b.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f25590b.removeJavascriptInterface("accessibility");
            this.f25590b.removeJavascriptInterface("accessibilityTraversal");
        }
        if (TextUtils.isEmpty(str)) {
            finish();
            return;
        }
        try {
            this.f25590b.loadUrl(str.trim());
        } catch (Exception unused) {
            LogUtil.d("Url error");
            finish();
        }
        a(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BaseWebViewActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BaseWebViewActivity.this.getActivity());
                    BaseWebViewActivity.this.onBackPressed();
                }
            });
        }
    }
}
