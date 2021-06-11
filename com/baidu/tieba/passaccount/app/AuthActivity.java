package com.baidu.tieba.passaccount.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
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
import d.a.a0.a.f;
import d.a.a0.a.g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AuthActivity extends BaseActivity {
    public static final String EXTRA_AUTH_TOKEN = "EXTRA_AUTH_TOKEN";
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_TYPE = "EXTRA_TYPE";
    public static final String PASS_AUTH_WIDGET_URL_PATH = "/passport/authwidget";
    public static final String PASS_MODIFY_PWD_URL_PATH = "/wp/passwordindex";
    public static final int TYPE_AUTH_TOKEN = 0;
    public static final int TYPE_BIND_MOBILE = 2;
    public static final int TYPE_MODIFY_PWD = 1;
    public String authToken;
    public String bduss;
    public SapiResult result = new SapiResult();
    public String tpl;
    public int type;

    /* loaded from: classes5.dex */
    public class a implements SapiWebView.OnBackCallback {
        public a() {
        }

        @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
        public void onBack() {
            AuthActivity.this.goBack();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SapiWebView.OnFinishCallback {
        public b() {
        }

        @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
        public void onFinish() {
            AuthActivity.this.onClose();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SapiWebView.WebviewClientCallback {
        public c() {
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void onPageFinished(WebView webView, String str) {
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (str == null || !str.contains("__wp-action=auth-widget")) {
                return;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("authsid");
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            AuthActivity.this.finishActivity(true, queryParameter);
        }

        @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
        public void shouldOverrideUrlLoading(WebView webView, String str) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SapiWebView.ChangePwdCallback {
        public d() {
        }

        @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
        public void onSuccess() {
            AuthActivity.this.finishActivity(true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z, String str) {
        int i2 = this.type;
        if (i2 == 0) {
            d.a.n0.c2.d.b.f().b(z, str);
        } else if (i2 == 1) {
            d.a.n0.c2.d.b.f().e(z);
        } else if (i2 == 2) {
            d.a.n0.c2.d.b.f().c(z);
        } else {
            d.a.n0.c2.d.b.f().a(null);
        }
        finish();
    }

    private String getAuthUrl() {
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

    private List<PassNameValuePair> getBindBdussCookies() {
        Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
        String buildBDUSSCookie = SapiUtils.buildBDUSSCookie(environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(environment.getWap(), buildBDUSSCookie));
        return arrayList;
    }

    private String getModifyPwdUrl() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    public String getHost(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.result.setResultCode(-301);
        this.result.setResultMsg("流程已结束");
        finishActivity(false, null);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setBtnVisibility(4, 0, 4);
        this.sapiWebView.setOnBackCallback(new a());
        this.sapiWebView.setOnFinishCallback(new b());
        int i2 = this.type;
        if (i2 == 0) {
            setTitleText("身份验证");
            this.sapiWebView.setWebviewClientCallback(new c());
            this.sapiWebView.loadUrl(getAuthUrl());
        } else if (i2 == 1) {
            setTitleText(g.sapi_sdk_title_modify_pwd);
            SapiAccountManager.getInstance().getAccountService().webLogin(this, this.bduss);
            this.sapiWebView.loadUrl(getModifyPwdUrl(), getBindBdussCookies());
            this.sapiWebView.setChangePwdCallback(new d());
        } else if (i2 == 2) {
            setTitleText("绑定手机");
            this.sapiWebView.loadBindWidget(BindWidgetAction.BIND_MOBILE, this.bduss, null, true, null);
        } else {
            finishActivity(false, null);
        }
    }
}
