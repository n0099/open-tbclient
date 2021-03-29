package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.lightapp.widget.PullToRefreshWebview;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LightappBrowserFragment extends BaseFragment implements NoProguard, com.baidu.wallet.lightapp.multipage.a, NoNetView.a {
    public static final String JUMP_URL = "jump_url";

    /* renamed from: c  reason: collision with root package name */
    public String f24965c;

    /* renamed from: d  reason: collision with root package name */
    public LightappWebView f24966d;

    /* renamed from: e  reason: collision with root package name */
    public PullToRefreshWebview f24967e;

    /* renamed from: f  reason: collision with root package name */
    public LightappJsClient f24968f;

    /* renamed from: h  reason: collision with root package name */
    public DownloadListener f24970h;
    public NoNetView j;
    public View k;
    public String l;
    public LayoutInflater mInflater;
    public String n;
    public String o;
    public ViewGroup s;
    public static final String sTag = LightappBrowserFragment.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f24963b = Pattern.compile("^(https?://|file:///android_asset/).*");

    /* renamed from: g  reason: collision with root package name */
    public boolean f24969g = true;
    public boolean i = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24964a = false;
    public boolean m = true;
    public boolean p = false;
    public String q = "wallet_base_multi_window_tips";
    public boolean r = false;

    /* loaded from: classes5.dex */
    public class BaseCustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public BaseCustomChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    /* loaded from: classes5.dex */
    public class BaseCustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public BaseCustomWebViewClient() {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_lOAD_START);
            PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_lOAD_START);
            LightappBrowserFragment.this.f24968f.setUrlLocal(str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(i + "", str2));
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(i + "", str2));
            LogUtil.d(LightappBrowserFragment.sTag, "onReceivedError.showErrorPage");
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(15)
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = LightappBrowserFragment.sTag;
            LogUtil.d(str2, "OriginalUrl : " + webView.getOriginalUrl());
            String str3 = LightappBrowserFragment.sTag;
            LogUtil.d(str3, "shouldOverrideUrlLoading url = " + str);
            if (str.startsWith("tel:")) {
                LightappBrowserFragment.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            }
            if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "")});
                    LightappBrowserFragment.this.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    GlobalUtils.toast(LightappBrowserFragment.this.getActivity(), "请先配置邮箱");
                }
            } else if (str.toLowerCase(Locale.CHINA).startsWith("http") || str.toLowerCase(Locale.CHINA).startsWith("https") || str.toLowerCase(Locale.CHINA).startsWith("file")) {
                if (!LightappBrowserFragment.this.i || TextUtils.isEmpty(LightappBrowserFragment.this.f24965c) || str.equals(LightappBrowserFragment.this.f24965c)) {
                    return false;
                }
                BaiduWalletDelegate.getInstance().openH5Module(LightappBrowserFragment.this.getActivity(), str, true);
                return true;
            } else {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addCategory("android.intent.category.BROWSABLE");
                    intent2.setComponent(null);
                    intent2.setSelector(null);
                    LightappBrowserFragment.this.startActivity(intent2);
                    return true;
                } catch (Exception e3) {
                    LogUtil.d(LightappBrowserFragment.sTag, e3.getMessage());
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes5.dex */
    public class CustomChromeClient extends BaseCustomChromeClient implements NoProguard {
        public CustomChromeClient() {
            super();
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (LightappBrowserFragment.this.m) {
                LightappBrowserFragment.this.a(i);
            }
            if (i == 100) {
                if (LightappBrowserFragment.this.m) {
                    LightappBrowserFragment.this.e();
                }
                if (LightappBrowserFragment.this.f24964a) {
                    return;
                }
                LogUtil.d(LightappBrowserFragment.sTag, "onProgressChanged.hideErrorPage");
                LightappBrowserFragment.this.f();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (TextUtils.isEmpty(LightappBrowserFragment.this.n) || NetworkUtils.isNetworkConnected(LightappBrowserFragment.this.getActivity())) {
                String unused = LightappBrowserFragment.this.o;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CustomWebViewClient extends BaseCustomWebViewClient implements NoProguard {
        public CustomWebViewClient() {
            super();
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (LightappBrowserFragment.this.m) {
                LightappBrowserFragment.this.e();
            }
            LightappBrowserFragment.this.a(str);
            if (webView.getProgress() != 100) {
                LightappBrowserFragment.this.f24964a = true;
            }
            String str2 = LightappBrowserFragment.sTag;
            LogUtil.d(str2, "onPageFinished.finishedError:  " + LightappBrowserFragment.this.f24964a);
            super.onPageFinished(webView, str);
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_END_lOAD);
            PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_END_lOAD);
        }

        @Override // com.baidu.wallet.lightapp.business.LightappBrowserFragment.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (LightappBrowserFragment.this.m) {
                LightappBrowserFragment.this.d();
            }
            LightappBrowserFragment.this.o = null;
            super.onPageStarted(webView, str, bitmap);
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD);
            PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD);
        }

        @Override // com.baidu.wallet.lightapp.business.LightappBrowserFragment.BaseCustomWebViewClient, android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (-10 == i) {
                return;
            }
            LightappBrowserFragment lightappBrowserFragment = LightappBrowserFragment.this;
            lightappBrowserFragment.f24964a = true;
            if (lightappBrowserFragment.j != null) {
                LightappBrowserFragment.this.j.setFailureCause(i);
            }
            LightappBrowserFragment.this.b(str2);
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
            String url = sslError == null ? null : sslError.getUrl();
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_FRAGMENT_SSL_ERROR, Arrays.asList(primaryError + "", url));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_FRAGMENT_SSL_ERROR, Arrays.asList(primaryError + "", url));
            if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                sslErrorHandler.proceed();
                return;
            }
            LightappBrowserFragment lightappBrowserFragment = LightappBrowserFragment.this;
            lightappBrowserFragment.f24964a = true;
            if (lightappBrowserFragment.j != null) {
                LightappBrowserFragment.this.j.setFailureCause(primaryError);
            }
            LightappBrowserFragment.this.b(url);
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
            String environment = DebugConfig.getInstance(LightappBrowserFragment.this.getActivity()).getEnvironment();
            if (!"QA".equals(environment) && !"RD".equals(environment)) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                sslErrorHandler.proceed();
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        getActivity().finish();
    }

    public void enableProgressStripe(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String exeSSCommand(String str, String str2, String str3) {
        return null;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void executeJsFunction(String str, String str2) {
        if (this.f24966d != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f24966d.evaluateJavascript(sb.toString(), null);
                    return;
                }
                LightappWebView lightappWebView = this.f24966d;
                lightappWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.wallet.lightapp.multipage.a
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        return null;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i) {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        return true;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
    }

    public void onBackPressed() {
        if (this.f24966d.canGoBack()) {
            String str = sTag;
            LogUtil.d(str, "cangoback:  " + this.f24966d.getUrl());
            this.f24966d.goBack();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mInflater = layoutInflater;
        return a();
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LightappJsClient lightappJsClient = this.f24968f;
        if (lightappJsClient != null) {
            lightappJsClient.destroy();
        }
        LightappWebView lightappWebView = this.f24966d;
        if (lightappWebView != null) {
            ViewGroup viewGroup = (ViewGroup) lightappWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f24966d);
            }
            this.f24966d.removeAllViews();
            this.f24966d.destroy();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (isDetached() || isRemoving()) {
            return;
        }
        try {
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        refresh(str);
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f24968f.onRequestPermissionsResultLocal(i, strArr, iArr);
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        LightappWebView lightappWebView = this.f24966d;
        if (lightappWebView != null) {
            lightappWebView.setDownloadListener(this.f24970h);
        }
        super.onResume();
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(String str, boolean z) {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i) {
    }

    public void refresh(String str) {
        Context applicationContext = getActivity().getApplicationContext();
        if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(applicationContext, "ebpay_no_network"));
        } else if (this.f24966d != null) {
            if (!TextUtils.isEmpty(str) && !f24963b.matcher(str).matches()) {
                str = "https://" + str;
            }
            if (TextUtils.isEmpty(str)) {
                this.f24966d.reload();
            } else {
                this.f24965c = str;
                this.f24966d.loadUrl(str);
            }
            this.f24964a = false;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.f24970h = downloadListener;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        return null;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setIsCheckPermission(boolean z) {
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.p) {
            this.p = z;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(JSONArray jSONArray) {
    }

    public void setMultiWindowTipsId(String str) {
        this.q = str;
    }

    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        this.f24966d.getSettings().setSupportZoom(true);
        this.f24966d.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f24966d.getSettings().setDisplayZoomControls(false);
        } else {
            setZoomControlGone(this.f24966d);
        }
        this.f24966d.getSettings().setUseWideViewPort(true);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(String str, String str2, boolean z) {
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            try {
                declaredField.set(view, zoomButtonsController);
            } catch (IllegalAccessException e2) {
                LogUtil.d(e2.getMessage());
            } catch (IllegalArgumentException e3) {
                LogUtil.d(e3.getMessage());
            }
        } catch (NoSuchFieldException e4) {
            LogUtil.d(e4.getMessage());
        } catch (SecurityException e5) {
            LogUtil.d(e5.getMessage());
        }
    }

    public void setmOpenUrlInNewWindow(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        NoNetView noNetView = this.j;
        if (noNetView != null) {
            noNetView.notifyUrlFinish();
        }
        LightappWebView lightappWebView = this.f24966d;
        if (lightappWebView != null) {
            lightappWebView.setVisibility(0);
        }
    }

    private void b() {
        this.k.setVisibility(0);
        this.k.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
        a(5);
    }

    private void c() {
        this.k.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
    }

    private View a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f24965c = arguments.getString("jump_url");
        }
        if (TextUtils.isEmpty(this.f24965c)) {
            return null;
        }
        String trim = this.f24965c.trim();
        this.f24965c = trim;
        if (!f24963b.matcher(trim).matches()) {
            this.f24965c = "https://" + this.f24965c;
        }
        if (this.f24965c.contains("hideNativeErrorPage=1") || this.f24965c.contains("hideNativeErrorPage%3d1")) {
            this.f24969g = false;
        }
        this.n = "";
        this.l = ResUtils.getString(getActivity(), "ebpay_loading");
        ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(ResUtils.layout(getActivity(), "wallet_base_lightapp_webview_fragment"), (ViewGroup) null);
        this.s = viewGroup;
        this.f24967e = (PullToRefreshWebview) viewGroup.findViewById(ResUtils.id(getActivity(), "cust_webview"));
        this.f24967e.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<LightappWebView>() { // from class: com.baidu.wallet.lightapp.business.LightappBrowserFragment.1

            /* renamed from: c  reason: collision with root package name */
            public final int f24973c = 1;

            /* renamed from: a  reason: collision with root package name */
            public Handler f24971a = new Handler(Looper.getMainLooper()) { // from class: com.baidu.wallet.lightapp.business.LightappBrowserFragment.1.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (1 == message.what) {
                        PullToRefreshBase pullToRefreshBase = (PullToRefreshBase) message.obj;
                        if (pullToRefreshBase != null) {
                            pullToRefreshBase.onPullDownRefreshComplete();
                        }
                        removeMessages(1);
                    }
                }
            };

            @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onPullDownToRefresh(PullToRefreshBase<LightappWebView> pullToRefreshBase) {
                pullToRefreshBase.getRefreshableView().reload();
                Message obtain = Message.obtain();
                obtain.obj = pullToRefreshBase;
                obtain.what = 1;
                this.f24971a.sendMessageDelayed(obtain, 600L);
            }

            @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onPullUpToRefresh(PullToRefreshBase<LightappWebView> pullToRefreshBase) {
            }
        });
        this.f24967e.setPullRefreshEnabled(true);
        this.f24967e.setLoadingAnimationStyle(LoadingLayout.AnimationStyle.ROTATE);
        this.f24966d = this.f24967e.getRefreshableView();
        this.j = (NoNetView) this.s.findViewById(ResUtils.id(getActivity(), "nonet_view"));
        this.k = this.s.findViewById(ResUtils.id(getActivity(), "progress_line"));
        String userAgentString = this.f24966d.getSettings().getUserAgentString();
        LogUtil.logd("ua=" + userAgentString);
        WebSettings settings = this.f24966d.getSettings();
        settings.setUserAgentString(userAgentString + " " + BussinessUtils.getUA(getActivity()));
        StringBuilder sb = new StringBuilder();
        sb.append("ua2=");
        sb.append(this.f24966d.getSettings().getUserAgentString());
        LogUtil.logd(sb.toString());
        this.f24966d.setWebViewClient(new CustomWebViewClient());
        this.f24966d.setWebChromeClient(new CustomChromeClient());
        this.f24966d.getSettings().setJavaScriptEnabled(true);
        this.f24966d.getSettings().setDomStorageEnabled(true);
        this.f24966d.getSettings().setDatabaseEnabled(true);
        this.f24966d.getSettings().setGeolocationDatabasePath(getActivity().getApplicationContext().getDir("database", 0).getPath());
        setSupportZoom();
        this.f24966d.getSettings().setTextZoom(100);
        this.f24966d.getSettings().setGeolocationEnabled(true);
        this.f24966d.setScrollBarStyle(0);
        this.f24966d.clearCache(false);
        this.f24966d.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.f24966d.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f24966d.removeJavascriptInterface("accessibility");
            this.f24966d.removeJavascriptInterface("accessibilityTraversal");
        }
        LightappJsClient lightappJsClient = new LightappJsClient(this, this.f24966d);
        this.f24968f = lightappJsClient;
        this.f24966d.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.f24966d, true);
        }
        this.f24966d.loadUrl(this.f24965c);
        this.f24964a = false;
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.f24969g) {
            NoNetView noNetView = this.j;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappWebView lightappWebView = this.f24966d;
            if (lightappWebView != null) {
                lightappWebView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.SYNC_WEB_LOGIN_STATUS_TO_NATIVE, Arrays.asList(str));
        PayStatisticsUtil.onEventWithValue(LightAppStatEvent.SYNC_WEB_LOGIN_STATUS_TO_NATIVE, str);
        WalletLoginHelper.getInstance().syncH5LoginStatus(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(getActivity()) * i) / 100.0f);
        this.k.setLayoutParams(layoutParams);
    }
}
