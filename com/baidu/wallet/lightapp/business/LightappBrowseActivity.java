package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.PromptDialog;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappBaseActivity;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.multipage.LangbridgeActivity;
import com.baidu.wallet.lightapp.widget.BdLightAppActionBar;
import com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.wallet.utils.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes5.dex */
public class LightappBrowseActivity extends LightappBaseActivity implements NoProguard, IBeanResponseCallback, com.baidu.wallet.lightapp.multipage.a, NoNetView.a {
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TITLE = "title";

    /* renamed from: f  reason: collision with root package name */
    public static int f24605f;
    public static final Pattern l = Pattern.compile("^(https?://|file:///android_asset/).*");
    public String A;
    public String B;
    public TextView H;
    public ContactInfoPresenter I;
    public com.baidu.wallet.lightapp.business.presenter.a J;
    public String K;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24607b;

    /* renamed from: g  reason: collision with root package name */
    public LightappBusinessClient f24611g;
    public String j;
    public String k;
    public Vector<LoadTimeLine> mLoadTimeLine;
    public WebviewMenu p;
    public a q;
    public BdActionBar r;
    public FrameLayout s;
    public FrameLayout t;
    public LangBrigdeSlideLayout u;
    public NoNetView v;
    public View w;
    public FrameLayout x;
    public FrameLayout y;
    public String z;

    /* renamed from: e  reason: collision with root package name */
    public int f24610e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f24612h = -1;
    public Vector<Application.ActivityLifecycleCallbacks> i = new Vector<>();
    public boolean m = false;
    public boolean n = true;
    public boolean o = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24606a = false;
    public boolean C = false;
    public String D = "wallet_base_multi_window_close";
    public boolean E = false;
    public boolean F = false;
    public Handler G = null;
    public boolean L = false;

    /* renamed from: c  reason: collision with root package name */
    public int f24608c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f24609d = 0;

    /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24624a;

