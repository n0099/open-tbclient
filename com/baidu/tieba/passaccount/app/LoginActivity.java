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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private LinearLayout Gs;
    private BdAsyncTask<?, ?, ?> aRG;
    private View ajw;
    private View byX;
    private SapiWebView egN;
    private FrameLayout egP;
    private TextView egQ;
    private SapiWebView.VoiceLoginHandler egR;
    private Handler egS;
    private NavigationBar mNavigationBar;
    private boolean egO = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j azc = null;
    private final CustomMessageListener egT = new k(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0033a XY = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.egO = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.egT);
        setupViews();
    }

    protected void setupViews() {
        this.Gs = (LinearLayout) findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_login_navi);
        this.ajw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ajw.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.login));
        this.byX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.egQ = (TextView) this.byX.findViewById(t.g.right_textview);
        this.egQ.setText(getPageContext().getString(t.j.account_regedit));
        av.c(this.egQ, t.d.navi_op_text, 1);
        this.egQ.setOnClickListener(this);
        this.egP = (FrameLayout) findViewById(t.g.webview_container);
        this.egN = new SapiWebView(getPageContext().getPageActivity());
        this.egP.removeAllViews();
        this.egP.addView(this.egN);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.egN);
        this.egN.setOnFinishCallback(new o(this));
        this.egN.setAuthorizationListener(new p(this));
        this.egR = new q(this);
        this.egN.setVoiceLoginHandler(this.egR);
        this.egS = new r(this);
        this.egN.setSocialLoginHandler(this.egS);
        this.egN.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajw) {
            finish();
        } else if (view == this.egQ) {
            if (this.mFrom == 2) {
                finish();
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
            }
        }
    }

    private void u(Intent intent) {
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
        u(intent);
        this.egN.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aKR();
            } else if (i2 == 230014 && intent != null) {
                oB(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                LC();
                aKP();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKR() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aKQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oB(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(t.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKP() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m9getInst().onUserChanged();
        if (this.egO) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKQ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aRG != null) {
                this.aRG.cancel();
            }
            this.aRG = com.baidu.tbadk.core.a.a.oO().a(session.username, session.bduss, "", null, this.XY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.azc == null) {
            this.azc = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.azc.a(new s(this));
        }
        this.azc.AL();
        this.azc.i(accountData);
        this.azc.AH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.Gs, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC() {
        if (this.mFrom == 3 && TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.eH().e(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.azc != null) {
            this.azc.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Gs != null) {
            this.Gs.removeAllViews();
        }
        aKS();
        if (this.aRG != null) {
            this.aRG.cancel();
        }
        super.onDestroy();
    }

    public void aKS() {
        if (this.egS != null) {
            this.egS.removeCallbacksAndMessages(null);
        }
        if (this.egP != null) {
            this.egP.removeAllViews();
        }
        if (this.egN != null) {
            this.egN.setAuthorizationListener(null);
            this.egN.setVoiceLoginHandler(null);
            this.egN.setSocialLoginHandler(null);
            this.egN.setOnBackCallback(null);
            this.egN.setOnFinishCallback(null);
            this.egN.getSettings().setBuiltInZoomControls(true);
            this.egN.setVisibility(8);
            com.baidu.adp.lib.h.h.eG().postDelayed(new u(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LD() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean OJ = com.baidu.tieba.d.a.OI().OJ();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null && OJ) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }
}
