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
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.lightapp.ability.b.b;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.lightapp.widget.PullToRefreshWebview;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class LightappBrowserFragment extends BaseFragment implements NoProguard, com.baidu.wallet.lightapp.multipage.a, NoNetView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JUMP_URL = "jump_url";

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f61841b;
    public static final String sTag;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61842a;

    /* renamed from: c  reason: collision with root package name */
    public String f61843c;

    /* renamed from: d  reason: collision with root package name */
    public LightappWebView f61844d;

    /* renamed from: e  reason: collision with root package name */
    public PullToRefreshWebview f61845e;

    /* renamed from: f  reason: collision with root package name */
    public LightappJsClient f61846f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61847g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadListener f61848h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61849i;

    /* renamed from: j  reason: collision with root package name */
    public NoNetView f61850j;
    public View k;
    public String l;
    public boolean m;
    public LayoutInflater mInflater;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public boolean r;
    public ViewGroup s;

    /* loaded from: classes8.dex */
    public class BaseCustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LightappBrowserFragment f61857a;

        public BaseCustomChromeClient(LightappBrowserFragment lightappBrowserFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowserFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61857a = lightappBrowserFragment;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, callback) == null) {
                callback.invoke(str, true, false);
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class BaseCustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LightappBrowserFragment f61858a;

        public BaseCustomWebViewClient(LightappBrowserFragment lightappBrowserFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowserFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61858a = lightappBrowserFragment;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, bitmap) == null) {
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_lOAD_START);
                this.f61858a.f61846f.setUrlLocal(str);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(i2 + "", str2));
                LogUtil.d(LightappBrowserFragment.sTag, "onReceivedError.showErrorPage");
                super.onReceivedError(webView, i2, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(15)
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                String str2 = LightappBrowserFragment.sTag;
                LogUtil.d(str2, "OriginalUrl : " + webView.getOriginalUrl());
                String str3 = LightappBrowserFragment.sTag;
                LogUtil.d(str3, "shouldOverrideUrlLoading url = " + str);
                if (str.startsWith("tel:")) {
                    this.f61858a.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                }
                if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                    try {
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                        intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "")});
                        this.f61858a.startActivity(intent);
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        GlobalUtils.toast(this.f61858a.getActivity(), "请先配置邮箱");
                    }
                } else if (str.toLowerCase(Locale.CHINA).startsWith("http") || str.toLowerCase(Locale.CHINA).startsWith("https") || str.toLowerCase(Locale.CHINA).startsWith("file")) {
                    if (!this.f61858a.f61849i || TextUtils.isEmpty(this.f61858a.f61843c) || str.equals(this.f61858a.f61843c)) {
                        return false;
                    }
                    BaiduWalletDelegate.getInstance().openH5Module(this.f61858a.getActivity(), str, true);
                    return true;
                } else {
                    try {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent2.addCategory("android.intent.category.BROWSABLE");
                        intent2.setComponent(null);
                        intent2.setSelector(null);
                        this.f61858a.startActivity(intent2);
                        return true;
                    } catch (Exception e3) {
                        LogUtil.d(LightappBrowserFragment.sTag, e3.getMessage());
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class CustomChromeClient extends BaseCustomChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LightappBrowserFragment f61859b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomChromeClient(LightappBrowserFragment lightappBrowserFragment) {
            super(lightappBrowserFragment);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowserFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LightappBrowserFragment) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61859b = lightappBrowserFragment;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i2) == null) {
                if (this.f61859b.m) {
                    this.f61859b.a(i2);
                }
                if (i2 == 100) {
                    if (this.f61859b.m) {
                        this.f61859b.e();
                    }
                    if (this.f61859b.f61842a) {
                        return;
                    }
                    LogUtil.d(LightappBrowserFragment.sTag, "onProgressChanged.hideErrorPage");
                    this.f61859b.f();
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (TextUtils.isEmpty(this.f61859b.n) || NetworkUtils.isNetworkConnected(this.f61859b.getActivity())) {
                    String unused = this.f61859b.o;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class CustomWebViewClient extends BaseCustomWebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LightappBrowserFragment f61860b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomWebViewClient(LightappBrowserFragment lightappBrowserFragment) {
            super(lightappBrowserFragment);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBrowserFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LightappBrowserFragment) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61860b = lightappBrowserFragment;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (this.f61860b.m) {
                    this.f61860b.e();
                }
                this.f61860b.a(str);
                if (webView.getProgress() != 100) {
                    this.f61860b.f61842a = true;
                }
                String str2 = LightappBrowserFragment.sTag;
                LogUtil.d(str2, "onPageFinished.finishedError:  " + this.f61860b.f61842a);
                super.onPageFinished(webView, str);
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_END_lOAD);
            }
        }

        @Override // com.baidu.wallet.lightapp.business.LightappBrowserFragment.BaseCustomWebViewClient, com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                if (this.f61860b.m) {
                    this.f61860b.d();
                }
                this.f61860b.o = null;
                super.onPageStarted(webView, str, bitmap);
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD);
            }
        }

        @Override // com.baidu.wallet.lightapp.business.LightappBrowserFragment.BaseCustomWebViewClient, android.webkit.WebViewClient
        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) || -10 == i2) {
                return;
            }
            LightappBrowserFragment lightappBrowserFragment = this.f61860b;
            lightappBrowserFragment.f61842a = true;
            if (lightappBrowserFragment.f61850j != null) {
                this.f61860b.f61850j.setFailureCause(i2);
            }
            this.f61860b.b(str2);
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_FRAGMENT_SSL_ERROR, Arrays.asList(primaryError + "", url));
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                    return;
                }
                LightappBrowserFragment lightappBrowserFragment = this.f61860b;
                lightappBrowserFragment.f61842a = true;
                if (lightappBrowserFragment.f61850j != null) {
                    this.f61860b.f61850j.setFailureCause(primaryError);
                }
                this.f61860b.b(url);
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(primaryError + "", url));
                String environment = DebugConfig.getInstance(this.f61860b.getActivity()).getEnvironment();
                if (!"QA".equals(environment) && !"RD".equals(environment)) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                } else {
                    sslErrorHandler.proceed();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1150993249, "Lcom/baidu/wallet/lightapp/business/LightappBrowserFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1150993249, "Lcom/baidu/wallet/lightapp/business/LightappBrowserFragment;");
                return;
            }
        }
        sTag = LightappBrowserFragment.class.getSimpleName();
        f61841b = Pattern.compile("^(https?://|file:///android_asset/).*");
    }

    public LightappBrowserFragment() {
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
        this.f61847g = true;
        this.f61849i = true;
        this.f61842a = false;
        this.m = true;
        this.p = false;
        this.q = "wallet_base_multi_window_tips";
        this.r = false;
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
            getActivity().finish();
        }
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void doNetworkTomography(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) {
            com.baidu.wallet.lightapp.ability.b.b.a().a(str, new b.a(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowserFragment.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public boolean f61855a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowserFragment f61856b;

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
                    this.f61856b = this;
                    this.f61855a = false;
                }

                @Override // com.baidu.wallet.lightapp.ability.b.b.a
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.f61855a) {
                        return;
                    }
                    WalletGlobalUtils.showLoadingDialog(this.f61856b.getActivity());
                }

                @Override // com.baidu.wallet.lightapp.ability.b.b.a
                public void a(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (!jSONObject.optBoolean("isOnline", true)) {
                                GlobalUtils.toast(this.f61856b.getContext(), ResUtils.getString(this.f61856b.getActivity(), "network_no_connected"));
                            } else if (!jSONObject.optBoolean("isInternetConnected", true)) {
                                GlobalUtils.toast(this.f61856b.getContext(), ResUtils.getString(this.f61856b.getActivity(), "network_no_internet_connected"));
                            } else {
                                GlobalUtils.toast(this.f61856b.getContext(), ResUtils.getString(this.f61856b.getActivity(), "network_tomography_done"));
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
            }, getContext(), map);
        }
    }

    public void enableProgressStripe(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.m = z;
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
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && this.f61844d != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f61844d.evaluateJavascript(sb.toString(), null);
                    return;
                }
                LightappWebView lightappWebView = this.f61844d;
                lightappWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.wallet.lightapp.multipage.a
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getCellHashStamps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public String getLoadTimeLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void historyGo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isActiveCell() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public boolean isPreloaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void loadAlubm(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.f61844d.canGoBack()) {
            String str = sTag;
            LogUtil.d(str, "cangoback:  " + this.f61844d.getUrl());
            this.f61844d.goBack();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.mInflater = layoutInflater;
            return a();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            LightappJsClient lightappJsClient = this.f61846f;
            if (lightappJsClient != null) {
                lightappJsClient.destroy();
            }
            LightappWebView lightappWebView = this.f61844d;
            if (lightappWebView != null) {
                ViewGroup viewGroup = (ViewGroup) lightappWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f61844d);
                }
                this.f61844d.removeAllViews();
                this.f61844d.destroy();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
    }

    @Override // com.baidu.wallet.lightapp.widget.NoNetView.a
    public void onReloadClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            refresh(str);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048596, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            this.f61846f.onRequestPermissionsResultLocal(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LightappWebView lightappWebView = this.f61844d;
            if (lightappWebView != null) {
                lightappWebView.setDownloadListener(this.f61848h);
            }
            super.onResume();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void openInNewWebView(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, arrayList, i2) == null) {
        }
    }

    public void refresh(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            Context applicationContext = DxmApplicationContextImpl.getApplicationContext(getActivity());
            if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(applicationContext, "ebpay_no_network"));
            } else if (this.f61844d != null) {
                if (!TextUtils.isEmpty(str) && !f61841b.matcher(str).matches()) {
                    str = "https://" + str;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f61844d.reload();
                } else {
                    this.f61843c = str;
                    this.f61844d.loadUrl(str);
                }
                this.f61842a = false;
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void rmFromPreloadPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void selectPhoneFromAddressBook() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, downloadListener) == null) {
            this.f61848h = downloadListener;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str, str2})) == null) {
            return null;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setIsCheckPermission(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || z == this.p) {
            return;
        }
        this.p = z;
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setMenuInMainThread(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, jSONArray) == null) {
        }
    }

    public void setMultiWindowTipsId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setSubMenu(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048610, this, str, str2, str3, i2) == null) {
        }
    }

    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f61844d.getSettings().setSupportZoom(true);
            this.f61844d.getSettings().setBuiltInZoomControls(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f61844d.getSettings().setDisplayZoomControls(false);
            } else {
                setZoomControlGone(this.f61844d);
            }
            this.f61844d.getSettings().setUseWideViewPort(true);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void setTitlesInMainThread(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048612, this, str, str2, z) == null) {
        }
    }

    public void setZoomControlGone(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
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
    }

    public void setmOpenUrlInNewWindow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f61849i = z;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.a
    public void startNewLightApp(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            NoNetView noNetView = this.f61850j;
            if (noNetView != null) {
                noNetView.notifyUrlFinish();
            }
            LightappWebView lightappWebView = this.f61844d;
            if (lightappWebView != null) {
                lightappWebView.setVisibility(0);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.k.setVisibility(0);
            this.k.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
            a(5);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.k.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
        }
    }

    private View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f61843c = arguments.getString("jump_url");
            }
            if (TextUtils.isEmpty(this.f61843c)) {
                return null;
            }
            String trim = this.f61843c.trim();
            this.f61843c = trim;
            if (!f61841b.matcher(trim).matches()) {
                this.f61843c = "https://" + this.f61843c;
            }
            if (this.f61843c.contains("hideNativeErrorPage=1") || this.f61843c.contains("hideNativeErrorPage%3d1")) {
                this.f61847g = false;
            }
            this.n = "";
            this.l = ResUtils.getString(getActivity(), "ebpay_loading");
            ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(ResUtils.layout(getActivity(), "wallet_base_lightapp_webview_fragment"), (ViewGroup) null);
            this.s = viewGroup;
            this.f61845e = (PullToRefreshWebview) viewGroup.findViewById(ResUtils.id(getActivity(), "cust_webview"));
            this.f61845e.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<LightappWebView>(this) { // from class: com.baidu.wallet.lightapp.business.LightappBrowserFragment.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public Handler f61851a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBrowserFragment f61852b;

                /* renamed from: c  reason: collision with root package name */
                public final int f61853c;

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
                    this.f61852b = this;
                    this.f61853c = 1;
                    this.f61851a = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.wallet.lightapp.business.LightappBrowserFragment.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f61854a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, r8};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    super((Looper) newInitContext2.callArgs[0]);
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f61854a = this;
                        }

                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeL(1048576, this, message) == null) && 1 == message.what) {
                                PullToRefreshBase pullToRefreshBase = (PullToRefreshBase) message.obj;
                                if (pullToRefreshBase != null) {
                                    pullToRefreshBase.onPullDownRefreshComplete();
                                }
                                removeMessages(1);
                            }
                        }
                    };
                }

                @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
                public void onPullDownToRefresh(PullToRefreshBase<LightappWebView> pullToRefreshBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, pullToRefreshBase) == null) {
                        pullToRefreshBase.getRefreshableView().reload();
                        Message obtain = Message.obtain();
                        obtain.obj = pullToRefreshBase;
                        obtain.what = 1;
                        this.f61851a.sendMessageDelayed(obtain, 600L);
                    }
                }

                @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
                public void onPullUpToRefresh(PullToRefreshBase<LightappWebView> pullToRefreshBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pullToRefreshBase) == null) {
                    }
                }
            });
            this.f61845e.setPullRefreshEnabled(true);
            this.f61845e.setLoadingAnimationStyle(LoadingLayout.AnimationStyle.ROTATE);
            this.f61844d = this.f61845e.getRefreshableView();
            this.f61850j = (NoNetView) this.s.findViewById(ResUtils.id(getActivity(), "nonet_view"));
            this.k = this.s.findViewById(ResUtils.id(getActivity(), "progress_line"));
            String userAgentString = this.f61844d.getSettings().getUserAgentString();
            LogUtil.logd("ua=" + userAgentString);
            WebSettings settings = this.f61844d.getSettings();
            settings.setUserAgentString(userAgentString + " " + BussinessUtils.getUA(getActivity()));
            StringBuilder sb = new StringBuilder();
            sb.append("ua2=");
            sb.append(this.f61844d.getSettings().getUserAgentString());
            LogUtil.logd(sb.toString());
            this.f61844d.setWebViewClient(new CustomWebViewClient(this));
            this.f61844d.setWebChromeClient(new CustomChromeClient(this));
            this.f61844d.getSettings().setJavaScriptEnabled(true);
            this.f61844d.getSettings().setDomStorageEnabled(true);
            this.f61844d.getSettings().setDatabaseEnabled(true);
            this.f61844d.getSettings().setGeolocationDatabasePath(DxmApplicationContextImpl.getApplicationContext(getActivity()).getDir("database", 0).getPath());
            setSupportZoom();
            this.f61844d.getSettings().setTextZoom(100);
            this.f61844d.getSettings().setGeolocationEnabled(true);
            this.f61844d.setScrollBarStyle(0);
            this.f61844d.clearCache(false);
            this.f61844d.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.f61844d.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f61844d.removeJavascriptInterface("accessibility");
                this.f61844d.removeJavascriptInterface("accessibilityTraversal");
            }
            LightappJsClient lightappJsClient = new LightappJsClient(this, this.f61844d);
            this.f61846f = lightappJsClient;
            this.f61844d.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.f61844d, true);
            }
            this.f61844d.loadUrl(this.f61843c);
            this.f61842a = false;
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && this.f61847g) {
            NoNetView noNetView = this.f61850j;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappWebView lightappWebView = this.f61844d;
            if (lightappWebView != null) {
                lightappWebView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            WalletLoginHelper.getInstance().syncH5LoginStatus(getActivity(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.width = (int) ((DisplayUtils.getDisplayWidth(getActivity()) * i2) / 100.0f);
            this.k.setLayoutParams(layoutParams);
        }
    }
}
