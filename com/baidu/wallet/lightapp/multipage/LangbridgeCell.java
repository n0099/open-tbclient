package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
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
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.lightapp.ability.b.b;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LangbridgeBarParams;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.widget.BdLightAppActionBar;
import com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.wallet.utils.URLUtil;
import com.baidu.webkit.sdk.PermissionRequest;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.google.android.material.badge.BadgeDrawable;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class LangbridgeCell implements com.baidu.wallet.lightapp.multipage.a, c, NoNetView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern R;
    public static final FrameLayout.LayoutParams s;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray A;
    public String B;
    public String C;
    public List<String> D;
    public ContactInfoPresenter E;
    public Vector<LoadTimeLine> F;
    public FrameLayout G;
    public WebChromeClient.CustomViewCallback H;
    public FrameLayout I;
    public FrameLayout J;
    public FrameLayout K;
    public FrameLayout L;
    public Intent M;
    public int N;
    public String O;
    public boolean P;
    public boolean Q;
    public com.baidu.wallet.lightapp.business.presenter.a S;
    public String T;
    public int U;
    public List V;
    public String W;
    public LangbridgeBarParams X;
    public LangbridgeBarParams Y;
    public Uri Z;

    /* renamed from: a  reason: collision with root package name */
    public String f60051a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f60052b;

    /* renamed from: c  reason: collision with root package name */
    public LightappJsClient f60053c;

    /* renamed from: d  reason: collision with root package name */
    public LightappBusinessClient f60054d;

    /* renamed from: e  reason: collision with root package name */
    public ValueCallback<Uri> f60055e;

    /* renamed from: f  reason: collision with root package name */
    public ValueCallback<Uri[]> f60056f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60057g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60058h;

    /* renamed from: i  reason: collision with root package name */
    public View f60059i;
    public Context j;
    public LangbridgeSlideLayout k;
    public LightappBrowserWebView l;
    public Bundle m;
    public com.baidu.wallet.lightapp.multipage.b n;
    public boolean o;
    public boolean p;
    public NoNetView q;
    public View r;
    public View t;
    public WebviewMenu u;
    public a v;
    public BdActionBar w;
    public LinearLayout x;
    public TextView y;
    public boolean z;

    /* loaded from: classes10.dex */
    public class CustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f60118a;

        /* renamed from: b  reason: collision with root package name */
        public Pattern f60119b;

        /* renamed from: c  reason: collision with root package name */
        public String f60120c;

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
            this.f60118a = langbridgeCell;
            this.f60119b = Pattern.compile("\\s*https?://.*");
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
                LangbridgeCell langbridgeCell = this.f60118a;
                if (langbridgeCell.f60057g) {
                    langbridgeCell.l.clearHistory();
                    if (str == null || str.contains("about:blank")) {
                        return;
                    }
                    this.f60118a.f60057g = false;
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                Vector<LoadTimeLine> vector = this.f60118a.F;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
                }
                this.f60118a.u();
                LangbridgeCell langbridgeCell = this.f60118a;
                com.baidu.wallet.lightapp.base.a a2 = com.baidu.wallet.lightapp.base.a.a();
                LangbridgeCell langbridgeCell2 = this.f60118a;
                langbridgeCell.U = a2.a(langbridgeCell2.j, str, langbridgeCell2.U);
                this.f60118a.B = str;
                String host = Uri.parse(str).getHost();
                this.f60120c = str;
                if (TextUtils.isEmpty(host)) {
                    this.f60118a.y.setVisibility(8);
                } else {
                    this.f60118a.y.setVisibility(0);
                    LangbridgeCell langbridgeCell3 = this.f60118a;
                    langbridgeCell3.y.setText(langbridgeCell3.j.getResources().getString(ResUtils.string(this.f60118a.j, "wallet_langbridge_url_outer"), host));
                }
                String title = this.f60118a.w.getTitle();
                if (title != null && title.equals("")) {
                    String title2 = webView.getTitle();
                    if (title2 == null || this.f60119b.matcher(title2).matches()) {
                        this.f60118a.d((String) null);
                    } else {
                        this.f60118a.d(title2);
                    }
                }
                if (webView.getProgress() != 100) {
                    this.f60118a.z = true;
                }
                LogUtil.d("LangbridgeCell", "onPageFinished.finishedError:  " + this.f60118a.z + " url: " + str);
                super.onPageFinished(webView, str);
                this.f60118a.a(0, "success", str);
                String[] strArr = new String[6];
                strArr[0] = CheckUtils.stripUrlParams(this.f60118a.B);
                strArr[1] = this.f60118a.s();
                strArr[2] = this.f60118a.z ? "1" : "0";
                strArr[3] = "";
                strArr[4] = "";
                strArr[5] = URLUtil.getHost(this.f60118a.B);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(strArr));
                if (this.f60118a.isActiveCell()) {
                    if (webView.getProgress() == 100) {
                        WhiteScreenMonitor.a().a(this.f60118a.l, WhiteScreenMonitor.PageStates.FINISH);
                    }
                    LangbridgeCacheManager.getInstance().handleFinishPage(str);
                }
                String str2 = i.a().a(this.f60118a.getContext()).MW_JSCALL_ONACTIVE;
                if (this.f60118a.isActiveCell() && !TextUtils.isEmpty(str2)) {
                    this.f60118a.executeJsFunction(str2, null);
                }
                LightappBrowserWebView lightappBrowserWebView = this.f60118a.l;
                if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack()) {
                    return;
                }
                LangbridgeCell langbridgeCell4 = this.f60118a;
                if (langbridgeCell4.f60057g) {
                    return;
                }
                langbridgeCell4.x();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                LogUtil.d("onPageStarted", "url = " + str);
                LogUtil.d("onPageStarted", "clear query url = " + URLUtil.clearQuery(str));
                Vector<LoadTimeLine> vector = this.f60118a.F;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
                }
                this.f60118a.C = str;
                if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                    this.f60118a.setFullScreenInMainThread(false, a(str, this.f60120c) && (this.f60118a.X != null && this.f60118a.X.isHideTitle), false, false, "", "");
                } else if (this.f60118a.Y != null && !this.f60118a.Y.equals(this.f60118a.X)) {
                    LangbridgeCell langbridgeCell = this.f60118a;
                    langbridgeCell.setFullScreenInMainThread(langbridgeCell.Y.isFullScreen, this.f60118a.Y.isHideTitle, this.f60118a.Y.isHideHost, this.f60118a.Y.isIconWhite, StringUtil.getHexColorStr(this.f60118a.Y.fullScreenActionBarColor), StringUtil.getHexColorStr(this.f60118a.Y.fullScreenTitleColor));
                    LangbridgeCell langbridgeCell2 = this.f60118a;
                    langbridgeCell2.Y = langbridgeCell2.X;
                }
                this.f60118a.A();
                if (!this.f60118a.isActiveCell() || LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                    this.f60118a.t();
                }
                this.f60118a.d("");
                this.f60118a.w.setTitleCenterSafeTipText("");
                this.f60118a.w.setRightImgZone1Enable(false);
                if (this.f60118a.w.getRightZone1View().getVisibility() == 0) {
                    this.f60118a.w.setRightImgZone1Visibility(8);
                    this.f60118a.w.hideBubble(false);
                }
                LangbridgeCell langbridgeCell3 = this.f60118a;
                langbridgeCell3.v = null;
                LightappBusinessClient lightappBusinessClient = langbridgeCell3.f60054d;
                if (lightappBusinessClient != null) {
                    lightappBusinessClient.setH5BackCb(null);
                }
                LangbridgeCell langbridgeCell4 = this.f60118a;
                langbridgeCell4.f60051a = null;
                langbridgeCell4.f60053c.setUrlLocal(str);
                super.onPageStarted(webView, str, bitmap);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f60118a.B), this.f60118a.s(), "", "", "", URLUtil.getHost(this.f60118a.B)));
                if (this.f60118a.isActiveCell()) {
                    WhiteScreenMonitor.a().a(this.f60118a.l, WhiteScreenMonitor.PageStates.START);
                    LangbridgePreloadCellCenter.getInstance(this.f60118a.getContext()).setAllCellsEnable(false);
                    LangbridgeCacheManager.getInstance().handleStartPage(str);
                    z = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
                } else {
                    z = false;
                }
                if (!NetworkUtils.isNetworkAvailable(this.f60118a.j) && !z) {
                    this.f60118a.c(str);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(CheckUtils.stripUrlParams(str)));
                }
                if (a(str, this.f60120c)) {
                    return;
                }
                com.baidu.wallet.lightapp.base.c.a(this.f60118a.getActivity());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str;
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
                linkedHashMap.put("pageUrl", this.f60118a.C);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f60118a.C).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f60118a.getContext());
                if (webResourceError == null || webResourceRequest == null || -10 == webResourceError.getErrorCode() || !webResourceRequest.isForMainFrame()) {
                    return;
                }
                this.f60118a.z = true;
                if (-1 == webResourceError.getErrorCode() && this.f60118a.V != null && this.f60118a.V.contains(String.valueOf(webResourceRequest.getUrl()))) {
                    this.f60118a.V.remove(String.valueOf(webResourceRequest.getUrl()));
                } else {
                    NoNetView noNetView = this.f60118a.q;
                    if (noNetView != null) {
                        noNetView.setFailureCause(webResourceError.getErrorCode());
                    }
                    this.f60118a.c(webResourceRequest.getUrl().toString());
                }
                LightappWebViewCenter.getInstance().startAutoChecker();
                this.f60118a.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), webResourceRequest.getUrl().toString());
                LogUtil.d("LangbridgeCell", "onReceivedError2.showErrorPage");
                String[] strArr = new String[4];
                strArr[0] = String.valueOf(webResourceError.getErrorCode());
                strArr[1] = String.valueOf(webResourceRequest.getUrl());
                LightappBrowserWebView b2 = this.f60118a.b();
                String str2 = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                if (b2 == null) {
                    str = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                } else {
                    str = this.f60118a.b().hashCode() + "";
                }
                strArr[2] = str;
                if (this.f60118a.f60053c != null) {
                    str2 = this.f60118a.f60053c.hashCode() + "";
                }
                strArr[3] = str2;
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
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
                        LightappWebViewCenter.getInstance().startAutoChecker();
                        this.f60118a.a(statusCode, webResourceResponse.getReasonPhrase(), uri);
                        LogUtil.d("LangbridgeCell", "onReceivedHttpError2,callback");
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (Build.VERSION.SDK_INT >= 21) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (webResourceRequest != null && webResourceResponse != null) {
                        linkedHashMap.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, String.valueOf(webResourceResponse.getStatusCode()));
                        linkedHashMap.put("url", String.valueOf(webResourceRequest.getUrl()));
                        linkedHashMap.put("method", webResourceRequest.getMethod());
                        linkedHashMap.put("reqHeaders", String.valueOf(a(webResourceRequest.getRequestHeaders())));
                        linkedHashMap.put("respHeaders", String.valueOf(webResourceResponse.getResponseHeaders()));
                        linkedHashMap.put("reasonPhrase", webResourceResponse.getReasonPhrase());
                        linkedHashMap.put("pageUrl", this.f60118a.C);
                    }
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f60118a.C).toString());
                    Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, linkedHashMap, this.f60118a.getContext());
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
                    linkedHashMap.put("pageUrl", this.f60118a.C);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f60118a.C).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, linkedHashMap, this.f60118a.getContext());
                int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                    return;
                }
                LangbridgeCell langbridgeCell = this.f60118a;
                langbridgeCell.z = true;
                NoNetView noNetView = langbridgeCell.q;
                if (noNetView != null) {
                    noNetView.setFailureCause(primaryError);
                }
                this.f60118a.c(url);
                LightappWebViewCenter.getInstance().startAutoChecker();
                this.f60118a.a(primaryError, sslError.getCertificate().toString(), sslError.getUrl());
                LogUtil.d("LangbridgeCell", "onReceivedSslError");
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, webResourceRequest)) == null) {
                if (this.f60118a.isActiveCell() && this.f60118a.f60058h) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(this.f60118a.q().getLangbridgeHash(), webResourceRequest.getUrl().toString());
                    this.f60118a.f60058h = false;
                }
                if (this.f60118a.isActiveCell()) {
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
                LogUtil.d("LangbridgeCell", "OriginalUrl : " + webView.getOriginalUrl());
                LogUtil.d("LangbridgeCell", "shouldOverrideUrlLoading url = " + str);
                if (str.startsWith("tel:")) {
                    try {
                        this.f60118a.a(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                    try {
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                        intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "")});
                        this.f60118a.a(intent);
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        GlobalUtils.toast(this.f60118a.j, "请先配置邮箱");
                    }
                } else if (!str.toLowerCase(Locale.CHINA).startsWith("http") && !str.toLowerCase(Locale.CHINA).startsWith("https") && !str.toLowerCase(Locale.CHINA).startsWith("file")) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 1);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent(null);
                        if (Build.VERSION.SDK_INT >= 15) {
                            parseUri.setSelector(null);
                        }
                        this.f60118a.a(parseUri);
                        return true;
                    } catch (Exception e4) {
                        com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", e4.getMessage());
                    }
                } else if (webView.getOriginalUrl() != null && !webView.getOriginalUrl().equals("about:blank") && i.a().a(this.f60118a.j).MW_ON && !i.a().a(this.f60118a.j).MW_USE_OLD && i.a().a(this.f60118a.j).MW_HOLDLINK_ON && i.a().a(this.f60118a.j).MW_MULTI_ON && this.f60118a.isActiveCell()) {
                    LangbridgePreloadCellCenter.getInstance(this.f60118a.getContext());
                    if (LangbridgePreloadCellCenter.needNewWebviewOpen(str)) {
                        this.f60118a.q().createLangbridgeCell(str, false, false, "");
                        DXMSdkSAUtils.onEventWithValues("#linkHoldPreloadPage", Arrays.asList(str));
                        return true;
                    }
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
                linkedHashMap.put("pageUrl", this.f60118a.C);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f60118a.C).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f60118a.getContext());
                if (-10 == i2) {
                    return;
                }
                LangbridgeCell langbridgeCell = this.f60118a;
                langbridgeCell.z = true;
                NoNetView noNetView = langbridgeCell.q;
                if (noNetView != null) {
                    noNetView.setFailureCause(i2);
                }
                this.f60118a.c(str2);
                LightappWebViewCenter.getInstance().startAutoChecker();
                this.f60118a.a(i2, str, str2);
                String[] strArr = new String[4];
                strArr[0] = i2 + "";
                strArr[1] = str2;
                if (this.f60118a.b() == null) {
                    str3 = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                } else {
                    str3 = this.f60118a.b().hashCode() + "";
                }
                strArr[2] = str3;
                strArr[3] = this.f60118a.f60053c.hashCode() + "";
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
                LogUtil.d("LangbridgeCell", "onReceivedError1.showErrorPage");
                super.onReceivedError(webView, i2, str, str2);
            }
        }
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class WebviewMenu extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MENU_ITEM_INDEX_CLOSE = 34;
        public static final int MENU_ITEM_INDEX_REFRESH = 33;
        public static final int MENU_ITEM_INDEX_SHARE = 32;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f60121a;

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
            this.f60121a = langbridgeCell;
            add(33, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (langbridgeCell.m.getBoolean("lang_showshare", false)) {
                add(32, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    /* loaded from: classes10.dex */
    public class a extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f60122a;

        /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeCell$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C1847a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f60127a;

            /* renamed from: b  reason: collision with root package name */
            public String f60128b;

            /* renamed from: c  reason: collision with root package name */
            public String f60129c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f60130d;

            public C1847a(a aVar) {
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
                this.f60130d = aVar;
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
            this.f60122a = langbridgeCell;
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        if (!jSONArray.isNull(i4)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i4);
                            if (jSONObject.has("title") && jSONObject.has("icon") && jSONObject.has("callback")) {
                                C1847a c1847a = new C1847a();
                                c1847a.f60127a = jSONObject.optString("title", null);
                                c1847a.f60128b = jSONObject.optString("icon", null);
                                c1847a.f60129c = jSONObject.optString("callback", null);
                                if (compile.matcher(c1847a.f60127a).matches() && !TextUtils.isEmpty(c1847a.f60128b) && !TextUtils.isEmpty(c1847a.f60129c)) {
                                    if (5 <= arrayList.size()) {
                                        break;
                                    }
                                    arrayList.add(c1847a);
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
                C1847a c1847a2 = (C1847a) arrayList.get(i5);
                add(i5 + 256, c1847a2.f60127a, c1847a2.f60128b);
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
                public final /* synthetic */ LangbridgeCell f60123a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f60124b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ArrayList f60125c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f60126d;

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
                    this.f60126d = this;
                    this.f60123a = langbridgeCell;
                    this.f60124b = size;
                    this.f60125c = arrayList;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                        int itemId = bdMenuItem.getItemId();
                        if (255 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f60126d.f60122a.B), this.f60126d.f60122a.s()));
                            if (this.f60126d.f60122a.isActiveCell()) {
                                this.f60126d.f60122a.q().setRnAuthResult(2, "实名认证取消");
                                this.f60126d.f60122a.q().closeWindow();
                            }
                        } else if (254 == itemId) {
                            DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f60126d.f60122a.B)));
                            LightAppWrapper.getInstance().callShare(this.f60126d.f60122a.getActivity(), new LightAppShareModel(this.f60126d.f60122a.l.getTitle(), this.f60126d.f60122a.l.getTitle(), this.f60126d.f60122a.l.getUrl(), null), null);
                        } else if (253 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f60126d.f60122a.B)));
                            if (this.f60126d.f60122a.isActiveCell()) {
                                LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f60126d.f60122a.getActivity(), this.f60126d.f60122a.B);
                            }
                            this.f60126d.f60122a.l.reload();
                            LangbridgeCell langbridgeCell2 = this.f60126d.f60122a;
                            langbridgeCell2.B = langbridgeCell2.l.getUrl();
                            this.f60126d.f60122a.z = false;
                        } else {
                            int i6 = itemId - 256;
                            if (i6 <= this.f60124b) {
                                this.f60126d.f60122a.executeJsFunction(((C1847a) this.f60125c.get(i6)).f60129c, "");
                            }
                        }
                    }
                }
            });
            layoutMenu();
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                LogUtil.i("LangbridgeCell", "onTouchEvent " + motionEvent.getAction());
                return true;
            }
            return invokeL.booleanValue;
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
        s = new FrameLayout.LayoutParams(-1, -1);
        R = Pattern.compile("^(https?://|file:///android_asset/).*");
    }

    public LangbridgeCell(Context context, LightappBrowserWebView lightappBrowserWebView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lightappBrowserWebView, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60057g = true;
        this.f60058h = false;
        this.m = new Bundle();
        this.o = false;
        this.p = false;
        this.z = false;
        this.M = null;
        this.N = -1;
        this.O = null;
        this.P = false;
        this.Q = false;
        this.U = -1;
        this.X = new LangbridgeBarParams();
        this.Y = null;
        this.j = DxmApplicationContextImpl.getApplicationContext(context);
        this.l = lightappBrowserWebView;
        this.T = str;
        if ("PRELOAD".equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append((toString() + System.currentTimeMillis()).hashCode());
            sb.append("");
            this.W = sb.toString();
            LogUtil.i("LangbridgeCell", "cellHashStamp form myself " + this.W);
        } else {
            this.W = str2;
            LogUtil.i("LangbridgeCell", "cellHashStamp form outer " + this.W);
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            a(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60109a;

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
                    this.f60109a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f60109a.l.setOnMyScrollChangeListener(new LightappWebView.a(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f60110a;

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
                                this.f60110a = this;
                            }

                            @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                            public void a(int i2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                    this.f60110a.f60109a.w.hideBubble(true);
                                    if (this.f60110a.f60109a.X.isFullScreen) {
                                        int height = this.f60110a.f60109a.w.getHeight();
                                        float f2 = (height - i2) / height;
                                        if (f2 > 0.0f) {
                                            if (this.f60110a.f60109a.X.fullScreenTitleColor != 0) {
                                                LangbridgeCell langbridgeCell = this.f60110a.f60109a;
                                                langbridgeCell.w.setFullScreenTextColor(langbridgeCell.X.fullScreenTitleColor);
                                            }
                                            float f3 = 1.0f - f2;
                                            int i3 = (int) (255.0f * f3);
                                            if (this.f60110a.f60109a.X.isHideTitle) {
                                                if (i3 >= 255) {
                                                    this.f60110a.f60109a.w.setTitleTextColorAlpha(i3);
                                                } else {
                                                    this.f60110a.f60109a.w.setTitleTextColorAlpha(0);
                                                }
                                            }
                                            if (this.f60110a.f60109a.X.isIconWhite) {
                                                this.f60110a.f60109a.w.setIconFlag(true);
                                            }
                                            if (this.f60110a.f60109a.X.fullScreenActionBarColor != -1) {
                                                LangbridgeCell langbridgeCell2 = this.f60110a.f60109a;
                                                langbridgeCell2.w.setTitlebgColor(LangbridgeCell.a(f3, langbridgeCell2.X.fullScreenActionBarColor, ResUtils.getColor(this.f60110a.f60109a.j, "wallet_extend_color_actionbar_bg")));
                                                return;
                                            }
                                            return;
                                        }
                                        if (this.f60110a.f60109a.X.isHideTitle) {
                                            this.f60110a.f60109a.w.setTitleTextColorAlpha(255);
                                        }
                                        if (this.f60110a.f60109a.X.isIconWhite) {
                                            this.f60110a.f60109a.w.setIconFlag(false);
                                        }
                                        LangbridgeCell langbridgeCell3 = this.f60110a.f60109a;
                                        langbridgeCell3.w.setTitlebgColor(ResUtils.getColor(langbridgeCell3.j, "wallet_extend_color_actionbar_bg"));
                                        this.f60110a.f60109a.w.resetFullScreenTextColor();
                                        return;
                                    }
                                    int height2 = this.f60110a.f60109a.w.getHeight();
                                    float f4 = (height2 - i2) / height2;
                                    if (f4 > 0.0f) {
                                        int i4 = (int) ((1.0f - f4) * 255.0f);
                                        if (this.f60110a.f60109a.X.isHideTitle) {
                                            if (i4 >= 255) {
                                                this.f60110a.f60109a.w.setTitleTextColorAlpha(i4);
                                            } else {
                                                this.f60110a.f60109a.w.setTitleTextColorAlpha(0);
                                            }
                                        }
                                    } else if (this.f60110a.f60109a.X.isHideTitle) {
                                        this.f60110a.f60109a.w.setTitleTextColorAlpha(255);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LogUtil.i("LangbridgeCell", "hideCustomView");
            if (this.r == null || getActivity() == null || this.H == null) {
                return;
            }
            c(true);
            ((FrameLayout) getActivity().getWindow().getDecorView()).removeView(this.G);
            this.G = null;
            this.r = null;
            this.H.onCustomViewHidden();
            getActivity().setRequestedOrientation(1);
            DXMSdkSAUtils.onEventWithValues("#webviewVedioNotFullScreen", Arrays.asList(this.B));
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            WebviewMenu webviewMenu = new WebviewMenu(this, p());
            this.u = webviewMenu;
            webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60069a;

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
                    this.f60069a = this;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                        switch (bdMenuItem.getItemId()) {
                            case 32:
                                DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f60069a.B)));
                                LightAppWrapper.getInstance().callShare(this.f60069a.getActivity(), new LightAppShareModel(this.f60069a.l.getTitle(), this.f60069a.l.getTitle(), this.f60069a.l.getUrl(), null), null);
                                return;
                            case 33:
                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f60069a.B)));
                                if (this.f60069a.isActiveCell()) {
                                    LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f60069a.getActivity(), this.f60069a.B);
                                }
                                this.f60069a.l.reload();
                                this.f60069a.z = false;
                                return;
                            case 34:
                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f60069a.B), this.f60069a.s()));
                                if (this.f60069a.isActiveCell()) {
                                    this.f60069a.q().setRnAuthResult(2, "实名认证取消");
                                    this.f60069a.q().closeWindow();
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
    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65575, this) == null) || "baiduapp".equals(BeanConstants.CHANNEL_ID) || this.w.setCloseButtonVisibility(0) == 0) {
            return;
        }
        this.w.setCloseOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeCell f60087a;

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
                this.f60087a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f60087a.B), this.f60087a.s()));
                    if (this.f60087a.isActiveCell()) {
                        GlobalUtils.hideKeyboard(this.f60087a.q().getControllerActivity());
                        this.f60087a.q().setRnAuthResult(2, "实名认证取消");
                        this.f60087a.q().closeWindow();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            NoNetView noNetView = this.q;
            if (noNetView != null) {
                noNetView.notifyUrlFinish();
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65577, this) == null) || (bdActionBar = this.w) == null) {
            return;
        }
        if (this.X.isHideTitle) {
            bdActionBar.setTitleTextColorAlpha(0);
        } else {
            bdActionBar.setTitleTextColorAlpha(255);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void checkClodDown(String str, List<String> list, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, str, list, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        LangbridgeSettings.ConsoleMsgBehaviour[] consoleMsgBehaviourArr = i.a().a(getContext()).MW_CONSOLE_MESSAGE_BEHAVAIOUR;
        for (int i2 = 0; consoleMsgBehaviourArr != null && i2 < consoleMsgBehaviourArr.length; i2++) {
            if (consoleMsgBehaviourArr[i2] != null && str.equals(consoleMsgBehaviourArr[i2].mConsoleString)) {
                String[] strArr = new String[2];
                strArr[0] = i.a().b(getContext()).MW_ON ? "1" : "0";
                strArr[1] = i.a().b(getContext()).MW_USE_OLD ? "1" : "0";
                ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
                arrayList.addAll(list);
                try {
                    int parseInt = !TextUtils.isEmpty(consoleMsgBehaviourArr[i2].mScore) ? Integer.parseInt(consoleMsgBehaviourArr[i2].mScore) : 0;
                    e a2 = e.a();
                    Context context = getContext();
                    if (parseInt < 0) {
                        parseInt = 0;
                    }
                    a2.a(context, parseInt, str2, arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    e.a().a(getContext(), 0, str2, arrayList);
                }
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            a(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60095a;

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
                    this.f60095a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f60095a.isActiveCell()) {
                        this.f60095a.q().closeTopWebview();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && isActiveCell()) {
            q().closeWindow();
        }
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void doNetworkTomography(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, map) == null) {
            com.baidu.wallet.lightapp.ability.b.b.a().a(str, new b.a(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public boolean f60096a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60097b;

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
                    this.f60097b = this;
                    this.f60096a = false;
                }

                @Override // com.baidu.wallet.lightapp.ability.b.b.a
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.f60096a) {
                        return;
                    }
                    WalletGlobalUtils.showLoadingDialog(this.f60097b.getActivity());
                    this.f60096a = true;
                }

                @Override // com.baidu.wallet.lightapp.ability.b.b.a
                public void a(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (!jSONObject.optBoolean("isOnline", true)) {
                                GlobalUtils.toast(this.f60097b.getContext(), ResUtils.getString(this.f60097b.getActivity(), "network_no_connected"));
                            } else if (!jSONObject.optBoolean("isInternetConnected", true)) {
                                GlobalUtils.toast(this.f60097b.getContext(), ResUtils.getString(this.f60097b.getActivity(), "network_no_internet_connected"));
                            } else {
                                GlobalUtils.toast(this.f60097b.getContext(), ResUtils.getString(this.f60097b.getActivity(), "network_tomography_done"));
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
            }, getContext(), map);
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
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048596, this, str, str2, str3)) != null) {
            return (String) invokeLLL.objValue;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (!TextUtils.isEmpty(o()) && !o().equals("PRELOAD")) {
            stringBuffer.append(o() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        } else {
            stringBuffer.append(toString().hashCode() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        }
        if (!this.B.isEmpty()) {
            try {
                url = new URL(this.B);
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
            if (h.a(str)) {
                return null;
            }
            return h.a().a(str, new String[]{str2, str3, stringBuffer.toString()});
        }
        url = null;
        if (url != null) {
        }
        if (h.a(str)) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void executeJsFunction(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) && this.l != null && !TextUtils.isEmpty(str)) {
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

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (q() != null) {
                return q().getControllerActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getCellHashStamps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.j : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? JsonUtils.toJson(this.F) : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            a(new Runnable(this, i2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f60085a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60086b;

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
                    this.f60086b = this;
                    this.f60085a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f60086b.isActiveCell()) {
                        this.f60086b.q().historyGo(this.f60085a);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            WeakReference<d> weakReference = this.f60052b;
            return (weakReference == null || weakReference.get() == null || this.f60052b.get().getControllerActivity() == null || !this.f60052b.get().isActiveCell(this)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isPreloaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public LangbridgeBarParams l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.X : (LangbridgeBarParams) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || getActivity() == null) {
            return;
        }
        this.S = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.f60054d, str);
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.OPENABLE");
        if (Build.VERSION.SDK_INT < 19) {
            intent.setAction("android.intent.action.GET_CONTENT");
        } else {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
        }
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        try {
            getActivity().startActivityForResult(Intent.createChooser(intent, "选择图片"), 5);
        } catch (ActivityNotFoundException e2) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL, Arrays.asList(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO));
            e2.printStackTrace();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            n();
            a(this.l);
            this.f60054d = (LightappBusinessClient) this.f60053c.getLightappBusiness();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            View inflate = LayoutInflater.from(this.j).inflate(ResUtils.layout(this.j, "wallet_langbrige_cell"), (ViewGroup) null);
            this.f60059i = inflate;
            LangbridgeSlideLayout langbridgeSlideLayout = (LangbridgeSlideLayout) inflate.findViewById(ResUtils.id(this.j, "bd_langbridge_slide"));
            this.k = langbridgeSlideLayout;
            langbridgeSlideLayout.setTarget(this.l);
            this.K = (FrameLayout) this.f60059i.findViewById(ResUtils.id(this.j, "bd_ab_container"));
            this.L = (FrameLayout) this.f60059i.findViewById(ResUtils.id(this.j, "bd_trans_container"));
            this.I = (FrameLayout) this.f60059i.findViewById(ResUtils.id(this.j, "progress_line_container"));
            this.J = (FrameLayout) this.f60059i.findViewById(ResUtils.id(this.j, "progress_trans_container"));
            View view = new View(this.j);
            this.t = view;
            view.setVisibility(8);
            this.w = b(this.m.getBoolean("lang_longtitle", true));
            this.q = (NoNetView) this.f60059i.findViewById(ResUtils.id(this.j, "nonet_view"));
            a(false);
            w();
            b("");
            this.x = (LinearLayout) this.f60059i.findViewById(ResUtils.id(this.j, "walelt_app_host_background"));
            this.y = (TextView) this.f60059i.findViewById(ResUtils.id(this.j, "walelt_base_light_app_host"));
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            if (!NetworkUtils.isNetworkAvailable(this.j)) {
                GlobalUtils.toast(p(), ResUtils.getString(this.j, "ebpay_no_network"));
                return;
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.reload();
                this.z = false;
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, str2) == null) {
            a(new Runnable(this, str, str2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60114a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f60115b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60116c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60116c = this;
                    this.f60114a = str;
                    this.f60115b = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f60116c.isActiveCell()) {
                        String str3 = this.f60116c.B;
                        if (str3 != null && (!str3.equals(this.f60114a) || !this.f60116c.B.equals(this.f60115b))) {
                            if (!TextUtils.isEmpty(this.f60115b)) {
                                LangbridgeCacheManager.getInstance().handleLoadUrl(this.f60116c.q().getLangbridgeHash(), this.f60115b);
                            } else {
                                LangbridgeCacheManager.getInstance().handleLoadUrl(this.f60116c.q().getLangbridgeHash(), this.f60114a);
                            }
                            if (this.f60116c.q().createLangbridgeCell(this.f60114a, false, false, this.f60115b)) {
                                this.f60116c.x();
                                return;
                            }
                            return;
                        }
                        LightappBrowserWebView lightappBrowserWebView = this.f60116c.l;
                        if (lightappBrowserWebView != null) {
                            lightappBrowserWebView.reload();
                            this.f60116c.z = false;
                        }
                    }
                }
            });
        }
    }

    public Context p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? getActivity() != null ? getActivity() : getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            a(1101, str, this.B);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, arrayList, i2) == null) {
            a(new Runnable(this, i2, arrayList) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f60063a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ArrayList f60064b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60065c;

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
                    this.f60065c = this;
                    this.f60063a = i2;
                    this.f60064b = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f60065c.isActiveCell()) {
                        if (this.f60063a == -1) {
                            LangbridgePreloadCellCenter.getInstance(this.f60065c.getContext()).preload(this.f60064b, this.f60065c.q().getOwnerTag(), this.f60065c.q().getLangbridgeStamp());
                        } else {
                            LangbridgePreloadCellCenter.getInstance(this.f60065c.getContext()).preload(this.f60064b, this.f60063a, this.f60065c.q().getOwnerTag(), this.f60065c.q().getLangbridgeStamp());
                        }
                    }
                }
            });
        }
    }

    public d q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            WeakReference<d> weakReference = this.f60052b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (d) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? q() != null && q().isBottomCell(this) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void rmFromPreloadPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            LangbridgePreloadCellCenter.getInstance(this.j).removeCellByCell(this);
        }
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(q() != null ? Integer.valueOf(q().getLangbridgeStatus()) : "");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && isActiveCell()) {
            this.E = new ContactInfoPresenter(getActivity(), this.f60054d);
            ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str, str2})) == null) {
            a(new Runnable(this, z4, z3, z, str2, str, z2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f60102a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f60103b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f60104c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f60105d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f60106e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f60107f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60108g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z), str2, str, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60108g = this;
                    this.f60102a = z4;
                    this.f60103b = z3;
                    this.f60104c = z;
                    this.f60105d = str2;
                    this.f60106e = str;
                    this.f60107f = z2;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        this.f60108g.X.isFullScreen = this.f60104c;
                        if (!TextUtils.isEmpty(this.f60105d)) {
                            try {
                                this.f60108g.X.fullScreenTitleColor = Color.parseColor(this.f60105d);
                            } catch (Throwable th) {
                                LogUtil.d("error", th.toString());
                                this.f60108g.X.fullScreenTitleColor = 0;
                            }
                        } else {
                            this.f60108g.X.fullScreenTitleColor = 0;
                        }
                        if (!TextUtils.isEmpty(this.f60106e)) {
                            try {
                                this.f60108g.X.fullScreenActionBarColor = Color.parseColor(this.f60106e);
                            } catch (Throwable unused) {
                                this.f60108g.X.fullScreenActionBarColor = -1;
                            }
                        } else {
                            this.f60108g.X.fullScreenActionBarColor = -1;
                        }
                        this.f60108g.X.isHideTitle = this.f60107f;
                        this.f60108g.X.isIconWhite = this.f60102a;
                        this.f60108g.X.isHideHost = this.f60103b;
                    }
                }

                private void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                        if (this.f60108g.X.fullScreenTitleColor != 0) {
                            LangbridgeCell langbridgeCell = this.f60108g;
                            langbridgeCell.w.setFullScreenTextColor(langbridgeCell.X.fullScreenTitleColor);
                            return;
                        }
                        this.f60108g.w.resetFullScreenTextColor();
                    }
                }

                private void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65539, this) == null) {
                        if (this.f60108g.X.fullScreenActionBarColor != -1) {
                            LangbridgeCell langbridgeCell = this.f60108g;
                            langbridgeCell.w.setTitlebgColor(langbridgeCell.X.fullScreenActionBarColor);
                            this.f60108g.w.setBottomSeperatorvisible(false);
                            LangbridgeCell langbridgeCell2 = this.f60108g;
                            langbridgeCell2.a(Color.alpha(langbridgeCell2.X.fullScreenActionBarColor) != 255);
                            return;
                        }
                        LangbridgeCell langbridgeCell3 = this.f60108g;
                        langbridgeCell3.w.setTitlebgColor(ResUtils.getColor(langbridgeCell3.j, "wallet_extend_color_actionbar_bg"));
                        this.f60108g.w.setBottomSeperatorvisible(true);
                        LangbridgeCell langbridgeCell4 = this.f60108g;
                        langbridgeCell4.a(Color.alpha(langbridgeCell4.X.fullScreenActionBarColor) != 255);
                    }
                }

                private void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                        if (this.f60108g.X.fullScreenActionBarColor != -1 && (this.f60108g.X.fullScreenActionBarColor | (-16777216)) != -1) {
                            LangbridgeCell langbridgeCell = this.f60108g;
                            langbridgeCell.x.setBackgroundColor(langbridgeCell.X.fullScreenActionBarColor);
                        } else {
                            LangbridgeCell langbridgeCell2 = this.f60108g;
                            langbridgeCell2.x.setBackgroundColor(ResUtils.getColor(langbridgeCell2.j, "wallet_base_background1_color_7f"));
                        }
                        if (this.f60108g.X.fullScreenTitleColor != 0) {
                            LangbridgeCell langbridgeCell3 = this.f60108g;
                            langbridgeCell3.y.setTextColor(langbridgeCell3.X.fullScreenTitleColor);
                            return;
                        }
                        LangbridgeCell langbridgeCell4 = this.f60108g;
                        langbridgeCell4.y.setTextColor(ResUtils.getColor(langbridgeCell4.j, "wallet_base_font_text4Color"));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a();
                        this.f60108g.w.setIconFlag(this.f60102a);
                        LangbridgeSlideLayout langbridgeSlideLayout = this.f60108g.k;
                        if (langbridgeSlideLayout != null) {
                            langbridgeSlideLayout.setSupportPullDown(!this.f60103b);
                        }
                        c();
                        b();
                        this.f60108g.z();
                        d();
                    }
                }
            });
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("actionBarHeight", DisplayUtils.px2dip(this.j, this.w.getActionBarHeight()));
                jSONObject.put("statusBarHeight", DisplayUtils.px2dip(this.j, this.w.getStatusBarHeight()));
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
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.Q = z;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, jSONArray) == null) {
            this.A = jSONArray;
            a(new Runnable(this, jSONArray) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONArray f60111a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60112b;

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
                    this.f60112b = this;
                    this.f60111a = jSONArray;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f60112b.w.getRightZoneView() == null) {
                        return;
                    }
                    LangbridgeCell langbridgeCell = this.f60112b;
                    LangbridgeCell langbridgeCell2 = this.f60112b;
                    langbridgeCell.v = new a(langbridgeCell2, langbridgeCell2.p(), this.f60111a);
                    this.f60112b.w.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.8.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass8 f60113a;

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
                            this.f60113a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                LangbridgeCell langbridgeCell3 = this.f60113a.f60112b;
                                a aVar = langbridgeCell3.v;
                                if (aVar != null) {
                                    aVar.show();
                                    return;
                                }
                                WebviewMenu webviewMenu = langbridgeCell3.u;
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
    public void setSubMenu(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048629, this, str, str2, str3, i2) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.w.getRightZone1View();
            NetImageView netImageView = (NetImageView) this.w.getRightImgZone1ImgView();
            a(new Runnable(this, i2, netImageView) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f60066a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NetImageView f60067b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60068c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), netImageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60068c = this;
                    this.f60066a = i2;
                    this.f60067b = netImageView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f60068c.w.setRightImgZone1Visibility(this.f60066a);
                        this.f60067b.setImageDrawable(null);
                        this.f60067b.setVisibility(this.f60066a);
                        if (this.f60066a == 4) {
                            this.f60068c.w.hideBubble(false);
                        }
                    }
                }
            });
            if (i2 == 4 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            netImageView.setEnabled(true);
            ImageLoader.getInstance(this.j).getBitmap(str, new ImageLoader.OnGetBitmapListener(this, str2, netImageView, relativeLayout, str3) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60070a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NetImageView f60071b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ RelativeLayout f60072c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f60073d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60074e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, netImageView, relativeLayout, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60074e = this;
                    this.f60070a = str2;
                    this.f60071b = netImageView;
                    this.f60072c = relativeLayout;
                    this.f60073d = str3;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public boolean needCancel(String str4, Object obj) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str4, obj)) == null) {
                        return false;
                    }
                    return invokeLL.booleanValue;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onError(String str4, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str4, obj) == null) {
                        LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "icon getFail error = " + str4);
                    }
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onGetBitmap(String str4, Object obj, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str4, obj, bitmap) == null) || bitmap == null || TextUtils.isEmpty(this.f60070a)) {
                        return;
                    }
                    LightappUtils.runOnUiThread(new Runnable(this, bitmap) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.13.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f60075a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass13 f60076b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bitmap};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f60076b = this;
                            this.f60075a = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (!this.f60076b.f60071b.isEnabled()) {
                                    LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "icon getSuccess caller，页面发生其它加载：" + this.f60076b.f60074e.B);
                                    return;
                                }
                                this.f60076b.f60074e.w.setRightImgZone1Visibility(0);
                                this.f60076b.f60074e.w.setRightImgZone1Enable(true);
                                this.f60076b.f60071b.setImageDrawable(new BitmapDrawable(this.f60075a));
                                if (this.f60076b.f60074e.X.isIconWhite && this.f60076b.f60074e.w.isIconWhite()) {
                                    this.f60076b.f60071b.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                                } else {
                                    this.f60076b.f60071b.clearColorFilter();
                                }
                                this.f60076b.f60071b.setVisibility(0);
                                if (this.f60076b.f60072c.getVisibility() == 0) {
                                    AnonymousClass13 anonymousClass13 = this.f60076b;
                                    anonymousClass13.f60074e.w.showBubble(anonymousClass13.f60073d, true);
                                }
                            }
                        }
                    });
                }
            }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            LightappUtils.runOnUiThread(new Runnable(this, str2) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60077a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60078b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60078b = this;
                    this.f60077a = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f60078b.w.setRightImgZone1OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.14.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f60079a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f60079a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "执行js");
                                    this.f60079a.f60078b.w.hideBubble(true);
                                    AnonymousClass14 anonymousClass14 = this.f60079a;
                                    anonymousClass14.f60078b.executeJsFunction(anonymousClass14.f60077a, null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048630, this, str, str2, z) == null) {
            a(new Runnable(this, str, str2, z) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60098a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f60099b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f60100c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60101d;

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
                    this.f60101d = this;
                    this.f60098a = str;
                    this.f60099b = str2;
                    this.f60100c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LangbridgeCell langbridgeCell = this.f60101d;
                        if (langbridgeCell.w != null) {
                            String str4 = "";
                            if (!NetworkUtils.isNetworkConnected(langbridgeCell.j)) {
                                this.f60101d.w.setTitleCenterSafeTipText("");
                            } else {
                                if (TextUtils.isEmpty(this.f60098a)) {
                                    if (!TextUtils.isEmpty(this.f60101d.l.getTitle()) && !LangbridgeCell.R.matcher(this.f60101d.l.getTitle()).matches()) {
                                        str3 = this.f60101d.l.getTitle();
                                        LangbridgeCell langbridgeCell2 = this.f60101d;
                                        langbridgeCell2.f60051a = langbridgeCell2.l.getTitle();
                                    } else {
                                        this.f60101d.f60051a = null;
                                        str3 = "";
                                    }
                                    LogUtil.d("mWebView.getTitle =", this.f60101d.l.getTitle());
                                    this.f60101d.w.setTitleCenterSafeTipText("");
                                } else {
                                    str3 = this.f60098a;
                                    this.f60101d.f60051a = str3;
                                    if (!TextUtils.isEmpty(this.f60099b)) {
                                        String trim = this.f60099b.trim();
                                        if (!TextUtils.isEmpty(trim)) {
                                            this.f60101d.w.setTitleCenterSafeTipText(trim);
                                        }
                                    } else {
                                        this.f60101d.w.setTitleCenterSafeTipText("");
                                    }
                                }
                                str4 = str3;
                            }
                            this.f60101d.d(str4);
                            int[] titleSizeRange = this.f60101d.w.getTitleSizeRange();
                            int i2 = titleSizeRange[0];
                            int i3 = titleSizeRange[1];
                            if (this.f60100c) {
                                int mainTitleViewWidth = this.f60101d.w.getMainTitleViewWidth();
                                float f2 = i2;
                                float stringWidth = StringUtil.getStringWidth(this.f60101d.w.getTitle(), f2);
                                this.f60101d.w.setTitleEllipsize(TextUtils.TruncateAt.END);
                                float f3 = mainTitleViewWidth;
                                if (stringWidth <= f3) {
                                    this.f60101d.w.setTitleSize(i2);
                                    return;
                                }
                                float f4 = f3 / stringWidth;
                                if (1.0f > f4 && i3 / f2 <= f4) {
                                    this.f60101d.w.setTitleSize(Math.round(f2 * f4));
                                    return;
                                }
                                this.f60101d.w.setTitleSize(i3);
                                return;
                            }
                            this.f60101d.w.setTitleSize(i2);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void startNewLightApp(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LangbridgeActivity.startLangbridge(context, str, str2, z, z2);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.t.setVisibility(0);
            this.t.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_blue"));
            a(5);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.t.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_transparent"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            LogUtil.d("LangbridgeCell", "handleBackPressed ");
            if (this.r == null && this.G == null) {
                LightappBusinessClient lightappBusinessClient = this.f60054d;
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
                this.B = this.l.getUrl();
                return true;
            }
            B();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.p = false;
            if (!r()) {
                x();
            }
            String str = i.a().a(getContext()).MW_JSCALL_ONACTIVE;
            if (!TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(str)) {
                executeJsFunction(str, null);
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null && !TextUtils.isEmpty(lightappBrowserWebView.getUrl())) {
                WhiteScreenMonitor.a().a(this.l, WhiteScreenMonitor.PageStates.ACTIVE);
            }
            BdActionBar bdActionBar = this.w;
            if (bdActionBar != null) {
                bdActionBar.setTopStatusWhite(bdActionBar.isIconWhite());
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            String str = i.a().a(getContext()).MW_JSCALL_ONNEGATIVE;
            if (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(str)) {
                return;
            }
            executeJsFunction(str, null);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.z = false;
            this.f60058h = true;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.Q) {
                this.f60054d.checkPermission();
                this.Q = false;
            }
            if (this.F == null || TextUtils.isEmpty(this.B)) {
                return;
            }
            this.F.add(new LoadTimeLine(this.B.trim(), "onResume", String.valueOf(System.currentTimeMillis())));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.F != null && !TextUtils.isEmpty(this.B)) {
                this.F.add(new LoadTimeLine(this.B.trim(), MissionEvent.MESSAGE_PAUSE, String.valueOf(System.currentTimeMillis())));
            }
            this.U = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.B, this.U);
            LightappUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60092a;

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
                    this.f60092a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    BdActionBar bdActionBar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (bdActionBar = this.f60092a.w) == null) {
                        return;
                    }
                    bdActionBar.hideBubble(true);
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LightappJsClient lightappJsClient = this.f60053c;
            if (lightappJsClient != null) {
                lightappJsClient.destroy();
            }
            if (this.r != null || this.G != null) {
                this.G = null;
                this.r = null;
                this.H.onCustomViewHidden();
                this.H = null;
            }
            if (this.l != null) {
                WeakReference<d> weakReference = this.f60052b;
                if (weakReference != null && weakReference.get() != null && this.f60052b.get().getControllerActivity() != null) {
                    LightappWebViewCenter.getInstance().releaseLightappWebView2Pool(this.f60052b.get().getControllerActivity(), this.l);
                } else {
                    LightappWebViewCenter.getInstance().releaseLightappWebView2Pool(null, this.l);
                }
                this.k.setTarget(null);
            }
            this.p = false;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60093a;

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
                    this.f60093a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f60093a.i();
                    }
                }
            }, ResUtils.getInteger(getContext(), "wallet_langbridge_slide_duration"));
        }
    }

    private BdActionBar b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65557, this, z)) == null) {
            if (z) {
                return new BdLightAppActionBar(p());
            }
            return new BdActionBar(p());
        }
        return (BdActionBar) invokeZ.objValue;
    }

    private void e(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, str) == null) {
            String[] b2 = com.baidu.wallet.lightapp.business.a.b(str);
            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "CELL add Js Hook groupName = " + str + "\n filesName=" + Arrays.toString(b2));
            if (b2 == null || b2.length <= 0) {
                return;
            }
            for (String str2 : b2) {
                if (!TextUtils.isEmpty(str2)) {
                    String a2 = com.baidu.wallet.lightapp.business.a.a(str2);
                    LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "CELL to Add COMMON JSFile = " + a2);
                    if (!TextUtils.isEmpty(a2) && (lightappBrowserWebView = this.l) != null) {
                        lightappBrowserWebView.addJsCode(str2, a2);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class CustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LangbridgeCell f60117a;

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
            this.f60117a = langbridgeCell;
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtil.i("LangbridgeCell", "getVideoLoadingProgressView");
                FrameLayout frameLayout = new FrameLayout(this.f60117a.getActivity());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return frameLayout;
            }
            return (View) invokeV.objValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consoleMessage)) == null) {
                if (consoleMessage == null) {
                    return super.onConsoleMessage(consoleMessage);
                }
                ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
                if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                    String sourceId = consoleMessage.sourceId();
                    sourceId = (TextUtils.equals(sourceId, this.f60117a.C) || TextUtils.isEmpty(sourceId)) ? "" : "";
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("level", messageLevel.name());
                    linkedHashMap.put("message", consoleMessage.message());
                    linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                    linkedHashMap.put("sourceId", sourceId);
                    linkedHashMap.put("pageUrl", this.f60117a.C);
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f60117a.C).toString());
                    if (!TextUtils.isEmpty(consoleMessage.message()) && consoleMessage.message().contains(LightappJsClient.LIGHTAPP_JS_NAME)) {
                        linkedHashMap.put("owner", this.f60117a.o());
                        if (this.f60117a.b() != null && this.f60117a.b().getJsBridge() != null) {
                            linkedHashMap.put(AlbumActivityConfig.FROM_WEB_VIEW, this.f60117a.b().hashCode() + "");
                            if (this.f60117a.f60053c == null) {
                                str = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                            } else {
                                str = this.f60117a.f60053c.hashCode() + "";
                            }
                            linkedHashMap.put("jsclient", str);
                        }
                    }
                    LogUtil.i("LangbridgeCell", "console message:" + consoleMessage.message());
                    LangbridgeCell langbridgeCell = this.f60117a;
                    String message = consoleMessage.message();
                    String[] strArr = new String[3];
                    strArr[0] = this.f60117a.C;
                    strArr[1] = messageLevel.name();
                    strArr[2] = this.f60117a.p ? "1" : "0";
                    langbridgeCell.checkClodDown(message, Arrays.asList(strArr), "webview_console");
                    Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, linkedHashMap, this.f60117a.getContext());
                }
                return super.onConsoleMessage(consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, callback) == null) {
                callback.invoke(str, true, false);
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogUtil.i("LangbridgeCell", "onHideCustomView");
                this.f60117a.B();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                LogUtil.d("LangbridgeCell", "onProgressChanged:newProgress   " + i2);
                this.f60117a.a(i2);
                if (i2 == 100) {
                    this.f60117a.u();
                    if (this.f60117a.z) {
                        return;
                    }
                    LogUtil.d("LangbridgeCell", "onProgressChanged.hideErrorPage");
                    this.f60117a.y();
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (this.f60117a.w != null) {
                    String str2 = "";
                    if (!TextUtils.isEmpty("") && !NetworkUtils.isNetworkConnected(this.f60117a.j)) {
                        this.f60117a.w.setTitleCenterSafeTipText("");
                    } else {
                        LangbridgeCell langbridgeCell = this.f60117a;
                        String str3 = langbridgeCell.f60051a;
                        if (str3 != null) {
                            str2 = str3;
                        } else if (!TextUtils.isEmpty(langbridgeCell.m.getString("lang_customtitle"))) {
                            str2 = this.f60117a.m.getString("lang_customtitle");
                        } else if (TextUtils.isEmpty(str) || LangbridgeCell.R.matcher(str).matches()) {
                            str2 = " ";
                        } else {
                            if (("http://" + str).equals(this.f60117a.B)) {
                                str = " ";
                            }
                            str2 = str;
                        }
                    }
                    this.f60117a.d(str2);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, view, customViewCallback) == null) {
                LogUtil.i("LangbridgeCell", "onShowCustomView");
                if (this.f60117a.getActivity() == null || !this.f60117a.isActiveCell()) {
                    return;
                }
                LangbridgeCell langbridgeCell = this.f60117a;
                if (langbridgeCell.r == null) {
                    this.f60117a.G = new b(this.f60117a.getActivity());
                    this.f60117a.G.addView(view, LangbridgeCell.s);
                    ((FrameLayout) langbridgeCell.getActivity().getWindow().getDecorView()).addView(this.f60117a.G, LangbridgeCell.s);
                    LangbridgeCell langbridgeCell2 = this.f60117a;
                    langbridgeCell2.r = view;
                    langbridgeCell2.c(false);
                    LogUtil.i("LangbridgeCell", "fullscreen");
                    this.f60117a.H = customViewCallback;
                    this.f60117a.getActivity().setRequestedOrientation(0);
                    DXMSdkSAUtils.onEventWithValues("#webviewVedioFullScreen", Arrays.asList(this.f60117a.B));
                    return;
                }
                customViewCallback.onCustomViewHidden();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            String[] acceptTypes;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, valueCallback, fileChooserParams)) == null) {
                this.f60117a.f60056f = valueCallback;
                if (webView != null && !TextUtils.isEmpty(webView.getUrl())) {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_INPUT_FILE, Arrays.asList(webView.getUrl()));
                }
                if (fileChooserParams != null && (acceptTypes = fileChooserParams.getAcceptTypes()) != null && acceptTypes.length > 0 && !TextUtils.isEmpty(acceptTypes[0])) {
                    this.f60117a.a(acceptTypes[0], fileChooserParams.isCaptureEnabled(), 2);
                }
                return true;
            }
            return invokeLLL.booleanValue;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, valueCallback) == null) {
                this.f60117a.f60055e = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                try {
                    this.f60117a.a(Intent.createChooser(intent, "File Chooser"), 1);
                } catch (ActivityNotFoundException unused) {
                    DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, valueCallback, str) == null) {
                this.f60117a.f60055e = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(str);
                try {
                    this.f60117a.a(Intent.createChooser(intent, "File Browser"), 1);
                } catch (ActivityNotFoundException unused) {
                    DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, valueCallback, str, str2) == null) {
                this.f60117a.f60055e = valueCallback;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f60117a.a(str, !TextUtils.isEmpty(str2), 1);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, this, str) == null) || this.w == null) {
            return;
        }
        if (!this.m.getBoolean("lang_showtitle", true)) {
            this.w.setVisibility(8);
        }
        d("");
        this.w.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeCell f60083a;

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
                this.f60083a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f60083a.isActiveCell()) {
                    GlobalUtils.hideKeyboard(this.f60083a.q().getControllerActivity());
                    this.f60083a.q().backPressed();
                }
            }
        });
        if (this.u == null) {
            return;
        }
        this.w.setRightImgZone2Visibility(0);
        this.w.setRightImgZone2Enable(true);
        this.w.setRightImgZone2Src(ResUtils.drawable(this.j, "wallet_langbridge_actionbar_more"), ResUtils.getString(this.j, "wallet_base_bdaction_more"));
        this.w.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LangbridgeCell f60084a;

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
                this.f60084a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f60084a.u.show();
                }
            }
        });
        this.w.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
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
            if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
                userAgentString = userAgentString + " " + BussinessUtils.getUA(p());
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
            this.f60053c = lightappJsClient;
            lightappWebView.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
            DXMSdkSAUtils.onEventWithValues("#injectJavaObject", Arrays.asList(o(), this.f60053c.hashCode() + "", lightappWebView.hashCode() + ""));
            LangbridgeSettings a2 = i.a().a(this.j);
            if (a2.MW_ON && a2.MW_INJECTJS_FOR_HS) {
                lightappWebView.addJsCode(LangbridgeSettings.MW_JSHOOK_HISTORY_NAME, i.a().a(LangbridgeSettings.MW_JSHOOK_HISTORY_NAME, a2.MW_JSHOOK_HISTORY));
            }
            if (a2.MW_ON && a2.MW_INJECTJS_FOR_SS) {
                lightappWebView.addJsCode(LangbridgeSettings.MW_JSHOOK_SESSION_NAME, i.a().a(LangbridgeSettings.MW_JSHOOK_SESSION_NAME, a2.MW_JSHOOK_SESSION));
            }
            e("common");
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(lightappWebView, true);
            }
            lightappWebView.setWebViewClient(new CustomWebViewClient(this));
            lightappWebView.setWebChromeClient(new CustomChromeClient(this));
            lightappWebView.setDownloadListener(new DownloadListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public Pattern f60060a;

                /* renamed from: b  reason: collision with root package name */
                public Matcher f60061b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60062c;

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
                    this.f60062c = this;
                    Pattern compile = Pattern.compile(".*");
                    this.f60060a = compile;
                    this.f60061b = compile.matcher("");
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        if (this.f60062c.V == null) {
                            this.f60062c.V = new LinkedList();
                        }
                        this.f60062c.V.add(str);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            this.f60062c.a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (Exception e2) {
                            LogUtil.e("LangbridgeCell", "Download Error", e2);
                            GlobalUtils.toast(this.f60062c.j, "下载出现异常");
                        }
                    }
                }
            });
            this.F = new Vector<>();
            if (TextUtils.isEmpty(this.B)) {
                return;
            }
            this.F.add(new LoadTimeLine(this.B.trim(), "onCreate", String.valueOf(System.currentTimeMillis())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, this, str) == null) && this.m.getBoolean("lang_showerror", true)) {
            NoNetView noNetView = this.q;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65565, this, str) == null) || this.w == null) {
            return;
        }
        z();
        this.w.setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65563, this, z) == null) {
            getActivity().getWindow().setFlags(z ? 0 : 1024, 1024);
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
        this.f60057g = true;
        this.f60058h = false;
        this.m = new Bundle();
        this.o = false;
        this.p = false;
        this.z = false;
        this.M = null;
        this.N = -1;
        this.O = null;
        this.P = false;
        this.Q = false;
        this.U = -1;
        this.X = new LangbridgeBarParams();
        this.Y = null;
        this.j = DxmApplicationContextImpl.getApplicationContext(dVar.getControllerActivity());
        this.l = lightappBrowserWebView;
        this.T = str;
        if (bundle != null) {
            this.m = bundle;
            LangbridgeBarParams langbridgeBarParams = (LangbridgeBarParams) bundle.get("lang_prebarparams");
            if (langbridgeBarParams != null) {
                this.Y = langbridgeBarParams;
            }
        }
        a(dVar);
        this.W = dVar.getLangbridgeStamp();
        LogUtil.i("LangbridgeCell", "cellHashStamp form Controller " + this.W);
        m();
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(String str, com.baidu.wallet.lightapp.multipage.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, bVar, z) == null) {
            this.B = str;
            this.n = bVar;
            this.o = false;
            a(new Runnable(this, z, bVar, str) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f60088a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.baidu.wallet.lightapp.multipage.b f60089b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f60090c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LangbridgeCell f60091d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), bVar, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60091d = this;
                    this.f60088a = z;
                    this.f60089b = bVar;
                    this.f60090c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (!LangbridgeCell.R.matcher(this.f60091d.B).matches()) {
                                LangbridgeCell langbridgeCell = this.f60091d;
                                langbridgeCell.B = "https://" + this.f60091d.B;
                            }
                            this.f60091d.p = this.f60088a;
                            this.f60091d.l.loadUrl(this.f60091d.B.trim());
                            this.f60091d.z = false;
                        } catch (Exception e2) {
                            LogUtil.d("Url error");
                            this.f60091d.p = false;
                            com.baidu.wallet.lightapp.multipage.b bVar2 = this.f60089b;
                            if (bVar2 != null) {
                                bVar2.a(1102, e2.toString(), this.f60090c);
                            }
                            if (this.f60091d.isActiveCell()) {
                                this.f60091d.q().closeWindow();
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
            if ("PRELOAD".equals(o()) && !str.equals(o())) {
                h a2 = h.a();
                a2.a("transfer", new String[]{toString().hashCode() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, str + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
                a(str);
                dVar.setLangbridgeStamp(this.W);
            }
            if (bundle != null) {
                this.m = bundle;
                LangbridgeBarParams langbridgeBarParams = (LangbridgeBarParams) bundle.get("lang_prebarparams");
                if (langbridgeBarParams != null) {
                    this.Y = langbridgeBarParams;
                }
            }
            this.n = null;
            this.l.setBaseContext(getActivity());
            this.w.setTop(getActivity());
            this.w.setVisibility(this.m.getBoolean("lang_showtitle", true) ? 0 : 8);
            this.w.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
            w();
            JSONArray jSONArray = this.A;
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
        this.f60052b = new WeakReference<>(dVar);
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, strArr, iArr) == null) {
            this.f60053c.onRequestPermissionsResultLocal(i2, strArr, iArr);
            LightappBusinessClient lightappBusinessClient = this.f60054d;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.onRequestPermissionsResult(this.C, i2, strArr, iArr);
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
                        a(this.O, this.P, this.N);
                        this.O = "";
                        this.P = false;
                        this.N = -1;
                    }
                }
                z = false;
            } else if (iArr[0] == 0) {
                Intent intent = this.M;
                if (intent != null) {
                    a(intent, this.N);
                }
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.N == 1) {
                    ValueCallback<Uri> valueCallback = this.f60055e;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(null);
                        this.f60055e = null;
                    }
                    this.Z = null;
                } else if (i2 == 2) {
                    ValueCallback<Uri[]> valueCallback2 = this.f60056f;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(new Uri[0]);
                        this.f60056f = null;
                    }
                    this.Z = null;
                }
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public void a(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            this.M = null;
            this.N = -1;
            if (i2 == 4) {
                if (i3 == -1) {
                    if (intent == null || intent.getData() == null || (contactInfoPresenter = this.E) == null) {
                        return;
                    }
                    contactInfoPresenter.a(intent.getData());
                    return;
                }
                LightappBusinessClient lightappBusinessClient = this.f60054d;
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
                    this.S.a(intent, jSONObject);
                    return;
                }
                try {
                    jSONObject.put("errCode", LightappConstants.ERRCODE_CANCEL);
                    jSONObject.put("des", "用户取消选择");
                    this.f60054d.setAlubmPhotoData(1, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (i2 == 1) {
                if (this.f60055e == null) {
                    return;
                }
                Uri data = (intent == null || i3 != -1) ? null : intent.getData();
                if (data != null) {
                    this.f60055e.onReceiveValue(data);
                } else {
                    this.f60055e.onReceiveValue(this.Z);
                }
                this.f60055e = null;
                this.Z = null;
            } else if (i2 == 2) {
                if (this.f60056f == null) {
                    return;
                }
                Uri data2 = (intent == null || i3 != -1) ? null : intent.getData();
                if (data2 != null) {
                    this.f60056f.onReceiveValue(new Uri[]{data2});
                } else {
                    Uri uri = this.Z;
                    if (uri != null) {
                        this.f60056f.onReceiveValue(new Uri[]{uri});
                    } else {
                        this.f60056f.onReceiveValue(new Uri[0]);
                    }
                }
                this.f60056f = null;
                this.Z = null;
            } else if (i2 == 3) {
                if (i3 == -1) {
                    this.f60053c.onCallCameraPicCallbackLocal();
                }
            } else if (i2 != 4) {
                if (i2 == 6) {
                    this.f60053c.onInsertCalendarEventDone(i3 == -1);
                }
            } else if (i3 == -1) {
                if (intent != null && intent.getData() != null) {
                    List<String> loadRawPhone = ContactManager.getIContactsImpl().loadRawPhone(intent.getData(), this.j);
                    this.D = loadRawPhone;
                    if (loadRawPhone != null && loadRawPhone.size() > 1) {
                        if (this.D.size() == 2) {
                            String str = this.D.get(0);
                            String str2 = this.D.get(1);
                            if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                                str = "";
                            }
                            this.f60053c.onContactsSelectedLocal(0, new String[]{str, StringUtils.trimAll(str2)}, "");
                            return;
                        }
                        a(this.D, new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.24
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ LangbridgeCell f60094a;

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
                                this.f60094a = this;
                            }

                            @Override // android.widget.AdapterView.OnItemClickListener
                            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j)}) == null) || i4 <= 0 || i4 >= this.f60094a.D.size()) {
                                    return;
                                }
                                String replace = this.f60094a.D.get(i4).replace(" ", "").replace("-", "");
                                LangbridgeCell langbridgeCell = this.f60094a;
                                langbridgeCell.f60053c.onContactsSelectedLocal(0, new String[]{langbridgeCell.D.get(0), replace}, "");
                            }
                        });
                        return;
                    }
                }
                this.f60053c.onContactsSelectedLocal(1, null, ResUtils.getString(this.j, "wallet_base_select_phone_fail"));
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.c
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60059i : (View) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.T = str;
        }
    }

    public void a(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, intent, i2) == null) && isActiveCell()) {
            q().getControllerActivity().startActivityForResult(intent, i2);
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, intent) == null) && isActiveCell()) {
            q().getControllerActivity().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(this.j) * i2) / 100.0f);
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void a(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, onItemClickListener) == null) {
            SelectNumberDialog selectNumberDialog = new SelectNumberDialog(p());
            selectNumberDialog.setOnItemClickListener(onItemClickListener);
            selectNumberDialog.setData(list);
            selectNumberDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65548, this, i2, str, str2) == null) || this.n == null || this.o) {
            return;
        }
        if (i2 != 0) {
            this.o = true;
        }
        this.n.a(i2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
        if (r13.equals("image") != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, boolean z, int i2) {
        Intent intent;
        Intent intent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") && !PermissionManager.checkCallingPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                this.O = str;
                this.P = z;
                this.N = i2;
                BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LangbridgeCell f60080a;

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
                        this.f60080a = this;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                PermissionManager.checkCallingOrSelfPermission(this.f60080a.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 102);
                            } else {
                                this.f60080a.a(102, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, new int[]{-1, -1});
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
            getContext().getPackageManager();
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
                    if (str2.equals(MediaStreamTrack.AUDIO_TRACK_KIND)) {
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
                            File file2 = new File(file + File.separator + "IMG_" + System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
                            if ("iqiyi".equals(BeanConstants.CHANNEL_ID)) {
                                Context p = p();
                                this.Z = FileProvider.getUriForFile(p, p().getPackageName() + ".fileprovider", file2);
                            } else {
                                Activity activity = getActivity();
                                this.Z = FileProvider.getUriForFile(activity, p().getPackageName() + ".langbrigeProvider", file2);
                            }
                            p().grantUriPermission(p().getPackageName(), this.Z, 3);
                            intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent2.putExtra("output", this.Z);
                            if (!PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                                this.M = intent2;
                                this.N = i2;
                                BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.16
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ LangbridgeCell f60081a;

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
                                        this.f60081a = this;
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void isAllAgree(Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                            if (bool.booleanValue()) {
                                                PermissionManager.checkCallingOrSelfPermission(this.f60081a.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                            } else {
                                                this.f60081a.a(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
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
                            if ("iqiyi".equals(BeanConstants.CHANNEL_ID)) {
                                Context p2 = p();
                                this.Z = FileProvider.getUriForFile(p2, p().getPackageName() + ".fileprovider", file3);
                            } else {
                                Context p3 = p();
                                this.Z = FileProvider.getUriForFile(p3, p().getPackageName() + ".langbrigeProvider", file3);
                            }
                            p().grantUriPermission(p().getPackageName(), this.Z, 3);
                            intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
                            intent2.putExtra("output", this.Z);
                            if (!PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                                this.M = intent2;
                                this.N = i2;
                                BaiduWalletUtils.requestPermissionsDialog("", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeCell.17
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ LangbridgeCell f60082a;

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
                                        this.f60082a = this;
                                    }

                                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                                    public void isAllAgree(Boolean bool) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                            if (bool.booleanValue()) {
                                                PermissionManager.checkCallingOrSelfPermission(this.f60082a.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 101);
                                            } else {
                                                this.f60082a.a(101, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
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
            try {
                a(intent, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, runnable) == null) || runnable == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
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
            FrameLayout frameLayout = z ? this.K : this.L;
            FrameLayout frameLayout2 = z ? this.L : this.K;
            FrameLayout frameLayout3 = z ? this.I : this.J;
            FrameLayout frameLayout4 = z ? this.J : this.I;
            if (this.w == null || frameLayout2.getChildCount() != 0 || this.t == null || frameLayout4.getChildCount() != 0) {
                return;
            }
            frameLayout.removeAllViews();
            frameLayout3.removeAllViews();
            frameLayout2.addView(this.w);
            frameLayout4.addView(this.t, new ViewGroup.LayoutParams(DisplayUtils.dip2px(this.j, 10.0f), DisplayUtils.dip2px(this.j, 2.0f)));
        }
    }
}
