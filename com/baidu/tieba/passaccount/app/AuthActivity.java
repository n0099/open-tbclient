package com.baidu.tieba.passaccount.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.baidu.l.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.f;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class AuthActivity extends BaseActivity {
    private String authToken;
    private String bduss;
    private SapiResult lxd = new SapiResult();
    private String tpl;
    private int type;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            PassManagerStatic.dlT();
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.lxd.setResultCode(-202);
            this.lxd.setResultMsg("网络连接失败，请检查网络设置");
            x(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.type = getIntent().getIntExtra("EXTRA_TYPE", 0);
        if (this.type == 0) {
            this.authToken = getIntent().getStringExtra("EXTRA_AUTH_TOKEN");
            this.tpl = SapiAccountManager.getInstance().getSapiConfiguration().getTpl();
            if (TextUtils.isEmpty(this.authToken) || TextUtils.isEmpty(this.tpl)) {
                this.lxd.setResultCode(-204);
                this.lxd.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                x(false, null);
            }
        } else if (this.type == 1 || this.type == 2) {
            this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
            this.tpl = SapiAccountManager.getInstance().getSapiConfiguration().getTpl();
            if (TextUtils.isEmpty(this.bduss)) {
                this.lxd.setResultCode(-204);
                this.lxd.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                x(false, null);
            }
        } else {
            this.lxd.setResultCode(-204);
            this.lxd.setResultMsg(PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
            x(false, null);
        }
    }

    public String getHost(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    private String dlE() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("adapter", URLEncoder.encode("3", "UTF-8")));
            arrayList.add(new PassNameValuePair("banner", "1"));
            arrayList.add(new PassNameValuePair("isnew", "true"));
            arrayList.add(new PassNameValuePair("token", URLEncoder.encode(this.authToken, "UTF-8")));
            arrayList.add(new PassNameValuePair("tpl", URLEncoder.encode(this.tpl, "UTF-8")));
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(getHost(f.l) + "?__wp-action=auth-widget", "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            Log.e(e);
        }
        return (SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap() + "/passport/authwidget") + "?" + SapiUtils.createRequestParams(arrayList);
    }

    private String dlF() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(getHost(f.l) + "?__wp-action=modify-pwd", "UTF-8")));
            arrayList.add(new PassNameValuePair("adapter", "3"));
            arrayList.add(new PassNameValuePair("banner", "1"));
            arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
            arrayList.add(new PassNameValuePair("tpl", URLEncoder.encode(this.tpl, "UTF-8")));
            arrayList.add(new PassNameValuePair("client", "android"));
            arrayList.add(new PassNameValuePair("clientfrom", "native"));
        } catch (UnsupportedEncodingException e) {
            Log.e(e);
        }
        String str = (SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap() + "/wp/passwordindex") + "?" + SapiUtils.createRequestParams(arrayList);
        if (arrayList.size() > 0) {
            return str + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        return str;
    }

    private List<PassNameValuePair> dlG() {
        Domain environment = SapiAccountManager.getInstance().getConfignation().getEnvironment();
        String buildBDUSSCookie = SapiUtils.buildBDUSSCookie(environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(environment.getWap(), buildBDUSSCookie));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setBtnVisibility(4, 0, 4);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.passaccount.app.AuthActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                AuthActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.AuthActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AuthActivity.this.onClose();
            }
        });
        if (this.type == 0) {
            setTitleText("身份验证");
            this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() { // from class: com.baidu.tieba.passaccount.app.AuthActivity.3
                @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
                public void shouldOverrideUrlLoading(WebView webView, String str) {
                }

                @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    if (str != null && str.contains("__wp-action=auth-widget")) {
                        String queryParameter = Uri.parse(str).getQueryParameter("authsid");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            AuthActivity.this.x(true, queryParameter);
                        }
                    }
                }

                @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
                public void onPageFinished(WebView webView, String str) {
                }
            });
            this.sapiWebView.loadUrl(dlE());
        } else if (this.type == 1) {
            setTitleText(a.g.sapi_sdk_title_modify_pwd);
            SapiAccountManager.getInstance().getAccountService().webLogin(this, this.bduss);
            this.sapiWebView.loadUrl(dlF(), dlG());
            this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback() { // from class: com.baidu.tieba.passaccount.app.AuthActivity.4
                @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
                public void onSuccess() {
                    AuthActivity.this.x(true, null);
                }
            });
        } else if (this.type == 2) {
            setTitleText("绑定手机");
            this.sapiWebView.loadBindWidget(BindWidgetAction.BIND_MOBILE, this.bduss, null, true, null);
        } else {
            x(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.lxd.setResultCode(-301);
        this.lxd.setResultMsg("流程已结束");
        x(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, String str) {
        if (this.type == 0) {
            b.dlY().z(z, str);
        } else if (this.type == 1) {
            b.dlY().um(z);
        } else if (this.type == 2) {
            b.dlY().un(z);
        } else {
            b.dlY().a((j.c) null);
        }
        finish();
    }
}
