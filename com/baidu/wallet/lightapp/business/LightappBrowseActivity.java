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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.analytics.Tracker;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TITLE = "title";

    /* renamed from: f  reason: collision with root package name */
    public static int f25377f;
    public static final Pattern l;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public boolean C;
    public String D;
    public boolean E;
    public boolean F;
    public Handler G;
    public TextView H;
    public ContactInfoPresenter I;
    public com.baidu.wallet.lightapp.business.presenter.a J;
    public String K;
    public boolean L;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25378a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f25379b;

    /* renamed from: c  reason: collision with root package name */
    public int f25380c;

    /* renamed from: d  reason: collision with root package name */
    public int f25381d;

    /* renamed from: e  reason: collision with root package name */
    public int f25382e;

    /* renamed from: g  reason: collision with root package name */
    public LightappBusinessClient f25383g;

    /* renamed from: h  reason: collision with root package name */
    public int f25384h;

    /* renamed from: i  reason: collision with root package name */
    public Vector<Application.ActivityLifecycleCallbacks> f25385i;
    public String j;
    public String k;
    public boolean m;
    public Vector<LoadTimeLine> mLoadTimeLine;
    public boolean n;
    public boolean o;
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

    /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25397a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-161689260, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-161689260, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity$4;");
                    return;
                }
            }
            int[] iArr = new int[LifeCycleCbName.values().length];
            f25397a = iArr;
            try {
                iArr[LifeCycleCbName.OnCreated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25397a[LifeCycleCbName.OnStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25397a[LifeCycleCbName.OnResumed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25397a[LifeCycleCbName.OnPaused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25397a[LifeCycleCbName.OnStopped.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25397a[LifeCycleCbName.OnSaveInstanceState.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25397a[LifeCycleCbName.OnDestroyed.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CustomChromeClient extends LightappBaseActivity.BaseCustomChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f25414b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomChromeClient(LightappBrowseActivity lightappBrowseActivity) {
            super(lightappBrowseActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LightappBaseActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25414b = lightappBrowseActivity;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, consoleMessage)) == null) {
                if (consoleMessage == null) {
                    return super.onConsoleMessage(consoleMessage);
                }
                ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
                if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                    String sourceId = consoleMessage.sourceId();
                    sourceId = (TextUtils.equals(sourceId, this.f25414b.K) || TextUtils.isEmpty(sourceId)) ? "" : "";
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("level", messageLevel.name());
                    linkedHashMap.put("message", consoleMessage.message());
                    linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                    linkedHashMap.put("sourceId", sourceId);
                    linkedHashMap.put("pageUrl", this.f25414b.K);
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25414b.K).toString());
                    Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, linkedHashMap, this.f25414b);
                }
                return super.onConsoleMessage(consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                LogUtil.d("LightappBrowseActivity", "onProgressChanged:newProgress   " + i2);
                this.f25414b.a(i2);
                if (i2 == 100) {
                    this.f25414b.dismissLoadingProgress();
                    if (this.f25414b.f25378a) {
                        return;
                    }
                    LogUtil.d("LightappBrowseActivity", "onProgressChanged.hideErrorPage");
                    this.f25414b.c();
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (this.f25414b.r != null) {
                    if (TextUtils.isEmpty(this.f25414b.A) || NetworkUtils.isNetworkConnected(this.f25414b.getActivity())) {
                        if (this.f25414b.B != null) {
                            this.f25414b.r.setTitle(this.f25414b.B);
                            return;
                        } else if (!TextUtils.isEmpty(this.f25414b.j)) {
                            this.f25414b.r.setTitle(this.f25414b.j);
                            return;
                        } else if (TextUtils.isEmpty(str) || LightappBrowseActivity.l.matcher(str).matches()) {
                            this.f25414b.r.setTitle(" ");
                            return;
                        } else {
                            if (("http://" + str).equals(this.f25414b.k)) {
                                this.f25414b.r.setTitle(" ");
                                return;
                            } else {
                                this.f25414b.r.setTitle(str);
                                return;
                            }
                        }
                    }
                    this.f25414b.r.setTitle(this.f25414b.A);
                    this.f25414b.r.setTitleCenterSafeTipText("");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CustomWebViewClient extends LightappBaseActivity.BaseCustomWebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f25415b;

        /* renamed from: c  reason: collision with root package name */
        public Pattern f25416c;

        /* renamed from: d  reason: collision with root package name */
        public String f25417d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomWebViewClient(LightappBrowseActivity lightappBrowseActivity) {
            super(lightappBrowseActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LightappBaseActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25415b = lightappBrowseActivity;
            this.f25416c = Pattern.compile("\\s*https?://.*");
        }

        private boolean a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) ? TextUtils.equals(str, str2) : invokeLL.booleanValue;
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                Vector<LoadTimeLine> vector = this.f25415b.mLoadTimeLine;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
                }
                this.f25415b.dismissLoadingProgress();
                this.f25415b.f25384h = com.baidu.wallet.lightapp.base.a.a().a(this.f25415b.getActivity(), str, this.f25415b.f25384h);
                this.f25415b.k = str;
                String host = Uri.parse(str).getHost();
                this.f25417d = str;
                if (TextUtils.isEmpty(host)) {
                    this.f25415b.H.setVisibility(8);
                } else {
                    this.f25415b.H.setVisibility(0);
                    this.f25415b.H.setText(this.f25415b.getResources().getString(ResUtils.string(this.f25415b.getActivity(), "wallet_lightapp_url_outer"), host));
                }
                String title = this.f25415b.r.getTitle();
                if (title != null && title.equals(this.f25415b.A)) {
                    String title2 = webView.getTitle();
                    if (title2 == null || this.f25416c.matcher(title2).matches()) {
                        this.f25415b.r.setTitle((String) null);
                    } else {
                        this.f25415b.r.setTitle(title2);
                    }
                }
                if (webView.getProgress() != 100) {
                    this.f25415b.f25378a = true;
                }
                LogUtil.d("LightappBrowseActivity", "onPageFinished.finishedError:  " + this.f25415b.f25378a);
                super.onPageFinished(webView, str);
                com.baidu.wallet.lightapp.monitor.a.a().a((View) this.f25415b.mWebView, "FINISH", false);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f25415b.k), "" + LightappBrowseActivity.f25377f));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f25415b.k), "" + LightappBrowseActivity.f25377f));
                LangbridgeCacheManager.getInstance().handleFinishPage(str);
                LightappBrowserWebView lightappBrowserWebView = this.f25415b.mWebView;
                if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack() || this.f25415b.mNeedClearHistory || BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID) || this.f25415b.r.setCloseButtonVisibility(0) == 0) {
                    return;
                }
                this.f25415b.r.setCloseOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.CustomWebViewClient.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CustomWebViewClient f25418a;

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
                        this.f25418a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25418a.f25415b.k), "" + LightappBrowseActivity.f25377f));
                            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25418a.f25415b.k), "" + LightappBrowseActivity.f25377f));
                            GlobalUtils.hideKeyboard(this.f25418a.f25415b.getActivity());
                            if (this.f25418a.f25415b.f25382e == 12) {
                                this.f25418a.f25415b.a(2, "实名认证取消");
                            }
                            this.f25418a.f25415b.finish();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                Vector<LoadTimeLine> vector = this.f25415b.mLoadTimeLine;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
                }
                this.f25415b.K = str;
                if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                    this.f25415b.setFullScreenInMainThread(false, false, false, false, "", "");
                }
                if (LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                    this.f25415b.showLoadingProgress();
                }
                this.f25415b.r.setTitle(this.f25415b.A);
                this.f25415b.r.setTitleCenterSafeTipText("");
                this.f25415b.q = null;
                if (this.f25415b.f25383g != null) {
                    this.f25415b.f25383g.setH5BackCb(null);
                }
                this.f25415b.B = null;
                super.onPageStarted(webView, str, bitmap);
                com.baidu.wallet.lightapp.monitor.a.a().a((View) this.f25415b.mWebView, "START", true);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f25415b.k), "" + LightappBrowseActivity.f25377f));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f25415b.k), "" + LightappBrowseActivity.f25377f));
                LangbridgeCacheManager.getInstance().handleStartPage(str);
                boolean isOfflineCacheReady = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
                if (!NetworkUtils.isNetworkAvailable(this.f25415b.getActivity()) && !isOfflineCacheReady) {
                    this.f25415b.c(str);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(CheckUtils.stripUrlParams(str)));
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_WRC_SHOW_ERROR, CheckUtils.stripUrlParams(str));
                }
                if (a(str, this.f25417d)) {
                    return;
                }
                com.baidu.wallet.lightapp.base.c.a(this.f25415b.getActivity());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
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
                linkedHashMap.put("pageUrl", this.f25415b.K);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25415b.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f25415b);
                if (webResourceError == null || webResourceRequest == null || -10 == webResourceError.getErrorCode() || !webResourceRequest.isForMainFrame()) {
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = this.f25415b;
                lightappBrowseActivity.f25378a = true;
                if (lightappBrowseActivity.v != null) {
                    this.f25415b.v.setFailureCause(webResourceError.getErrorCode());
                }
                this.f25415b.c(webResourceRequest.getUrl().toString());
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(String.valueOf(webResourceError.getErrorCode()), String.valueOf(webResourceRequest.getUrl())));
                PayStatisticsUtil.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(String.valueOf(webResourceError.getErrorCode()), String.valueOf(webResourceRequest.getUrl())));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceResponse) == null) {
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
                        linkedHashMap.put("pageUrl", this.f25415b.K);
                    }
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25415b.K).toString());
                    Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, linkedHashMap, this.f25415b);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, sslErrorHandler, sslError) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (sslError != null) {
                    linkedHashMap.put("errorCode", String.valueOf(sslError.getPrimaryError()));
                    linkedHashMap.put("url", sslError.getUrl());
                    linkedHashMap.put("certificate", String.valueOf(sslError.getCertificate()));
                    linkedHashMap.put("pageUrl", this.f25415b.K);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25415b.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, linkedHashMap, this.f25415b);
                int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_ACTIVITY_SSL_ERROR, Arrays.asList(primaryError + "", url));
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = this.f25415b;
                lightappBrowseActivity.f25378a = true;
                if (lightappBrowseActivity.v != null) {
                    this.f25415b.v.setFailureCause(primaryError);
                }
                this.f25415b.c(url);
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, webResourceRequest)) == null) {
                if (this.f25415b.mNeedOverrideUrl) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(this.f25415b.mLangbridgeHash, webResourceRequest.getUrl().toString());
                    this.f25415b.mNeedOverrideUrl = false;
                }
                return LangbridgeCacheManager.getInstance().interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
            }
            return (WebResourceResponse) invokeLL.objValue;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
                if (this.f25415b.mNeedOverrideUrl) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(this.f25415b.mLangbridgeHash, str);
                    this.f25415b.mNeedOverrideUrl = false;
                }
                return LangbridgeCacheManager.getInstance().interceptRequest(str, null);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("errorCode", String.valueOf(i2));
                linkedHashMap.put("url", str2);
                linkedHashMap.put("reasonPhrase", str);
                linkedHashMap.put("pageUrl", this.f25415b.K);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f25415b.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f25415b);
                if (-10 == i2) {
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = this.f25415b;
                lightappBrowseActivity.f25378a = true;
                if (lightappBrowseActivity.v != null) {
                    this.f25415b.v.setFailureCause(i2);
                }
                this.f25415b.c(str2);
                super.onReceivedError(webView, i2, str, str2);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class LifeCycleCbName {
        public static final /* synthetic */ LifeCycleCbName[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LifeCycleCbName OnCreated;
        public static final LifeCycleCbName OnDestroyed;
        public static final LifeCycleCbName OnPaused;
        public static final LifeCycleCbName OnResumed;
        public static final LifeCycleCbName OnSaveInstanceState;
        public static final LifeCycleCbName OnStarted;
        public static final LifeCycleCbName OnStopped;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1897129100, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity$LifeCycleCbName;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1897129100, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity$LifeCycleCbName;");
                    return;
                }
            }
            OnCreated = new LifeCycleCbName("OnCreated", 0);
            OnStarted = new LifeCycleCbName("OnStarted", 1);
            OnResumed = new LifeCycleCbName("OnResumed", 2);
            OnPaused = new LifeCycleCbName("OnPaused", 3);
            OnStopped = new LifeCycleCbName("OnStopped", 4);
            OnSaveInstanceState = new LifeCycleCbName("OnSaveInstanceState", 5);
            LifeCycleCbName lifeCycleCbName = new LifeCycleCbName("OnDestroyed", 6);
            OnDestroyed = lifeCycleCbName;
            $VALUES = new LifeCycleCbName[]{OnCreated, OnStarted, OnResumed, OnPaused, OnStopped, OnSaveInstanceState, lifeCycleCbName};
        }

        public LifeCycleCbName(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LifeCycleCbName valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LifeCycleCbName) Enum.valueOf(LifeCycleCbName.class, str) : (LifeCycleCbName) invokeL.objValue;
        }

        public static LifeCycleCbName[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LifeCycleCbName[]) $VALUES.clone() : (LifeCycleCbName[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class WebviewMenu extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MENU_ITEM_INDEX_CLOSE = 34;
        public static final int MENU_ITEM_INDEX_REFRESH = 33;
        public static final int MENU_ITEM_INDEX_SHARE = 32;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f25419a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebviewMenu(LightappBrowseActivity lightappBrowseActivity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowseActivity, context};
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
            this.f25419a = lightappBrowseActivity;
            add(33, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (lightappBrowseActivity.m) {
                add(32, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    /* loaded from: classes5.dex */
    public class a extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f25420a;

        /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0268a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f25425a;

            /* renamed from: b  reason: collision with root package name */
            public String f25426b;

            /* renamed from: c  reason: collision with root package name */
            public String f25427c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f25428d;

            public C0268a(a aVar) {
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
                this.f25428d = aVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LightappBrowseActivity lightappBrowseActivity, Context context, JSONArray jSONArray) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowseActivity, context, jSONArray};
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
            this.f25420a = lightappBrowseActivity;
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        if (!jSONArray.isNull(i4)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i4);
                            if (jSONObject.has("title") && jSONObject.has("icon") && jSONObject.has("callback")) {
                                C0268a c0268a = new C0268a();
                                c0268a.f25425a = jSONObject.optString("title", null);
                                c0268a.f25426b = jSONObject.optString("icon", null);
                                c0268a.f25427c = jSONObject.optString("callback", null);
                                if (compile.matcher(c0268a.f25425a).matches() && !TextUtils.isEmpty(c0268a.f25426b) && !TextUtils.isEmpty(c0268a.f25427c)) {
                                    if (5 <= arrayList.size()) {
                                        break;
                                    }
                                    arrayList.add(c0268a);
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
                C0268a c0268a2 = (C0268a) arrayList.get(i5);
                add(i5 + 256, c0268a2.f25425a, c0268a2.f25426b);
            }
            add(GDiffPatcher.COPY_INT_USHORT, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (lightappBrowseActivity.m) {
                add(254, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(255, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this, lightappBrowseActivity, size, arrayList) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25421a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f25422b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ArrayList f25423c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f25424d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, lightappBrowseActivity, Integer.valueOf(size), arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i6 = newInitContext2.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f25424d = this;
                    this.f25421a = lightappBrowseActivity;
                    this.f25422b = size;
                    this.f25423c = arrayList;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                        int itemId = bdMenuItem.getItemId();
                        if (255 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25424d.f25420a.k), "" + LightappBrowseActivity.f25377f));
                            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25424d.f25420a.k), "" + LightappBrowseActivity.f25377f));
                            if (this.f25424d.f25420a.f25382e == 12) {
                                this.f25424d.f25420a.a(2, "实名认证取消");
                            }
                            this.f25424d.f25420a.finish();
                        } else if (254 == itemId) {
                            DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f25424d.f25420a.k)));
                            PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(this.f25424d.f25420a.k));
                            LightAppWrapper.getInstance().callShare(this.f25424d.f25420a.getActivity(), new LightAppShareModel(this.f25424d.f25420a.mWebView.getTitle(), this.f25424d.f25420a.mWebView.getTitle(), this.f25424d.f25420a.mWebView.getUrl(), null), null);
                        } else if (253 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f25424d.f25420a.k)));
                            PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(this.f25424d.f25420a.k));
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f25424d.f25420a.getActivity(), this.f25424d.f25420a.k);
                            this.f25424d.f25420a.mWebView.reload();
                            LightappBrowseActivity lightappBrowseActivity2 = this.f25424d.f25420a;
                            lightappBrowseActivity2.k = lightappBrowseActivity2.mWebView.getUrl();
                            this.f25424d.f25420a.f25378a = false;
                        } else {
                            int i6 = itemId - 256;
                            if (i6 <= this.f25422b) {
                                this.f25424d.f25420a.executeJsFunction(((C0268a) this.f25423c.get(i6)).f25427c, "");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(951786020, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(951786020, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity;");
                return;
            }
        }
        l = Pattern.compile("^(https?://|file:///android_asset/).*");
    }

    public LightappBrowseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25382e = 0;
        this.f25384h = -1;
        this.f25385i = new Vector<>();
        this.m = false;
        this.n = true;
        this.o = true;
        this.f25378a = false;
        this.C = false;
        this.D = "wallet_base_multi_window_close";
        this.E = false;
        this.F = false;
        this.G = null;
        this.L = false;
        this.f25380c = -1;
        this.f25381d = 0;
    }

    public static int getCurrentColor(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int red = Color.red(i2);
            int blue = Color.blue(i2);
            int green = Color.green(i2);
            int alpha = Color.alpha(i2);
            return Color.argb((int) (alpha + (f2 * (Color.alpha(i3) - alpha))), (int) (red + ((Color.red(i3) - red) * f2)), (int) (green + ((Color.green(i3) - green) * f2)), (int) (blue + ((Color.blue(i3) - blue) * f2)));
        }
        return invokeCommon.intValue;
    }

    public static Intent getStartIntent(Context context, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? a(context, str, null, z, z2) : (Intent) invokeCommon.objValue;
    }

    public static void startLightApp(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLightApp(context, str, str2, z, z2, null);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            finish();
        }
    }

    public void dismissLoadingProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String exeSSCommand(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, str3)) == null) {
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void executeJsFunction(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.mWebView != null && !TextUtils.isEmpty(str)) {
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:9:0x0010, B:11:0x001d, B:13:0x0021, B:15:0x002a, B:20:0x004d, B:22:0x0053, B:16:0x0035, B:18:0x0045, B:23:0x0056, B:25:0x0061, B:26:0x006b), top: B:32:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void executeJsFunctionBase64(String str, T t) {
        String encodeToString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, t) == null) && this.mWebView != null && !TextUtils.isEmpty(str)) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (com.baidu.wallet.lightapp.multipage.a) invokeV.objValue;
    }

    public String getCanceledMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "取消" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getContentLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "wallet_langbrige_webview" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getApplicationContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ResUtils.getString(getActivity(), "wallet_base_select_phone_fail") : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getLightappWebviewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "cust_webview" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? JsonUtils.toJson(this.mLoadTimeLine) : (String) invokeV.objValue;
    }

    public boolean getShowShareForIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getIntent().getBooleanExtra("shwoshare", false) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.J = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.f25383g, str);
            getActivity().startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 5);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean needKeyboardAdjust() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i2, i3, intent) == null) {
            if (i2 == 4) {
                if (i3 == -1) {
                    if (intent == null || intent.getData() == null || (contactInfoPresenter = this.I) == null) {
                        return;
                    }
                    contactInfoPresenter.a(intent.getData());
                    return;
                }
                LightappBusinessClient lightappBusinessClient = this.f25383g;
                if (lightappBusinessClient != null) {
                    lightappBusinessClient.onContactsSelected("", 1, null, getCanceledMsg(), "0");
                }
            } else if (i2 == 5) {
                LogUtil.d("LightappBrowseActivity", "onActivityResult resultCode = " + i3);
                JSONObject jSONObject = new JSONObject();
                if (i3 == -1) {
                    if (intent == null || intent.getData() == null) {
                        return;
                    }
                    this.J.a(intent, jSONObject);
                    return;
                }
                try {
                    jSONObject.put(RouterCallback.KEY_ERROR_CODE, 10005);
                    jSONObject.put("des", "用户取消选择");
                    this.f25383g.setAlubmPhotoData(1, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.J.a("#callNativePhoto Fail", "用户取消选择");
            } else {
                super.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f25377f));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f25377f));
            LightappBusinessClient lightappBusinessClient = this.f25383g;
            if ((lightappBusinessClient != null ? lightappBusinessClient.getH5BackCb() : null) != null) {
                executeJsFunction(LightappBusinessClient.MTD_H5GOBCK, null);
            } else {
                if (this.f25382e == 12 && !this.mWebView.canGoBack()) {
                    a(2, "实名认证取消");
                }
                super.onBackPressed();
            }
            LightappBrowserWebView lightappBrowserWebView = this.mWebView;
            if (lightappBrowserWebView != null) {
                this.k = lightappBrowserWebView.getUrl();
            }
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, str) == null) {
            this.G.post(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25396a;

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
                    this.f25396a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048598, this, i2, obj, str) == null) {
            this.G.post(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25395a;

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
                    this.f25395a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            int i2 = f25377f;
            if (i2 < 2) {
                f25377f = i2 + 1;
            }
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                try {
                    this.f25382e = extras.getInt(com.baidu.wallet.api.Constants.BDL_KEY_BIZTYPE, 0);
                    this.k = extras.getString("jump_url");
                    this.j = extras.getString("title");
                    this.mLangbridgeHash = extras.getLong("LANGBRIDGE_HASH", 0L);
                    if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                        a(activityLifecycleCallbacks);
                    }
                } catch (Exception unused) {
                }
            }
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_ON_CREATE, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f25377f));
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_ON_CREATE, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f25377f));
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
                this.mWebView.setWebViewClient(new CustomWebViewClient(this));
                this.mWebView.setWebChromeClient(new CustomChromeClient(this));
                this.mWebView.setDownloadListener(new DownloadListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public Pattern f25386a;

                    /* renamed from: b  reason: collision with root package name */
                    public Matcher f25387b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ LightappBrowseActivity f25388c;

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
                        this.f25388c = this;
                        Pattern compile = Pattern.compile(".*");
                        this.f25386a = compile;
                        this.f25387b = compile.matcher("");
                    }

                    @Override // android.webkit.DownloadListener
                    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    return;
                                }
                                this.f25388c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            } catch (Exception e2) {
                                LogUtil.e("LightappBrowseActivity", "Download Error", e2);
                                GlobalUtils.toast(this.f25388c.getActivity(), "下载出现异常");
                            }
                        }
                    }
                });
                com.baidu.wallet.lightapp.base.a.a().a(getActivity());
                this.A = "";
                this.z = ResUtils.getString(this, "ebpay_loading");
                this.v = (NoNetView) findViewById(ResUtils.id(getActivity(), "nonet_view"));
                this.w = findViewById(ResUtils.id(getActivity(), "progress_line"));
                this.r = a(getIntent().getExtras().getBoolean(com.baidu.wallet.api.Constants.LONG_TITLE));
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
                WebviewMenu webviewMenu = new WebviewMenu(this, getActivity());
                this.p = webviewMenu;
                webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LightappBrowseActivity f25398a;

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
                        this.f25398a = this;
                    }

                    @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                    public void onClick(BdMenuItem bdMenuItem) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                            switch (bdMenuItem.getItemId()) {
                                case 32:
                                    DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f25398a.k)));
                                    PayStatisticsUtil.onEventWithValue("#callShare", CheckUtils.stripUrlParams(this.f25398a.k));
                                    LightAppWrapper.getInstance().callShare(this.f25398a.getActivity(), new LightAppShareModel(this.f25398a.mWebView.getTitle(), this.f25398a.mWebView.getTitle(), this.f25398a.mWebView.getUrl(), null), null);
                                    return;
                                case 33:
                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f25398a.k)));
                                    PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, CheckUtils.stripUrlParams(this.f25398a.k));
                                    LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f25398a.getActivity(), this.f25398a.k);
                                    this.f25398a.mWebView.reload();
                                    this.f25398a.f25378a = false;
                                    return;
                                case 34:
                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25398a.k), "" + LightappBrowseActivity.f25377f));
                                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f25398a.k), "" + LightappBrowseActivity.f25377f));
                                    if (this.f25398a.f25382e == 12) {
                                        this.f25398a.a(2, "实名认证取消");
                                    }
                                    this.f25398a.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                this.f25383g = (LightappBusinessClient) this.mLightappJsClient.getLightappBusiness();
                b(this.A);
                this.f25379b = (LinearLayout) findViewById(ResUtils.id(getActivity(), "walelt_app_host_background"));
                this.H = (TextView) findViewById(ResUtils.id(getActivity(), "walelt_base_light_app_host"));
                try {
                    if (!l.matcher(this.k).matches()) {
                        this.k = "https://" + this.k;
                    }
                    this.mWebView.loadUrl(this.k.trim());
                    this.f25378a = false;
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
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    @Nullable
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (1000 == i2) {
                return new PromptDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.mLangbridgeHash);
            Handler handler = this.G;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            com.baidu.wallet.lightapp.monitor.a.a().b();
            this.f25383g = null;
            if (this.f25382e == 12) {
                LocalRouter.getInstance(getApplicationContext()).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), null);
            }
            a(LifeCycleCbName.OnDestroyed, (Bundle) null);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            this.f25384h = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.k, this.f25384h);
            if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
                this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), MissionEvent.MESSAGE_PAUSE, String.valueOf(System.currentTimeMillis())));
            }
            this.E = false;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i2, dialog) == null) {
            if (1000 == i2) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(ResUtils.string(getApplicationContext(), "bd_wallet_download_prompt"));
                promptDialog.setCanceledOnTouchOutside(true);
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LightappBrowseActivity f25394a;

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
                        this.f25394a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Activity activity;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (activity = this.f25394a.getActivity()) == null || activity.isFinishing()) {
                            return;
                        }
                        activity.removeDialog(1000);
                    }
                });
                promptDialog.hideNegativeButton();
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (!NetworkUtils.isNetworkAvailable(getApplicationContext())) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getApplicationContext(), "ebpay_no_network"));
                return;
            }
            LightappBrowserWebView lightappBrowserWebView = this.mWebView;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.reload();
                this.f25378a = false;
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048606, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            LightappBusinessClient lightappBusinessClient = this.f25383g;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.onRequestPermissionsResult(this.K, i2, strArr, iArr);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            if (this.L) {
                this.f25383g.checkPermission();
                this.L = false;
            }
            if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
                this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), MissionEvent.MESSAGE_RESUME, String.valueOf(System.currentTimeMillis())));
            }
            f();
            this.E = true;
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public void onWebViewBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f25378a = false;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048609, this, str, z) == null) {
            runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25392a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25393b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25393b = this;
                    this.f25392a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f25393b.mWebView.loadUrl(this.f25392a.trim());
                            this.f25393b.f25378a = false;
                        } catch (Exception unused) {
                            this.f25393b.finish();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, arrayList, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public void prepareSelectNumDialog(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, list, onItemClickListener) == null) {
            SelectNumberDialog selectNumberDialog = new SelectNumberDialog(getActivity());
            selectNumberDialog.setOnItemClickListener(onItemClickListener);
            selectNumberDialog.setData(list);
            selectNumberDialog.show();
        }
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, activityLifecycleCallbacks) == null) {
            this.f25385i.removeElement(activityLifecycleCallbacks);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.I = new ContactInfoPresenter(getActivity(), this.f25383g);
            ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
        }
    }

    public void setActionBarTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
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
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str, str2})) == null) {
            runOnUiThread(new Runnable(this, z4, z3, z, z2, str2, str) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f25405a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f25406b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f25407c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f25408d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f25409e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f25410f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25411g;

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
                    this.f25411g = this;
                    this.f25405a = z4;
                    this.f25406b = z3;
                    this.f25407c = z;
                    this.f25408d = z2;
                    this.f25409e = str2;
                    this.f25410f = str;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        if (this.f25407c) {
                            this.f25411g.mWebView.setOnMyScrollChangeListener(new LightappWebView.a(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f25412a;

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
                                    this.f25412a = this;
                                }

                                @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                                public void a(int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                        int height = this.f25412a.f25411g.r.getHeight();
                                        float f2 = (height - i2) / height;
                                        if (f2 > 0.0f) {
                                            LightappBrowseActivity lightappBrowseActivity = this.f25412a.f25411g;
                                            if (lightappBrowseActivity.f25381d != 0) {
                                                lightappBrowseActivity.r.setFullScreenTextColor(this.f25412a.f25411g.f25381d);
                                            }
                                            float f3 = 1.0f - f2;
                                            int i3 = (int) (255.0f * f3);
                                            AnonymousClass9 anonymousClass9 = this.f25412a;
                                            if (anonymousClass9.f25408d) {
                                                if (i3 >= 255) {
                                                    anonymousClass9.f25411g.r.setTitleTextColorAlpha(i3);
                                                } else {
                                                    anonymousClass9.f25411g.r.setTitleTextColorAlpha(0);
                                                }
                                            }
                                            AnonymousClass9 anonymousClass92 = this.f25412a;
                                            if (anonymousClass92.f25405a) {
                                                anonymousClass92.f25411g.r.setIconFlag(true);
                                            }
                                            LightappBrowseActivity lightappBrowseActivity2 = this.f25412a.f25411g;
                                            if (lightappBrowseActivity2.f25380c != -1) {
                                                BdActionBar bdActionBar = lightappBrowseActivity2.r;
                                                LightappBrowseActivity lightappBrowseActivity3 = this.f25412a.f25411g;
                                                bdActionBar.setTitlebgColor(LightappBrowseActivity.getCurrentColor(f3, lightappBrowseActivity3.f25380c, ResUtils.getColor(lightappBrowseActivity3.getActivity(), "wallet_extend_color_actionbar_bg")));
                                                return;
                                            }
                                            return;
                                        }
                                        AnonymousClass9 anonymousClass93 = this.f25412a;
                                        if (anonymousClass93.f25408d) {
                                            anonymousClass93.f25411g.r.setTitleTextColorAlpha(255);
                                        }
                                        AnonymousClass9 anonymousClass94 = this.f25412a;
                                        if (anonymousClass94.f25405a) {
                                            anonymousClass94.f25411g.r.setIconFlag(false);
                                        }
                                        this.f25412a.f25411g.r.setTitlebgColor(ResUtils.getColor(this.f25412a.f25411g.getActivity(), "wallet_extend_color_actionbar_bg"));
                                        this.f25412a.f25411g.r.resetFullScreenTextColor();
                                    }
                                }
                            });
                        } else {
                            this.f25411g.mWebView.setOnMyScrollChangeListener(new LightappWebView.a(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.9.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f25413a;

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
                                    this.f25413a = this;
                                }

                                @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                                public void a(int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                        int height = this.f25413a.f25411g.r.getHeight();
                                        float f2 = (height - i2) / height;
                                        if (f2 > 0.0f) {
                                            int i3 = (int) ((1.0f - f2) * 255.0f);
                                            AnonymousClass9 anonymousClass9 = this.f25413a;
                                            if (anonymousClass9.f25408d) {
                                                if (i3 >= 255) {
                                                    anonymousClass9.f25411g.r.setTitleTextColorAlpha(i3);
                                                    return;
                                                } else {
                                                    anonymousClass9.f25411g.r.setTitleTextColorAlpha(0);
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        AnonymousClass9 anonymousClass92 = this.f25413a;
                                        if (anonymousClass92.f25408d) {
                                            anonymousClass92.f25411g.r.setTitleTextColorAlpha(255);
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
                        if (this.f25408d) {
                            this.f25411g.r.setTitleTextColorAlpha(0);
                        } else {
                            this.f25411g.r.setTitleTextColorAlpha(255);
                        }
                    }
                }

                private void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65539, this) == null) {
                        if (!TextUtils.isEmpty(this.f25409e)) {
                            try {
                                this.f25411g.f25381d = Color.parseColor(this.f25409e);
                            } catch (Throwable unused) {
                            }
                        } else {
                            this.f25411g.f25381d = 0;
                        }
                        LightappBrowseActivity lightappBrowseActivity = this.f25411g;
                        if (lightappBrowseActivity.f25381d != 0) {
                            lightappBrowseActivity.r.setFullScreenTextColor(this.f25411g.f25381d);
                        } else {
                            lightappBrowseActivity.r.resetFullScreenTextColor();
                        }
                    }
                }

                private void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                        if (!TextUtils.isEmpty(this.f25410f)) {
                            try {
                                this.f25411g.f25380c = Color.parseColor(this.f25410f);
                            } catch (Throwable unused) {
                            }
                        } else {
                            this.f25411g.f25380c = -1;
                        }
                        LightappBrowseActivity lightappBrowseActivity = this.f25411g;
                        if (lightappBrowseActivity.f25380c != -1) {
                            lightappBrowseActivity.r.setTitlebgColor(this.f25411g.f25380c);
                            this.f25411g.r.setBottomSeperatorvisible(false);
                            LightappBrowseActivity lightappBrowseActivity2 = this.f25411g;
                            lightappBrowseActivity2.setActionBarTransparent(Color.alpha(lightappBrowseActivity2.f25380c) != 255);
                            return;
                        }
                        lightappBrowseActivity.r.setTitlebgColor(ResUtils.getColor(this.f25411g.getActivity(), "wallet_extend_color_actionbar_bg"));
                        this.f25411g.r.setBottomSeperatorvisible(true);
                        this.f25411g.setActionBarTransparent(false);
                    }
                }

                private void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                        LightappBrowseActivity lightappBrowseActivity = this.f25411g;
                        int i2 = lightappBrowseActivity.f25380c;
                        if (i2 != -1 && ((-16777216) | i2) != -1) {
                            lightappBrowseActivity.f25379b.setBackgroundColor(i2);
                        } else {
                            LightappBrowseActivity lightappBrowseActivity2 = this.f25411g;
                            lightappBrowseActivity2.f25379b.setBackgroundColor(ResUtils.getColor(lightappBrowseActivity2.getActivity(), "wallet_base_background1_color_7f"));
                        }
                        LightappBrowseActivity lightappBrowseActivity3 = this.f25411g;
                        if (lightappBrowseActivity3.f25381d != 0) {
                            lightappBrowseActivity3.H.setTextColor(this.f25411g.f25381d);
                        } else {
                            lightappBrowseActivity3.H.setTextColor(ResUtils.getColor(this.f25411g.getActivity(), "wallet_base_font_text4Color"));
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25411g.r.setIconFlag(this.f25405a);
                        if (this.f25411g.u != null) {
                            this.f25411g.u.setSupportPullDown(!this.f25406b);
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
                jSONObject.put("actionBarHeight", DisplayUtils.px2dip(getApplicationContext(), this.r.getActionBarHeight()));
                jSONObject.put("statusBarHeight", DisplayUtils.px2dip(getApplicationContext(), this.r.getStatusBarHeight()));
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
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.L = z;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setIsMultiWindowAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || z == this.F) {
            return;
        }
        this.F = z;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setIsShowMultiWindowTips(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || z == this.C) {
            return;
        }
        this.C = z;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, jSONArray) == null) {
            runOnUiThread(new Runnable(this, jSONArray) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONArray f25389a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25390b;

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
                    this.f25390b = this;
                    this.f25389a = jSONArray;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f25390b.r.getRightZoneView() == null) {
                        return;
                    }
                    LightappBrowseActivity lightappBrowseActivity = this.f25390b;
                    LightappBrowseActivity lightappBrowseActivity2 = this.f25390b;
                    lightappBrowseActivity.q = new a(lightappBrowseActivity2, lightappBrowseActivity2.getActivity(), this.f25389a);
                    this.f25390b.r.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.10.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass10 f25391a;

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
                            this.f25391a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                if (this.f25391a.f25390b.q != null) {
                                    this.f25391a.f25390b.q.show();
                                } else if (this.f25391a.f25390b.p != null) {
                                    this.f25391a.f25390b.p.show();
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setMultiWindowTipsId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.D = str;
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.setSupportZoom();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048623, this, str, str2, z) == null) {
            runOnUiThread(new Runnable(this, str, str2, z) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25401a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25402b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f25403c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f25404d;

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
                    this.f25404d = this;
                    this.f25401a = str;
                    this.f25402b = str2;
                    this.f25403c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f25404d.r == null) {
                        return;
                    }
                    if (!NetworkUtils.isNetworkConnected(this.f25404d.getActivity())) {
                        this.f25404d.r.setTitle(this.f25404d.A);
                        this.f25404d.r.setTitleCenterSafeTipText("");
                    } else if (TextUtils.isEmpty(this.f25401a)) {
                        this.f25404d.r.setTitle(this.f25404d.mWebView.getTitle());
                        this.f25404d.B = null;
                    } else {
                        String str3 = this.f25401a;
                        this.f25404d.r.setTitle(str3);
                        this.f25404d.B = str3;
                        if (TextUtils.isEmpty(this.f25402b)) {
                            this.f25404d.r.setTitleCenterSafeTipText("");
                        } else {
                            String trim = this.f25402b.trim();
                            if (!TextUtils.isEmpty(trim)) {
                                this.f25404d.r.setTitleCenterSafeTipText(trim);
                            }
                        }
                    }
                    if (this.f25403c) {
                        int[] titleSizeRange = this.f25404d.r.getTitleSizeRange();
                        int i2 = titleSizeRange[0];
                        int i3 = titleSizeRange[1];
                        int mainTitleViewWidth = this.f25404d.r.getMainTitleViewWidth();
                        float f2 = i2;
                        float stringWidth = StringUtil.getStringWidth(this.f25404d.r.getTitle(), f2);
                        this.f25404d.r.setTitleEllipsize(TextUtils.TruncateAt.END);
                        float f3 = mainTitleViewWidth;
                        if (stringWidth <= f3) {
                            this.f25404d.r.setTitleSize(i2);
                            return;
                        }
                        float f4 = f3 / stringWidth;
                        if (1.0f <= f4 || i3 / f2 > f4) {
                            this.f25404d.r.setTitleSize(i3);
                            return;
                        }
                        this.f25404d.r.setTitleSize(Math.round(f2 * f4));
                    }
                }
            });
        }
    }

    public void showLoadingProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            d();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.w.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
        }
    }

    @TargetApi(24)
    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65570, this) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (this.C && isInMultiWindowMode()) {
            GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.D), -1, 1);
        }
        if (this.F || !isInMultiWindowMode()) {
            return;
        }
        finish();
    }

    public static void startLightApp(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        Intent a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), bundle}) == null) || (a2 = a(context, str, str2, z, z2, bundle)) == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, this, str) == null) && this.n) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.w.setVisibility(0);
            this.w.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
            a(5);
        }
    }

    private void b(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, str) == null) || (bdActionBar = this.r) == null) {
            return;
        }
        if (!this.o) {
            bdActionBar.setVisibility(8);
        }
        this.r.setTitle(this.A);
        this.r.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LightappBrowseActivity f25399a;

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
                this.f25399a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.f25399a.getActivity());
                    this.f25399a.onBackPressed();
                }
            }
        });
        if (this.p == null) {
            return;
        }
        this.r.setRightImgZone2Visibility(0);
        this.r.setRightImgZone2Enable(true);
        this.r.setRightImgZone2Src(ResUtils.drawable(getActivity(), "wallet_base_overflow"), ResUtils.getString(getActivity(), "wallet_base_bdaction_more"));
        this.r.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LightappBrowseActivity f25400a;

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
                this.f25400a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f25400a.p.show();
                }
            }
        });
        this.r.setOnlyIcons(getIntent().getExtras().getBoolean(com.baidu.wallet.api.Constants.ONLY_ICONS));
    }

    private void d(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, str) == null) {
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
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, this, str) == null) && TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(LangbridgeActivity.KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            NoNetView noNetView = this.v;
            if (noNetView != null) {
                noNetView.notifyUrlFinish();
            }
            LightappBrowserWebView lightappBrowserWebView = this.mWebView;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(0);
            }
        }
    }

    public static void startLightApp(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65588, null, context, str, z) == null) {
            startLightApp(context, str, null, true, z);
        }
    }

    private BdActionBar a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z)) == null) {
            if (z) {
                return new BdLightAppActionBar(getActivity());
            }
            return new BdActionBar(getActivity());
        }
        return (BdActionBar) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(getActivity()) * i2) / 100.0f);
            this.w.setLayoutParams(layoutParams);
        }
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? a(context, str, str2, z, z2, null) : (Intent) invokeCommon.objValue;
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), bundle})) == null) {
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
        return (Intent) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65546, this, i2, str) == null) {
            LocalRouter.getInstance(getApplicationContext()).route(this, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data("statusCode", Integer.valueOf(i2)).data("desc", str), null);
        }
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, lifeCycleCbName, bundle) == null) {
            Object[] array = this.f25385i.toArray();
            Activity activity = getActivity();
            switch (AnonymousClass4.f25397a[lifeCycleCbName.ordinal()]) {
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
    }

    private void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, activityLifecycleCallbacks) == null) || activityLifecycleCallbacks == null || this.f25385i.contains(activityLifecycleCallbacks)) {
            return;
        }
        this.f25385i.addElement(activityLifecycleCallbacks);
    }
}
