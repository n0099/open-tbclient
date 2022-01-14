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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.HttpsCertVerifyUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.net.URLEncoder;
import java.util.Arrays;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes13.dex */
public abstract class BaseWebViewActivity extends DxmPayBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANNEL_DISCOUNT_PARAMS = "channel_discount_params";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String JUMP_URL = "jump_url";
    public static final String WEBVIEW_TITLE = "webview_title";
    public static final String WEBVIEW_TITLE_STRING = "webview_title_string";
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SafeWebView f52181b;
    public boolean mIsSuccessFlag;

    /* loaded from: classes13.dex */
    public class a extends SafeWebView.SafeChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52182b;

        public a(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebViewActivity;
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i2) == null) {
                if (i2 <= 25) {
                    this.f52182b = false;
                } else if (!this.f52182b) {
                    this.a.f52181b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                    this.f52182b = true;
                    if (BeanConstants.DEBUG) {
                        String unused = BaseWebViewActivity.a;
                        String str = " inject js interface completely on progress " + i2;
                    }
                }
                super.onProgressChanged(webView, i2);
            }
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                if (!this.f52182b) {
                    if (BeanConstants.DEBUG) {
                        String unused = BaseWebViewActivity.a;
                        String str2 = "onReceivedTitle: " + str;
                    }
                    this.a.f52181b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                }
                super.onReceivedTitle(webView, str);
                this.f52182b = true;
                BaseWebViewActivity baseWebViewActivity = this.a;
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.a.getActivity(), "ebpay_bd_my_wallet");
                }
                baseWebViewActivity.a(str);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b extends SafeWebView.SafeWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52183b;

        public b(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebViewActivity;
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
                if (!this.f52183b) {
                    if (BeanConstants.DEBUG) {
                        String unused = BaseWebViewActivity.a;
                        String str2 = "doUpdateVisitedHistory: " + str;
                    }
                    this.a.f52181b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                }
                super.doUpdateVisitedHistory(webView, str, z);
                this.f52183b = true;
            }
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                if (!this.f52183b && BeanConstants.DEBUG) {
                    String unused = BaseWebViewActivity.a;
                    String str2 = "onLoadResource: " + str;
                }
                super.onLoadResource(webView, str);
                this.f52183b = true;
            }
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                if (!this.f52183b) {
                    if (BeanConstants.DEBUG) {
                        String unused = BaseWebViewActivity.a;
                        String str2 = "onPageFinished: " + str;
                    }
                    this.a.f52181b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                }
                super.onPageFinished(webView, str);
                WalletGlobalUtils.safeDismissDialog(this.a, -1);
                this.f52183b = false;
            }
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
                if (!this.f52183b) {
                    if (BeanConstants.DEBUG) {
                        String unused = BaseWebViewActivity.a;
                        String str2 = "onPageStarted: " + str;
                    }
                    this.a.f52181b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                }
                super.onPageStarted(webView, str, bitmap);
                this.f52183b = true;
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, sslErrorHandler, sslError) == null) {
                int primaryError = sslError == null ? 5000 : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                StatisticManager.onEventWithValues("#h5_cashier_ssl_error", Arrays.asList(primaryError + "", url));
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                } else {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            String host;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                Uri parse = Uri.parse(str);
                if (parse == null || !"baiduwalletsimplepay".equals(parse.getScheme()) || (host = parse.getHost()) == null) {
                    return false;
                }
                if (host.startsWith(WapPayActivity.SUCCESS_NOTIFY_METHOD)) {
                    this.a.mIsSuccessFlag = true;
                } else if (host.startsWith(WapPayActivity.CLOSE_VIEW_METHOD)) {
                    this.a.notifyResultMsg();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-909934934, "Lcom/baidu/wallet/paysdk/ui/BaseWebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-909934934, "Lcom/baidu/wallet/paysdk/ui/BaseWebViewActivity;");
                return;
            }
        }
        a = BaseWebViewActivity.class.getSimpleName();
    }

    public BaseWebViewActivity() {
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
        this.mIsSuccessFlag = false;
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    public abstract void notifyResultMsg();

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SafeWebView safeWebView = this.f52181b;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.f52181b.goBack();
                return;
            }
            notifyResultMsg();
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_webview_layout"));
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
                str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/HTML5/eptos.html";
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
                String encryptProxy = SecurePay.getInstance().encryptProxy(PayUtils.getCookie(this));
                str = str3 + "&atbc=" + (!TextUtils.isEmpty(encryptProxy) ? URLEncoder.encode(encryptProxy) : "") + "&key=" + URLEncoder.encode(SecurePay.getInstance().getpwProxy());
                if (extras != null) {
                    String string2 = extras.getString("extra_param");
                    if (!TextUtils.isEmpty(string2)) {
                        str = str + "&" + string2;
                    }
                }
            }
            WalletGlobalUtils.safeShowDialog(this, -1, "");
            SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(getActivity(), "dxm_cust_webview"));
            this.f52181b = safeWebView;
            safeWebView.setWebViewClient(new b());
            if (TextUtils.isEmpty(str2)) {
                this.f52181b.setWebChromeClient(new a());
            }
            this.f52181b.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT <= 18) {
                this.f52181b.getSettings().setSavePassword(false);
            }
            this.f52181b.setScrollBarStyle(0);
            this.f52181b.clearCache(false);
            this.f52181b.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.f52181b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f52181b.removeJavascriptInterface("accessibility");
                this.f52181b.removeJavascriptInterface("accessibilityTraversal");
            }
            if (TextUtils.isEmpty(str)) {
                finish();
                return;
            }
            try {
                this.f52181b.loadUrl(str.trim());
            } catch (Exception unused) {
                finish();
            }
            a(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(str);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BaseWebViewActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseWebViewActivity a;

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
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.a.getActivity());
                    this.a.onBackPressed();
                }
            }
        });
    }
}
