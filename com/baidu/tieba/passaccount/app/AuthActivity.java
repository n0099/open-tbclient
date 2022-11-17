package com.baidu.tieba.passaccount.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.fw7;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AuthActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SapiResult t;
    public int u;
    public String v;
    public String w;
    public String x;

    /* loaded from: classes5.dex */
    public class a implements SapiWebView.OnBackCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthActivity a;

        public a(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SapiWebView.OnFinishCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthActivity a;

        public b(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onClose();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SapiWebView.WebviewClientCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthActivity a;

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            }
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void shouldOverrideUrlLoading(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            }
        }

        public c(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) && str != null && str.contains("__wp-action=auth-widget")) {
                String queryParameter = Uri.parse(str).getQueryParameter("authsid");
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                this.a.i(true, queryParameter);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SapiWebView.ChangePwdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthActivity a;

        public d(AuthActivity authActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authActivity;
        }

        @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i(true, null);
        }
    }

    public AuthActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new SapiResult();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
            } else {
                onClose();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onClose();
            this.t.setResultCode(-301);
            this.t.setResultMsg("流程已结束");
            i(false, null);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                n();
            }
        }
    }

    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return new String(Base64.decode(str.getBytes(), 0));
        }
        return (String) invokeL.objValue;
    }

    public final void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
            int i = this.u;
            if (i == 0) {
                fw7.f().b(z, str);
            } else if (i == 1) {
                fw7.f().e(z);
            } else if (i == 2) {
                fw7.f().c(z);
            } else {
                fw7.f().a(null);
            }
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.init();
            int intExtra = getIntent().getIntExtra("EXTRA_TYPE", 0);
            this.u = intExtra;
            if (intExtra == 0) {
                this.v = getIntent().getStringExtra("EXTRA_AUTH_TOKEN");
                this.x = SapiAccountManager.getInstance().getSapiConfiguration().getTpl();
                if (TextUtils.isEmpty(this.v) || TextUtils.isEmpty(this.x)) {
                    this.t.setResultCode(-204);
                    this.t.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                    i(false, null);
                }
            } else if (intExtra != 1 && intExtra != 2) {
                this.t.setResultCode(-204);
                this.t.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                i(false, null);
            } else {
                this.w = getIntent().getStringExtra("EXTRA_BDUSS");
                this.x = SapiAccountManager.getInstance().getSapiConfiguration().getTpl();
                if (TextUtils.isEmpty(this.w)) {
                    this.t.setResultCode(-204);
                    this.t.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                    i(false, null);
                }
            }
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("adapter", URLEncoder.encode("3", "UTF-8")));
                arrayList.add(new PassNameValuePair(SpeedStatsUtils.UBC_VALUE_BANNER, "1"));
                arrayList.add(new PassNameValuePair("isnew", "true"));
                arrayList.add(new PassNameValuePair("token", URLEncoder.encode(this.v, "UTF-8")));
                arrayList.add(new PassNameValuePair("tpl", URLEncoder.encode(this.x, "UTF-8")));
                arrayList.add(new PassNameValuePair("u", URLEncoder.encode(l(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + SapiWebView.CALLBACK_PARAM_KEY + "=auth-widget", "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
            Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
            return (environment.getWap() + "/passport/authwidget") + "?" + SapiUtils.createRequestParams(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("u", URLEncoder.encode(l(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + SapiWebView.CALLBACK_PARAM_KEY + "=" + SapiWebView.ACTION_MODIFY_PWD, "UTF-8")));
                arrayList.add(new PassNameValuePair("adapter", "3"));
                arrayList.add(new PassNameValuePair(SpeedStatsUtils.UBC_VALUE_BANNER, "1"));
                arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
                arrayList.add(new PassNameValuePair("tpl", URLEncoder.encode(this.x, "UTF-8")));
                arrayList.add(new PassNameValuePair("client", "android"));
                arrayList.add(new PassNameValuePair("clientfrom", "native"));
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
            Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
            String str = (environment.getWap() + "/wp/passwordindex") + "?" + SapiUtils.createRequestParams(arrayList);
            if (arrayList.size() > 0) {
                return str + "&" + SapiUtils.createRequestParams(arrayList);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final List<PassNameValuePair> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
            String buildBDUSSCookie = SapiUtils.buildBDUSSCookie(environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(environment.getWap(), buildBDUSSCookie));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(R.layout.obfuscated_res_0x7f0d0516);
                PassManagerStatic.A();
                init();
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.t.setResultCode(-202);
                this.t.setResultMsg("网络连接失败，请检查网络设置");
                i(false, null);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.setupViews();
            setBtnVisibility(4, 0, 4);
            this.sapiWebView.setOnBackCallback(new a(this));
            this.sapiWebView.setOnFinishCallback(new b(this));
            int i = this.u;
            if (i == 0) {
                setTitleText("身份验证");
                this.sapiWebView.setWebviewClientCallback(new c(this));
                this.sapiWebView.loadUrl(j());
            } else if (i == 1) {
                setTitleText(R.string.obfuscated_res_0x7f0f0b18);
                SapiAccountManager.getInstance().getAccountService().webLogin(this, this.w);
                this.sapiWebView.loadUrl(m(), k());
                this.sapiWebView.setChangePwdCallback(new d(this));
            } else if (i == 2) {
                setTitleText("绑定手机");
                this.sapiWebView.loadBindWidget(BindWidgetAction.BIND_MOBILE, this.w, null, true, null);
            } else {
                i(false, null);
            }
        }
    }
}
