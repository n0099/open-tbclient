package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class QALoginActivity extends BaseActivity {
    private BdAsyncTask<?, ?, ?> aVh;
    private WebView mWebView;
    private String xo = "";
    private String tbs = "";
    private String eeK = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
    private String eeL = "http://wappass.qatest.baidu.com/passport/?login&u=https://tieba.baidu.com";
    private boolean eeA = false;
    private int mFrom = -1;
    private final a.InterfaceC0031a acF = new u(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.eeA = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        initView();
        MV();
        initData();
    }

    public void initView() {
        this.mWebView = new WebView(getPageContext().getPageActivity());
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        setContentView(this.mWebView);
    }

    public void initData() {
        this.mWebView.loadUrl(this.eeL);
    }

    public void MV() {
        this.mWebView.setWebViewClient(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        if (this.aVh != null) {
            this.aVh.cancel();
        }
        this.aVh = com.baidu.tieba.model.b.b("", this.xo, "", null, this.acF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LA() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m9getInst().onUserChanged();
        if (this.eeA) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }
}
