package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.widget.BdLightAppActionBar;
import com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.android.material.badge.BadgeDrawable;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LangbridgeCell implements com.baidu.wallet.lightapp.multipage.a, c, NoNetView.a {
    public static final Pattern O = Pattern.compile("^(https?://|file:///android_asset/).*");
    public List<String> A;
    public ContactInfoPresenter B;
    public Vector<LoadTimeLine> C;
    public int D;
    public int E;
    public FrameLayout F;
    public FrameLayout G;
    public FrameLayout H;
    public FrameLayout I;
    public Intent J;
    public int K;
    public String L;
    public boolean M;
    public boolean N;
    public com.baidu.wallet.lightapp.business.presenter.a P;
    public String Q;
    public int R;
    public Uri S;

    /* renamed from: a  reason: collision with root package name */
    public String f25007a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f25008b;

    /* renamed from: c  reason: collision with root package name */
    public LightappJsClient f25009c;

    /* renamed from: d  reason: collision with root package name */
    public LightappBusinessClient f25010d;

    /* renamed from: e  reason: collision with root package name */
    public ValueCallback<Uri> f25011e;

    /* renamed from: f  reason: collision with root package name */
    public ValueCallback<Uri[]> f25012f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25013g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25014h;

    /* renamed from: i  reason: collision with root package name */
    public View f25015i;
    public Context j;
    public LangbridgeSlideLayout k;
    public LightappBrowserWebView l;
    public Bundle m;
    public b n;
    public boolean o;
    public NoNetView p;
    public View q;
    public WebviewMenu r;
    public a s;
    public BdActionBar t;
    public LinearLayout u;
    public TextView v;
    public boolean w;
    public JSONArray x;
    public String y;
    public String z;

    /* loaded from: classes5.dex */
    public class CustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {

        /* renamed from: b  reason: collision with root package name */
        public Pattern f25058b = Pattern.compile("\\s*https?://.*");

        /* renamed from: c  reason: collision with root package name */
        public String f25059c;

        public CustomWebViewClient() {
        }

        private boolean a(String str, String str2) {
            return TextUtils.equals(str, str2);
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            if (langbridgeCell.f25013g) {
                langbridgeCell.l.clearHistory();
                if (str == null || str.contains("about:blank")) {
                    return;
                }
                LangbridgeCell.this.f25013g = false;
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Vector<LoadTimeLine> vector = LangbridgeCell.this.C;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
            }
            LangbridgeCell.this.s();
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            com.baidu.wallet.lightapp.base.a a2 = com.baidu.wallet.lightapp.base.a.a();
            LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
            langbridgeCell.R = a2.a(langbridgeCell2.j, str, langbridgeCell2.R);
            LangbridgeCell.this.y = str;
            String host = Uri.parse(str).getHost();
            this.f25059c = str;
            if (TextUtils.isEmpty(host)) {
                LangbridgeCell.this.v.setVisibility(8);
            } else {
                LangbridgeCell.this.v.setVisibility(0);
                LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                langbridgeCell3.v.setText(langbridgeCell3.j.getResources().getString(ResUtils.string(LangbridgeCell.this.j, "wallet_langbridge_url_outer"), host));
            }
            String title = LangbridgeCell.this.t.getTitle();
            if (title != null && title.equals("")) {
                String title2 = webView.getTitle();
                if (title2 != null && !this.f25058b.matcher(title2).matches()) {
                    LangbridgeCell.this.t.setTitle(title2);
                } else {
                    LangbridgeCell.this.t.setTitle((String) null);
                }
            }
            if (webView.getProgress() != 100) {
                LangbridgeCell.this.w = true;
            }
            LogUtil.d("LangbridgeCell", "onPageFinished.finishedError:  " + LangbridgeCell.this.w);
            super.onPageFinished(webView, str);
            LangbridgeCell.this.a(0, "success", str);
            com.baidu.wallet.lightapp.monitor.a.a().a((View) LangbridgeCell.this.l, "FINISH", false);
            String[] strArr = new String[3];
            strArr[0] = CheckUtils.stripUrlParams(LangbridgeCell.this.y);
            strArr[1] = LangbridgeCell.this.q();
            strArr[2] = LangbridgeCell.this.w ? "1" : "0";
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(strArr));
            String[] strArr2 = new String[3];
            strArr2[0] = CheckUtils.stripUrlParams(LangbridgeCell.this.y);
            strArr2[1] = LangbridgeCell.this.q();
            strArr2[2] = LangbridgeCell.this.w ? "1" : "0";
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(strArr2));
            if (LangbridgeCell.this.isActiveCell()) {
                LangbridgeCacheManager.getInstance().handleFinishPage(str);
            }
            String str2 = h.a().a(LangbridgeCell.this.getContext()).MW_JSCALL_ONACTIVE;
            if (LangbridgeCell.this.isActiveCell() && !TextUtils.isEmpty(str2)) {
                LangbridgeCell.this.executeJsFunction(str2, null);
            }
            LightappBrowserWebView lightappBrowserWebView = LangbridgeCell.this.l;
            if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack()) {
                return;
            }
            LangbridgeCell langbridgeCell4 = LangbridgeCell.this;
            if (langbridgeCell4.f25013g) {
                return;
            }
            langbridgeCell4.v();
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            boolean z;
            Vector<LoadTimeLine> vector = LangbridgeCell.this.C;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
            }
            LangbridgeCell.this.z = str;
            if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                LangbridgeCell.this.setFullScreenInMainThread(false, false, false, false, "", "");
            }
            if (!LangbridgeCell.this.isActiveCell() || LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                LangbridgeCell.this.r();
            }
            LangbridgeCell.this.t.setTitle("");
            LangbridgeCell.this.t.setTitleCenterSafeTipText("");
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            langbridgeCell.s = null;
            LightappBusinessClient lightappBusinessClient = langbridgeCell.f25010d;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.setH5BackCb(null);
            }
            LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
            langbridgeCell2.f25007a = null;
            langbridgeCell2.f25009c.setUrlLocal(str);
            super.onPageStarted(webView, str, bitmap);
            com.baidu.wallet.lightapp.monitor.a.a().a((View) LangbridgeCell.this.l, "START", true);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
            if (LangbridgeCell.this.isActiveCell()) {
                LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext()).setAllCellsEnable(false);
                LangbridgeCacheManager.getInstance().handleStartPage(str);
                z = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
            } else {
                z = false;
            }
            if (!NetworkUtils.isNetworkAvailable(LangbridgeCell.this.j) && !z) {
                LangbridgeCell.this.c(str);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(CheckUtils.stripUrlParams(str)));
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_WRC_SHOW_ERROR, CheckUtils.stripUrlParams(str));
            }
            if (a(str, this.f25059c)) {
                return;
            }
            com.baidu.wallet.lightapp.base.c.a(LangbridgeCell.this.getActivity());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str;
            String str2;
            String str3;
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
            linkedHashMap.put("pageUrl", LangbridgeCell.this.z);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.z).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, LangbridgeCell.this.getContext());
            if (webResourceError == null || webResourceRequest == null || -10 == webResourceError.getErrorCode() || !webResourceRequest.isForMainFrame()) {
                return;
            }
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            langbridgeCell.w = true;
            NoNetView noNetView = langbridgeCell.p;
            if (noNetView != null) {
                noNetView.setFailureCause(webResourceError.getErrorCode());
            }
            LangbridgeCell.this.c(webResourceRequest.getUrl().toString());
            LangbridgeCell.this.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), webResourceRequest.getUrl().toString());
            LogUtil.d("LangbridgeCell", "onReceivedError2.showErrorPage");
            String[] strArr = new String[4];
            strArr[0] = String.valueOf(webResourceError.getErrorCode());
            strArr[1] = String.valueOf(webResourceRequest.getUrl());
            LightappBrowserWebView b2 = LangbridgeCell.this.b();
            String str4 = StringUtil.NULL_STRING;
            if (b2 == null) {
                str = StringUtil.NULL_STRING;
            } else {
                str = LangbridgeCell.this.b().hashCode() + "";
            }
            strArr[2] = str;
            if (LangbridgeCell.this.f25009c == null) {
                str2 = StringUtil.NULL_STRING;
            } else {
                str2 = LangbridgeCell.this.f25009c.hashCode() + "";
            }
            strArr[3] = str2;
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
            String[] strArr2 = new String[4];
            strArr2[0] = String.valueOf(webResourceError.getErrorCode());
            strArr2[1] = String.valueOf(webResourceRequest.getUrl());
            if (LangbridgeCell.this.b() == null) {
                str3 = StringUtil.NULL_STRING;
            } else {
                str3 = LangbridgeCell.this.b().hashCode() + "";
            }
            strArr2[2] = str3;
            if (LangbridgeCell.this.f25009c != null) {
                str4 = LangbridgeCell.this.f25009c.hashCode() + "";
            }
            strArr2[3] = str4;
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (Build.VERSION.SDK_INT >= 21) {
                String mimeType = webResourceResponse.getMimeType();
                int statusCode = webResourceResponse.getStatusCode();
                String uri = webResourceRequest.getUrl().toString();
                if (mimeType.contains(SapiWebView.DATA_MIME_TYPE) && 400 <= statusCode && statusCode < 600 && !uri.contains("favicon.ico")) {
                    LangbridgeCell.this.a(statusCode, webResourceResponse.getReasonPhrase(), uri);
                    LogUtil.d("LangbridgeCell", "onReceivedHttpError2,callback");
                }
            }
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
                    linkedHashMap.put("pageUrl", LangbridgeCell.this.z);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.z).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, linkedHashMap, LangbridgeCell.this.getContext());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (sslError != null) {
                linkedHashMap.put("errorCode", String.valueOf(sslError.getPrimaryError()));
                linkedHashMap.put("url", sslError.getUrl());
                linkedHashMap.put("certificate", String.valueOf(sslError.getCertificate()));
                linkedHashMap.put("pageUrl", LangbridgeCell.this.z);
            }
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.z).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, linkedHashMap, LangbridgeCell.this.getContext());
            int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
            String url = sslError == null ? null : sslError.getUrl();
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
            if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                sslErrorHandler.proceed();
                return;
            }
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            langbridgeCell.w = true;
            NoNetView noNetView = langbridgeCell.p;
            if (noNetView != null) {
                noNetView.setFailureCause(primaryError);
            }
            LangbridgeCell.this.c(url);
            LangbridgeCell.this.a(primaryError, sslError.getCertificate().toString(), sslError.getUrl());
            LogUtil.d("LangbridgeCell", "onReceivedSslError");
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (LangbridgeCell.this.isActiveCell() && LangbridgeCell.this.f25014h) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.o().getLangbridgeHash(), webResourceRequest.getUrl().toString());
                LangbridgeCell.this.f25014h = false;
            }
            if (LangbridgeCell.this.isActiveCell()) {
                return LangbridgeCacheManager.getInstance().interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", "OriginalUrl : " + webView.getOriginalUrl());
            com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", "shouldOverrideUrlLoading url = " + str);
            if (str.startsWith("tel:")) {
                LangbridgeCell.this.a(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            }
            if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "")});
                    LangbridgeCell.this.a(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    GlobalUtils.toast(LangbridgeCell.this.j, "请先配置邮箱");
                }
            } else if (!str.toLowerCase(Locale.CHINA).startsWith("http") && !str.toLowerCase(Locale.CHINA).startsWith("https") && !str.toLowerCase(Locale.CHINA).startsWith("file")) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    if (Build.VERSION.SDK_INT >= 15) {
                        parseUri.setSelector(null);
                    }
                    LangbridgeCell.this.a(parseUri);
                    return true;
                } catch (Exception e3) {
                    com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", e3.getMessage());
                }
            } else {
                if (LangbridgeCell.this.isActiveCell()) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.o().getLangbridgeHash(), str);
                }
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, str);
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
            if (LangbridgeCell.this.isActiveCell() && LangbridgeCell.this.f25014h) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.o().getLangbridgeHash(), str);
                LangbridgeCell.this.f25014h = false;
            }
            if (LangbridgeCell.this.isActiveCell()) {
                return LangbridgeCacheManager.getInstance().interceptRequest(str, null);
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            String str3;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("errorCode", String.valueOf(i2));
            linkedHashMap.put("url", str2);
            linkedHashMap.put("reasonPhrase", str);
            linkedHashMap.put("pageUrl", LangbridgeCell.this.z);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.z).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, LangbridgeCell.this.getContext());
            if (-10 == i2) {
                return;
            }
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            langbridgeCell.w = true;
            NoNetView noNetView = langbridgeCell.p;
            if (noNetView != null) {
                noNetView.setFailureCause(i2);
            }
            LangbridgeCell.this.c(str2);
            LangbridgeCell.this.a(i2, str, str2);
            String[] strArr = new String[4];
            strArr[0] = i2 + "";
            strArr[1] = str2;
            LightappBrowserWebView b2 = LangbridgeCell.this.b();
            String str4 = StringUtil.NULL_STRING;
            if (b2 == null) {
                str3 = StringUtil.NULL_STRING;
            } else {
                str3 = LangbridgeCell.this.b().hashCode() + "";
            }
            strArr[2] = str3;
            strArr[3] = LangbridgeCell.this.f25009c.hashCode() + "";
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
            String[] strArr2 = new String[4];
            strArr2[0] = i2 + "";
            strArr2[1] = str2;
            if (LangbridgeCell.this.b() != null) {
                str4 = LangbridgeCell.this.b().hashCode() + "";
            }
            strArr2[2] = str4;
            strArr2[3] = LangbridgeCell.this.f25009c.hashCode() + "";
            PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr2));
            LogUtil.d("LangbridgeCell", "onReceivedError1.showErrorPage");
            super.onReceivedError(webView, i2, str, str2);
        }
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
            if (LangbridgeCell.this.m.getBoolean("lang_showshare", false)) {
                add(32, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    /* loaded from: classes5.dex */
    public class a extends LangBridgeMenuDialog implements NoProguard {

        /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeCell$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0249a {

            /* renamed from: a  reason: collision with root package name */
            public String f25066a;

            /* renamed from: b  reason: collision with root package name */
            public String f25067b;

            /* renamed from: c  reason: collision with root package name */
            public String f25068c;

            public C0249a() {
            }
        }

        public a(Context context, JSONArray jSONArray) {
            super(context);
            final ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!jSONArray.isNull(i2)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject.has("title") && jSONObject.has("icon") && jSONObject.has("callback")) {
                                C0249a c0249a = new C0249a();
                                c0249a.f25066a = jSONObject.optString("title", null);
                                c0249a.f25067b = jSONObject.optString("icon", null);
                                c0249a.f25068c = jSONObject.optString("callback", null);
                                if (compile.matcher(c0249a.f25066a).matches() && !TextUtils.isEmpty(c0249a.f25067b) && !TextUtils.isEmpty(c0249a.f25068c)) {
                                    if (5 <= arrayList.size()) {
                                        break;
                                    }
                                    arrayList.add(c0249a);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            final int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0249a c0249a2 = (C0249a) arrayList.get(i3);
                add(i3 + 256, c0249a2.f25066a, c0249a2.f25067b);
            }
            add(GDiffPatcher.COPY_INT_USHORT, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (LangbridgeCell.this.m.getBoolean("lang_showshare", false)) {
                add(254, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(255, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            setMenuItemClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.a.1
                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    int itemId = bdMenuItem.getItemId();
                    if (255 == itemId) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
                        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCell.this.o().setRnAuthResult(2, "实名认证取消");
                            LangbridgeCell.this.o().closeWindow();
                        }
                    } else if (254 == itemId) {
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y)));
                        PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(LangbridgeCell.this.y));
                        LightAppWrapper.getInstance().callShare(LangbridgeCell.this.getActivity(), new LightAppShareModel(LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getUrl(), null), null);
                    } else if (253 == itemId) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y)));
                        PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(LangbridgeCell.this.y));
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LangbridgeCell.this.getActivity(), LangbridgeCell.this.y);
                        }
                        LangbridgeCell.this.l.reload();
                        LangbridgeCell langbridgeCell = LangbridgeCell.this;
                        langbridgeCell.y = langbridgeCell.l.getUrl();
                        LangbridgeCell.this.w = false;
                    } else {
                        int i4 = itemId - 256;
                        if (i4 <= size) {
                            LangbridgeCell.this.executeJsFunction(((C0249a) arrayList.get(i4)).f25068c, "");
                        }
                    }
                }
            });
            layoutMenu();
        }
    }

    public LangbridgeCell(Context context, LightappBrowserWebView lightappBrowserWebView, String str) {
        this.f25013g = true;
        this.f25014h = false;
        this.m = new Bundle();
        this.o = false;
        this.w = false;
        this.J = null;
        this.K = -1;
        this.L = null;
        this.M = false;
        this.N = false;
        this.R = -1;
        this.D = -1;
        this.E = 0;
        this.j = context.getApplicationContext();
        this.l = lightappBrowserWebView;
        this.Q = str;
        k();
    }

    private void u() {
        WebviewMenu webviewMenu = new WebviewMenu(n());
        this.r = webviewMenu;
        webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.11
            @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
            public void onClick(BdMenuItem bdMenuItem) {
                switch (bdMenuItem.getItemId()) {
                    case 32:
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y)));
                        PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(LangbridgeCell.this.y));
                        LightAppWrapper.getInstance().callShare(LangbridgeCell.this.getActivity(), new LightAppShareModel(LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getUrl(), null), null);
                        return;
                    case 33:
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y)));
                        PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(LangbridgeCell.this.y));
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LangbridgeCell.this.getActivity(), LangbridgeCell.this.y);
                        }
                        LangbridgeCell.this.l.reload();
                        LangbridgeCell.this.w = false;
                        return;
                    case 34:
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
                        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCell.this.o().setRnAuthResult(2, "实名认证取消");
                            LangbridgeCell.this.o().closeWindow();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID) || this.t.setCloseButtonVisibility(0) == 0) {
            return;
        }
        this.t.setCloseOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(LangbridgeCell.this.y), LangbridgeCell.this.q()));
                if (LangbridgeCell.this.isActiveCell()) {
                    GlobalUtils.hideKeyboard(LangbridgeCell.this.o().getControllerActivity());
                    LangbridgeCell.this.o().setRnAuthResult(2, "实名认证取消");
                    LangbridgeCell.this.o().closeWindow();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        NoNetView noNetView = this.p;
        if (noNetView != null) {
            noNetView.notifyUrlFinish();
        }
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.setVisibility(0);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.2
            @Override // java.lang.Runnable
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    LangbridgeCell.this.o().closeTopWebview();
                }
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        if (isActiveCell()) {
            o().closeWindow();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void d() {
        if (!p()) {
            v();
        }
        String str = h.a().a(getContext()).MW_JSCALL_ONACTIVE;
        if (!TextUtils.isEmpty(this.y) && !TextUtils.isEmpty(str)) {
            executeJsFunction(str, null);
        }
        com.baidu.wallet.lightapp.monitor.a.a().a((View) this.l, "ACTIVE", false);
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void e() {
        String str = h.a().a(getContext()).MW_JSCALL_ONNEGATIVE;
        if (TextUtils.isEmpty(this.y) || TextUtils.isEmpty(str)) {
            return;
        }
        executeJsFunction(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    @Override // com.baidu.wallet.lightapp.multipage.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String exeSSCommand(String str, String str2, String str3) {
        URL url;
        StringBuffer stringBuffer = new StringBuffer("");
        if (!TextUtils.isEmpty(m()) && !m().equals("PRELOAD")) {
            stringBuffer.append(m() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        } else {
            stringBuffer.append(toString().hashCode() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        }
        if (!this.y.isEmpty()) {
            try {
                url = new URL(this.y);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
            if (url != null) {
                int hashCode = (url.getProtocol() + url.getHost() + url.getPort()).hashCode();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(hashCode);
                stringBuffer.append(sb.toString());
            }
            if (g.a(str)) {
                return null;
            }
            return g.a().a(str, new String[]{str2, str3, stringBuffer.toString()});
        }
        url = null;
        if (url != null) {
        }
        if (g.a(str)) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void executeJsFunction(String str, String str2) {
        if (this.l != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.l.evaluateJavascript(sb.toString(), null);
                    return;
                }
                LightappBrowserWebView lightappBrowserWebView = this.l;
                lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void f() {
        this.w = false;
        this.f25014h = true;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void g() {
        if (this.N) {
            this.f25010d.checkPermission();
            this.N = false;
        }
        if (this.C == null || TextUtils.isEmpty(this.y)) {
            return;
        }
        this.C.add(new LoadTimeLine(this.y.trim(), MissionEvent.MESSAGE_RESUME, String.valueOf(System.currentTimeMillis())));
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Activity getActivity() {
        if (o() != null) {
            return o().getControllerActivity();
        }
        return null;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Context getContext() {
        return this.j;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        return JsonUtils.toJson(this.C);
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void h() {
        if (this.C != null && !TextUtils.isEmpty(this.y)) {
            this.C.add(new LoadTimeLine(this.y.trim(), MissionEvent.MESSAGE_PAUSE, String.valueOf(System.currentTimeMillis())));
        }
        this.R = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.y, this.R);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(final int i2) {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.18
            @Override // java.lang.Runnable
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    LangbridgeCell.this.o().historyGo(i2);
                }
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void i() {
        LightappJsClient lightappJsClient = this.f25009c;
        if (lightappJsClient != null) {
            lightappJsClient.destroy();
        }
        if (this.l != null) {
            LightappWebViewCenter.getInstance().releaseLightappWebView2Pool(this.l);
            this.k.setTarget(null);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        WeakReference<d> weakReference = this.f25008b;
        return (weakReference == null || weakReference.get() == null || this.f25008b.get().getControllerActivity() == null || !this.f25008b.get().isActiveCell(this)) ? false : true;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void j() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.16
            @Override // java.lang.Runnable
            public void run() {
                LangbridgeCell.this.i();
            }
        }, ResUtils.getInteger(getContext(), "wallet_langbridge_slide_duration"));
    }

    public void k() {
        l();
        a(this.l);
        this.f25010d = (LightappBusinessClient) this.f25009c.getLightappBusiness();
    }

    public void l() {
        View inflate = LayoutInflater.from(this.j).inflate(ResUtils.layout(this.j, "wallet_langbrige_cell"), (ViewGroup) null);
        this.f25015i = inflate;
        LangbridgeSlideLayout langbridgeSlideLayout = (LangbridgeSlideLayout) inflate.findViewById(ResUtils.id(this.j, "bd_langbridge_slide"));
        this.k = langbridgeSlideLayout;
        langbridgeSlideLayout.setTarget(this.l);
        this.H = (FrameLayout) this.f25015i.findViewById(ResUtils.id(this.j, "bd_ab_container"));
        this.I = (FrameLayout) this.f25015i.findViewById(ResUtils.id(this.j, "bd_trans_container"));
        this.F = (FrameLayout) this.f25015i.findViewById(ResUtils.id(this.j, "progress_line_container"));
        this.G = (FrameLayout) this.f25015i.findViewById(ResUtils.id(this.j, "progress_trans_container"));
        View view = new View(this.j);
        this.q = view;
        view.setVisibility(8);
        this.t = b(this.m.getBoolean(Constants.LONG_TITLE));
        this.p = (NoNetView) this.f25015i.findViewById(ResUtils.id(this.j, "nonet_view"));
        a(false);
        u();
        b("");
        this.u = (LinearLayout) this.f25015i.findViewById(ResUtils.id(this.j, "walelt_app_host_background"));
        this.v = (TextView) this.f25015i.findViewById(ResUtils.id(this.j, "walelt_base_light_app_host"));
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        if (getActivity() == null) {
            return;
        }
        this.P = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.f25010d, str);
        getActivity().startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 5);
    }

    public String m() {
        return this.Q;
    }

    public Context n() {
        return getActivity() != null ? getActivity() : getContext();
    }

    public d o() {
        WeakReference<d> weakReference = this.f25008b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        if (!NetworkUtils.isNetworkAvailable(this.j)) {
            GlobalUtils.toast(n(), ResUtils.getString(this.j, "ebpay_no_network"));
            return;
        }
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.reload();
            this.w = false;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(final String str, final boolean z) {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.6
            @Override // java.lang.Runnable
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    String str2 = LangbridgeCell.this.y;
                    if (str2 != null && !str2.equals(str)) {
                        LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.o().getLangbridgeHash(), str);
                        if (LangbridgeCell.this.o().createLangbridgeCell(str, false, z)) {
                            LangbridgeCell.this.v();
                            return;
                        }
                        return;
                    }
                    LightappBrowserWebView lightappBrowserWebView = LangbridgeCell.this.l;
                    if (lightappBrowserWebView != null) {
                        lightappBrowserWebView.reload();
                        LangbridgeCell.this.w = false;
                    }
                }
            }
        });
    }

    public boolean p() {
        return o() != null && o().isBottomCell(this);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
        a(1101, str, this.y);
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(final ArrayList<String> arrayList, final int i2) {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.7
            @Override // java.lang.Runnable
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    if (i2 == -1) {
                        LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext()).preload(arrayList, LangbridgeCell.this.o().getOwnerTag());
                    } else {
                        LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext()).preload(arrayList, i2, LangbridgeCell.this.o().getOwnerTag());
                    }
                }
            }
        });
    }

    public String q() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(o() != null ? Integer.valueOf(o().getLangbridgeStatus()) : "");
        return sb.toString();
    }

    public void r() {
        this.q.setVisibility(0);
        this.q.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_blue"));
        a(5);
    }

    public void s() {
        this.q.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_transparent"));
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        if (isActiveCell()) {
            this.B = new ContactInfoPresenter(getActivity(), this.f25010d);
            ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str, final String str2) {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4
            private void a() {
                if (z) {
                    LangbridgeCell.this.l.setOnMyScrollChangeListener(new LightappWebView.a() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4.1
                        @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                        public void a(int i2) {
                            int height = LangbridgeCell.this.t.getHeight();
                            float f2 = (height - i2) / height;
                            if (f2 > 0.0f) {
                                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                                int i3 = langbridgeCell.E;
                                if (i3 != -1) {
                                    langbridgeCell.t.setFullScreenTextColor(i3);
                                }
                                float f3 = 1.0f - f2;
                                int i4 = (int) (255.0f * f3);
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                if (z2) {
                                    if (i4 >= 255) {
                                        LangbridgeCell.this.t.setTitleTextColorAlpha(i4);
                                    } else {
                                        LangbridgeCell.this.t.setTitleTextColorAlpha(0);
                                    }
                                }
                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                if (z4) {
                                    LangbridgeCell.this.t.setIconFlag(true);
                                }
                                LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                                int i5 = langbridgeCell2.D;
                                if (i5 != -1) {
                                    langbridgeCell2.t.setTitlebgColor(LangbridgeCell.a(f3, i5, ResUtils.getColor(langbridgeCell2.j, "wallet_extend_color_actionbar_bg")));
                                    return;
                                }
                                return;
                            }
                            AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                            if (z2) {
                                LangbridgeCell.this.t.setTitleTextColorAlpha(255);
                            }
                            AnonymousClass4 anonymousClass44 = AnonymousClass4.this;
                            if (z4) {
                                LangbridgeCell.this.t.setIconFlag(false);
                            }
                            LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                            langbridgeCell3.t.setTitlebgColor(ResUtils.getColor(langbridgeCell3.j, "wallet_extend_color_actionbar_bg"));
                            LangbridgeCell.this.t.resetFullScreenTextColor();
                        }
                    });
                } else {
                    LangbridgeCell.this.l.setOnMyScrollChangeListener(new LightappWebView.a() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4.2
                        @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                        public void a(int i2) {
                            int height = LangbridgeCell.this.t.getHeight();
                            float f2 = (height - i2) / height;
                            if (f2 > 0.0f) {
                                int i3 = (int) ((1.0f - f2) * 255.0f);
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                if (z2) {
                                    if (i3 >= 255) {
                                        LangbridgeCell.this.t.setTitleTextColorAlpha(i3);
                                        return;
                                    } else {
                                        LangbridgeCell.this.t.setTitleTextColorAlpha(0);
                                        return;
                                    }
                                }
                                return;
                            }
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            if (z2) {
                                LangbridgeCell.this.t.setTitleTextColorAlpha(255);
                            }
                        }
                    });
                }
            }

            private void b() {
                if (z2) {
                    LangbridgeCell.this.t.setTitleTextColorAlpha(0);
                } else {
                    LangbridgeCell.this.t.setTitleTextColorAlpha(255);
                }
            }

            private void c() {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        LangbridgeCell.this.E = Color.parseColor(str2);
                    } catch (Throwable unused) {
                    }
                } else {
                    LangbridgeCell.this.E = 0;
                }
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                int i2 = langbridgeCell.E;
                if (i2 != 0) {
                    langbridgeCell.t.setFullScreenTextColor(i2);
                } else {
                    langbridgeCell.t.resetFullScreenTextColor();
                }
            }

            private void d() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        LangbridgeCell.this.D = Color.parseColor(str);
                    } catch (Throwable unused) {
                    }
                } else {
                    LangbridgeCell.this.D = -1;
                }
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                int i2 = langbridgeCell.D;
                if (i2 != -1) {
                    langbridgeCell.t.setTitlebgColor(i2);
                    LangbridgeCell.this.t.setBottomSeperatorvisible(false);
                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                    langbridgeCell2.a(Color.alpha(langbridgeCell2.D) != 255);
                    return;
                }
                langbridgeCell.t.setTitlebgColor(ResUtils.getColor(langbridgeCell.j, "wallet_extend_color_actionbar_bg"));
                LangbridgeCell.this.t.setBottomSeperatorvisible(true);
                LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                langbridgeCell3.a(Color.alpha(langbridgeCell3.D) != 255);
            }

            private void e() {
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                int i2 = langbridgeCell.D;
                if (i2 != -1 && ((-16777216) | i2) != -1) {
                    langbridgeCell.u.setBackgroundColor(i2);
                } else {
                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                    langbridgeCell2.u.setBackgroundColor(ResUtils.getColor(langbridgeCell2.j, "wallet_base_background1_color_7f"));
                }
                LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                int i3 = langbridgeCell3.E;
                if (i3 != 0) {
                    langbridgeCell3.v.setTextColor(i3);
                } else {
                    langbridgeCell3.v.setTextColor(ResUtils.getColor(langbridgeCell3.j, "wallet_base_font_text4Color"));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                LangbridgeCell.this.t.setIconFlag(z4);
                LangbridgeSlideLayout langbridgeSlideLayout = LangbridgeCell.this.k;
                if (langbridgeSlideLayout != null) {
                    langbridgeSlideLayout.setSupportPullDown(!z3);
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
            jSONObject.put("actionBarHeight", DisplayUtils.px2dip(this.j, this.t.getActionBarHeight()));
            jSONObject.put("statusBarHeight", DisplayUtils.px2dip(this.j, this.t.getStatusBarHeight()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setIsCheckPermission(boolean z) {
        this.N = z;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(final JSONArray jSONArray) {
        this.x = jSONArray;
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.5
            @Override // java.lang.Runnable
            public void run() {
                if (LangbridgeCell.this.t.getRightZoneView() == null) {
                    return;
                }
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                langbridgeCell.s = new a(langbridgeCell2.n(), jSONArray);
                LangbridgeCell.this.t.setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                        a aVar = langbridgeCell3.s;
                        if (aVar != null) {
                            aVar.show();
                            return;
                        }
                        WebviewMenu webviewMenu = langbridgeCell3.r;
                        if (webviewMenu != null) {
                            webviewMenu.show();
                        }
                    }
                });
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(final String str, final String str2, final boolean z) {
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.3
            @Override // java.lang.Runnable
            public void run() {
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                if (langbridgeCell.t != null) {
                    if (!NetworkUtils.isNetworkConnected(langbridgeCell.j)) {
                        LangbridgeCell.this.t.setTitle("");
                        LangbridgeCell.this.t.setTitleCenterSafeTipText("");
                    } else if (TextUtils.isEmpty(str)) {
                        LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                        langbridgeCell2.t.setTitle(langbridgeCell2.l.getTitle());
                        LangbridgeCell.this.f25007a = null;
                    } else {
                        String str3 = str;
                        LangbridgeCell.this.t.setTitle(str3);
                        LangbridgeCell.this.f25007a = str3;
                        if (!TextUtils.isEmpty(str2)) {
                            String trim = str2.trim();
                            if (!TextUtils.isEmpty(trim)) {
                                LangbridgeCell.this.t.setTitleCenterSafeTipText(trim);
                            }
                        } else {
                            LangbridgeCell.this.t.setTitleCenterSafeTipText("");
                        }
                    }
                    if (z) {
                        int[] titleSizeRange = LangbridgeCell.this.t.getTitleSizeRange();
                        int i2 = titleSizeRange[0];
                        int i3 = titleSizeRange[1];
                        int mainTitleViewWidth = LangbridgeCell.this.t.getMainTitleViewWidth();
                        float f2 = i2;
                        float stringWidth = com.baidu.wallet.utils.StringUtil.getStringWidth(LangbridgeCell.this.t.getTitle(), f2);
                        LangbridgeCell.this.t.setTitleEllipsize(TextUtils.TruncateAt.END);
                        float f3 = mainTitleViewWidth;
                        if (stringWidth <= f3) {
                            LangbridgeCell.this.t.setTitleSize(i2);
                            return;
                        }
                        float f4 = f3 / stringWidth;
                        if (1.0f > f4 && i3 / f2 <= f4) {
                            LangbridgeCell.this.t.setTitleSize(Math.round(f2 * f4));
                            return;
                        }
                        LangbridgeCell.this.t.setTitleSize(i3);
                    }
                }
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public boolean c() {
        LightappBusinessClient lightappBusinessClient = this.f25010d;
        if ((lightappBusinessClient != null ? lightappBusinessClient.getH5BackCb() : null) != null) {
            executeJsFunction(LightappBusinessClient.MTD_H5GOBCK, null);
            return true;
        }
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack()) {
            return false;
        }
        LogUtil.d("LangbridgeCell", "cangoback:  " + this.l.getUrl());
        this.l.goBack();
        f();
        this.y = this.l.getUrl();
        return true;
    }

    private BdActionBar b(boolean z) {
        if (z) {
            return new BdLightAppActionBar(n());
        }
        return new BdActionBar(n());
    }

    private void b(String str) {
        if (this.t == null) {
            return;
        }
        if (!this.m.getBoolean("lang_showtitle", true)) {
            this.t.setVisibility(8);
        }
        this.t.setTitle("");
        this.t.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LangbridgeCell.this.isActiveCell()) {
                    GlobalUtils.hideKeyboard(LangbridgeCell.this.o().getControllerActivity());
                    LangbridgeCell.this.o().backPressed();
                }
            }
        });
        if (this.r == null) {
            return;
        }
        this.t.setRightImgZone2Visibility(0);
        this.t.setRightImgZone2Enable(true);
        this.t.setRightImgZone2Src(ResUtils.drawable(this.j, "wallet_base_overflow"), ResUtils.getString(this.j, "wallet_base_bdaction_more"));
        this.t.setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LangbridgeCell.this.r.show();
            }
        });
        this.t.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
    }

    public void a(LightappWebView lightappWebView) {
        WebSettings settings = lightappWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationDatabasePath(this.j.getDir("database", 0).getPath());
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setTextZoom(100);
        settings.setGeolocationEnabled(true);
        String userAgentString = settings.getUserAgentString();
        if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
            userAgentString = userAgentString + " " + BussinessUtils.getUA(n());
            settings.setUserAgentString(userAgentString);
        }
        if (!TextUtils.isEmpty(userAgentString)) {
            LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
        }
        lightappWebView.setScrollBarStyle(0);
        lightappWebView.clearCache(false);
        lightappWebView.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            lightappWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            lightappWebView.removeJavascriptInterface("accessibility");
            lightappWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        LightappJsClient lightappJsClient = new LightappJsClient(this, this.l);
        this.f25009c = lightappJsClient;
        lightappWebView.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
        DXMSdkSAUtils.onEventWithValues("#injectJavaObject", Arrays.asList(m(), this.f25009c.hashCode() + "", lightappWebView.hashCode() + ""));
        PayStatisticsUtil.onEventWithValues("#injectJavaObject", Arrays.asList(m(), this.f25009c.hashCode() + "", lightappWebView.hashCode() + ""));
        LangbridgeSettings a2 = h.a().a(this.j);
        if (a2.MW_ON && a2.MW_INJECTJS_FOR_HS) {
            lightappWebView.addJsCode(LangbridgeSettings.MW_JSHOOK_HISTORY_NAME, h.a().a(LangbridgeSettings.MW_JSHOOK_HISTORY_NAME, a2.MW_JSHOOK_HISTORY));
        }
        if (a2.MW_ON && a2.MW_INJECTJS_FOR_SS) {
            lightappWebView.addJsCode(LangbridgeSettings.MW_JSHOOK_SESSION_NAME, h.a().a(LangbridgeSettings.MW_JSHOOK_SESSION_NAME, a2.MW_JSHOOK_SESSION));
        }
        d("common");
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(lightappWebView, true);
        }
        lightappWebView.setWebViewClient(new CustomWebViewClient());
        lightappWebView.setWebChromeClient(new CustomChromeClient());
        lightappWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.1

            /* renamed from: a  reason: collision with root package name */
            public Pattern f25016a;

            /* renamed from: b  reason: collision with root package name */
            public Matcher f25017b;

            {
                Pattern compile = Pattern.compile(".*");
                this.f25016a = compile;
                this.f25017b = compile.matcher("");
            }

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    LangbridgeCell.this.a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e2) {
                    LogUtil.e("LangbridgeCell", "Download Error", e2);
                    GlobalUtils.toast(LangbridgeCell.this.j, "下载出现异常");
                }
            }
        });
        this.C = new Vector<>();
        if (TextUtils.isEmpty(this.y)) {
            return;
        }
        this.C.add(new LoadTimeLine(this.y.trim(), MissionEvent.MESSAGE_CREATE, String.valueOf(System.currentTimeMillis())));
    }

    private void d(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        String[] b2 = com.baidu.wallet.lightapp.business.a.b(str);
        LogUtil.d("WebViewCacheManager", "CELL add Js Hook groupName = " + str + "\n filesName=" + Arrays.toString(b2));
        if (b2 == null || b2.length <= 0) {
            return;
        }
        for (String str2 : b2) {
            if (!TextUtils.isEmpty(str2)) {
                String a2 = com.baidu.wallet.lightapp.business.a.a(str2);
                LogUtil.d("WebViewCacheManager", "CELL to Add COMMON JSFile = " + a2);
                if (!TextUtils.isEmpty(a2) && (lightappBrowserWebView = this.l) != null) {
                    lightappBrowserWebView.addJsCode(str2, a2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public CustomChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str;
            if (consoleMessage == null) {
                return super.onConsoleMessage(consoleMessage);
            }
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                String sourceId = consoleMessage.sourceId();
                sourceId = (TextUtils.equals(sourceId, LangbridgeCell.this.z) || TextUtils.isEmpty(sourceId)) ? "" : "";
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("level", messageLevel.name());
                linkedHashMap.put("message", consoleMessage.message());
                linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                linkedHashMap.put("sourceId", sourceId);
                linkedHashMap.put("pageUrl", LangbridgeCell.this.z);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.z).toString());
                if (!TextUtils.isEmpty(consoleMessage.message()) && consoleMessage.message().contains(LightappJsClient.LIGHTAPP_JS_NAME)) {
                    linkedHashMap.put("owner", LangbridgeCell.this.m());
                    if (LangbridgeCell.this.b() != null && LangbridgeCell.this.b().getJsBridge() != null) {
                        linkedHashMap.put("webview", LangbridgeCell.this.b().hashCode() + "");
                        if (LangbridgeCell.this.f25009c == null) {
                            str = StringUtil.NULL_STRING;
                        } else {
                            str = LangbridgeCell.this.f25009c.hashCode() + "";
                        }
                        linkedHashMap.put("jsclient", str);
                    }
                }
                Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, linkedHashMap, LangbridgeCell.this.getContext());
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            LogUtil.d("LangbridgeCell", "onProgressChanged:newProgress   " + i2);
            LangbridgeCell.this.a(i2);
            if (i2 == 100) {
                LangbridgeCell.this.s();
                if (LangbridgeCell.this.w) {
                    return;
                }
                LogUtil.d("LangbridgeCell", "onProgressChanged.hideErrorPage");
                LangbridgeCell.this.w();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (LangbridgeCell.this.t != null) {
                if (!TextUtils.isEmpty("") && !NetworkUtils.isNetworkConnected(LangbridgeCell.this.j)) {
                    LangbridgeCell.this.t.setTitle("");
                    LangbridgeCell.this.t.setTitleCenterSafeTipText("");
                    return;
                }
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                String str2 = langbridgeCell.f25007a;
                if (str2 != null) {
                    langbridgeCell.t.setTitle(str2);
                } else if (!TextUtils.isEmpty(langbridgeCell.m.getString("lang_customtitle"))) {
                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                    langbridgeCell2.t.setTitle(langbridgeCell2.m.getString("lang_customtitle"));
                } else if (!TextUtils.isEmpty(str) && !LangbridgeCell.O.matcher(str).matches()) {
                    if (("http://" + str).equals(LangbridgeCell.this.y)) {
                        LangbridgeCell.this.t.setTitle(" ");
                    } else {
                        LangbridgeCell.this.t.setTitle(str);
                    }
                } else {
                    LangbridgeCell.this.t.setTitle(" ");
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes;
            LangbridgeCell.this.f25012f = valueCallback;
            if (fileChooserParams == null || (acceptTypes = fileChooserParams.getAcceptTypes()) == null || acceptTypes.length <= 0 || TextUtils.isEmpty(acceptTypes[0])) {
                return true;
            }
            LangbridgeCell.this.a(acceptTypes[0], fileChooserParams.isCaptureEnabled(), 2);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            LangbridgeCell.this.f25011e = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            if (intent.resolveActivity(LangbridgeCell.this.n().getPackageManager()) != null) {
                LangbridgeCell.this.a(Intent.createChooser(intent, "File Chooser"), 1);
                return;
            }
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            LangbridgeCell.this.f25011e = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            if (intent.resolveActivity(LangbridgeCell.this.n().getPackageManager()) != null) {
                LangbridgeCell.this.a(Intent.createChooser(intent, "File Browser"), 1);
                return;
            }
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            LangbridgeCell.this.f25011e = valueCallback;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            LangbridgeCell.this.a(str, !TextUtils.isEmpty(str2), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.m.getBoolean("lang_showerror", true)) {
            NoNetView noNetView = this.p;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public LightappBrowserWebView b() {
        return this.l;
    }

    public LangbridgeCell(d dVar, Bundle bundle, LightappBrowserWebView lightappBrowserWebView, String str) {
        this.f25013g = true;
        this.f25014h = false;
        this.m = new Bundle();
        this.o = false;
        this.w = false;
        this.J = null;
        this.K = -1;
        this.L = null;
        this.M = false;
        this.N = false;
        this.R = -1;
        this.D = -1;
        this.E = 0;
        this.j = dVar.getControllerActivity().getApplicationContext();
        this.l = lightappBrowserWebView;
        this.Q = str;
        if (bundle != null) {
            this.m = bundle;
        }
        a(dVar);
        k();
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(final String str, final b bVar) {
        this.y = str;
        this.n = bVar;
        this.o = false;
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!LangbridgeCell.O.matcher(LangbridgeCell.this.y).matches()) {
                        LangbridgeCell langbridgeCell = LangbridgeCell.this;
                        langbridgeCell.y = "https://" + LangbridgeCell.this.y;
                    }
                    LangbridgeCell.this.l.loadUrl(LangbridgeCell.this.y.trim());
                    LangbridgeCell.this.w = false;
                } catch (Exception e2) {
                    LogUtil.d("Url error");
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(1102, e2.toString(), str);
                    }
                    if (LangbridgeCell.this.isActiveCell()) {
                        LangbridgeCell.this.o().closeWindow();
                    }
                }
            }
        });
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(d dVar, Bundle bundle, String str) {
        a(dVar);
        if ("PRELOAD".equals(m()) && !str.equals(m())) {
            g a2 = g.a();
            a2.a(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER, new String[]{toString().hashCode() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, str + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
            a(str);
        }
        if (bundle != null) {
            this.m = bundle;
        }
        this.n = null;
        this.l.setBaseContext(getActivity());
        this.t.setTop(getActivity());
        this.t.setVisibility(this.m.getBoolean("lang_showtitle", true) ? 0 : 8);
        this.t.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
        u();
        JSONArray jSONArray = this.x;
        if (jSONArray != null) {
            setMenuInMainThread(jSONArray);
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.f25008b = new WeakReference<>(dVar);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z;
        this.f25009c.onRequestPermissionsResultLocal(i2, strArr, iArr);
        LightappBusinessClient lightappBusinessClient = this.f25010d;
        if (lightappBusinessClient != null) {
            lightappBusinessClient.onRequestPermissionsResult(this.z, i2, strArr, iArr);
        }
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        if (i2 != 101) {
            if (i2 == 102) {
                int length = iArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    } else if (iArr[i3] != 0) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    a(this.L, this.M, this.K);
                    this.L = "";
                    this.M = false;
                    this.K = -1;
                }
            }
            z = false;
        } else if (iArr[0] == 0) {
            Intent intent = this.J;
            if (intent != null) {
                a(intent, this.K);
            }
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.K == 1) {
                ValueCallback<Uri> valueCallback = this.f25011e;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.f25011e = null;
                }
                this.S = null;
            } else if (i2 == 2) {
                ValueCallback<Uri[]> valueCallback2 = this.f25012f;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(new Uri[0]);
                    this.f25012f = null;
                }
                this.S = null;
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        this.J = null;
        this.K = -1;
        if (i2 == 4) {
            if (i3 == -1) {
                if (intent == null || intent.getData() == null || (contactInfoPresenter = this.B) == null) {
                    return;
                }
                contactInfoPresenter.a(intent.getData());
                return;
            }
            LightappBusinessClient lightappBusinessClient = this.f25010d;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.onContactsSelected("", 1, null, "取消", "0");
                return;
            }
            return;
        }
        if (i2 == 5) {
            LogUtil.d("LangbridgeCell", "onActivityResult resultCode = " + i3);
            JSONObject jSONObject = new JSONObject();
            if (i3 == -1) {
                if (intent == null || intent.getData() == null) {
                    return;
                }
                this.P.a(intent, jSONObject);
                return;
            }
            try {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, 10005);
                jSONObject.put("des", "用户取消选择");
                this.f25010d.setAlubmPhotoData(1, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.P.a("#callNativePhoto Fail", "用户取消选择");
        } else if (i2 == 1) {
            if (this.f25011e == null) {
                return;
            }
            Uri data = (intent == null || i3 != -1) ? null : intent.getData();
            if (data != null) {
                this.f25011e.onReceiveValue(data);
            } else {
                this.f25011e.onReceiveValue(this.S);
            }
            this.f25011e = null;
            this.S = null;
        } else if (i2 == 2) {
            if (this.f25012f == null) {
                return;
            }
            Uri data2 = (intent == null || i3 != -1) ? null : intent.getData();
            if (data2 != null) {
                this.f25012f.onReceiveValue(new Uri[]{data2});
            } else {
                Uri uri = this.S;
                if (uri != null) {
                    this.f25012f.onReceiveValue(new Uri[]{uri});
                } else {
                    this.f25012f.onReceiveValue(new Uri[0]);
                }
            }
            this.f25012f = null;
            this.S = null;
        } else if (i2 == 3) {
            if (i3 == -1) {
                this.f25009c.onCallCameraPicCallbackLocal();
            }
        } else if (i2 != 4) {
            if (i2 == 6) {
                this.f25009c.onInsertCalendarEventDone(i3 == -1);
            }
        } else if (i3 == -1) {
            if (intent != null && intent.getData() != null) {
                List<String> loadRawPhone = ContactManager.getIContactsImpl().loadRawPhone(intent.getData(), this.j);
                this.A = loadRawPhone;
                if (loadRawPhone != null && loadRawPhone.size() > 1) {
                    if (this.A.size() == 2) {
                        String str = this.A.get(0);
                        String str2 = this.A.get(1);
                        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                            str = "";
                        }
                        this.f25009c.onContactsSelectedLocal(0, new String[]{str, StringUtils.trimAll(str2)}, "");
                        return;
                    }
                    a(this.A, new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.17
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                            if (i4 <= 0 || i4 >= LangbridgeCell.this.A.size()) {
                                return;
                            }
                            String replace = LangbridgeCell.this.A.get(i4).replace(" ", "").replace("-", "");
                            LangbridgeCell langbridgeCell = LangbridgeCell.this;
                            langbridgeCell.f25009c.onContactsSelectedLocal(0, new String[]{langbridgeCell.A.get(0), replace}, "");
                        }
                    });
                    return;
                }
            }
            this.f25009c.onContactsSelectedLocal(1, null, ResUtils.getString(this.j, "wallet_base_select_phone_fail"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public View a() {
        return this.f25015i;
    }

    public void a(String str) {
        this.Q = str;
    }

    public void a(Intent intent, int i2) {
        if (isActiveCell()) {
            o().getControllerActivity().startActivityForResult(intent, i2);
        }
    }

    public void a(Intent intent) {
        if (isActiveCell()) {
            o().getControllerActivity().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
        layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(this.j) * i2) / 100.0f);
        this.q.setLayoutParams(layoutParams);
    }

    public void a(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        SelectNumberDialog selectNumberDialog = new SelectNumberDialog(n());
        selectNumberDialog.setOnItemClickListener(onItemClickListener);
        selectNumberDialog.setData(list);
        selectNumberDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        if (this.n == null || this.o) {
            return;
        }
        if (i2 != 0) {
            this.o = true;
        }
        this.n.a(i2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r14.equals("image") != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, boolean z, int i2) {
        Intent intent;
        Intent intent2;
        if (!PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") && !PermissionManager.checkCallingPermission(getActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            this.L = str;
            this.M = z;
            this.K = i2;
            BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.8
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        PermissionManager.checkCallingOrSelfPermission(LangbridgeCell.this.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 102);
                    } else {
                        LangbridgeCell.this.a(102, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1, -1});
                    }
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str2, Boolean bool) {
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str2, Boolean bool) {
                }
            });
            return;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), getContext().getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        PackageManager packageManager = getContext().getPackageManager();
        String[] split = str.split("/");
        if (split == null || split.length <= 0) {
            return;
        }
        char c2 = 0;
        if (TextUtils.isEmpty(split[0])) {
            return;
        }
        if (z) {
            String str2 = split[0];
            int hashCode = str2.hashCode();
            if (hashCode == 93166550) {
                if (str2.equals("audio")) {
                    c2 = 2;
                    if (c2 != 0) {
                    }
                    intent = intent2;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                intent = intent2;
            } else if (hashCode != 100313435) {
                if (hashCode == 112202875 && str2.equals("video")) {
                    c2 = 1;
                    if (c2 != 0) {
                        File file2 = new File(file + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg");
                        if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                            Context n = n();
                            this.S = FileProvider.getUriForFile(n, n().getPackageName() + ".fileprovider", file2);
                        } else {
                            Activity activity = getActivity();
                            this.S = FileProvider.getUriForFile(activity, n().getPackageName() + ".langbrigeProvider", file2);
                        }
                        n().grantUriPermission(n().getPackageName(), this.S, 3);
                        intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent2.putExtra("output", this.S);
                        if (!PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                            this.J = intent2;
                            this.K = i2;
                            BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.9
                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isAllAgree(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        PermissionManager.checkCallingOrSelfPermission(LangbridgeCell.this.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                    } else {
                                        LangbridgeCell.this.a(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                                    }
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isShow(String str3, Boolean bool) {
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void requestResult(String str3, Boolean bool) {
                                }
                            });
                            return;
                        }
                    } else if (c2 == 1) {
                        File file3 = new File(file + File.separator + "video_" + System.currentTimeMillis() + ".mp4");
                        if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                            Context n2 = n();
                            this.S = FileProvider.getUriForFile(n2, n().getPackageName() + ".fileprovider", file3);
                        } else {
                            Context n3 = n();
                            this.S = FileProvider.getUriForFile(n3, n().getPackageName() + ".langbrigeProvider", file3);
                        }
                        n().grantUriPermission(n().getPackageName(), this.S, 3);
                        intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
                        intent2.putExtra("output", this.S);
                        if (!PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                            this.J = intent2;
                            this.K = i2;
                            BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.10
                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isAllAgree(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        PermissionManager.checkCallingOrSelfPermission(LangbridgeCell.this.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                    } else {
                                        LangbridgeCell.this.a(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                                    }
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void isShow(String str3, Boolean bool) {
                                }

                                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                public void requestResult(String str3, Boolean bool) {
                                }
                            });
                            return;
                        }
                    } else if (c2 != 2) {
                        intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.setType(str);
                    } else {
                        intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
                    }
                    intent = intent2;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                intent = intent2;
            }
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(str);
        }
        if (intent.resolveActivity(packageManager) != null) {
            a(intent, i2);
        }
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static int a(float f2, int i2, int i3) {
        int red = Color.red(i2);
        int blue = Color.blue(i2);
        int green = Color.green(i2);
        int alpha = Color.alpha(i2);
        int red2 = Color.red(i3);
        int blue2 = Color.blue(i3);
        int i4 = red2 - red;
        int i5 = blue2 - blue;
        int green2 = (int) (green + ((Color.green(i3) - green) * f2));
        return Color.argb((int) (alpha + (f2 * (Color.alpha(i3) - alpha))), (int) (red + (i4 * f2)), green2, (int) (blue + (i5 * f2)));
    }

    public void a(boolean z) {
        LogUtil.d("LangbridgeCell", "setActionBarTransparent:" + z);
        FrameLayout frameLayout = z ? this.H : this.I;
        FrameLayout frameLayout2 = z ? this.I : this.H;
        FrameLayout frameLayout3 = z ? this.F : this.G;
        FrameLayout frameLayout4 = z ? this.G : this.F;
        if (this.t == null || frameLayout2.getChildCount() != 0 || this.q == null || frameLayout4.getChildCount() != 0) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout3.removeAllViews();
        frameLayout2.addView(this.t);
        frameLayout4.addView(this.q, new ViewGroup.LayoutParams(DisplayUtils.dip2px(this.j, 10.0f), DisplayUtils.dip2px(this.j, 2.0f)));
    }
}
