package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.PromptDialog;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.lightapp.ability.b.b;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappBaseActivity;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.multipage.LangbridgeActivity;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.i;
import com.baidu.wallet.lightapp.widget.BdLightAppActionBar;
import com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.wallet.utils.StringUtil;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes8.dex */
public class LightappBrowseActivity extends LightappBaseActivity implements NoProguard, IBeanResponseCallback, com.baidu.wallet.lightapp.multipage.a, NoNetView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS;
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TITLE = "title";

    /* renamed from: d  reason: collision with root package name */
    public static int f61592d;
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
    public List M;
    public LangbridgeBarParams N;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61593a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f61594b;

    /* renamed from: c  reason: collision with root package name */
    public int f61595c;

    /* renamed from: e  reason: collision with root package name */
    public LightappBusinessClient f61596e;

    /* renamed from: f  reason: collision with root package name */
    public int f61597f;
    public View fullScreenview;

    /* renamed from: g  reason: collision with root package name */
    public Vector<Application.ActivityLifecycleCallbacks> f61598g;

    /* renamed from: h  reason: collision with root package name */
    public String f61599h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f61600i;

    /* renamed from: j  reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f61601j;
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

    /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$9  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61645a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-161689105, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity$9;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-161689105, "Lcom/baidu/wallet/lightapp/business/LightappBrowseActivity$9;");
                    return;
                }
            }
            int[] iArr = new int[LifeCycleCbName.values().length];
            f61645a = iArr;
            try {
                iArr[LifeCycleCbName.OnCreated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61645a[LifeCycleCbName.OnStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61645a[LifeCycleCbName.OnResumed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61645a[LifeCycleCbName.OnPaused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f61645a[LifeCycleCbName.OnStopped.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f61645a[LifeCycleCbName.OnSaveInstanceState.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f61645a[LifeCycleCbName.OnDestroyed.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class CustomChromeClient extends LightappBaseActivity.BaseCustomChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f61646b;

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
            this.f61646b = lightappBrowseActivity;
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogUtil.i("LightappBrowseActivity", "getVideoLoadingProgressView");
                FrameLayout frameLayout = new FrameLayout(this.f61646b.getActivity());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return frameLayout;
            }
            return (View) invokeV.objValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consoleMessage)) == null) {
                if (consoleMessage == null) {
                    return super.onConsoleMessage(consoleMessage);
                }
                ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
                if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                    String sourceId = consoleMessage.sourceId();
                    sourceId = (TextUtils.equals(sourceId, this.f61646b.K) || TextUtils.isEmpty(sourceId)) ? "" : "";
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("level", messageLevel.name());
                    linkedHashMap.put("message", consoleMessage.message());
                    linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                    linkedHashMap.put("sourceId", sourceId);
                    linkedHashMap.put("pageUrl", this.f61646b.K);
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f61646b.K).toString());
                    this.f61646b.upToSensor(consoleMessage.message(), Arrays.asList(this.f61646b.K, messageLevel.name()));
                    Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, linkedHashMap, this.f61646b);
                }
                return super.onConsoleMessage(consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogUtil.i("LightappBrowseActivity", "onHideCustomView");
                this.f61646b.d();
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                LogUtil.d("LightappBrowseActivity", "onProgressChanged:newProgress   " + i2);
                this.f61646b.a(i2);
                if (i2 == 100) {
                    this.f61646b.dismissLoadingProgress();
                    if (this.f61646b.f61593a) {
                        return;
                    }
                    LogUtil.d("LightappBrowseActivity", "onProgressChanged.hideErrorPage");
                    this.f61646b.e();
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (this.f61646b.r != null) {
                    if (TextUtils.isEmpty(this.f61646b.A) || NetworkUtils.isNetworkConnected(this.f61646b.getActivity())) {
                        if (this.f61646b.B != null) {
                            this.f61646b.r.setTitle(this.f61646b.B);
                            return;
                        } else if (!TextUtils.isEmpty(this.f61646b.f61599h)) {
                            this.f61646b.r.setTitle(this.f61646b.f61599h);
                            return;
                        } else if (TextUtils.isEmpty(str) || LightappBrowseActivity.l.matcher(str).matches()) {
                            this.f61646b.r.setTitle(" ");
                            return;
                        } else {
                            if (("http://" + str).equals(this.f61646b.k)) {
                                this.f61646b.r.setTitle(" ");
                                return;
                            } else {
                                this.f61646b.r.setTitle(str);
                                return;
                            }
                        }
                    }
                    this.f61646b.r.setTitle(this.f61646b.A);
                    this.f61646b.r.setTitleCenterSafeTipText("");
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, view, customViewCallback) == null) {
                LogUtil.i("LightappBrowseActivity", "onShowCustomView");
                if (this.f61646b.getActivity() == null || !this.f61646b.isActiveCell()) {
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = this.f61646b;
                if (lightappBrowseActivity.fullScreenview == null) {
                    this.f61646b.f61600i = new b(this.f61646b.getActivity());
                    this.f61646b.f61600i.addView(view, LightappBrowseActivity.COVER_SCREEN_PARAMS);
                    ((FrameLayout) lightappBrowseActivity.getActivity().getWindow().getDecorView()).addView(this.f61646b.f61600i, LightappBrowseActivity.COVER_SCREEN_PARAMS);
                    LightappBrowseActivity lightappBrowseActivity2 = this.f61646b;
                    lightappBrowseActivity2.fullScreenview = view;
                    lightappBrowseActivity2.b(false);
                    LogUtil.i("LightappBrowseActivity", "fullscreen");
                    this.f61646b.f61601j = customViewCallback;
                    this.f61646b.getActivity().setRequestedOrientation(0);
                    DXMSdkSAUtils.onEventWithValues("#webviewVedioFullScreen", Arrays.asList(this.f61646b.k));
                    return;
                }
                customViewCallback.onCustomViewHidden();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class CustomWebViewClient extends LightappBaseActivity.BaseCustomWebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f61647b;

        /* renamed from: c  reason: collision with root package name */
        public Pattern f61648c;

        /* renamed from: d  reason: collision with root package name */
        public String f61649d;

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
            this.f61647b = lightappBrowseActivity;
            this.f61648c = Pattern.compile("\\s*https?://.*");
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
                Vector<LoadTimeLine> vector = this.f61647b.mLoadTimeLine;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
                }
                this.f61647b.dismissLoadingProgress();
                this.f61647b.f61597f = com.baidu.wallet.lightapp.base.a.a().a(this.f61647b.getActivity(), str, this.f61647b.f61597f);
                this.f61647b.k = str;
                String host = Uri.parse(str).getHost();
                this.f61649d = str;
                if (TextUtils.isEmpty(host)) {
                    this.f61647b.H.setVisibility(8);
                } else {
                    this.f61647b.H.setVisibility(0);
                    this.f61647b.H.setText(this.f61647b.getResources().getString(ResUtils.string(this.f61647b.getActivity(), "wallet_lightapp_url_outer"), host));
                }
                String title = this.f61647b.r.getTitle();
                if (title != null && title.equals(this.f61647b.A)) {
                    String title2 = webView.getTitle();
                    if (title2 == null || this.f61648c.matcher(title2).matches()) {
                        this.f61647b.r.setTitle((String) null);
                    } else {
                        this.f61647b.r.setTitle(title2);
                    }
                }
                if (webView.getProgress() != 100) {
                    this.f61647b.f61593a = true;
                }
                LogUtil.d("LightappBrowseActivity", "onPageFinished.finishedError:  " + this.f61647b.f61593a);
                super.onPageFinished(webView, str);
                if (webView.getProgress() == 100) {
                    com.baidu.wallet.lightapp.monitor.a.a().a((View) this.f61647b.mWebView, "FINISH", false);
                }
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f61647b.k), "" + LightappBrowseActivity.f61592d));
                LangbridgeCacheManager.getInstance().handleFinishPage(str);
                LightappBrowserWebView lightappBrowserWebView = this.f61647b.mWebView;
                if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack() || this.f61647b.mNeedClearHistory || this.f61647b.r.setCloseButtonVisibility(0) == 0) {
                    return;
                }
                this.f61647b.r.setCloseOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.CustomWebViewClient.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CustomWebViewClient f61650a;

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
                        this.f61650a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f61650a.f61647b.k), "" + LightappBrowseActivity.f61592d));
                            GlobalUtils.hideKeyboard(this.f61650a.f61647b.getActivity());
                            if (this.f61650a.f61647b.f61595c == 12) {
                                this.f61650a.f61647b.a(2, "实名认证取消");
                            }
                            this.f61650a.f61647b.finish();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                LogUtil.d("onPageStarted", "url = " + str);
                Vector<LoadTimeLine> vector = this.f61647b.mLoadTimeLine;
                if (vector != null) {
                    vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
                }
                this.f61647b.K = str;
                if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                    this.f61647b.setFullScreenInMainThread(false, false, false, false, "", "");
                }
                this.f61647b.c();
                if (LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                    this.f61647b.showLoadingProgress();
                }
                this.f61647b.r.setTitle(this.f61647b.A);
                this.f61647b.r.setTitleCenterSafeTipText("");
                this.f61647b.r.setRightImgZone1Enable(false);
                if (this.f61647b.r.getRightZone1View().getVisibility() == 0) {
                    this.f61647b.r.setRightImgZone1Visibility(8);
                    this.f61647b.r.hideBubble(false);
                }
                this.f61647b.q = null;
                if (this.f61647b.f61596e != null) {
                    this.f61647b.f61596e.setH5BackCb(null);
                }
                this.f61647b.B = null;
                super.onPageStarted(webView, str, bitmap);
                com.baidu.wallet.lightapp.monitor.a.a().a((View) this.f61647b.mWebView, "START", true);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(CheckUtils.stripUrlParams(this.f61647b.k), "" + LightappBrowseActivity.f61592d));
                LangbridgeCacheManager.getInstance().handleStartPage(str);
                boolean isOfflineCacheReady = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
                if (!NetworkUtils.isNetworkAvailable(this.f61647b.getActivity()) && !isOfflineCacheReady) {
                    this.f61647b.c(str);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(CheckUtils.stripUrlParams(str)));
                }
                if (a(str, this.f61649d)) {
                    return;
                }
                com.baidu.wallet.lightapp.base.c.a(this.f61647b.getActivity());
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
                linkedHashMap.put("pageUrl", this.f61647b.K);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f61647b.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f61647b);
                if (webResourceError == null || webResourceRequest == null || -10 == webResourceError.getErrorCode() || !webResourceRequest.isForMainFrame()) {
                    return;
                }
                this.f61647b.f61593a = true;
                if (-1 != webResourceError.getErrorCode() || this.f61647b.M == null || !this.f61647b.M.contains(String.valueOf(webResourceRequest.getUrl()))) {
                    if (this.f61647b.v != null) {
                        this.f61647b.v.setFailureCause(webResourceError.getErrorCode());
                    }
                    this.f61647b.c(webResourceRequest.getUrl().toString());
                } else {
                    this.f61647b.M.remove(String.valueOf(webResourceRequest.getUrl()));
                }
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(String.valueOf(webResourceError.getErrorCode()), String.valueOf(webResourceRequest.getUrl())));
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
                        linkedHashMap.put("pageUrl", this.f61647b.K);
                    }
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f61647b.K).toString());
                    Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, linkedHashMap, this.f61647b);
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
                    linkedHashMap.put("pageUrl", this.f61647b.K);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f61647b.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, linkedHashMap, this.f61647b);
                int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = this.f61647b;
                lightappBrowseActivity.f61593a = true;
                if (lightappBrowseActivity.v != null) {
                    this.f61647b.v.setFailureCause(primaryError);
                }
                this.f61647b.c(url);
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, webResourceRequest)) == null) {
                if (this.f61647b.mNeedOverrideUrl) {
                    LangbridgeCacheManager.getInstance().handleLoadUrl(this.f61647b.mLangbridgeHash, webResourceRequest.getUrl().toString());
                    this.f61647b.mNeedOverrideUrl = false;
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

        @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity.BaseCustomWebViewClient, android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("errorCode", String.valueOf(i2));
                linkedHashMap.put("url", str2);
                linkedHashMap.put("reasonPhrase", str);
                linkedHashMap.put("pageUrl", this.f61647b.K);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(this.f61647b.K).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, linkedHashMap, this.f61647b);
                if (-10 == i2) {
                    return;
                }
                LightappBrowseActivity lightappBrowseActivity = this.f61647b;
                lightappBrowseActivity.f61593a = true;
                if (lightappBrowseActivity.v != null) {
                    this.f61647b.v.setFailureCause(i2);
                }
                this.f61647b.c(str2);
                super.onReceivedError(webView, i2, str, str2);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class WebviewMenu extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MENU_ITEM_INDEX_CLOSE = 34;
        public static final int MENU_ITEM_INDEX_REFRESH = 33;
        public static final int MENU_ITEM_INDEX_SHARE = 32;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f61651a;

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
            this.f61651a = lightappBrowseActivity;
            add(33, ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (lightappBrowseActivity.m) {
                add(32, ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    /* loaded from: classes8.dex */
    public class a extends LangBridgeMenuDialog implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LightappBrowseActivity f61652a;

        /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1837a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f61657a;

            /* renamed from: b  reason: collision with root package name */
            public String f61658b;

            /* renamed from: c  reason: collision with root package name */
            public String f61659c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f61660d;

            public C1837a(a aVar) {
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
                this.f61660d = aVar;
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
            this.f61652a = lightappBrowseActivity;
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        if (!jSONArray.isNull(i4)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i4);
                            if (jSONObject.has("title") && jSONObject.has("icon") && jSONObject.has("callback")) {
                                C1837a c1837a = new C1837a();
                                c1837a.f61657a = jSONObject.optString("title", null);
                                c1837a.f61658b = jSONObject.optString("icon", null);
                                c1837a.f61659c = jSONObject.optString("callback", null);
                                if (compile.matcher(c1837a.f61657a).matches() && !TextUtils.isEmpty(c1837a.f61658b) && !TextUtils.isEmpty(c1837a.f61659c)) {
                                    if (5 <= arrayList.size()) {
                                        break;
                                    }
                                    arrayList.add(c1837a);
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
                C1837a c1837a2 = (C1837a) arrayList.get(i5);
                add(i5 + 256, c1837a2.f61657a, c1837a2.f61658b);
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
                public final /* synthetic */ LightappBrowseActivity f61653a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f61654b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ArrayList f61655c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f61656d;

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
                    this.f61656d = this;
                    this.f61653a = lightappBrowseActivity;
                    this.f61654b = size;
                    this.f61655c = arrayList;
                }

                @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                        int itemId = bdMenuItem.getItemId();
                        if (255 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f61656d.f61652a.k), "" + LightappBrowseActivity.f61592d));
                            if (this.f61656d.f61652a.f61595c == 12) {
                                this.f61656d.f61652a.a(2, "实名认证取消");
                            }
                            this.f61656d.f61652a.finish();
                        } else if (254 == itemId) {
                            DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f61656d.f61652a.k)));
                            LightAppWrapper.getInstance().callShare(this.f61656d.f61652a.getActivity(), new LightAppShareModel(this.f61656d.f61652a.mWebView.getTitle(), this.f61656d.f61652a.mWebView.getTitle(), this.f61656d.f61652a.mWebView.getUrl(), null), null);
                        } else if (253 == itemId) {
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f61656d.f61652a.k)));
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f61656d.f61652a.getActivity(), this.f61656d.f61652a.k);
                            this.f61656d.f61652a.mWebView.reload();
                            LightappBrowseActivity lightappBrowseActivity2 = this.f61656d.f61652a;
                            lightappBrowseActivity2.k = lightappBrowseActivity2.mWebView.getUrl();
                            this.f61656d.f61652a.f61593a = false;
                        } else {
                            int i6 = itemId - 256;
                            if (i6 <= this.f61654b) {
                                this.f61656d.f61652a.executeJsFunction(((C1837a) this.f61655c.get(i6)).f61659c, "");
                            }
                        }
                    }
                }
            });
            layoutMenu();
        }
    }

    /* loaded from: classes8.dex */
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
                LogUtil.i("LightappBrowseActivity", "onTouchEvent " + motionEvent.getAction());
                return true;
            }
            return invokeL.booleanValue;
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
        COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
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
        this.f61595c = 0;
        this.f61597f = -1;
        this.f61598g = new Vector<>();
        this.m = false;
        this.n = true;
        this.o = true;
        this.f61593a = false;
        this.C = false;
        this.D = "wallet_base_multi_window_close";
        this.E = false;
        this.F = false;
        this.G = null;
        this.L = false;
        this.N = new LangbridgeBarParams();
    }

    public static int getCurrentColor(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? a(context, str, null, z, z2) : (Intent) invokeCommon.objValue;
    }

    public static void startLightApp(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65592, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLightApp(context, str, str2, z, z2, null);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void checkClodDown(String str, List<String> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, list, str2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeTopWebview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void closeWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            finish();
        }
    }

    public void dismissLoadingProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
        }
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void doNetworkTomography(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) {
            com.baidu.wallet.lightapp.ability.b.b.a().a(str, new b.a(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public boolean f61608a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61609b;

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
                    this.f61609b = this;
                    this.f61608a = false;
                }

                @Override // com.baidu.wallet.lightapp.ability.b.b.a
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.f61608a) {
                        return;
                    }
                    WalletGlobalUtils.showLoadingDialog(this.f61609b.getActivity());
                    this.f61608a = true;
                }

                @Override // com.baidu.wallet.lightapp.ability.b.b.a
                public void a(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (!jSONObject.optBoolean("isOnline", true)) {
                                GlobalUtils.toast(this.f61609b.getContext(), ResUtils.getString(this.f61609b.getActivity(), "network_no_connected"));
                            } else if (!jSONObject.optBoolean("isInternetConnected", true)) {
                                GlobalUtils.toast(this.f61609b.getContext(), ResUtils.getString(this.f61609b.getActivity(), "network_no_internet_connected"));
                            } else {
                                GlobalUtils.toast(this.f61609b.getContext(), ResUtils.getString(this.f61609b.getActivity(), "network_tomography_done"));
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
            }, getContext(), map);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String exeSSCommand(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, str3)) == null) {
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void executeJsFunction(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && this.mWebView != null && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, t) == null) && this.mWebView != null && !TextUtils.isEmpty(str)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (com.baidu.wallet.lightapp.multipage.a) invokeV.objValue;
    }

    public String getCanceledMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "取消" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getCellHashStamps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getContentLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "wallet_langbrige_webview" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? DxmApplicationContextImpl.getApplicationContext(this) : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ResUtils.getString(getActivity(), "wallet_base_select_phone_fail") : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public String getLightappWebviewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "cust_webview" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? JsonUtils.toJson(this.mLoadTimeLine) : (String) invokeV.objValue;
    }

    public boolean getShowShareForIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getIntent().getBooleanExtra("shwoshare", false) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isPreloaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.J = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.f61596e, str);
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
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean needKeyboardAdjust() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (i2 == 4) {
                if (i3 == -1) {
                    if (intent == null || intent.getData() == null || (contactInfoPresenter = this.I) == null) {
                        return;
                    }
                    contactInfoPresenter.a(intent.getData());
                    return;
                }
                LightappBusinessClient lightappBusinessClient = this.f61596e;
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
                    jSONObject.put("errCode", LightappConstants.ERRCODE_CANCEL);
                    jSONObject.put(BeanConstants.DXM_OCR_KEY_ERROR_DES, "用户取消选择");
                    this.f61596e.setAlubmPhotoData(1, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else {
                super.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            LogUtil.d("LightappBrowseActivity", "onBackPressed");
            if (this.fullScreenview == null && this.f61600i == null) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.k), "" + f61592d));
                LightappBusinessClient lightappBusinessClient = this.f61596e;
                if ((lightappBusinessClient != null ? lightappBusinessClient.getH5BackCb() : null) != null) {
                    executeJsFunction(LightappBusinessClient.MTD_H5GOBCK, null);
                } else {
                    if (this.f61595c == 12 && !this.mWebView.canGoBack()) {
                        a(2, "实名认证取消");
                    }
                    super.onBackPressed();
                }
                LightappBrowserWebView lightappBrowserWebView = this.mWebView;
                if (lightappBrowserWebView != null) {
                    this.k = lightappBrowserWebView.getUrl();
                    return;
                }
                return;
            }
            d();
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048601, this, i2, i3, str) == null) {
            this.G.post(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61644a;

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
                    this.f61644a = this;
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
        if (interceptable == null || interceptable.invokeILL(1048602, this, i2, obj, str) == null) {
            this.G.post(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61643a;

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
                    this.f61643a = this;
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
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            int i2 = f61592d;
            if (i2 < 2) {
                f61592d = i2 + 1;
            }
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                try {
                    this.f61595c = extras.getInt("baidu.wallet.lightapp.biztype", 0);
                    this.k = extras.getString("jump_url");
                    this.f61599h = extras.getString("title");
                    this.mLangbridgeHash = extras.getLong("LANGBRIDGE_HASH", 0L);
                    if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                        a(activityLifecycleCallbacks);
                    }
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 11) {
                requestWindowFeature(10);
            }
            if (bundle != null) {
                this.k = bundle.getString("jump_url");
                this.m = bundle.getBoolean("shwoshare", false);
                this.n = bundle.getBoolean(LangbridgeActivity.IS_SHOW_NATIVE_ERROR_PAGE, true);
                this.o = bundle.getBoolean(LangbridgeActivity.IS_SHOW_TITLE_BAR, true);
                this.f61599h = bundle.getString("title");
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
                    public Pattern f61602a;

                    /* renamed from: b  reason: collision with root package name */
                    public Matcher f61603b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ LightappBrowseActivity f61604c;

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
                        this.f61604c = this;
                        Pattern compile = Pattern.compile(".*");
                        this.f61602a = compile;
                        this.f61603b = compile.matcher("");
                    }

                    @Override // android.webkit.DownloadListener
                    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                            if (this.f61604c.M == null) {
                                this.f61604c.M = new LinkedList();
                            }
                            this.f61604c.M.add(str);
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    return;
                                }
                                this.f61604c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            } catch (Exception e2) {
                                LogUtil.e("LightappBrowseActivity", "Download Error", e2);
                                GlobalUtils.toast(this.f61604c.getActivity(), "下载出现异常");
                            }
                        }
                    }
                });
                com.baidu.wallet.lightapp.base.a.a().a(getActivity());
                this.A = "";
                this.z = ResUtils.getString(this, "ebpay_loading");
                this.v = (NoNetView) findViewById(ResUtils.id(getActivity(), "nonet_view"));
                this.w = findViewById(ResUtils.id(getActivity(), "progress_line"));
                this.r = a(getIntent().getExtras().getBoolean("long_title", true));
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
                webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LightappBrowseActivity f61605a;

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
                        this.f61605a = this;
                    }

                    @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
                    public void onClick(BdMenuItem bdMenuItem) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) {
                            switch (bdMenuItem.getItemId()) {
                                case 32:
                                    DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(CheckUtils.stripUrlParams(this.f61605a.k)));
                                    LightAppWrapper.getInstance().callShare(this.f61605a.getActivity(), new LightAppShareModel(this.f61605a.mWebView.getTitle(), this.f61605a.mWebView.getTitle(), this.f61605a.mWebView.getUrl(), null), null);
                                    return;
                                case 33:
                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(CheckUtils.stripUrlParams(this.f61605a.k)));
                                    LangbridgeCacheManager.getInstance().onLangbridgeRefresh(this.f61605a.getActivity(), this.f61605a.k);
                                    this.f61605a.mWebView.reload();
                                    this.f61605a.f61593a = false;
                                    return;
                                case 34:
                                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(CheckUtils.stripUrlParams(this.f61605a.k), "" + LightappBrowseActivity.f61592d));
                                    if (this.f61605a.f61595c == 12) {
                                        this.f61605a.a(2, "实名认证取消");
                                    }
                                    this.f61605a.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                this.f61596e = (LightappBusinessClient) this.mLightappJsClient.getLightappBusiness();
                b(this.A);
                this.f61594b = (LinearLayout) findViewById(ResUtils.id(getActivity(), "walelt_app_host_background"));
                this.H = (TextView) findViewById(ResUtils.id(getActivity(), "walelt_base_light_app_host"));
                try {
                    if (!l.matcher(this.k).matches()) {
                        this.k = "https://" + this.k;
                    }
                    this.mWebView.loadUrl(this.k.trim());
                    this.f61593a = false;
                } catch (Exception unused2) {
                    LogUtil.d("Url error");
                    finish();
                }
                this.mLoadTimeLine = new Vector<>();
                if (!TextUtils.isEmpty(this.k)) {
                    this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), "onCreate", String.valueOf(System.currentTimeMillis())));
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDestroy();
            if (this.fullScreenview != null || this.f61600i != null) {
                this.f61600i = null;
                this.fullScreenview = null;
                this.f61601j.onCustomViewHidden();
                this.f61601j = null;
            }
            LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.mLangbridgeHash);
            Handler handler = this.G;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            com.baidu.wallet.lightapp.monitor.a.a().b();
            this.f61596e = null;
            if (this.f61595c == 12) {
                LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), null);
            }
            a(LifeCycleCbName.OnDestroyed, (Bundle) null);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || Build.VERSION.SDK_INT < 24) {
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
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPause();
            this.f61597f = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.k, this.f61597f);
            if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
                this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), MissionEvent.MESSAGE_PAUSE, String.valueOf(System.currentTimeMillis())));
            }
            this.E = false;
            BdActionBar bdActionBar = this.r;
            if (bdActionBar != null) {
                bdActionBar.hideBubble(true);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i2, dialog) == null) {
            if (1000 == i2) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(ResUtils.string(DxmApplicationContextImpl.getApplicationContext(this), "bd_wallet_download_prompt"));
                promptDialog.setCanceledOnTouchOutside(true);
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LightappBrowseActivity f61642a;

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
                        this.f61642a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Activity activity;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (activity = this.f61642a.getActivity()) == null || activity.isFinishing()) {
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
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (!NetworkUtils.isNetworkAvailable(DxmApplicationContextImpl.getApplicationContext(this))) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(DxmApplicationContextImpl.getApplicationContext(this), "ebpay_no_network"));
                return;
            }
            LightappBrowserWebView lightappBrowserWebView = this.mWebView;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.reload();
                this.f61593a = false;
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048610, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            LightappBusinessClient lightappBusinessClient = this.f61596e;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.onRequestPermissionsResult(this.K, i2, strArr, iArr);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            if (this.L) {
                this.f61596e.checkPermission();
                this.L = false;
            }
            if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
                this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), "onResume", String.valueOf(System.currentTimeMillis())));
            }
            h();
            this.E = true;
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public void onWebViewBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f61593a = false;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            runOnUiThread(new Runnable(this, str2, str) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61639a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61640b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61641c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61641c = this;
                    this.f61639a = str2;
                    this.f61640b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (!TextUtils.isEmpty(this.f61639a)) {
                                this.f61641c.mWebView.loadUrl(this.f61639a.trim());
                            } else {
                                this.f61641c.mWebView.loadUrl(this.f61640b.trim());
                            }
                            this.f61641c.f61593a = false;
                        } catch (Exception unused) {
                            this.f61641c.finish();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, arrayList, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    public void prepareSelectNumDialog(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, list, onItemClickListener) == null) {
            SelectNumberDialog selectNumberDialog = new SelectNumberDialog(getActivity());
            selectNumberDialog.setOnItemClickListener(onItemClickListener);
            selectNumberDialog.setData(list);
            selectNumberDialog.show();
        }
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, activityLifecycleCallbacks) == null) {
            this.f61598g.removeElement(activityLifecycleCallbacks);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void rmFromPreloadPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.I = new ContactInfoPresenter(getActivity(), this.f61596e);
            ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
        }
    }

    public void setActionBarTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str, str2})) == null) {
            runOnUiThread(new Runnable(this, z4, z3, z, str2, str, z2) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f61614a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f61615b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f61616c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f61617d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f61618e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f61619f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61620g;

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
                    this.f61620g = this;
                    this.f61614a = z4;
                    this.f61615b = z3;
                    this.f61616c = z;
                    this.f61617d = str2;
                    this.f61618e = str;
                    this.f61619f = z2;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        this.f61620g.N.isFullScreen = this.f61616c;
                        if (!TextUtils.isEmpty(this.f61617d)) {
                            try {
                                this.f61620g.N.fullScreenTitleColor = Color.parseColor(this.f61617d);
                            } catch (Throwable th) {
                                LogUtil.d("error", th.toString());
                                this.f61620g.N.fullScreenTitleColor = 0;
                            }
                        } else {
                            this.f61620g.N.fullScreenTitleColor = 0;
                        }
                        if (!TextUtils.isEmpty(this.f61618e)) {
                            try {
                                this.f61620g.N.fullScreenActionBarColor = Color.parseColor(this.f61618e);
                            } catch (Throwable unused) {
                                this.f61620g.N.fullScreenActionBarColor = -1;
                            }
                        } else {
                            this.f61620g.N.fullScreenActionBarColor = -1;
                        }
                        this.f61620g.N.isHideTitle = this.f61619f;
                        this.f61620g.N.isIconWhite = this.f61614a;
                    }
                }

                private void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                        if (this.f61619f) {
                            this.f61620g.r.setTitleTextColorAlpha(0);
                        } else {
                            this.f61620g.r.setTitleTextColorAlpha(255);
                        }
                    }
                }

                private void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65539, this) == null) {
                        if (this.f61620g.N.fullScreenTitleColor != 0) {
                            this.f61620g.r.setFullScreenTextColor(this.f61620g.N.fullScreenTitleColor);
                        } else {
                            this.f61620g.r.resetFullScreenTextColor();
                        }
                    }
                }

                private void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                        if (this.f61620g.N.fullScreenActionBarColor != -1) {
                            this.f61620g.r.setTitlebgColor(this.f61620g.N.fullScreenActionBarColor);
                            this.f61620g.r.setBottomSeperatorvisible(false);
                            LightappBrowseActivity lightappBrowseActivity = this.f61620g;
                            lightappBrowseActivity.setActionBarTransparent(Color.alpha(lightappBrowseActivity.N.fullScreenActionBarColor) != 255);
                            return;
                        }
                        this.f61620g.r.setTitlebgColor(ResUtils.getColor(this.f61620g.getActivity(), "wallet_extend_color_actionbar_bg"));
                        this.f61620g.r.setBottomSeperatorvisible(true);
                        this.f61620g.setActionBarTransparent(false);
                    }
                }

                private void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                        if (this.f61620g.N.fullScreenActionBarColor != -1 && (this.f61620g.N.fullScreenActionBarColor | (-16777216)) != -1) {
                            LightappBrowseActivity lightappBrowseActivity = this.f61620g;
                            lightappBrowseActivity.f61594b.setBackgroundColor(lightappBrowseActivity.N.fullScreenActionBarColor);
                        } else {
                            LightappBrowseActivity lightappBrowseActivity2 = this.f61620g;
                            lightappBrowseActivity2.f61594b.setBackgroundColor(ResUtils.getColor(lightappBrowseActivity2.getActivity(), "wallet_base_background1_color_7f"));
                        }
                        if (this.f61620g.N.fullScreenTitleColor != 0) {
                            this.f61620g.H.setTextColor(this.f61620g.N.fullScreenTitleColor);
                        } else {
                            this.f61620g.H.setTextColor(ResUtils.getColor(this.f61620g.getActivity(), "wallet_base_font_text4Color"));
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a();
                        this.f61620g.r.setIconFlag(this.f61614a);
                        if (this.f61620g.u != null) {
                            this.f61620g.u.setSupportPullDown(!this.f61615b);
                        }
                        d();
                        c();
                        b();
                        e();
                    }
                }
            });
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("actionBarHeight", DisplayUtils.px2dip(DxmApplicationContextImpl.getApplicationContext(this), this.r.getActionBarHeight()));
                jSONObject.put("statusBarHeight", DisplayUtils.px2dip(DxmApplicationContextImpl.getApplicationContext(this), this.r.getStatusBarHeight()));
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
            this.L = z;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setIsMultiWindowAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || z == this.F) {
            return;
        }
        this.F = z;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void setIsShowMultiWindowTips(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || z == this.C) {
            return;
        }
        this.C = z;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jSONArray) == null) {
            runOnUiThread(new Runnable(this, jSONArray) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONArray f61623a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61624b;

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
                    this.f61624b = this;
                    this.f61623a = jSONArray;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f61624b.r.getRightZoneView() == null) {
                        return;
                    }
                    LightappBrowseActivity lightappBrowseActivity = this.f61624b;
                    LightappBrowseActivity lightappBrowseActivity2 = this.f61624b;
                    lightappBrowseActivity.q = new a(lightappBrowseActivity2, lightappBrowseActivity2.getActivity(), this.f61623a);
                    this.f61624b.r.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.17.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass17 f61625a;

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
                            this.f61625a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                if (this.f61625a.f61624b.q != null) {
                                    this.f61625a.f61624b.q.show();
                                } else if (this.f61625a.f61624b.p != null) {
                                    this.f61625a.f61624b.p.show();
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
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.D = str;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setSubMenu(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048627, this, str, str2, str3, i2) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.r.getRightZone1View();
            NetImageView netImageView = (NetImageView) this.r.getRightImgZone1ImgView();
            runOnUiThread(new Runnable(this, i2, netImageView) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f61626a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NetImageView f61627b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61628c;

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
                    this.f61628c = this;
                    this.f61626a = i2;
                    this.f61627b = netImageView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61628c.r.setRightImgZone1Visibility(this.f61626a);
                        this.f61627b.setImageDrawable(null);
                        this.f61627b.setVisibility(this.f61626a);
                        if (this.f61626a == 4) {
                            this.f61628c.r.hideBubble(false);
                        }
                    }
                }
            });
            if (i2 == 4 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            netImageView.setEnabled(true);
            ImageLoader.getInstance(getActivity()).getBitmap(str, new ImageLoader.OnGetBitmapListener(this, str2, netImageView, relativeLayout, str3) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61629a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NetImageView f61630b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ RelativeLayout f61631c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f61632d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61633e;

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
                    this.f61633e = this;
                    this.f61629a = str2;
                    this.f61630b = netImageView;
                    this.f61631c = relativeLayout;
                    this.f61632d = str3;
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
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str4, obj, bitmap) == null) || bitmap == null || TextUtils.isEmpty(this.f61629a)) {
                        return;
                    }
                    this.f61633e.runOnUiThread(new Runnable(this, bitmap) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f61634a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f61635b;

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
                            this.f61635b = this;
                            this.f61634a = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.f61635b.f61630b.isEnabled()) {
                                    this.f61635b.f61633e.r.setRightImgZone1Visibility(0);
                                    this.f61635b.f61633e.r.setRightImgZone1Enable(true);
                                    this.f61635b.f61630b.setImageDrawable(new BitmapDrawable(this.f61634a));
                                    if (this.f61635b.f61633e.N.isIconWhite && this.f61635b.f61633e.r.isIconWhite()) {
                                        this.f61635b.f61630b.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                                    } else {
                                        this.f61635b.f61630b.clearColorFilter();
                                    }
                                    this.f61635b.f61630b.setVisibility(0);
                                    if (this.f61635b.f61631c.getVisibility() == 0) {
                                        this.f61635b.f61633e.r.showBubble(this.f61635b.f61632d, true);
                                        return;
                                    }
                                    return;
                                }
                                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "icon getSuccess但页面发生已变：" + this.f61635b.f61633e.k);
                            }
                        }
                    });
                }
            }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            runOnUiThread(new Runnable(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61636a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61637b;

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
                    this.f61637b = this;
                    this.f61636a = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61637b.r.setRightImgZone1OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f61638a;

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
                                this.f61638a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "执行js");
                                    this.f61638a.f61637b.r.hideBubble(true);
                                    AnonymousClass4 anonymousClass4 = this.f61638a;
                                    anonymousClass4.f61637b.executeJsFunction(anonymousClass4.f61636a, null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappBaseActivity
    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.setSupportZoom();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048629, this, str, str2, z) == null) {
            runOnUiThread(new Runnable(this, str, str2, z) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61610a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61611b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f61612c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61613d;

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
                    this.f61613d = this;
                    this.f61610a = str;
                    this.f61611b = str2;
                    this.f61612c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f61613d.r == null) {
                        return;
                    }
                    if (!NetworkUtils.isNetworkConnected(this.f61613d.getActivity())) {
                        this.f61613d.r.setTitle(this.f61613d.A);
                        this.f61613d.r.setTitleCenterSafeTipText("");
                    } else if (TextUtils.isEmpty(this.f61610a)) {
                        if (TextUtils.isEmpty(this.f61613d.mWebView.getTitle()) || LightappBrowseActivity.l.matcher(this.f61613d.mWebView.getTitle()).matches()) {
                            this.f61613d.r.setTitle("");
                            this.f61613d.B = null;
                        } else {
                            this.f61613d.r.setTitle(this.f61613d.mWebView.getTitle());
                            LightappBrowseActivity lightappBrowseActivity = this.f61613d;
                            lightappBrowseActivity.B = lightappBrowseActivity.mWebView.getTitle();
                        }
                        LogUtil.d("mWebView.getTitle =", this.f61613d.mWebView.getTitle());
                        this.f61613d.r.setTitleCenterSafeTipText("");
                    } else {
                        String str3 = this.f61610a;
                        this.f61613d.r.setTitle(str3);
                        this.f61613d.B = str3;
                        if (TextUtils.isEmpty(this.f61611b)) {
                            this.f61613d.r.setTitleCenterSafeTipText("");
                        } else {
                            String trim = this.f61611b.trim();
                            if (!TextUtils.isEmpty(trim)) {
                                this.f61613d.r.setTitleCenterSafeTipText(trim);
                            }
                        }
                    }
                    int[] titleSizeRange = this.f61613d.r.getTitleSizeRange();
                    int i2 = titleSizeRange[0];
                    int i3 = titleSizeRange[1];
                    if (this.f61612c) {
                        int mainTitleViewWidth = this.f61613d.r.getMainTitleViewWidth();
                        float f2 = i2;
                        float stringWidth = StringUtil.getStringWidth(this.f61613d.r.getTitle(), f2);
                        this.f61613d.r.setTitleEllipsize(TextUtils.TruncateAt.END);
                        float f3 = mainTitleViewWidth;
                        if (stringWidth <= f3) {
                            this.f61613d.r.setTitleSize(i2);
                            return;
                        }
                        float f4 = f3 / stringWidth;
                        if (1.0f <= f4 || i3 / f2 > f4) {
                            this.f61613d.r.setTitleSize(i3);
                            return;
                        }
                        this.f61613d.r.setTitleSize(Math.round(f2 * f4));
                        return;
                    }
                    this.f61613d.r.setTitleSize(i2);
                }
            });
        }
    }

    public void showLoadingProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            f();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void startNewLightApp(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLightApp(context, str, str2, z, z2);
        }
    }

    public void upToSensor(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048632, this, str, list) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        LangbridgeSettings.ConsoleMsgBehaviour[] consoleMsgBehaviourArr = i.a().a(this).MW_CONSOLE_MESSAGE_BEHAVAIOUR;
        for (int i2 = 0; consoleMsgBehaviourArr != null && i2 < consoleMsgBehaviourArr.length; i2++) {
            if (str.equals(consoleMsgBehaviourArr[i2].mConsoleString)) {
                String[] strArr = new String[2];
                strArr[0] = i.a().b(getContext()).MW_ON ? "1" : "0";
                strArr[1] = i.a().b(getContext()).MW_USE_OLD ? "1" : "0";
                new ArrayList(Arrays.asList(strArr)).addAll(list);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_CONSOLE_ERROR, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
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

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.w.setVisibility(0);
            this.w.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
            a(5);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.w.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
        }
    }

    @TargetApi(24)
    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65580, this) == null) || Build.VERSION.SDK_INT < 24) {
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
        if (!(interceptable == null || interceptable.invokeCommon(65593, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), bundle}) == null) || (a2 = a(context, str, str2, z, z2, bundle)) == null) {
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
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightappBrowseActivity f61621a;

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
                    this.f61621a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61621a.mWebView.setOnMyScrollChangeListener(new LightappWebView.a(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.16.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass16 f61622a;

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
                                this.f61622a = this;
                            }

                            @Override // com.baidu.wallet.lightapp.base.LightappWebView.a
                            public void a(int i2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                    this.f61622a.f61621a.r.hideBubble(true);
                                    if (this.f61622a.f61621a.N.isFullScreen) {
                                        int height = this.f61622a.f61621a.r.getHeight();
                                        float f2 = (height - i2) / height;
                                        if (f2 > 0.0f) {
                                            if (this.f61622a.f61621a.N.fullScreenTitleColor != 0) {
                                                this.f61622a.f61621a.r.setFullScreenTextColor(this.f61622a.f61621a.N.fullScreenTitleColor);
                                            }
                                            float f3 = 1.0f - f2;
                                            int i3 = (int) (255.0f * f3);
                                            if (this.f61622a.f61621a.N.isHideTitle) {
                                                if (i3 >= 255) {
                                                    this.f61622a.f61621a.r.setTitleTextColorAlpha(i3);
                                                } else {
                                                    this.f61622a.f61621a.r.setTitleTextColorAlpha(0);
                                                }
                                            }
                                            if (this.f61622a.f61621a.N.isIconWhite) {
                                                this.f61622a.f61621a.r.setIconFlag(true);
                                            }
                                            if (this.f61622a.f61621a.N.fullScreenActionBarColor != -1) {
                                                this.f61622a.f61621a.r.setTitlebgColor(LightappBrowseActivity.getCurrentColor(f3, this.f61622a.f61621a.N.fullScreenActionBarColor, ResUtils.getColor(this.f61622a.f61621a.getActivity(), "wallet_extend_color_actionbar_bg")));
                                                return;
                                            }
                                            return;
                                        }
                                        if (this.f61622a.f61621a.N.isHideTitle) {
                                            this.f61622a.f61621a.r.setTitleTextColorAlpha(255);
                                        }
                                        if (this.f61622a.f61621a.N.isIconWhite) {
                                            this.f61622a.f61621a.r.setIconFlag(false);
                                        }
                                        this.f61622a.f61621a.r.setTitlebgColor(ResUtils.getColor(this.f61622a.f61621a.getActivity(), "wallet_extend_color_actionbar_bg"));
                                        this.f61622a.f61621a.r.resetFullScreenTextColor();
                                        return;
                                    }
                                    int height2 = this.f61622a.f61621a.r.getHeight();
                                    float f4 = (height2 - i2) / height2;
                                    if (f4 > 0.0f) {
                                        int i4 = (int) ((1.0f - f4) * 255.0f);
                                        if (this.f61622a.f61621a.N.isHideTitle) {
                                            if (i4 >= 255) {
                                                this.f61622a.f61621a.r.setTitleTextColorAlpha(i4);
                                            } else {
                                                this.f61622a.f61621a.r.setTitleTextColorAlpha(0);
                                            }
                                        }
                                    } else if (this.f61622a.f61621a.N.isHideTitle) {
                                        this.f61622a.f61621a.r.setTitleTextColorAlpha(255);
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
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            LogUtil.i("LightappBrowseActivity", "hideCustomView");
            if (this.fullScreenview == null || getActivity() == null || this.f61601j == null) {
                return;
            }
            b(true);
            ((FrameLayout) getActivity().getWindow().getDecorView()).removeView(this.f61600i);
            this.f61600i = null;
            this.fullScreenview = null;
            this.f61601j.onCustomViewHidden();
            getActivity().setRequestedOrientation(1);
            DXMSdkSAUtils.onEventWithValues("#webviewVedioNotFullScreen", Arrays.asList(this.k));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65566, this, str) == null) && this.n) {
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

    private void b(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, this, str) == null) || (bdActionBar = this.r) == null) {
            return;
        }
        if (!this.o) {
            bdActionBar.setVisibility(8);
        }
        this.r.setTitle(this.A);
        this.r.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LightappBrowseActivity f61606a;

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
                this.f61606a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.f61606a.getActivity());
                    this.f61606a.onBackPressed();
                }
            }
        });
        if (this.p == null) {
            return;
        }
        this.r.setRightImgZone2Visibility(0);
        this.r.setRightImgZone2Enable(true);
        this.r.setRightImgZone2Src(ResUtils.drawable(getActivity(), "wallet_langbridge_actionbar_more"), ResUtils.getString(getActivity(), "wallet_base_bdaction_more"));
        this.r.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowseActivity.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LightappBrowseActivity f61607a;

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
                this.f61607a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f61607a.p.show();
                }
            }
        });
        this.r.setOnlyIcons(getIntent().getExtras().getBoolean("only_icons"));
    }

    public static void startLightApp(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65594, null, context, str, z) == null) {
            startLightApp(context, str, null, true, z);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, this, str) == null) && TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(LangbridgeActivity.KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    private void d(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, str) == null) {
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

    private BdActionBar a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65543, this, z)) == null) {
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
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            getActivity().getWindow().setFlags(z ? 0 : 1024, 1024);
        }
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
                intent.setFlags(268435456);
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, this, i2, str) == null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data("statusCode", Integer.valueOf(i2)).data("desc", str), null);
        }
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, lifeCycleCbName, bundle) == null) {
            Object[] array = this.f61598g.toArray();
            Activity activity = getActivity();
            switch (AnonymousClass9.f61645a[lifeCycleCbName.ordinal()]) {
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
        if (!(interceptable == null || interceptable.invokeL(65550, this, activityLifecycleCallbacks) == null) || activityLifecycleCallbacks == null || this.f61598g.contains(activityLifecycleCallbacks)) {
            return;
        }
        this.f61598g.addElement(activityLifecycleCallbacks);
    }
}
