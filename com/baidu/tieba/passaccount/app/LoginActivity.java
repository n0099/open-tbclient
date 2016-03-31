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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private LinearLayout Nm;
    private BdAsyncTask<?, ?, ?> aLL;
    private View ajA;
    private View cZA;
    private SapiWebView.VoiceLoginHandler cZB;
    private Handler cZC;
    private SapiWebView cZw;
    private FrameLayout cZy;
    private TextView cZz;
    private NavigationBar mNavigationBar;
    private boolean cZx = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j ayp = null;
    private final CustomMessageListener cZD = new j(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0042a YU = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.cZx = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.cZD);
        setupViews();
    }

    protected void setupViews() {
        this.Nm = (LinearLayout) findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_login_navi);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ajA.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.login));
        this.cZA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.cZz = (TextView) this.cZA.findViewById(t.g.right_textview);
        this.cZz.setText(getPageContext().getString(t.j.account_regedit));
        at.b(this.cZz, t.d.navi_op_text, 1);
        this.cZz.setOnClickListener(this);
        this.cZy = (FrameLayout) findViewById(t.g.webview_container);
        this.cZw = new SapiWebView(getPageContext().getPageActivity());
        this.cZy.removeAllViews();
        this.cZy.addView(this.cZw);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.cZw);
        this.cZw.setOnFinishCallback(new n(this));
        this.cZw.setAuthorizationListener(new o(this));
        this.cZB = new p(this);
        this.cZw.setVoiceLoginHandler(this.cZB);
        this.cZC = new q(this);
        this.cZw.setSocialLoginHandler(this.cZC);
        this.cZw.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajA) {
            finish();
        } else if (view == this.cZz) {
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
        this.cZw.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                auB();
            } else if (i2 == 230014 && intent != null) {
                lB(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                JJ();
                auz();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auB() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            auA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(t.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auz() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.cZx) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auA() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aLL != null) {
                this.aLL.cancel();
            }
            this.aLL = com.baidu.tbadk.core.a.a.qM().a(session.username, session.bduss, session.ptoken, this.YU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.ayp == null) {
            this.ayp = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.ayp.a(new r(this));
        }
        this.ayp.Bw();
        this.ayp.h(accountData);
        this.ayp.Bs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.l(this.Nm, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hy().b(new s(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ayp != null) {
            this.ayp.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Nm != null) {
            this.Nm.removeAllViews();
        }
        auC();
        if (this.aLL != null) {
            this.aLL.cancel();
        }
        super.onDestroy();
    }

    public void auC() {
        if (this.cZC != null) {
            this.cZC.removeCallbacksAndMessages(null);
        }
        if (this.cZy != null) {
            this.cZy.removeAllViews();
        }
        if (this.cZw != null) {
            this.cZw.setAuthorizationListener(null);
            this.cZw.setVoiceLoginHandler(null);
            this.cZw.setSocialLoginHandler(null);
            this.cZw.setOnBackCallback(null);
            this.cZw.setOnFinishCallback(null);
            this.cZw.getSettings().setBuiltInZoomControls(true);
            this.cZw.setVisibility(8);
            com.baidu.adp.lib.h.h.hx().postDelayed(new t(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean Mx = com.baidu.tieba.a.a.Mw().Mx();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null && Mx) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }
}