        static {
            int[] iArr = new int[LifeCycleCbName.values().length];
            f24624a = iArr;
            try {
                iArr[LifeCycleCbName.OnCreated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24624a[LifeCycleCbName.OnStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24624a[LifeCycleCbName.OnResumed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24624a[LifeCycleCbName.OnPaused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24624a[LifeCycleCbName.OnStopped.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24624a[LifeCycleCbName.OnSaveInstanceState.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24624a[LifeCycleCbName.OnDestroyed.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CustomChromeClient extends LightappBaseActivity.BaseCustomChromeClient implements NoProguard {
        public CustomChromeClient() {
            super();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return super.onConsoleMessage(consoleMessage);
            }
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                String sourceId = consoleMessage.sourceId();
                sourceId = (TextUtils.equals(sourceId, LightappBrowseActivity.this.K) || TextUtils.isEmpty(sourceId)) ? "" : "";
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("level", messageLevel.name());
                linkedHashMap.put("message", consoleMessage.message());
                linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                linkedHashMap.put("sourceId", sourceId);
                linkedHashMap.put("pageUrl", LightappBrowseActivity.this.K);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, linkedHashMap, LightappBrowseActivity.this);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            LogUtil.d("LightappBrowseActivity", "onProgressChanged:newProgress   " + i);
            LightappBrowseActivity.this.a(i);
            if (i == 100) {
                LightappBrowseActivity.this.dismissLoadingProgress();
                if (LightappBrowseActivity.this.f24606a) {
                    return;
                }
                LogUtil.d("LightappBrowseActivity", "onProgressChanged.hideErrorPage");
                LightappBrowseActivity.this.c();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (LightappBrowseActivity.this.r != null) {
                if (TextUtils.isEmpty(LightappBrowseActivity.this.A) || NetworkUtils.isNetworkConnected(LightappBrowseActivity.this.getActivity())) {
                    if (LightappBrowseActivity.this.B != null) {
                        LightappBrowseActivity.this.r.setTitle(LightappBrowseActivity.this.B);
                        return;
                    } else if (!TextUtils.isEmpty(LightappBrowseActivity.this.j)) {
                        LightappBrowseActivity.this.r.setTitle(LightappBrowseActivity.this.j);
                        return;
                    } else if (TextUtils.isEmpty(str) || LightappBrowseActivity.l.matcher(str).matches()) {
                        LightappBrowseActivity.this.r.setTitle(" ");
                        return;
                    } else {
                        if (("http://" + str).equals(LightappBrowseActivity.this.k)) {
                            LightappBrowseActivity.this.r.setTitle(" ");
                            return;
                        } else {
                            LightappBrowseActivity.this.r.setTitle(str);
                            return;
                        }
                    }
                }
                LightappBrowseActivity.this.r.setTitle(LightappBrowseActivity.this.A);
                LightappBrowseActivity.this.r.setTitleCenterSafeTipText("");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CustomWebViewClient extends LightappBaseActivity.BaseCustomWebViewClient implements NoProguard {

        /* renamed from: c  reason: collision with root package name */
        public Pattern f24643c;

        /* renamed from: d  reason: collision with root package name */
        public String f24644d;

        public CustomWebViewClient() {
            super();
            this.f24643c = Pattern.compile("\\s*https?://.*");
        }

        private boolean a(String str, String str2) {
            return TextUtils.equals(str, str2);
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Vector<LoadTimeLine> vector = LightappBrowseActivity.this.mLoadTimeLine;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
            }
            LightappBrowseActivity.this.dismissLoadingProgress();
            LightappBrowseActivity.this.f24612h = com.baidu.wallet.lightapp.base.a.a().a(LightappBrowseActivity.this.getActivity(), str, LightappBrowseActivity.this.f24612h);
            LightappBrowseActivity.this.k = str;
            String host = Uri.parse(str).getHost();
            this.f24644d = str;
            if (TextUtils.isEmpty(host)) {
                LightappBrowseActivity.this.H.setVisibility(8);
            } else {
                LightappBrowseActivity.this.H.setVisibility(0);
                LightappBrowseActivity.this.H.setText(LightappBrowseActivity.this.getResources().getString(ResUtils.string(LightappBrowseActivity.this.getActivity(), "wallet_lightapp_url_outer"), host));
            }
            String title = LightappBrowseActivity.this.r.getTitle();
            if (title != null && title.equals(LightappBrowseActivity.this.A)) {
                String title2 = webView.getTitle();
                if (title2 == null || this.f24643c.matcher(title2).matches()) {
                    LightappBrowseActivity.this.r.setTitle((String) null);
                } else {
                    LightappBrowseActivity.this.r.setTitle(title2);
                }
            }
            if (webView.getProgress() != 100) {
                LightappBrowseActivity.this.f24606a = true;
            }
            LogUtil.d("LightappBrowseActivity", "onPageFinished.finishedError:  " + LightappBrowseActivity.this.f24606a);
            super.onPageFinished(webView, str);
            com.baidu.wallet.lightapp.monitor.a.a().a((View) LightappBrowseActivity.this.mWebView, "FINISH", false);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
            LangbridgeCacheManager.getInstance().handleFinishPage(str);
            LightappBrowserWebView lightappBrowserWebView = LightappBrowseActivity.this.mWebView;
            if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack() || LightappBrowseActivity.this.mNeedClearHistory || BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID) || LightappBrowseActivity.this.r.setCloseButtonVisibility(0) == 0) {
                return;
            }
            LightappBrowseActivity.this.r.setCloseOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.CustomWebViewClient.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
                    GlobalUtils.hideKeyboard(LightappBrowseActivity.this.getActivity());
                    if (LightappBrowseActivity.this.f24610e == 12) {
                        LightappBrowseActivity.this.a(2, "实名认证取消");
                    }
                    LightappBrowseActivity.this.finish();
                }
            });
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Vector<LoadTimeLine> vector = LightappBrowseActivity.this.mLoadTimeLine;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
            }
            LightappBrowseActivity.this.K = str;
            if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                LightappBrowseActivity.this.setFullScreenInMainThread(false, false, false, false, "", "");
            }
            if (LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                LightappBrowseActivity.this.showLoadingProgress();
            }
            LightappBrowseActivity.this.r.setTitle(LightappBrowseActivity.this.A);
            LightappBrowseActivity.this.r.setTitleCenterSafeTipText("");
            LightappBrowseActivity.this.q = null;
            if (LightappBrowseActivity.this.f24611g != null) {
                LightappBrowseActivity.this.f24611g.setH5BackCb(null);
            }
            LightappBrowseActivity.this.B = null;
            super.onPageStarted(webView, str, bitmap);
            com.baidu.wallet.lightapp.monitor.a.a().a((View) LightappBrowseActivity.this.mWebView, "START", true);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
            LangbridgeCacheManager.getInstance().handleStartPage(str);
            boolean isOfflineCacheReady = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
            if (!NetworkUtils.isNetworkAvailable(LightappBrowseActivity.this.getActivity()) && !isOfflineCacheReady) {
                LightappBrowseActivity.this.c(str);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(CheckUtils.stripUrlParams(str)));
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_WRC_SHOW_ERROR, CheckUtils.stripUrlParams(str));
            }
            if (a(str, this.f24644d)) {
                return;
            }
            com.baidu.wallet.lightapp.base.c.a(LightappBrowseActivity.this.getActivity());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                linkedHashMap.put("errorCode", String.valueOf(webResourceError.getErrorCode()));
            } else {
                linkedHashMap.put("errorCode", String.valueOf(Integer.MIN_VALUE));
            }
            if (Build.VERSION.SDK_INT >= 21 && webResourceRequest != null) {
                linkedHashMap.put("url", String.valueOf(webResourceRequest.getUrl()));
                linkedHashMap.put("method", webResourceRequest.getMethod());
                linkedHashMap.put("reqHeaders", String.valueOf(a(webResourceRequest.getRequestHeaders())));
            }
            if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                linkedHashMap.put("reasonPhrase", String.valueOf(webResourceError.getDescription()));
            }
            linkedHashMap.put("pageUrl", LightappBrowseActivity.this.K);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.K).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, LightappBrowseActivity.this);
            if (webResourceError == null || webResourceRequest == null || -10 == webResourceError.getErrorCode() || !webResourceRequest.isForMainFrame()) {
                return;
            }
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            lightappBrowseActivity.f24606a = true;
            if (lightappBrowseActivity.v != null) {
                LightappBrowseActivity.this.v.setFailureCause(webResourceError.getErrorCode());
            }
            LightappBrowseActivity.this.c(webResourceRequest.getUrl().toString());
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(String.valueOf(webResourceError.getErrorCode()), String.valueOf(webResourceRequest.getUrl())));
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(String.valueOf(webResourceError.getErrorCode()), String.valueOf(webResourceRequest.getUrl())));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (Build.VERSION.SDK_INT >= 21) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (webResourceRequest != null && webResourceResponse != null) {
                    linkedHashMap.put("statusCode", String.valueOf(webResourceResponse.getStatusCode()));
                    linkedHashMap.put("url", String.valueOf(webResourceRequest.getUrl()));
                    linkedHashMap.put("method", webResourceRequest.getMethod());
                    linkedHashMap.put("reqHeaders", String.valueOf(a(webResourceRequest.getRequestHeaders())));
                    linkedHashMap.put("respHeaders", String.valueOf(webResourceResponse.getResponseHeaders()));
                    linkedHashMap.put("reasonPhrase", webResourceResponse.getReasonPhrase());
                    linkedHashMap.put("pageUrl", LightappBrowseActivity.this.K);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, linkedHashMap, LightappBrowseActivity.this);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (sslError != null) {
                linkedHashMap.put("errorCode", String.valueOf(sslError.getPrimaryError()));
                linkedHashMap.put("url", sslError.getUrl());
                linkedHashMap.put("certificate", String.valueOf(sslError.getCertificate()));
                linkedHashMap.put("pageUrl", LightappBrowseActivity.this.K);
            }
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.K).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, linkedHashMap, LightappBrowseActivity.this);
            int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
            String url = sslError == null ? null : sslError.getUrl();
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
            if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                sslErrorHandler.proceed();
                return;
            }
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            lightappBrowseActivity.f24606a = true;
            if (lightappBrowseActivity.v != null) {
                LightappBrowseActivity.this.v.setFailureCause(primaryError);
            }
            LightappBrowseActivity.this.c(url);
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (LightappBrowseActivity.this.mNeedOverrideUrl) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LightappBrowseActivity.this.mLangbridgeHash, webResourceRequest.getUrl().toString());
                LightappBrowseActivity.this.mNeedOverrideUrl = false;
            }
            return LangbridgeCacheManager.getInstance().interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
        }

        private Map a(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                HashMap hashMap = new HashMap(map);
                Iterator it = hashMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if ("Cookie".equalsIgnoreCase((String) ((Map.Entry) it.next()).getKey())) {
                        it.remove();
                        break;
                    }
                }
                return hashMap;
            }
            return Collections.emptyMap();
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (LightappBrowseActivity.this.mNeedOverrideUrl) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LightappBrowseActivity.this.mLangbridgeHash, str);
                LightappBrowseActivity.this.mNeedOverrideUrl = false;
            }
            return LangbridgeCacheManager.getInstance().interceptRequest(str, null);
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("errorCode", String.valueOf(i));
            linkedHashMap.put("url", str2);
            linkedHashMap.put("reasonPhrase", str);
            linkedHashMap.put("pageUrl", LightappBrowseActivity.this.K);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.K).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, LightappBrowseActivity.this);
            if (-10 == i) {
                return;
            }
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            lightappBrowseActivity.f24606a = true;
            if (lightappBrowseActivity.v != null) {
                LightappBrowseActivity.this.v.setFailureCause(i);
            }
            LightappBrowseActivity.this.c(str2);
            super.onReceivedError(webView, i, str, str2);
        }
    }

    /* loaded from: classes5.dex */
    public enum LifeCycleCbName {
        OnCreated,
        OnStarted,
        OnResumed,
        OnPaused,
        OnStopped,
        OnSaveInstanceState,
        OnDestroyed
    }

    /* loaded from: classes5.dex */
    public static class LoadTimeLine implements NoProguard {
        public String event;
        public String time;
        public String url;

        public LoadTimeLine(String str, String str2, String str3) {
            this.url = str;
            this.event = str2;
            this.time = str3;
        }
    }

    /* loaded from: classes5.dex */
    public class WebviewMenu extends LangBridgeMenuDialog implements NoProguard {
        public static final int MENU_ITEM_INDEX_CLOSE = 34;
        public static final int MENU_ITEM_INDEX_REFRESH = 33;
        public static final int MENU_ITEM_INDEX_SHARE = 32;

        public WebviewMenu(Context context) {
            super(context);
            add(33, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (LightappBrowseActivity.this.m) {
                add(32, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    /* loaded from: classes5.dex */
    public class a extends LangBridgeMenuDialog implements NoProguard {

        /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0255a {

            /* renamed from: a  reason: collision with root package name */
            public String f24652a;

            /* renamed from: b  reason: collision with root package name */
            public String f24653b;

            /* renamed from: c  reason: collision with root package name */
            public String f24654c;

            public C0255a() {
            }
        }

        public a(Context context, JSONArray jSONArray) {
            super(context);
            final ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        if (!jSONArray.isNull(i)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject.has("title") && jSONObject.has("icon") && jSONObject.has("callback")) {
                                C0255a c0255a = new C0255a();
                                c0255a.f24652a = jSONObject.optString("title", null);
                                c0255a.f24653b = jSONObject.optString("icon", null);
                                c0255a.f24654c = jSONObject.optString("callback", null);
                                if (compile.matcher(c0255a.f24652a).matches() && !TextUtils.isEmpty(c0255a.f24653b) && !TextUtils.isEmpty(c0255a.f24654c)) {
                                    if (5 <= arrayList.size()) {
                                        break;
                                    }
                                    arrayList.add(c0255a);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            final int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0255a c0255a2 = (C0255a) arrayList.get(i2);
                add(i2 + 256, c0255a2.f24652a, c0255a2.f24653b);
            }
            add(GDiffPatcher.COPY_INT_USHORT, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (LightappBrowseActivity.this.m) {
                add(254, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(255, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            setMenuItemClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.a.1
                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    int itemId = bdMenuItem.getItemId();
                    if (255 == itemId) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
                        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
                        if (LightappBrowseActivity.this.f24610e == 12) {
                            LightappBrowseActivity.this.a(2, "实名认证取消");
                        }
                        LightappBrowseActivity.this.finish();
                    } else if (254 == itemId) {
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)));
                        PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(LightappBrowseActivity.this.k));
                        LightAppWrapper.getInstance().callShare(LightappBrowseActivity.this.getActivity(), new LightAppShareModel(LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getUrl(), null), null);
                    } else if (253 == itemId) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)));
                        PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(LightappBrowseActivity.this.k));
                        LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LightappBrowseActivity.this.getActivity(), LightappBrowseActivity.this.k);
                        LightappBrowseActivity.this.mWebView.reload();
                        LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                        lightappBrowseActivity.k = lightappBrowseActivity.mWebView.getUrl();
                        LightappBrowseActivity.this.f24606a = false;
                    } else {
                        int i3 = itemId - 256;
                        if (i3 <= size) {
                            LightappBrowseActivity.this.executeJsFunction(((C0255a) arrayList.get(i3)).f24654c, "");
                        }
                    }
                }
            });
            layoutMenu();
        }
    }

    public static int getCurrentColor(float f2, int i, int i2) {
        int red = Color.red(i);
        int blue = Color.blue(i);
        int green = Color.green(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int blue2 = Color.blue(i2);
        int i3 = red2 - red;
        int i4 = blue2 - blue;
        int green2 = (int) (green + ((Color.green(i2) - green) * f2));
        return Color.argb((int) (alpha + (f2 * (Color.alpha(i2) - alpha))), (int) (red + (i3 * f2)), green2, (int) (blue + (i4 * f2)));
    }

    public static Intent getStartIntent(Context context, String str, boolean z, boolean z2) {
        return a(context, str, null, z, z2);
    }

    public static void startLightApp(Context context, String str, String str2, boolean z, boolean z2) {
        startLightApp(context, str, str2, z, z2, null);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        finish();
    }

    public void dismissLoadingProgress() {
        e();
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String exeSSCommand(String str, String str2, String str3) {
        return null;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void executeJsFunction(String str, String str2) {
        if (this.mWebView != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mWebView.evaluateJavascript(sb.toString(), null);
                    return;
                }
                LightappBrowserWebView lightappBrowserWebView = this.mWebView;
                lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:7:0x000c, B:9:0x0019, B:11:0x001d, B:13:0x0026, B:18:0x0049, B:20:0x004f, B:14:0x0031, B:16:0x0041, B:21:0x0052, B:23:0x005d, B:24:0x0067), top: B:27:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void executeJsFunctionBase64(String str, T t) {
        String encodeToString;
        if (this.mWebView != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (t != null) {
                    if (t instanceof String) {
                        if (!TextUtils.isEmpty((String) t)) {
                            encodeToString = Base64Utils.encodeToString(((String) t).getBytes());
                            if (!TextUtils.isEmpty(encodeToString)) {
                                sb.append(encodeToString);
                            }
                        }
                        encodeToString = null;
                        if (!TextUtils.isEmpty(encodeToString)) {
                        }
                    } else {
                        if ("[B".equals(t.getClass().toString())) {
                            encodeToString = Base64Utils.encodeToString((byte[]) t);
                            if (!TextUtils.isEmpty(encodeToString)) {
                            }
                        }
                        encodeToString = null;
                        if (!TextUtils.isEmpty(encodeToString)) {
                        }
                    }
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mWebView.evaluateJavascript(sb.toString(), null);
                    return;
                }
                this.mWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public com.baidu.wallet.lightapp.multipage.a getBusinessImpl() {
        return this;
    }

    public String getCanceledMsg() {
        return "取消";
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getContentLayoutId() {
        return "wallet_langbrige_webview";
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Context getContext() {
        return getApplicationContext();
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getErrMsg() {
        return ResUtils.getString(getActivity(), "wallet_base_select_phone_fail");
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getLightappWebviewId() {
        return "cust_webview";
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        return JsonUtils.toJson(this.mLoadTimeLine);
    }

    public boolean getShowShareForIntent() {
        return getIntent().getBooleanExtra("shwoshare", false);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i) {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        return true;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        return false;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        this.J = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.f24611g, str);
        getActivity().startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 5);
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean needKeyboardAdjust() {
        return true;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        if (i == 4) {
            if (i2 == -1) {
                if (intent == null || intent.getData() == null || (contactInfoPresenter = this.I) == null) {
                    return;
                }
                contactInfoPresenter.a(intent.getData());
                return;
            }
            LightappBusinessClient lightappBusinessClient = this.f24611g;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.onContactsSelected("", 1, null, getCanceledMsg(), "0");
            }
        } else if (i == 5) {
            LogUtil.d("LightappBrowseActivity", "onActivityResult resultCode = " + i2);
            JSONObject jSONObject = new JSONObject();
            if (i2 == -1) {
                if (intent == null || intent.getData() == null) {
                    return;
                }
                this.J.a(intent, jSONObject);
                return;
            }
            try {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, 10005);
                jSONObject.put("des", "用户取消选择");
                this.f24611g.setAlubmPhotoData(1, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.J.a("#callNativePhoto Fail", "用户取消选择");
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f24605f));
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f24605f));
        LightappBusinessClient lightappBusinessClient = this.f24611g;
        if ((lightappBusinessClient != null ? lightappBusinessClient.getH5BackCb() : null) != null) {
            executeJsFunction(LightappBusinessClient.MTD_H5GOBCK, null);
        } else {
            if (this.f24610e == 12 && !this.mWebView.canGoBack()) {
                a(2, "实名认证取消");
            }
            super.onBackPressed();
        }
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            this.k = lightappBrowserWebView.getUrl();
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i, int i2, String str) {
        this.G.post(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i, Object obj, String str) {
        this.G.post(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.2
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        int i = f24605f;
        if (i < 2) {
            f24605f = i + 1;
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                this.f24610e = extras.getInt(Constants.BDL_KEY_BIZTYPE, 0);
                this.k = extras.getString("jump_url");
                this.j = extras.getString("title");
                this.mLangbridgeHash = extras.getLong("LANGBRIDGE_HASH", 0L);
                if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                    a(activityLifecycleCallbacks);
                }
            } catch (Exception unused) {
            }
        }
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_ON_CREATE, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f24605f));
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_ON_CREATE, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f24605f));
        if (Build.VERSION.SDK_INT >= 11) {
            requestWindowFeature(10);
        }
        if (bundle != null) {
            this.k = bundle.getString("jump_url");
            this.m = bundle.getBoolean("shwoshare", false);
            this.n = bundle.getBoolean(LangbridgeActivity.IS_SHOW_NATIVE_ERROR_PAGE, true);
            this.o = bundle.getBoolean(LangbridgeActivity.IS_SHOW_TITLE_BAR, true);
            this.j = bundle.getString("title");
        }
        super.onCreate(bundle);
        if (this.mWebView != null && !TextUtils.isEmpty(this.k)) {
            LangbridgeCacheManager.getInstance().handleCreateLangbirdge(this.k, this.mWebView);
            a(this.k);
            setIsShowMultiWindowTips(true);
            setIsMultiWindowAvailable(false);
            this.G = new Handler(getMainLooper());
            this.m = getShowShareForIntent();
            if (this.k.contains("showShare=1") || this.k.contains("showShare%3d1")) {
                this.m = true;
            }
            if (this.k.contains("hideShare=1") || this.k.contains("hideShare%3d1")) {
                this.m = false;
            }
            if (this.k.contains("hideNativeErrorPage=1") || this.k.contains("hideNativeErrorPage%3d1")) {
                this.n = false;
            }
            if (this.k.contains("hideTitleBar")) {
                this.o = false;
            }
            String userAgentString = this.mWebView.getSettings().getUserAgentString();
            LogUtil.logd("ua=" + userAgentString);
            if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
                userAgentString = userAgentString + " " + BussinessUtils.getUA(getActivity());
                this.mWebView.getSettings().setUserAgentString(userAgentString);
            }
            if (!TextUtils.isEmpty(userAgentString)) {
                LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
            }
            LogUtil.logd("ua2=" + this.mWebView.getSettings().getUserAgentString());
            this.mWebView.setWebViewClient(new CustomWebViewClient());
            this.mWebView.setWebChromeClient(new CustomChromeClient());
            this.mWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.1

                /* renamed from: a  reason: collision with root package name */
                public Pattern f24613a;

                /* renamed from: b  reason: collision with root package name */
                public Matcher f24614b;

                {
                    Pattern compile = Pattern.compile(".*");
                    this.f24613a = compile;
                    this.f24614b = compile.matcher("");
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        LightappBrowseActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    } catch (Exception e2) {
                        LogUtil.e("LightappBrowseActivity", "Download Error", e2);
                        GlobalUtils.toast(LightappBrowseActivity.this.getActivity(), "下载出现异常");
                    }
                }
            });
            com.baidu.wallet.lightapp.base.a.a().a(getActivity());
            this.A = "";
            this.z = ResUtils.getString(this, "ebpay_loading");
            this.v = (NoNetView) findViewById(ResUtils.id(getActivity(), "nonet_view"));
            this.w = findViewById(ResUtils.id(getActivity(), "progress_line"));
            this.r = a(getIntent().getExtras().getBoolean(Constants.LONG_TITLE));
            this.v = (NoNetView) findViewById(ResUtils.id(getActivity(), "nonet_view"));
            this.u = (LangBrigdeSlideLayout) findViewById(ResUtils.id(getActivity(), "bd_langbridge_slide"));
            this.s = (FrameLayout) findViewById(ResUtils.id(getActivity(), "bd_ab_container"));
            this.t = (FrameLayout) findViewById(ResUtils.id(getActivity(), "bd_trans_container"));
            this.x = (FrameLayout) findViewById(ResUtils.id(getActivity(), "progress_line_container"));
            this.y = (FrameLayout) findViewById(ResUtils.id(getActivity(), "progress_trans_container"));
            View view = new View(getActivity());
            this.w = view;
            view.setVisibility(8);
            setActionBarTransparent(false);
            WebviewMenu webviewMenu = new WebviewMenu(getActivity());
            this.p = webviewMenu;
            webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.5
                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    switch (bdMenuItem.getItemId()) {
                        case 32:
                            DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)));
                            PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(LightappBrowseActivity.this.k));
                            LightAppWrapper.getInstance().callShare(LightappBrowseActivity.this.getActivity(), new LightAppShareModel(LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getUrl(), null), null);
                            return;
                        case 33:
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)));
                            PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(LightappBrowseActivity.this.k));
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LightappBrowseActivity.this.getActivity(), LightappBrowseActivity.this.k);
                            LightappBrowseActivity.this.mWebView.reload();
                            LightappBrowseActivity.this.f24606a = false;
                            return;
                        case 34:
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
                            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.f24605f));
                            if (LightappBrowseActivity.this.f24610e == 12) {
                                LightappBrowseActivity.this.a(2, "实名认证取消");
                            }
                            LightappBrowseActivity.this.finish();
                            return;
                        default:
                            return;
                    }
                }
            });
            this.f24611g = (LightappBusinessClient) this.mLightappJsClient.getLightappBusiness();
            b(this.A);
            this.f24607b = (LinearLayout) findViewById(ResUtils.id(getActivity(), "walelt_app_host_background"));
            this.H = (TextView) findViewById(ResUtils.id(getActivity(), "walelt_base_light_app_host"));
            try {
                if (!l.matcher(this.k).matches()) {
                    this.k = "https://" + this.k;
                }
                this.mWebView.loadUrl(this.k.trim());
                this.f24606a = false;
            } catch (Exception unused2) {
                LogUtil.d("Url error");
                finish();
            }
            this.mLoadTimeLine = new Vector<>();
            if (!TextUtils.isEmpty(this.k)) {
                this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), MissionEvent.MESSAGE_CREATE, String.valueOf(System.currentTimeMillis())));
            }
            d("common");
            return;
        }
        finish();
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    @Nullable
    public Dialog onCreateDialog(int i) {
        if (1000 == i) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i);
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.mLangbridgeHash);
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.baidu.wallet.lightapp.monitor.a.a().b();
        this.f24611g = null;
        if (this.f24610e == 12) {
            LocalRouter.getInstance(getApplicationContext()).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), null);
        }
        a(LifeCycleCbName.OnDestroyed, (Bundle) null);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (z && this.E) {
                if (this.C) {
                    GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.D), -1, 1);
                }
                if (this.F) {
                    return;
                }
                finish();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f24612h = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.k, this.f24612h);
        if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
            this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), MissionEvent.MESSAGE_PAUSE, String.valueOf(System.currentTimeMillis())));
        }
        this.E = false;
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (1000 == i) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(ResUtils.string(getApplicationContext(), "bd_wallet_download_prompt"));
            promptDialog.setCanceledOnTouchOutside(true);
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Activity activity = LightappBrowseActivity.this.getActivity();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    activity.removeDialog(1000);
                }
            });
            promptDialog.hideNegativeButton();
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        if (!NetworkUtils.isNetworkAvailable(getApplicationContext())) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getApplicationContext(), "ebpay_no_network"));
            return;
        }
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.reload();
            this.f24606a = false;
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        LightappBusinessClient lightappBusinessClient = this.f24611g;
        if (lightappBusinessClient != null) {
            lightappBusinessClient.onRequestPermissionsResult(this.K, i, strArr, iArr);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.L) {
            this.f24611g.checkPermission();
            this.L = false;
        }
        if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
            this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), MissionEvent.MESSAGE_RESUME, String.valueOf(System.currentTimeMillis())));
        }
        f();
        this.E = true;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public void onWebViewBack() {
        this.f24606a = false;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(final String str, boolean z) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LightappBrowseActivity.this.mWebView.loadUrl(str.trim());
                    LightappBrowseActivity.this.f24606a = false;
                } catch (Exception unused) {
                    LightappBrowseActivity.this.finish();
                }
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i) {
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public void prepareSelectNumDialog(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        SelectNumberDialog selectNumberDialog = new SelectNumberDialog(getActivity());
        selectNumberDialog.setOnItemClickListener(onItemClickListener);
        selectNumberDialog.setData(list);
        selectNumberDialog.show();
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.i.removeElement(activityLifecycleCallbacks);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        this.I = new ContactInfoPresenter(getActivity(), this.f24611g);
        ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
    }

    public void setActionBarTransparent(boolean z) {
        LogUtil.d("LightappBrowseActivity", "setActionBarTransparent:" + z);
        FrameLayout frameLayout = z ? this.s : this.t;
        FrameLayout frameLayout2 = z ? this.t : this.s;
        FrameLayout frameLayout3 = z ? this.x : this.y;
        FrameLayout frameLayout4 = z ? this.y : this.x;
        if (this.r == null || frameLayout2.getChildCount() != 0 || this.w == null || frameLayout4.getChildCount() != 0) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout3.removeAllViews();
        frameLayout2.addView(this.r);
        frameLayout4.addView(this.w, new ViewGroup.LayoutParams(DisplayUtils.dip2px(this, 10.0f), DisplayUtils.dip2px(this, 2.0f)));
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str, final String str2) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.9
            private void a() {
                if (z) {
                    LightappBrowseActivity.this.mWebView.setOnMyScrollChangeListener(new LightappWebView.a() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.9.1
                        @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                        public void a(int i) {
                            int height = LightappBrowseActivity.this.r.getHeight();
                            float f2 = (height - i) / height;
                            if (f2 > 0.0f) {
                                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                                if (lightappBrowseActivity.f24609d != 0) {
                                    lightappBrowseActivity.r.setFullScreenTextColor(LightappBrowseActivity.this.f24609d);
                                }
                                float f3 = 1.0f - f2;
                                int i2 = (int) (255.0f * f3);
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                if (z2) {
                                    if (i2 >= 255) {
                                        LightappBrowseActivity.this.r.setTitleTextColorAlpha(i2);
                                    } else {
                                        LightappBrowseActivity.this.r.setTitleTextColorAlpha(0);
                                    }
                                }
                                AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                                if (z4) {
                                    LightappBrowseActivity.this.r.setIconFlag(true);
                                }
                                LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                                if (lightappBrowseActivity2.f24608c != -1) {
                                    BdActionBar bdActionBar = lightappBrowseActivity2.r;
                                    LightappBrowseActivity lightappBrowseActivity3 = LightappBrowseActivity.this;
                                    bdActionBar.setTitlebgColor(LightappBrowseActivity.getCurrentColor(f3, lightappBrowseActivity3.f24608c, ResUtils.getColor(lightappBrowseActivity3.getActivity(), "wallet_extend_color_actionbar_bg")));
                                    return;
                                }
                                return;
                            }
                            AnonymousClass9 anonymousClass93 = AnonymousClass9.this;
                            if (z2) {
                                LightappBrowseActivity.this.r.setTitleTextColorAlpha(255);
                            }
                            AnonymousClass9 anonymousClass94 = AnonymousClass9.this;
                            if (z4) {
                                LightappBrowseActivity.this.r.setIconFlag(false);
                            }
                            LightappBrowseActivity.this.r.setTitlebgColor(ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_extend_color_actionbar_bg"));
                            LightappBrowseActivity.this.r.resetFullScreenTextColor();
                        }
                    });
                } else {
                    LightappBrowseActivity.this.mWebView.setOnMyScrollChangeListener(new LightappWebView.a() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.9.2
                        @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                        public void a(int i) {
                            int height = LightappBrowseActivity.this.r.getHeight();
                            float f2 = (height - i) / height;
                            if (f2 > 0.0f) {
                                int i2 = (int) ((1.0f - f2) * 255.0f);
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                if (z2) {
                                    if (i2 >= 255) {
                                        LightappBrowseActivity.this.r.setTitleTextColorAlpha(i2);
                                        return;
                                    } else {
                                        LightappBrowseActivity.this.r.setTitleTextColorAlpha(0);
                                        return;
                                    }
                                }
                                return;
                            }
                            AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                            if (z2) {
                                LightappBrowseActivity.this.r.setTitleTextColorAlpha(255);
                            }
                        }
                    });
                }
            }

            private void b() {
                if (z2) {
                    LightappBrowseActivity.this.r.setTitleTextColorAlpha(0);
                } else {
                    LightappBrowseActivity.this.r.setTitleTextColorAlpha(255);
                }
            }

            private void c() {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        LightappBrowseActivity.this.f24609d = Color.parseColor(str2);
                    } catch (Throwable unused) {
                    }
                } else {
                    LightappBrowseActivity.this.f24609d = 0;
                }
                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                if (lightappBrowseActivity.f24609d != 0) {
                    lightappBrowseActivity.r.setFullScreenTextColor(LightappBrowseActivity.this.f24609d);
                } else {
                    lightappBrowseActivity.r.resetFullScreenTextColor();
                }
            }

            private void d() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        LightappBrowseActivity.this.f24608c = Color.parseColor(str);
                    } catch (Throwable unused) {
                    }
                } else {
                    LightappBrowseActivity.this.f24608c = -1;
                }
                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                if (lightappBrowseActivity.f24608c != -1) {
                    lightappBrowseActivity.r.setTitlebgColor(LightappBrowseActivity.this.f24608c);
                    LightappBrowseActivity.this.r.setBottomSeperatorvisible(false);
                    LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                    lightappBrowseActivity2.setActionBarTransparent(Color.alpha(lightappBrowseActivity2.f24608c) != 255);
                    return;
                }
                lightappBrowseActivity.r.setTitlebgColor(ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_extend_color_actionbar_bg"));
                LightappBrowseActivity.this.r.setBottomSeperatorvisible(true);
                LightappBrowseActivity.this.setActionBarTransparent(false);
            }

            private void e() {
                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                int i = lightappBrowseActivity.f24608c;
                if (i != -1 && ((-16777216) | i) != -1) {
                    lightappBrowseActivity.f24607b.setBackgroundColor(i);
                } else {
                    LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                    lightappBrowseActivity2.f24607b.setBackgroundColor(ResUtils.getColor(lightappBrowseActivity2.getActivity(), "wallet_base_background1_color_7f"));
                }
                LightappBrowseActivity lightappBrowseActivity3 = LightappBrowseActivity.this;
                if (lightappBrowseActivity3.f24609d != 0) {
                    lightappBrowseActivity3.H.setTextColor(LightappBrowseActivity.this.f24609d);
                } else {
                    lightappBrowseActivity3.H.setTextColor(ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_base_font_text4Color"));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                LightappBrowseActivity.this.r.setIconFlag(z4);
                if (LightappBrowseActivity.this.u != null) {
                    LightappBrowseActivity.this.u.setSupportPullDown(!z3);
                }
                d();
                c();
                b();
                e();
                a();
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionBarHeight", DisplayUtils.px2dip(getApplicationContext(), this.r.getActionBarHeight()));
            jSONObject.put("statusBarHeight", DisplayUtils.px2dip(getApplicationContext(), this.r.getStatusBarHeight()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setIsCheckPermission(boolean z) {
        this.L = z;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.F) {
            this.F = z;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.C) {
            this.C = z;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(final JSONArray jSONArray) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if (LightappBrowseActivity.this.r.getRightZoneView() == null) {
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                lightappBrowseActivity.q = new a(lightappBrowseActivity2.getActivity(), jSONArray);
                LightappBrowseActivity.this.r.setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.10.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (LightappBrowseActivity.this.q != null) {
                            LightappBrowseActivity.this.q.show();
                        } else if (LightappBrowseActivity.this.p != null) {
                            LightappBrowseActivity.this.p.show();
                        }
                    }
                });
            }
        });
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setMultiWindowTipsId(String str) {
        this.D = str;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        super.setSupportZoom();
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(final String str, final String str2, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.8
            @Override // java.lang.Runnable
            public void run() {
                if (LightappBrowseActivity.this.r != null) {
                    if (!NetworkUtils.isNetworkConnected(LightappBrowseActivity.this.getActivity())) {
                        LightappBrowseActivity.this.r.setTitle(LightappBrowseActivity.this.A);
                        LightappBrowseActivity.this.r.setTitleCenterSafeTipText("");
                    } else if (TextUtils.isEmpty(str)) {
                        LightappBrowseActivity.this.r.setTitle(LightappBrowseActivity.this.mWebView.getTitle());
                        LightappBrowseActivity.this.B = null;
                    } else {
                        String str3 = str;
                        LightappBrowseActivity.this.r.setTitle(str3);
                        LightappBrowseActivity.this.B = str3;
                        if (TextUtils.isEmpty(str2)) {
                            LightappBrowseActivity.this.r.setTitleCenterSafeTipText("");
                        } else {
                            String trim = str2.trim();
                            if (!TextUtils.isEmpty(trim)) {
                                LightappBrowseActivity.this.r.setTitleCenterSafeTipText(trim);
                            }
                        }
                    }
                    if (z) {
                        int[] titleSizeRange = LightappBrowseActivity.this.r.getTitleSizeRange();
                        int i = titleSizeRange[0];
                        int i2 = titleSizeRange[1];
                        int mainTitleViewWidth = LightappBrowseActivity.this.r.getMainTitleViewWidth();
                        float f2 = i;
                        float stringWidth = StringUtil.getStringWidth(LightappBrowseActivity.this.r.getTitle(), f2);
                        LightappBrowseActivity.this.r.setTitleEllipsize(TextUtils.TruncateAt.END);
                        float f3 = mainTitleViewWidth;
                        if (stringWidth <= f3) {
                            LightappBrowseActivity.this.r.setTitleSize(i);
                            return;
                        }
                        float f4 = f3 / stringWidth;
                        if (1.0f <= f4 || i2 / f2 > f4) {
                            LightappBrowseActivity.this.r.setTitleSize(i2);
                            return;
                        }
                        LightappBrowseActivity.this.r.setTitleSize(Math.round(f2 * f4));
                    }
                }
            }
        });
    }

    public void showLoadingProgress() {
        d();
    }

    private void e() {
        this.w.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
    }

    @TargetApi(24)
    private void f() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (this.C && isInMultiWindowMode()) {
                GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.D), -1, 1);
            }
            if (this.F || !isInMultiWindowMode()) {
                return;
            }
            finish();
        }
    }

    public static void startLightApp(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        Intent a2 = a(context, str, str2, z, z2, bundle);
        if (a2 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a2.putExtra("LANGBRIDGE_HASH", currentTimeMillis);
        LangbridgeCacheManager.getInstance().handleStartLangbirdge(currentTimeMillis, str);
        context.startActivity(a2);
        if (context instanceof Activity) {
            if (z) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.n) {
            NoNetView noNetView = this.v;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappBrowserWebView lightappBrowserWebView = this.mWebView;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(8);
            }
        }
    }

    private void d() {
        this.w.setVisibility(0);
        this.w.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
        a(5);
    }

    private void b(String str) {
        BdActionBar bdActionBar = this.r;
        if (bdActionBar == null) {
            return;
        }
        if (!this.o) {
            bdActionBar.setVisibility(8);
        }
        this.r.setTitle(this.A);
        this.r.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GlobalUtils.hideKeyboard(LightappBrowseActivity.this.getActivity());
                LightappBrowseActivity.this.onBackPressed();
            }
        });
        if (this.p == null) {
            return;
        }
        this.r.setRightImgZone2Visibility(0);
        this.r.setRightImgZone2Enable(true);
        this.r.setRightImgZone2Src(ResUtils.drawable(getActivity(), "wallet_base_overflow"), ResUtils.getString(getActivity(), "wallet_base_bdaction_more"));
        this.r.setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LightappBrowseActivity.this.p.show();
            }
        });
        this.r.setOnlyIcons(getIntent().getExtras().getBoolean(Constants.ONLY_ICONS));
    }

    private void d(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        String[] b2 = com.baidu.wallet.lightapp.business.a.b(str);
        LogUtil.d("LightappBrowseActivity", "OLD to add Js Hook groupName = " + str + "\n filesName=" + Arrays.toString(b2));
        if (b2 == null || b2.length <= 0) {
            return;
        }
        for (String str2 : b2) {
            if (!TextUtils.isEmpty(str2)) {
                String a2 = com.baidu.wallet.lightapp.business.a.a(str2);
                if (!TextUtils.isEmpty(a2) && (lightappBrowserWebView = this.mWebView) != null) {
                    lightappBrowserWebView.addJsCode(str2, a2);
                    LogUtil.d("WebViewCacheManager", "OLD toAdd COMMON JSFile = " + a2);
                }
            }
        }
    }

    private void a(String str) {
        if (TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(LangbridgeActivity.KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        NoNetView noNetView = this.v;
        if (noNetView != null) {
            noNetView.notifyUrlFinish();
        }
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.setVisibility(0);
        }
    }

    public static void startLightApp(Context context, String str, boolean z) {
        startLightApp(context, str, null, true, z);
    }

    private BdActionBar a(boolean z) {
        if (z) {
            return new BdLightAppActionBar(getActivity());
        }
        return new BdActionBar(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
        layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(getActivity()) * i) / 100.0f);
        this.w.setLayoutParams(layoutParams);
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2) {
        return a(context, str, str2, z, z2, null);
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, LightappBrowseActivity.class);
        intent.putExtra("jump_url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("with_anim", z);
        intent.putExtra("shwoshare", z2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            LogUtil.d("LightappBrowseActivity", "context is activity!");
        } else {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        LocalRouter.getInstance(getApplicationContext()).route(this, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data("statusCode", Integer.valueOf(i)).data("desc", str), null);
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Object[] array = this.i.toArray();
        Activity activity = getActivity();
        switch (AnonymousClass4.f24624a[lifeCycleCbName.ordinal()]) {
            case 1:
                for (int length = array.length - 1; length >= 0; length--) {
                    ((Application.ActivityLifecycleCallbacks) array[length]).onActivityCreated(activity, bundle);
                }
                return;
            case 2:
                for (int length2 = array.length - 1; length2 >= 0; length2--) {
                    ((Application.ActivityLifecycleCallbacks) array[length2]).onActivityStarted(activity);
                }
                return;
            case 3:
                for (int length3 = array.length - 1; length3 >= 0; length3--) {
                    ((Application.ActivityLifecycleCallbacks) array[length3]).onActivityResumed(activity);
                }
                return;
            case 4:
                for (int length4 = array.length - 1; length4 >= 0; length4--) {
                    ((Application.ActivityLifecycleCallbacks) array[length4]).onActivityPaused(activity);
                }
                return;
            case 5:
                for (int length5 = array.length - 1; length5 >= 0; length5--) {
                    ((Application.ActivityLifecycleCallbacks) array[length5]).onActivityStopped(activity);
                }
                return;
            case 6:
                for (int length6 = array.length - 1; length6 >= 0; length6--) {
                    ((Application.ActivityLifecycleCallbacks) array[length6]).onActivitySaveInstanceState(activity, bundle);
                }
                return;
            case 7:
                for (int length7 = array.length - 1; length7 >= 0; length7--) {
                    ((Application.ActivityLifecycleCallbacks) array[length7]).onActivityDestroyed(activity);
                }
                return;
            default:
                return;
        }
    }

    private void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks == null || this.i.contains(activityLifecycleCallbacks)) {
            return;
        }
        this.i.addElement(activityLifecycleCallbacks);
    }
}
