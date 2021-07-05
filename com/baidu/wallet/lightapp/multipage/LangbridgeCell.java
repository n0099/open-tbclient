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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.analytics.Tracker;
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
/* loaded from: classes6.dex */
public class LangbridgeCell implements com.baidu.wallet.lightapp.multipage.a, c, NoNetView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern O;
    public transient /* synthetic */ FieldHolder $fh;
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
    public String f25550a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f25551b;

    /* renamed from: c  reason: collision with root package name */
    public LightappJsClient f25552c;

    /* renamed from: d  reason: collision with root package name */
    public LightappBusinessClient f25553d;

    /* renamed from: e  reason: collision with root package name */
    public ValueCallback<Uri> f25554e;

    /* renamed from: f  reason: collision with root package name */
    public ValueCallback<Uri[]> f25555f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25556g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25557h;

    /* renamed from: i  reason: collision with root package name */
    public View f25558i;
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

    /* loaded from: classes6.dex */
    public class CustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f25600a;

        /* renamed from: b  reason: collision with root package name */
        public Pattern f25601b;

        /* renamed from: c  reason: collision with root package name */
        public String f25602c;

        public CustomWebViewClient(LangbridgeCell langbridgeCell) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {langbridgeCell};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25600a = langbridgeCell;
            this.f25601b = Pattern.compile("\\s*https?://.*");
        }

        private boolean a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) ? TextUtils.equals(str, str2) : invokeLL.booleanValue;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
                super.doUpdateVisitedHistory(webView, str, z);
                LangbridgeCell langbridgeCell = this.f25600a;
                if (langbridgeCell.f25556g) {
                    langbridgeCell.l.clearHistory();
                    if (str == null || str.contains("about:blank")) {
                        return;
                    }
                    this.f25600a.f25556g = false;
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                Vector<LoadTimeLine> vector = this.f25600a.C;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
                }
                this.f25600a.s();
                LangbridgeCell langbridgeCell = this.f25600a;
                com.baidu.wallet.lightapp.base.a a2 = com.baidu.wallet.lightapp.base.a.a();
                LangbridgeCell langbridgeCell2 = this.f25600a;
                langbridgeCell.R = a2.a(langbridgeCell2.j, str, langbridgeCell2.R);
                this.f25600a.y = str;
                String host = Uri.parse(str).getHost();
                this.f25602c = str;
                if (TextUtils.isEmpty(host)) {
                    this.f25600a.v.setVisibility(8);
                } else {
                    this.f25600a.v.setVisibility(0);
                    LangbridgeCell langbridgeCell3 = this.f25600a;
                    langbridgeCell3.v.setText(langbridgeCell3.j.getResources().getString(ResUtils.string(this.f25600a.j, "wallet_langbridge_url_outer"), host));
                }
                String title = this.f25600a.t.getTitle();
                if (title != null && title.equals("")) {
                    String title2 = webView.getTitle();
                    if (title2 != null && !this.f25601b.matcher(title2).matches()) {
                        this.f25600a.t.setTitle(title2);
                    } else {
                        this.f25600a.t.setTitle((String) null);
                    }
                }
                if (webView.getProgress() != 100) {
                    this.f25600a.w = true;
                }
                LogUtil.d("LangbridgeCell", "onPageFinished.finishedError:  " + this.f25600a.w);
                super.onPageFinished(webView, str);
                this.f25600a.a(0, "success", str);
                com.baidu.wallet.lightapp.monitor.a.a().a((View) this.f25600a.l, "FINISH", false);
                String[] strArr = new String[3];
                strArr[0] = CheckUtils.stripUrlParams(this.f25600a.y);
                strArr[1] = this.f25600a.q();
                strArr[2] = this.f25600a.w ? "1" : "0";
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(strArr));
                String[] strArr2 = new String[3];
                strArr2[0] = CheckUtils.stripUrlParams(this.f25600a.y);
                strArr2[1] = this.f25600a.q();
                strArr2[2] = this.f25600a.w ? "1" : "0";
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(strArr2));
                if (this.f25600a.isActiveCell()) {
                    LangbridgeCacheManager.getInstance().handleFinishPage(str);
                }
                String str2 = h.a().a(this.f25600a.getContext()).MW_JSCALL_ONACTIVE;
                if (this.f25600a.isActiveCell() && !TextUtils.isEmpty(str2)) {
                    this.f25600a.executeJsFunction(str2, null);
                }
                LightappBrowserWebView lightappBrowserWebView = this.f25600a.l;
                if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack()) {
                    return;
                }
                LangbridgeCell langbridgeCell4 = this.f25600a;
                if (langbridgeCell4.f25556g) {
                    return;
                }
                langbridgeCell4.v();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                Vector<LoadTimeLine> vector = this.f25600a.C;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
                }
                this.f25600a.z = str;
                if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                    this.f25600a.setFullScreenInMainThread(false, false, false, false, "", "");
                }
                if (!this.f25600a.isActiveCell() || LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                    this.f25600a.r();
                }
                this.f25600a.t.setTitle("");
                this.f25600a.t.setTitleCenterSafeTipText("");
                LangbridgeCell langbridgeCell = this.f25600a;
                langbridgeCell.s = null;
                LightappBusinessClient lightappBusinessClient = langbridgeCell.f25553d;
                if (lightappBusinessClient != null) {
                    lightappBusinessClient.setH5BackCb(null);
                }
                LangbridgeCell langbridgeCell2 = this.f25600a;
                langbridgeCell2.f25550a = null;
                langbridgeCell2.f25552c.setUrlLocal(str);
                super.onPageStarted(webView, str, bitmap);
                com.baidu.wallet.lightapp.monitor.a.a().a((View) this.f25600a.l, "START", true);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f25600a.y), this.f25600a.q()));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f25600a.y), this.f25600a.q()));
                if (this.f25600a.isActiveCell()) {
                    LangbridgePreloadCellCenter.getInstance(this.f25600a.getContext()).setAllCellsEnable(false);
                    LangbridgeCacheManager.getInstance().handleStartPage(str);
                    z = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
                } else {
                    z = false;
                }
                if (!NetworkUtils.isNetworkAvailable(this.f25600a.j) && !z) {
                    this.f25600a.c(str);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(CheckUtils.stripUrlParams(str)));
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_WRC_SHOW_ERROR, CheckUtils.stripUrlParams(str));
                }
                if (a(str, this.f25602c)) {
                    return;
                }
                com.baidu.wallet.lightapp.base.c.a(this.f25600a.getActivity());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceError) == null) {
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
                linkedHashMap.put("pageUrl", this.f25600a.z);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25600a.z).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f25600a.getContext());
                if (webResourceError == null || webResourceRequest == null || -10 == webResourceError.getErrorCode() || !webResourceRequest.isForMainFrame()) {
                    return;
                }
                LangbridgeCell langbridgeCell = this.f25600a;
                langbridgeCell.w = true;
                NoNetView noNetView = langbridgeCell.p;
                if (noNetView != null) {
                    noNetView.setFailureCause(webResourceError.getErrorCode());
                }
                this.f25600a.c(webResourceRequest.getUrl().toString());
                this.f25600a.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), webResourceRequest.getUrl().toString());
                LogUtil.d("LangbridgeCell", "onReceivedError2.showErrorPage");
                String[] strArr = new String[4];
                strArr[0] = String.valueOf(webResourceError.getErrorCode());
                strArr[1] = String.valueOf(webResourceRequest.getUrl());
                LightappBrowserWebView b2 = this.f25600a.b();
                String str4 = StringUtil.NULL_STRING;
                if (b2 == null) {
                    str = StringUtil.NULL_STRING;
                } else {
                    str = this.f25600a.b().hashCode() + "";
                }
                strArr[2] = str;
                if (this.f25600a.f25552c == null) {
                    str2 = StringUtil.NULL_STRING;
                } else {
                    str2 = this.f25600a.f25552c.hashCode() + "";
                }
                strArr[3] = str2;
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
                String[] strArr2 = new String[4];
                strArr2[0] = String.valueOf(webResourceError.getErrorCode());
                strArr2[1] = String.valueOf(webResourceRequest.getUrl());
                if (this.f25600a.b() == null) {
                    str3 = StringUtil.NULL_STRING;
                } else {
                    str3 = this.f25600a.b().hashCode() + "";
                }
                strArr2[2] = str3;
                if (this.f25600a.f25552c != null) {
                    str4 = this.f25600a.f25552c.hashCode() + "";
                }
                strArr2[3] = str4;
                PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr2));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, webResourceRequest, webResourceResponse) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    String mimeType = webResourceResponse.getMimeType();
                    int statusCode = webResourceResponse.getStatusCode();
                    String uri = webResourceRequest.getUrl().toString();
                    if (mimeType.contains(SapiWebView.DATA_MIME_TYPE) && 400 <= statusCode && statusCode < 600 && !uri.contains("favicon.ico")) {
                        this.f25600a.a(statusCode, webResourceResponse.getReasonPhrase(), uri);
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
                        linkedHashMap.put("pageUrl", this.f25600a.z);
                    }
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25600a.z).toString());
                    Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, linkedHashMap, this.f25600a.getContext());
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, sslErrorHandler, sslError) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (sslError != null) {
                    linkedHashMap.put("errorCode", String.valueOf(sslError.getPrimaryError()));
                    linkedHashMap.put("url", sslError.getUrl());
                    linkedHashMap.put("certificate", String.valueOf(sslError.getCertificate()));
                    linkedHashMap.put("pageUrl", this.f25600a.z);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25600a.z).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, linkedHashMap, this.f25600a.getContext());
                int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                    return;
                }
                LangbridgeCell langbridgeCell = this.f25600a;
                langbridgeCell.w = true;
                NoNetView noNetView = langbridgeCell.p;
                if (noNetView != null) {
                    noNetView.setFailureCause(primaryError);
                }
                this.f25600a.c(url);
                this.f25600a.a(primaryError, sslError.getCertificate().toString(), sslError.getUrl());
                LogUtil.d("LangbridgeCell", "onReceivedSslError");
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
                PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, webResourceRequest)) == null) {
                if (this.f25600a.isActiveCell() && this.f25600a.f25557h) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(this.f25600a.o().getLangbridgeHash(), webResourceRequest.getUrl().toString());
                    this.f25600a.f25557h = false;
                }
                if (this.f25600a.isActiveCell()) {
                    return LangbridgeCacheManager.getInstance().interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
                }
                return null;
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, webView, str)) == null) {
                com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", "OriginalUrl : " + webView.getOriginalUrl());
                com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", "shouldOverrideUrlLoading url = " + str);
                if (str.startsWith("tel:")) {
                    this.f25600a.a(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                }
                if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                    try {
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                        intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "")});
                        this.f25600a.a(intent);
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        GlobalUtils.toast(this.f25600a.j, "请先配置邮箱");
                    }
                } else if (!str.toLowerCase(Locale.CHINA).startsWith("http") && !str.toLowerCase(Locale.CHINA).startsWith("https") && !str.toLowerCase(Locale.CHINA).startsWith("file")) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 1);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent(null);
                        if (Build.VERSION.SDK_INT >= 15) {
                            parseUri.setSelector(null);
                        }
                        this.f25600a.a(parseUri);
                        return true;
                    } catch (Exception e3) {
                        com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", e3.getMessage());
                    }
                } else {
                    if (this.f25600a.isActiveCell()) {
                        LangbridgeCacheManager.getInstance().handleLoadUrl(this.f25600a.o().getLangbridgeHash(), str);
                    }
                    return false;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }

        private Map a(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, map)) == null) {
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
            return (Map) invokeL.objValue;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
                if (this.f25600a.isActiveCell() && this.f25600a.f25557h) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(this.f25600a.o().getLangbridgeHash(), str);
                    this.f25600a.f25557h = false;
                }
                if (this.f25600a.isActiveCell()) {
                    return LangbridgeCacheManager.getInstance().interceptRequest(str, null);
                }
                return null;
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("errorCode", String.valueOf(i2));
                linkedHashMap.put("url", str2);
                linkedHashMap.put("reasonPhrase", str);
                linkedHashMap.put("pageUrl", this.f25600a.z);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25600a.z).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f25600a.getContext());
                if (-10 == i2) {
                    return;
                }
                LangbridgeCell langbridgeCell = this.f25600a;
                langbridgeCell.w = true;
                NoNetView noNetView = langbridgeCell.p;
                if (noNetView != null) {
                    noNetView.setFailureCause(i2);
                }
                this.f25600a.c(str2);
                this.f25600a.a(i2, str, str2);
                String[] strArr = new String[4];
                strArr[0] = i2 + "";
                strArr[1] = str2;
                LightappBrowserWebView b2 = this.f25600a.b();
                String str4 = StringUtil.NULL_STRING;
                if (b2 == null) {
                    str3 = StringUtil.NULL_STRING;
                } else {
                    str3 = this.f25600a.b().hashCode() + "";
                }
                strArr[2] = str3;
                strArr[3] = this.f25600a.f25552c.hashCode() + "";
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
                String[] strArr2 = new String[4];
                strArr2[0] = i2 + "";
                strArr2[1] = str2;
                if (this.f25600a.b() != null) {
                    str4 = this.f25600a.b().hashCode() + "";
                }
                strArr2[2] = str4;
                strArr2[3] = this.f25600a.f25552c.hashCode() + "";
                PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr2));
                LogUtil.d("LangbridgeCell", "onReceivedError1.showErrorPage");
                super.onReceivedError(webView, i2, str, str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class LoadTimeLine implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String event;
        public String time;
        public String url;

        public LoadTimeLine(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
            this.event = str2;
            this.time = str3;
        }
    }

    /* loaded from: classes6.dex */
    public class WebviewMenu extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MENU_ITEM_INDEX_CLOSE = 34;
        public static final int MENU_ITEM_INDEX_REFRESH = 33;
        public static final int MENU_ITEM_INDEX_SHARE = 32;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f25603a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebviewMenu(LangbridgeCell langbridgeCell, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {langbridgeCell, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25603a = langbridgeCell;
            add(33, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (langbridgeCell.m.getBoolean("lang_showshare", false)) {
                add(32, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f25604a;

        /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeCell$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0274a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f25609a;

            /* renamed from: b  reason: collision with root package name */
            public String f25610b;

            /* renamed from: c  reason: collision with root package name */
            public String f25611c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f25612d;

            public C0274a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25612d = aVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LangbridgeCell langbridgeCell, Context context, JSONArray jSONArray) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {langbridgeCell, context, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25604a = langbridgeCell;
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        if (!jSONArray.isNull(i4)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i4);
                            if (jSONObject.has("title") && jSONObject.has("icon") && jSONObject.has("callback")) {
                                C0274a c0274a = new C0274a();
                                c0274a.f25609a = jSONObject.optString("title", null);
                                c0274a.f25610b = jSONObject.optString("icon", null);
                                c0274a.f25611c = jSONObject.optString("callback", null);
                                if (compile.matcher(c0274a.f25609a).matches() && !TextUtils.isEmpty(c0274a.f25610b) && !TextUtils.isEmpty(c0274a.f25611c)) {
                                    if (5 <= arrayList.size()) {
                                        break;
                                    }
                                    arrayList.add(c0274a);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                C0274a c0274a2 = (C0274a) arrayList.get(i5);
                add(i5 + 256, c0274a2.f25609a, c0274a2.f25610b);
            }
            add(GDiffPatcher.COPY_INT_USHORT, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (langbridgeCell.m.getBoolean("lang_showshare", false)) {
                add(254, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(255, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this, langbridgeCell, size, arrayList) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25605a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f25606b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ArrayList f25607c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f25608d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, langbridgeCell, Integer.valueOf(size), arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i6 = newInitContext2.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f25608d = this;
                    this.f25605a = langbridgeCell;
                    this.f25606b = size;
                    this.f25607c = arrayList;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                        int itemId = bdMenuItem.getItemId();
                        if (255 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25608d.f25604a.y), this.f25608d.f25604a.q()));
                            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25608d.f25604a.y), this.f25608d.f25604a.q()));
                            if (this.f25608d.f25604a.isActiveCell()) {
                                this.f25608d.f25604a.o().setRnAuthResult(2, "实名认证取消");
                                this.f25608d.f25604a.o().closeWindow();
                            }
                        } else if (254 == itemId) {
                            DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f25608d.f25604a.y)));
                            PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(this.f25608d.f25604a.y));
                            LightAppWrapper.getInstance().callShare(this.f25608d.f25604a.getActivity(), new LightAppShareModel(this.f25608d.f25604a.l.getTitle(), this.f25608d.f25604a.l.getTitle(), this.f25608d.f25604a.l.getUrl(), null), null);
                        } else if (253 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f25608d.f25604a.y)));
                            PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(this.f25608d.f25604a.y));
                            if (this.f25608d.f25604a.isActiveCell()) {
                                LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f25608d.f25604a.getActivity(), this.f25608d.f25604a.y);
                            }
                            this.f25608d.f25604a.l.reload();
                            LangbridgeCell langbridgeCell2 = this.f25608d.f25604a;
                            langbridgeCell2.y = langbridgeCell2.l.getUrl();
                            this.f25608d.f25604a.w = false;
                        } else {
                            int i6 = itemId - 256;
                            if (i6 <= this.f25606b) {
                                this.f25608d.f25604a.executeJsFunction(((C0274a) this.f25607c.get(i6)).f25611c, "");
                            }
                        }
                    }
                }
            });
            layoutMenu();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1286237247, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeCell;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1286237247, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeCell;");
                return;
            }
        }
        O = Pattern.compile("^(https?://|file:///android_asset/).*");
    }

    public LangbridgeCell(Context context, LightappBrowserWebView lightappBrowserWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lightappBrowserWebView, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25556g = true;
        this.f25557h = false;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            WebviewMenu webviewMenu = new WebviewMenu(this, n());
            this.r = webviewMenu;
            webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25563a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25563a = this;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                        switch (bdMenuItem.getItemId()) {
                            case 32:
                                DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f25563a.y)));
                                PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(this.f25563a.y));
                                LightAppWrapper.getInstance().callShare(this.f25563a.getActivity(), new LightAppShareModel(this.f25563a.l.getTitle(), this.f25563a.l.getTitle(), this.f25563a.l.getUrl(), null), null);
                                return;
                            case 33:
                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f25563a.y)));
                                PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(this.f25563a.y));
                                if (this.f25563a.isActiveCell()) {
                                    LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f25563a.getActivity(), this.f25563a.y);
                                }
                                this.f25563a.l.reload();
                                this.f25563a.w = false;
                                return;
                            case 34:
                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25563a.y), this.f25563a.q()));
                                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25563a.y), this.f25563a.q()));
                                if (this.f25563a.isActiveCell()) {
                                    this.f25563a.o().setRnAuthResult(2, "实名认证取消");
                                    this.f25563a.o().closeWindow();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID) || this.t.setCloseButtonVisibility(0) == 0) {
            return;
        }
        this.t.setCloseOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeCell f25566a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25566a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25566a.y), this.f25566a.q()));
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25566a.y), this.f25566a.q()));
                    if (this.f25566a.isActiveCell()) {
                        GlobalUtils.hideKeyboard(this.f25566a.o().getControllerActivity());
                        this.f25566a.o().setRnAuthResult(2, "实名认证取消");
                        this.f25566a.o().closeWindow();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            NoNetView noNetView = this.p;
            if (noNetView != null) {
                noNetView.notifyUrlFinish();
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            a(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25574a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25574a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f25574a.isActiveCell()) {
                        this.f25574a.o().closeTopWebview();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && isActiveCell()) {
            o().closeWindow();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (!p()) {
                v();
            }
            String str = h.a().a(getContext()).MW_JSCALL_ONACTIVE;
            if (!TextUtils.isEmpty(this.y) && !TextUtils.isEmpty(str)) {
                executeJsFunction(str, null);
            }
            com.baidu.wallet.lightapp.monitor.a.a().a((View) this.l, "ACTIVE", false);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = h.a().a(getContext()).MW_JSCALL_ONNEGATIVE;
            if (TextUtils.isEmpty(this.y) || TextUtils.isEmpty(str)) {
                return;
            }
            executeJsFunction(str, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    @Override // com.baidu.wallet.lightapp.multipage.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String exeSSCommand(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048594, this, str, str2, str3)) != null) {
            return (String) invokeLLL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) && this.l != null && !TextUtils.isEmpty(str)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w = false;
            this.f25557h = true;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.N) {
                this.f25553d.checkPermission();
                this.N = false;
            }
            if (this.C == null || TextUtils.isEmpty(this.y)) {
                return;
            }
            this.C.add(new LoadTimeLine(this.y.trim(), MissionEvent.MESSAGE_RESUME, String.valueOf(System.currentTimeMillis())));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (o() != null) {
                return o().getControllerActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.j : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? JsonUtils.toJson(this.C) : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.C != null && !TextUtils.isEmpty(this.y)) {
                this.C.add(new LoadTimeLine(this.y.trim(), MissionEvent.MESSAGE_PAUSE, String.valueOf(System.currentTimeMillis())));
            }
            this.R = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.y, this.R);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            a(new Runnable(this, i2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f25572a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25573b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25573b = this;
                    this.f25572a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f25573b.isActiveCell()) {
                        this.f25573b.o().historyGo(this.f25572a);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            LightappJsClient lightappJsClient = this.f25552c;
            if (lightappJsClient != null) {
                lightappJsClient.destroy();
            }
            if (this.l != null) {
                LightappWebViewCenter.getInstance().releaseLightappWebView2Pool(this.l);
                this.k.setTarget(null);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            WeakReference<d> weakReference = this.f25551b;
            return (weakReference == null || weakReference.get() == null || this.f25551b.get().getControllerActivity() == null || !this.f25551b.get().isActiveCell(this)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25570a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25570a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25570a.i();
                    }
                }
            }, ResUtils.getInteger(getContext(), "wallet_langbridge_slide_duration"));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            l();
            a(this.l);
            this.f25553d = (LightappBusinessClient) this.f25552c.getLightappBusiness();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            View inflate = LayoutInflater.from(this.j).inflate(ResUtils.layout(this.j, "wallet_langbrige_cell"), (ViewGroup) null);
            this.f25558i = inflate;
            LangbridgeSlideLayout langbridgeSlideLayout = (LangbridgeSlideLayout) inflate.findViewById(ResUtils.id(this.j, "bd_langbridge_slide"));
            this.k = langbridgeSlideLayout;
            langbridgeSlideLayout.setTarget(this.l);
            this.H = (FrameLayout) this.f25558i.findViewById(ResUtils.id(this.j, "bd_ab_container"));
            this.I = (FrameLayout) this.f25558i.findViewById(ResUtils.id(this.j, "bd_trans_container"));
            this.F = (FrameLayout) this.f25558i.findViewById(ResUtils.id(this.j, "progress_line_container"));
            this.G = (FrameLayout) this.f25558i.findViewById(ResUtils.id(this.j, "progress_trans_container"));
            View view = new View(this.j);
            this.q = view;
            view.setVisibility(8);
            this.t = b(this.m.getBoolean(com.baidu.wallet.api.Constants.LONG_TITLE));
            this.p = (NoNetView) this.f25558i.findViewById(ResUtils.id(this.j, "nonet_view"));
            a(false);
            u();
            b("");
            this.u = (LinearLayout) this.f25558i.findViewById(ResUtils.id(this.j, "walelt_app_host_background"));
            this.v = (TextView) this.f25558i.findViewById(ResUtils.id(this.j, "walelt_base_light_app_host"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || getActivity() == null) {
            return;
        }
        this.P = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.f25553d, str);
        getActivity().startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 5);
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public Context n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? getActivity() != null ? getActivity() : getContext() : (Context) invokeV.objValue;
    }

    public d o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            WeakReference<d> weakReference = this.f25551b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
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
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048613, this, str, z) == null) {
            a(new Runnable(this, str, z) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25591a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f25592b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25593c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25593c = this;
                    this.f25591a = str;
                    this.f25592b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f25593c.isActiveCell()) {
                        String str2 = this.f25593c.y;
                        if (str2 != null && !str2.equals(this.f25591a)) {
                            LangbridgeCacheManager.getInstance().handleLoadUrl(this.f25593c.o().getLangbridgeHash(), this.f25591a);
                            if (this.f25593c.o().createLangbridgeCell(this.f25591a, false, this.f25592b)) {
                                this.f25593c.v();
                                return;
                            }
                            return;
                        }
                        LightappBrowserWebView lightappBrowserWebView = this.f25593c.l;
                        if (lightappBrowserWebView != null) {
                            lightappBrowserWebView.reload();
                            this.f25593c.w = false;
                        }
                    }
                }
            });
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? o() != null && o().isBottomCell(this) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            a(1101, str, this.y);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, arrayList, i2) == null) {
            a(new Runnable(this, i2, arrayList) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f25594a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ArrayList f25595b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25596c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25596c = this;
                    this.f25594a = i2;
                    this.f25595b = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f25596c.isActiveCell()) {
                        if (this.f25594a == -1) {
                            LangbridgePreloadCellCenter.getInstance(this.f25596c.getContext()).preload(this.f25595b, this.f25596c.o().getOwnerTag());
                        } else {
                            LangbridgePreloadCellCenter.getInstance(this.f25596c.getContext()).preload(this.f25595b, this.f25594a, this.f25596c.o().getOwnerTag());
                        }
                    }
                }
            });
        }
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(o() != null ? Integer.valueOf(o().getLangbridgeStatus()) : "");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.q.setVisibility(0);
            this.q.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_blue"));
            a(5);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.q.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_transparent"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && isActiveCell()) {
            this.B = new ContactInfoPresenter(getActivity(), this.f25553d);
            ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str, str2})) == null) {
            a(new Runnable(this, z4, z3, z, z2, str2, str) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f25579a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f25580b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f25581c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f25582d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f25583e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f25584f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25585g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(z2), str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25585g = this;
                    this.f25579a = z4;
                    this.f25580b = z3;
                    this.f25581c = z;
                    this.f25582d = z2;
                    this.f25583e = str2;
                    this.f25584f = str;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        if (this.f25581c) {
                            this.f25585g.l.setOnMyScrollChangeListener(new LightappWebView.a(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f25586a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f25586a = this;
                                }

                                @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                                public void a(int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                        int height = this.f25586a.f25585g.t.getHeight();
                                        float f2 = (height - i2) / height;
                                        if (f2 > 0.0f) {
                                            LangbridgeCell langbridgeCell = this.f25586a.f25585g;
                                            int i3 = langbridgeCell.E;
                                            if (i3 != -1) {
                                                langbridgeCell.t.setFullScreenTextColor(i3);
                                            }
                                            float f3 = 1.0f - f2;
                                            int i4 = (int) (255.0f * f3);
                                            AnonymousClass4 anonymousClass4 = this.f25586a;
                                            if (anonymousClass4.f25582d) {
                                                if (i4 >= 255) {
                                                    anonymousClass4.f25585g.t.setTitleTextColorAlpha(i4);
                                                } else {
                                                    anonymousClass4.f25585g.t.setTitleTextColorAlpha(0);
                                                }
                                            }
                                            AnonymousClass4 anonymousClass42 = this.f25586a;
                                            if (anonymousClass42.f25579a) {
                                                anonymousClass42.f25585g.t.setIconFlag(true);
                                            }
                                            LangbridgeCell langbridgeCell2 = this.f25586a.f25585g;
                                            int i5 = langbridgeCell2.D;
                                            if (i5 != -1) {
                                                langbridgeCell2.t.setTitlebgColor(LangbridgeCell.a(f3, i5, ResUtils.getColor(langbridgeCell2.j, "wallet_extend_color_actionbar_bg")));
                                                return;
                                            }
                                            return;
                                        }
                                        AnonymousClass4 anonymousClass43 = this.f25586a;
                                        if (anonymousClass43.f25582d) {
                                            anonymousClass43.f25585g.t.setTitleTextColorAlpha(255);
                                        }
                                        AnonymousClass4 anonymousClass44 = this.f25586a;
                                        if (anonymousClass44.f25579a) {
                                            anonymousClass44.f25585g.t.setIconFlag(false);
                                        }
                                        LangbridgeCell langbridgeCell3 = this.f25586a.f25585g;
                                        langbridgeCell3.t.setTitlebgColor(ResUtils.getColor(langbridgeCell3.j, "wallet_extend_color_actionbar_bg"));
                                        this.f25586a.f25585g.t.resetFullScreenTextColor();
                                    }
                                }
                            });
                        } else {
                            this.f25585g.l.setOnMyScrollChangeListener(new LightappWebView.a(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f25587a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f25587a = this;
                                }

                                @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                                public void a(int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                        int height = this.f25587a.f25585g.t.getHeight();
                                        float f2 = (height - i2) / height;
                                        if (f2 > 0.0f) {
                                            int i3 = (int) ((1.0f - f2) * 255.0f);
                                            AnonymousClass4 anonymousClass4 = this.f25587a;
                                            if (anonymousClass4.f25582d) {
                                                if (i3 >= 255) {
                                                    anonymousClass4.f25585g.t.setTitleTextColorAlpha(i3);
                                                    return;
                                                } else {
                                                    anonymousClass4.f25585g.t.setTitleTextColorAlpha(0);
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        AnonymousClass4 anonymousClass42 = this.f25587a;
                                        if (anonymousClass42.f25582d) {
                                            anonymousClass42.f25585g.t.setTitleTextColorAlpha(255);
                                        }
                                    }
                                }
                            });
                        }
                    }
                }

                private void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                        if (this.f25582d) {
                            this.f25585g.t.setTitleTextColorAlpha(0);
                        } else {
                            this.f25585g.t.setTitleTextColorAlpha(255);
                        }
                    }
                }

                private void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65539, this) == null) {
                        if (!TextUtils.isEmpty(this.f25583e)) {
                            try {
                                this.f25585g.E = Color.parseColor(this.f25583e);
                            } catch (Throwable unused) {
                            }
                        } else {
                            this.f25585g.E = 0;
                        }
                        LangbridgeCell langbridgeCell = this.f25585g;
                        int i2 = langbridgeCell.E;
                        if (i2 != 0) {
                            langbridgeCell.t.setFullScreenTextColor(i2);
                        } else {
                            langbridgeCell.t.resetFullScreenTextColor();
                        }
                    }
                }

                private void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65540, this) == null) {
                        if (!TextUtils.isEmpty(this.f25584f)) {
                            try {
                                this.f25585g.D = Color.parseColor(this.f25584f);
                            } catch (Throwable unused) {
                            }
                        } else {
                            this.f25585g.D = -1;
                        }
                        LangbridgeCell langbridgeCell = this.f25585g;
                        int i2 = langbridgeCell.D;
                        if (i2 != -1) {
                            langbridgeCell.t.setTitlebgColor(i2);
                            this.f25585g.t.setBottomSeperatorvisible(false);
                            LangbridgeCell langbridgeCell2 = this.f25585g;
                            langbridgeCell2.a(Color.alpha(langbridgeCell2.D) != 255);
                            return;
                        }
                        langbridgeCell.t.setTitlebgColor(ResUtils.getColor(langbridgeCell.j, "wallet_extend_color_actionbar_bg"));
                        this.f25585g.t.setBottomSeperatorvisible(true);
                        LangbridgeCell langbridgeCell3 = this.f25585g;
                        langbridgeCell3.a(Color.alpha(langbridgeCell3.D) != 255);
                    }
                }

                private void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                        LangbridgeCell langbridgeCell = this.f25585g;
                        int i2 = langbridgeCell.D;
                        if (i2 != -1 && ((-16777216) | i2) != -1) {
                            langbridgeCell.u.setBackgroundColor(i2);
                        } else {
                            LangbridgeCell langbridgeCell2 = this.f25585g;
                            langbridgeCell2.u.setBackgroundColor(ResUtils.getColor(langbridgeCell2.j, "wallet_base_background1_color_7f"));
                        }
                        LangbridgeCell langbridgeCell3 = this.f25585g;
                        int i3 = langbridgeCell3.E;
                        if (i3 != 0) {
                            langbridgeCell3.v.setTextColor(i3);
                        } else {
                            langbridgeCell3.v.setTextColor(ResUtils.getColor(langbridgeCell3.j, "wallet_base_font_text4Color"));
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25585g.t.setIconFlag(this.f25579a);
                        LangbridgeSlideLayout langbridgeSlideLayout = this.f25585g.k;
                        if (langbridgeSlideLayout != null) {
                            langbridgeSlideLayout.setSupportPullDown(!this.f25580b);
                        }
                        d();
                        c();
                        b();
                        e();
                        a();
                    }
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
        return (JSONObject) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setIsCheckPermission(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.N = z;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, jSONArray) == null) {
            this.x = jSONArray;
            a(new Runnable(this, jSONArray) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONArray f25588a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25589b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONArray};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25589b = this;
                    this.f25588a = jSONArray;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f25589b.t.getRightZoneView() == null) {
                        return;
                    }
                    LangbridgeCell langbridgeCell = this.f25589b;
                    LangbridgeCell langbridgeCell2 = this.f25589b;
                    langbridgeCell.s = new a(langbridgeCell2, langbridgeCell2.n(), this.f25588a);
                    this.f25589b.t.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass5 f25590a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25590a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                LangbridgeCell langbridgeCell3 = this.f25590a.f25589b;
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
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048624, this, str, str2, z) == null) {
            a(new Runnable(this, str, str2, z) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25575a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25576b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f25577c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25578d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25578d = this;
                    this.f25575a = str;
                    this.f25576b = str2;
                    this.f25577c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LangbridgeCell langbridgeCell = this.f25578d;
                        if (langbridgeCell.t != null) {
                            if (!NetworkUtils.isNetworkConnected(langbridgeCell.j)) {
                                this.f25578d.t.setTitle("");
                                this.f25578d.t.setTitleCenterSafeTipText("");
                            } else if (TextUtils.isEmpty(this.f25575a)) {
                                LangbridgeCell langbridgeCell2 = this.f25578d;
                                langbridgeCell2.t.setTitle(langbridgeCell2.l.getTitle());
                                this.f25578d.f25550a = null;
                            } else {
                                String str3 = this.f25575a;
                                this.f25578d.t.setTitle(str3);
                                this.f25578d.f25550a = str3;
                                if (!TextUtils.isEmpty(this.f25576b)) {
                                    String trim = this.f25576b.trim();
                                    if (!TextUtils.isEmpty(trim)) {
                                        this.f25578d.t.setTitleCenterSafeTipText(trim);
                                    }
                                } else {
                                    this.f25578d.t.setTitleCenterSafeTipText("");
                                }
                            }
                            if (this.f25577c) {
                                int[] titleSizeRange = this.f25578d.t.getTitleSizeRange();
                                int i2 = titleSizeRange[0];
                                int i3 = titleSizeRange[1];
                                int mainTitleViewWidth = this.f25578d.t.getMainTitleViewWidth();
                                float f2 = i2;
                                float stringWidth = com.baidu.wallet.utils.StringUtil.getStringWidth(this.f25578d.t.getTitle(), f2);
                                this.f25578d.t.setTitleEllipsize(TextUtils.TruncateAt.END);
                                float f3 = mainTitleViewWidth;
                                if (stringWidth <= f3) {
                                    this.f25578d.t.setTitleSize(i2);
                                    return;
                                }
                                float f4 = f3 / stringWidth;
                                if (1.0f > f4 && i3 / f2 <= f4) {
                                    this.f25578d.t.setTitleSize(Math.round(f2 * f4));
                                    return;
                                }
                                this.f25578d.t.setTitleSize(i3);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            LightappBusinessClient lightappBusinessClient = this.f25553d;
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
        return invokeV.booleanValue;
    }

    private BdActionBar b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65550, this, z)) == null) {
            if (z) {
                return new BdLightAppActionBar(n());
            }
            return new BdActionBar(n());
        }
        return (BdActionBar) invokeZ.objValue;
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, str) == null) || this.t == null) {
            return;
        }
        if (!this.m.getBoolean("lang_showtitle", true)) {
            this.t.setVisibility(8);
        }
        this.t.setTitle("");
        this.t.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeCell f25564a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25564a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f25564a.isActiveCell()) {
                    GlobalUtils.hideKeyboard(this.f25564a.o().getControllerActivity());
                    this.f25564a.o().backPressed();
                }
            }
        });
        if (this.r == null) {
            return;
        }
        this.t.setRightImgZone2Visibility(0);
        this.t.setRightImgZone2Enable(true);
        this.t.setRightImgZone2Src(ResUtils.drawable(this.j, "wallet_base_overflow"), ResUtils.getString(this.j, "wallet_base_bdaction_more"));
        this.t.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeCell f25565a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25565a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f25565a.r.show();
                }
            }
        });
        this.t.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
    }

    public void a(LightappWebView lightappWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lightappWebView) == null) {
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
            this.f25552c = lightappJsClient;
            lightappWebView.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
            DXMSdkSAUtils.onEventWithValues("#injectJavaObject", Arrays.asList(m(), this.f25552c.hashCode() + "", lightappWebView.hashCode() + ""));
            PayStatisticsUtil.onEventWithValues("#injectJavaObject", Arrays.asList(m(), this.f25552c.hashCode() + "", lightappWebView.hashCode() + ""));
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
            lightappWebView.setWebViewClient(new CustomWebViewClient(this));
            lightappWebView.setWebChromeClient(new CustomChromeClient(this));
            lightappWebView.setDownloadListener(new DownloadListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public Pattern f25559a;

                /* renamed from: b  reason: collision with root package name */
                public Matcher f25560b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25561c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25561c = this;
                    Pattern compile = Pattern.compile(".*");
                    this.f25559a = compile;
                    this.f25560b = compile.matcher("");
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        try {
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            this.f25561c.a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (Exception e2) {
                            LogUtil.e("LangbridgeCell", "Download Error", e2);
                            GlobalUtils.toast(this.f25561c.j, "下载出现异常");
                        }
                    }
                }
            });
            this.C = new Vector<>();
            if (TextUtils.isEmpty(this.y)) {
                return;
            }
            this.C.add(new LoadTimeLine(this.y.trim(), MissionEvent.MESSAGE_CREATE, String.valueOf(System.currentTimeMillis())));
        }
    }

    private void d(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
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
    }

    /* loaded from: classes6.dex */
    public class CustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f25599a;

        public CustomChromeClient(LangbridgeCell langbridgeCell) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {langbridgeCell};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25599a = langbridgeCell;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, consoleMessage)) == null) {
                if (consoleMessage == null) {
                    return super.onConsoleMessage(consoleMessage);
                }
                ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
                if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                    String sourceId = consoleMessage.sourceId();
                    sourceId = (TextUtils.equals(sourceId, this.f25599a.z) || TextUtils.isEmpty(sourceId)) ? "" : "";
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("level", messageLevel.name());
                    linkedHashMap.put("message", consoleMessage.message());
                    linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                    linkedHashMap.put("sourceId", sourceId);
                    linkedHashMap.put("pageUrl", this.f25599a.z);
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25599a.z).toString());
                    if (!TextUtils.isEmpty(consoleMessage.message()) && consoleMessage.message().contains(LightappJsClient.LIGHTAPP_JS_NAME)) {
                        linkedHashMap.put("owner", this.f25599a.m());
                        if (this.f25599a.b() != null && this.f25599a.b().getJsBridge() != null) {
                            linkedHashMap.put("webview", this.f25599a.b().hashCode() + "");
                            if (this.f25599a.f25552c == null) {
                                str = StringUtil.NULL_STRING;
                            } else {
                                str = this.f25599a.f25552c.hashCode() + "";
                            }
                            linkedHashMap.put("jsclient", str);
                        }
                    }
                    Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, linkedHashMap, this.f25599a.getContext());
                }
                return super.onConsoleMessage(consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, callback) == null) {
                callback.invoke(str, true, false);
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                LogUtil.d("LangbridgeCell", "onProgressChanged:newProgress   " + i2);
                this.f25599a.a(i2);
                if (i2 == 100) {
                    this.f25599a.s();
                    if (this.f25599a.w) {
                        return;
                    }
                    LogUtil.d("LangbridgeCell", "onProgressChanged.hideErrorPage");
                    this.f25599a.w();
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (this.f25599a.t != null) {
                    if (!TextUtils.isEmpty("") && !NetworkUtils.isNetworkConnected(this.f25599a.j)) {
                        this.f25599a.t.setTitle("");
                        this.f25599a.t.setTitleCenterSafeTipText("");
                        return;
                    }
                    LangbridgeCell langbridgeCell = this.f25599a;
                    String str2 = langbridgeCell.f25550a;
                    if (str2 != null) {
                        langbridgeCell.t.setTitle(str2);
                    } else if (!TextUtils.isEmpty(langbridgeCell.m.getString("lang_customtitle"))) {
                        LangbridgeCell langbridgeCell2 = this.f25599a;
                        langbridgeCell2.t.setTitle(langbridgeCell2.m.getString("lang_customtitle"));
                    } else if (!TextUtils.isEmpty(str) && !LangbridgeCell.O.matcher(str).matches()) {
                        if (("http://" + str).equals(this.f25599a.y)) {
                            this.f25599a.t.setTitle(" ");
                        } else {
                            this.f25599a.t.setTitle(str);
                        }
                    } else {
                        this.f25599a.t.setTitle(" ");
                    }
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            String[] acceptTypes;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, webView, valueCallback, fileChooserParams)) == null) {
                this.f25599a.f25555f = valueCallback;
                if (fileChooserParams == null || (acceptTypes = fileChooserParams.getAcceptTypes()) == null || acceptTypes.length <= 0 || TextUtils.isEmpty(acceptTypes[0])) {
                    return true;
                }
                this.f25599a.a(acceptTypes[0], fileChooserParams.isCaptureEnabled(), 2);
                return true;
            }
            return invokeLLL.booleanValue;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, valueCallback) == null) {
                this.f25599a.f25554e = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                if (intent.resolveActivity(this.f25599a.n().getPackageManager()) != null) {
                    this.f25599a.a(Intent.createChooser(intent, "File Chooser"), 1);
                    return;
                }
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
                PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, valueCallback, str) == null) {
                this.f25599a.f25554e = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(str);
                if (intent.resolveActivity(this.f25599a.n().getPackageManager()) != null) {
                    this.f25599a.a(Intent.createChooser(intent, "File Browser"), 1);
                    return;
                }
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
                PayStatisticsUtil.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, valueCallback, str, str2) == null) {
                this.f25599a.f25554e = valueCallback;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f25599a.a(str, !TextUtils.isEmpty(str2), 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, str) == null) && this.m.getBoolean("lang_showerror", true)) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (LightappBrowserWebView) invokeV.objValue;
    }

    public LangbridgeCell(d dVar, Bundle bundle, LightappBrowserWebView lightappBrowserWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, bundle, lightappBrowserWebView, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f25556g = true;
        this.f25557h = false;
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
    public void a(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, bVar) == null) {
            this.y = str;
            this.n = bVar;
            this.o = false;
            a(new Runnable(this, bVar, str) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f25567a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25568b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f25569c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25569c = this;
                    this.f25567a = bVar;
                    this.f25568b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (!LangbridgeCell.O.matcher(this.f25569c.y).matches()) {
                                LangbridgeCell langbridgeCell = this.f25569c;
                                langbridgeCell.y = "https://" + this.f25569c.y;
                            }
                            this.f25569c.l.loadUrl(this.f25569c.y.trim());
                            this.f25569c.w = false;
                        } catch (Exception e2) {
                            LogUtil.d("Url error");
                            b bVar2 = this.f25567a;
                            if (bVar2 != null) {
                                bVar2.a(1102, e2.toString(), this.f25568b);
                            }
                            if (this.f25569c.isActiveCell()) {
                                this.f25569c.o().closeWindow();
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(d dVar, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, dVar, bundle, str) == null) {
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
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f25551b = new WeakReference<>(dVar);
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, strArr, iArr) == null) {
            this.f25552c.onRequestPermissionsResultLocal(i2, strArr, iArr);
            LightappBusinessClient lightappBusinessClient = this.f25553d;
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
                    ValueCallback<Uri> valueCallback = this.f25554e;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(null);
                        this.f25554e = null;
                    }
                    this.S = null;
                } else if (i2 == 2) {
                    ValueCallback<Uri[]> valueCallback2 = this.f25555f;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(new Uri[0]);
                        this.f25555f = null;
                    }
                    this.S = null;
                }
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
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
                LightappBusinessClient lightappBusinessClient = this.f25553d;
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
                    this.f25553d.setAlubmPhotoData(1, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.P.a("#callNativePhoto Fail", "用户取消选择");
            } else if (i2 == 1) {
                if (this.f25554e == null) {
                    return;
                }
                Uri data = (intent == null || i3 != -1) ? null : intent.getData();
                if (data != null) {
                    this.f25554e.onReceiveValue(data);
                } else {
                    this.f25554e.onReceiveValue(this.S);
                }
                this.f25554e = null;
                this.S = null;
            } else if (i2 == 2) {
                if (this.f25555f == null) {
                    return;
                }
                Uri data2 = (intent == null || i3 != -1) ? null : intent.getData();
                if (data2 != null) {
                    this.f25555f.onReceiveValue(new Uri[]{data2});
                } else {
                    Uri uri = this.S;
                    if (uri != null) {
                        this.f25555f.onReceiveValue(new Uri[]{uri});
                    } else {
                        this.f25555f.onReceiveValue(new Uri[0]);
                    }
                }
                this.f25555f = null;
                this.S = null;
            } else if (i2 == 3) {
                if (i3 == -1) {
                    this.f25552c.onCallCameraPicCallbackLocal();
                }
            } else if (i2 != 4) {
                if (i2 == 6) {
                    this.f25552c.onInsertCalendarEventDone(i3 == -1);
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
                            this.f25552c.onContactsSelectedLocal(0, new String[]{str, StringUtils.trimAll(str2)}, "");
                            return;
                        }
                        a(this.A, new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.17
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ LangbridgeCell f25571a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f25571a = this;
                            }

                            @Override // android.widget.AdapterView.OnItemClickListener
                            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j)}) == null) || i4 <= 0 || i4 >= this.f25571a.A.size()) {
                                    return;
                                }
                                String replace = this.f25571a.A.get(i4).replace(" ", "").replace("-", "");
                                LangbridgeCell langbridgeCell = this.f25571a;
                                langbridgeCell.f25552c.onContactsSelectedLocal(0, new String[]{langbridgeCell.A.get(0), replace}, "");
                            }
                        });
                        return;
                    }
                }
                this.f25552c.onContactsSelectedLocal(1, null, ResUtils.getString(this.j, "wallet_base_select_phone_fail"));
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25558i : (View) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.Q = str;
        }
    }

    public void a(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, intent, i2) == null) && isActiveCell()) {
            o().getControllerActivity().startActivityForResult(intent, i2);
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, intent) == null) && isActiveCell()) {
            o().getControllerActivity().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(this.j) * i2) / 100.0f);
            this.q.setLayoutParams(layoutParams);
        }
    }

    public void a(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, onItemClickListener) == null) {
            SelectNumberDialog selectNumberDialog = new SelectNumberDialog(n());
            selectNumberDialog.setOnItemClickListener(onItemClickListener);
            selectNumberDialog.setData(list);
            selectNumberDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(AdIconUtil.AD_TEXT_ID, this, i2, str, str2) == null) || this.n == null || this.o) {
            return;
        }
        if (i2 != 0) {
            this.o = true;
        }
        this.n.a(i2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
        if (r14.equals("image") != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, boolean z, int i2) {
        Intent intent;
        Intent intent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") && !PermissionManager.checkCallingPermission(getActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                this.L = str;
                this.M = z;
                this.K = i2;
                BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LangbridgeCell f25597a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25597a = this;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                PermissionManager.checkCallingOrSelfPermission(this.f25597a.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 102);
                            } else {
                                this.f25597a.a(102, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1, -1});
                            }
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str2, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, bool) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str2, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str2, bool) == null) {
                        }
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
                                BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.9
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ LangbridgeCell f25598a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f25598a = this;
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void isAllAgree(Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                            if (bool.booleanValue()) {
                                                PermissionManager.checkCallingOrSelfPermission(this.f25598a.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                            } else {
                                                this.f25598a.a(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                                            }
                                        }
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void isShow(String str3, Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, bool) == null) {
                                        }
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void requestResult(String str3, Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str3, bool) == null) {
                                        }
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
                                BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.10
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ LangbridgeCell f25562a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f25562a = this;
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void isAllAgree(Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                            if (bool.booleanValue()) {
                                                PermissionManager.checkCallingOrSelfPermission(this.f25562a.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                            } else {
                                                this.f25562a.a(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                                            }
                                        }
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void isShow(String str3, Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, bool) == null) {
                                        }
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void requestResult(String str3, Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str3, bool) == null) {
                                        }
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
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, runnable) == null) || runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static int a(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int red = Color.red(i2);
            int blue = Color.blue(i2);
            int green = Color.green(i2);
            int alpha = Color.alpha(i2);
            return Color.argb((int) (alpha + (f2 * (Color.alpha(i3) - alpha))), (int) (red + ((Color.red(i3) - red) * f2)), (int) (green + ((Color.green(i3) - green) * f2)), (int) (blue + ((Color.blue(i3) - blue) * f2)));
        }
        return invokeCommon.intValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
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
}
