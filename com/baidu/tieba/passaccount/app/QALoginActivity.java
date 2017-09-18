package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class QALoginActivity extends BaseActivity {
    private BdAsyncTask<?, ?, ?> aWK;
    private WebView mWebView;
    private String wq = "";
    private String tbs = "";
    private String eBO = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
    private String eBP = "http://wappass.qatest.baidu.com/passport/?login&u=https://tieba.baidu.com";
    private boolean eBE = false;
    private int mFrom = -1;
    private final a.InterfaceC0043a aeb = new a.InterfaceC0043a() { // from class: com.baidu.tieba.passaccount.app.QALoginActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
        public void cp(String str) {
            if (QALoginActivity.this.getLoadingDialog() == null || !QALoginActivity.this.getLoadingDialog().isShowing()) {
                QALoginActivity.this.showLoadingDialog(QALoginActivity.this.getPageContext().getString(d.l.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.QALoginActivity.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        QALoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            QALoginActivity.this.closeLoadingDialog();
            if (TextUtils.isEmpty(accountData.getAccount())) {
                QALoginActivity.this.showToast("用户名为空");
                return;
            }
            q(accountData);
            if (QALoginActivity.this.mFrom == 4) {
                QALoginActivity.this.Le();
            } else {
                QALoginActivity.this.aOi();
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            QALoginActivity.this.closeLoadingDialog();
            QALoginActivity.this.showToast(str2);
            QALoginActivity.this.finish();
        }

        private void q(final AccountData accountData) {
            h.fR().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.QALoginActivity.2.2
                @Override // java.lang.Runnable
                public void run() {
                    b.b(accountData);
                }
            });
            TbadkCoreApplication.setCurrentAccount(accountData, QALoginActivity.this.getPageContext().getPageActivity());
            com.baidu.tbadk.browser.a.ay(TbadkCoreApplication.getInst());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.eBE = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        initView();
        initListener();
        initData();
    }

    public void initView() {
        this.mWebView = new WebView(getPageContext().getPageActivity());
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        setContentView(this.mWebView);
    }

    public void initData() {
        this.mWebView.loadUrl(this.eBP);
    }

    public void initListener() {
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.passaccount.app.QALoginActivity.1
            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (str.startsWith(QALoginActivity.this.eBO) || str.startsWith("https://tieba.baidu.com")) {
                    String cookie = CookieManager.getInstance().getCookie(str);
                    if (cookie.contains("BDUSS=")) {
                        String[] split = cookie.split("=");
                        int i = 0;
                        while (true) {
                            if (i < split.length) {
                                if (!split[i].contains("BDUSS") || i + 1 >= split.length) {
                                    i++;
                                } else {
                                    QALoginActivity.this.wq = split[i + 1];
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (QALoginActivity.this.wq != null && QALoginActivity.this.wq.length() > 0) {
                        QALoginActivity.this.aOj();
                        return;
                    }
                    QALoginActivity.this.showToast("登录失败");
                    if (i.hi() && QALoginActivity.this.mWebView != null) {
                        QALoginActivity.this.mWebView.reload();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOj() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        if (this.aWK != null) {
            this.aWK.cancel();
        }
        this.aWK = com.baidu.tieba.model.b.b("", this.wq, "", null, this.aeb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le() {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOi() {
        int i = 1;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged();
        if (this.eBE) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }
}
