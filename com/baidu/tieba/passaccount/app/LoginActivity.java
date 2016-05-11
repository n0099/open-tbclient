package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
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
    private LinearLayout DE;
    private BdAsyncTask<?, ?, ?> aHW;
    private View afm;
    private SapiWebView dbR;
    private FrameLayout dbT;
    private TextView dbU;
    private View dbV;
    private SapiWebView.VoiceLoginHandler dbW;
    private Handler dbX;
    private NavigationBar mNavigationBar;
    private boolean dbS = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j auq = null;
    private final CustomMessageListener dbY = new k(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0033a Uk = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.dbS = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.dbY);
        setupViews();
    }

    protected void setupViews() {
        this.DE = (LinearLayout) findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_login_navi);
        this.afm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.afm.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.login));
        this.dbV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.dbU = (TextView) this.dbV.findViewById(t.g.right_textview);
        this.dbU.setText(getPageContext().getString(t.j.account_regedit));
        at.c(this.dbU, t.d.navi_op_text, 1);
        this.dbU.setOnClickListener(this);
        this.dbT = (FrameLayout) findViewById(t.g.webview_container);
        this.dbR = new SapiWebView(getPageContext().getPageActivity());
        this.dbT.removeAllViews();
        this.dbT.addView(this.dbR);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dbR);
        this.dbR.setOnFinishCallback(new o(this));
        this.dbR.setAuthorizationListener(new p(this));
        this.dbW = new q(this);
        this.dbR.setVoiceLoginHandler(this.dbW);
        this.dbX = new r(this);
        this.dbR.setSocialLoginHandler(this.dbX);
        this.dbR.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.afm) {
            finish();
        } else if (view == this.dbU) {
            if (this.mFrom == 2) {
                finish();
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
            }
        }
    }

    private void r(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG);
            int intExtra = intent.getIntExtra(SocialLoginActivityConfig.RESULT_CODE, -100);
            Log.e("LoginActivity", "Intent:" + intent.toString());
            Log.e("LoginActivity", "Message:" + stringExtra);
            Log.e("LoginActivity", "Code:" + intExtra);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.e("LoginActivity", "onActivityResult   RequestCode:" + i + "  ResultCode:" + i2);
        r(intent);
        this.dbR.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                auH();
            } else if (i2 == 230014 && intent != null) {
                lF(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                Ia();
                auF();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auH() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            auG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(t.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auF() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m11getInst().onUserChanged();
        if (this.dbS) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auG() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aHW != null) {
                this.aHW.cancel();
            }
            this.aHW = com.baidu.tbadk.core.a.a.oj().a(session.username, session.bduss, "", this.Uk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.auq == null) {
            this.auq = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.auq.a(new s(this));
        }
        this.auq.zq();
        this.auq.h(accountData);
        this.auq.zm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.l(this.DE, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia() {
        if (this.mFrom == 3 && TbadkCoreApplication.m11getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dM().b(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.auq != null) {
            this.auq.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.DE != null) {
            this.DE.removeAllViews();
        }
        auI();
        if (this.aHW != null) {
            this.aHW.cancel();
        }
        super.onDestroy();
    }

    public void auI() {
        if (this.dbX != null) {
            this.dbX.removeCallbacksAndMessages(null);
        }
        if (this.dbT != null) {
            this.dbT.removeAllViews();
        }
        if (this.dbR != null) {
            this.dbR.setAuthorizationListener(null);
            this.dbR.setVoiceLoginHandler(null);
            this.dbR.setSocialLoginHandler(null);
            this.dbR.setOnBackCallback(null);
            this.dbR.setOnFinishCallback(null);
            this.dbR.getSettings().setBuiltInZoomControls(true);
            this.dbR.setVisibility(8);
            com.baidu.adp.lib.h.h.dL().postDelayed(new u(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m11getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean Lg = com.baidu.tieba.b.a.Lf().Lg();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null && Lg) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }
}
