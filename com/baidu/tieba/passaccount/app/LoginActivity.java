package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.AccountBundingActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.atomData.SocialLoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private LinearLayout Mg;
    private SapiWebView cdf;
    private FrameLayout cdh;
    private TextView cdi;
    private View cdj;
    private SapiWebView.VoiceLoginHandler cdk;
    private Handler cdl;
    private View mBack;
    private NavigationBar mNavigationBar;
    private boolean cdg = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.k auv = null;
    private final CustomMessageListener cdm = new j(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0040a XS = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.cdg = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.cdm);
        adX();
    }

    protected void adX() {
        this.Mg = (LinearLayout) findViewById(i.f.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.sapi_login_navi);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.login));
        this.cdj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.cdi = (TextView) this.cdj.findViewById(i.f.right_textview);
        this.cdi.setText(getPageContext().getString(i.h.account_regedit));
        an.b(this.cdi, i.c.navi_op_text, 1);
        this.cdi.setOnClickListener(this);
        this.cdh = (FrameLayout) findViewById(i.f.webview_container);
        this.cdf = new SapiWebView(getPageContext().getPageActivity());
        this.cdh.removeAllViews();
        this.cdh.addView(this.cdf);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.cdf);
        this.cdf.setOnFinishCallback(new n(this));
        this.cdf.setAuthorizationListener(new o(this));
        this.cdk = new p(this);
        this.cdf.setVoiceLoginHandler(this.cdk);
        this.cdl = new q(this);
        this.cdf.setSocialLoginHandler(this.cdl);
        this.cdf.loadLogin();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bd.a((View) this.cdf, i.c.cp_link_tip_b, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.cdi) {
            if (this.mFrom == 2) {
                finish();
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.cdf.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aea();
            } else if (i2 == 230014 && intent != null) {
                jw(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                FX();
                adY();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aea() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            adZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(i.h.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adY() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.cdg) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adZ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.rd().a(session.username, session.bduss, session.ptoken, this.XS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        if (this.auv == null) {
            this.auv = new com.baidu.tbadk.coreExtra.view.k(getPageContext());
            this.auv.a(new r(this));
        }
        this.auv.yR();
        this.auv.h(accountData);
        this.auv.yN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.j(this.Mg, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FX() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hh().b(new s(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.auv != null) {
            this.auv.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Mg != null) {
            this.Mg.removeAllViews();
        }
        aeb();
        super.onDestroy();
    }

    public void aeb() {
        if (this.cdl != null) {
            this.cdl.removeCallbacksAndMessages(null);
        }
        if (this.cdh != null) {
            this.cdh.removeAllViews();
        }
        if (this.cdf != null) {
            this.cdf.setAuthorizationListener(null);
            this.cdf.setVoiceLoginHandler(null);
            this.cdf.setSocialLoginHandler(null);
            this.cdf.setOnBackCallback(null);
            this.cdf.setOnFinishCallback(null);
            this.cdf.getSettings().setBuiltInZoomControls(true);
            this.cdf.setVisibility(8);
            com.baidu.adp.lib.g.h.hg().postDelayed(new t(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FY() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }
}
