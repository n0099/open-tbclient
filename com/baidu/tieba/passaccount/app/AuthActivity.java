package com.baidu.tieba.passaccount.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.a.f;
import d.a.c0.a.g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AuthActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_AUTH_TOKEN = "EXTRA_AUTH_TOKEN";
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_TYPE = "EXTRA_TYPE";
    public static final String PASS_AUTH_WIDGET_URL_PATH = "/passport/authwidget";
    public static final String PASS_MODIFY_PWD_URL_PATH = "/wp/passwordindex";
    public static final int TYPE_AUTH_TOKEN = 0;
    public static final int TYPE_BIND_MOBILE = 2;
    public static final int TYPE_MODIFY_PWD = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String authToken;
    public String bduss;
    public SapiResult result;
    public String tpl;
    public int type;

    /* loaded from: classes4.dex */
    public class a implements SapiWebView.OnBackCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthActivity f19143a;

        public a(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19143a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19143a.goBack();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SapiWebView.OnFinishCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthActivity f19144a;

        public b(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19144a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19144a.onClose();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements SapiWebView.WebviewClientCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthActivity f19145a;

        public c(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19145a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            }
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) && str != null && str.contains("__wp-action=auth-widget")) {
                String queryParameter = Uri.parse(str).getQueryParameter("authsid");
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                this.f19145a.finishActivity(true, queryParameter);
            }
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void shouldOverrideUrlLoading(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements SapiWebView.ChangePwdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthActivity f19146a;

        public d(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19146a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19146a.finishActivity(true, null);
            }
        }
    }

    public AuthActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.result = new SapiResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65539, this, z, str) == null) {
            int i2 = this.type;
            if (i2 == 0) {
                d.a.q0.f2.d.b.f().b(z, str);
            } else if (i2 == 1) {
                d.a.q0.f2.d.b.f().e(z);
            } else if (i2 == 2) {
                d.a.q0.f2.d.b.f().c(z);
            } else {
                d.a.q0.f2.d.b.f().a(null);
            }
            finish();
        }
    }

    private String getAuthUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("adapter", URLEncoder.encode("3", "UTF-8")));
                arrayList.add(new PassNameValuePair("banner", "1"));
                arrayList.add(new PassNameValuePair("isnew", "true"));
                arrayList.add(new PassNameValuePair("token", URLEncoder.encode(this.authToken, "UTF-8")));
                arrayList.add(new PassNameValuePair("tpl", URLEncoder.encode(this.tpl, "UTF-8")));
                arrayList.add(new PassNameValuePair("u", URLEncoder.encode(getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + SapiWebView.CALLBACK_PARAM_KEY + "=auth-widget", "UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
            return (environment.getWap() + PASS_AUTH_WIDGET_URL_PATH) + "?" + SapiUtils.createRequestParams(arrayList);
        }
        return (String) invokeV.objValue;
    }

    private List<PassNameValuePair> getBindBdussCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
            String buildBDUSSCookie = SapiUtils.buildBDUSSCookie(environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(environment.getWap(), buildBDUSSCookie));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private String getModifyPwdUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("u", URLEncoder.encode(getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + SapiWebView.CALLBACK_PARAM_KEY + "=" + SapiWebView.ACTION_MODIFY_PWD, "UTF-8")));
                arrayList.add(new PassNameValuePair("adapter", "3"));
                arrayList.add(new PassNameValuePair("banner", "1"));
                arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
                arrayList.add(new PassNameValuePair("tpl", URLEncoder.encode(this.tpl, "UTF-8")));
                arrayList.add(new PassNameValuePair("client", "android"));
                arrayList.add(new PassNameValuePair("clientfrom", "native"));
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
            String str = (environment.getWap() + PASS_MODIFY_PWD_URL_PATH) + "?" + SapiUtils.createRequestParams(arrayList);
            if (arrayList.size() > 0) {
                return str + "&" + SapiUtils.createRequestParams(arrayList);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
            } else {
                onClose();
            }
        }
    }

    public String getHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new String(Base64.decode(str.getBytes(), 0)) : (String) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.init();
            int intExtra = getIntent().getIntExtra(EXTRA_TYPE, 0);
            this.type = intExtra;
            if (intExtra == 0) {
                this.authToken = getIntent().getStringExtra(EXTRA_AUTH_TOKEN);
                this.tpl = SapiAccountManager.getInstance().getSapiConfiguration().getTpl();
                if (TextUtils.isEmpty(this.authToken) || TextUtils.isEmpty(this.tpl)) {
                    this.result.setResultCode(-204);
                    this.result.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                    finishActivity(false, null);
                }
            } else if (intExtra != 1 && intExtra != 2) {
                this.result.setResultCode(-204);
                this.result.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                finishActivity(false, null);
            } else {
                this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
                this.tpl = SapiAccountManager.getInstance().getSapiConfiguration().getTpl();
                if (TextUtils.isEmpty(this.bduss)) {
                    this.result.setResultCode(-204);
                    this.result.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                    finishActivity(false, null);
                }
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onClose();
            this.result.setResultCode(-301);
            this.result.setResultMsg("流程已结束");
            finishActivity(false, null);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                PassManagerStatic.z();
                init();
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.result.setResultCode(-202);
                this.result.setResultMsg("网络连接失败，请检查网络设置");
                finishActivity(false, null);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                goBack();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.setupViews();
            setBtnVisibility(4, 0, 4);
            this.sapiWebView.setOnBackCallback(new a(this));
            this.sapiWebView.setOnFinishCallback(new b(this));
            int i2 = this.type;
            if (i2 == 0) {
                setTitleText("身份验证");
                this.sapiWebView.setWebviewClientCallback(new c(this));
                this.sapiWebView.loadUrl(getAuthUrl());
            } else if (i2 == 1) {
                setTitleText(g.sapi_sdk_title_modify_pwd);
                SapiAccountManager.getInstance().getAccountService().webLogin(this, this.bduss);
                this.sapiWebView.loadUrl(getModifyPwdUrl(), getBindBdussCookies());
                this.sapiWebView.setChangePwdCallback(new d(this));
            } else if (i2 == 2) {
                setTitleText("绑定手机");
                this.sapiWebView.loadBindWidget(BindWidgetAction.BIND_MOBILE, this.bduss, null, true, null);
            } else {
                finishActivity(false, null);
            }
        }
    }
}
