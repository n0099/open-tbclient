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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private BdAsyncTask<?, ?, ?> aVS;
    private View aor;
    private SapiWebView dZI;
    private FrameLayout dZL;
    private TextView dZM;
    private View dZN;
    private Handler dZO;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootLayout;
    private boolean dZJ = false;
    private int mFrom = -1;
    private int dZK = -1;
    private com.baidu.tbadk.coreExtra.view.j aDA = null;
    private final CustomMessageListener dZP = new e(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0035a acr = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(w.j.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.dZJ = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        this.dZK = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        registerListener(this.dZP);
        setupViews();
    }

    protected void setupViews() {
        this.mRootLayout = (LinearLayout) findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.sapi_login_navi);
        this.aor = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aor.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(w.l.login));
        this.dZN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.navigation_right_button_layout, (View.OnClickListener) null);
        this.dZM = (TextView) this.dZN.findViewById(w.h.right_textview);
        this.dZM.setText(getPageContext().getString(w.l.register));
        aq.c(this.dZM, w.e.navi_op_text, 1);
        this.dZM.setOnClickListener(this);
        this.dZL = (FrameLayout) findViewById(w.h.webview_container);
        this.dZI = new SapiWebView(getPageContext().getPageActivity());
        this.dZL.removeAllViews();
        this.dZL.addView(this.dZI);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dZI);
        this.dZI.setOnFinishCallback(new i(this));
        this.dZI.setAuthorizationListener(new j(this));
        this.dZO = new k(this);
        this.dZI.setSocialLoginHandler(this.dZO);
        this.dZI.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aor) {
            finish();
        } else if (view == this.dZM) {
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
        this.dZI.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aGF();
            } else if (i2 == 230014 && intent != null) {
                no(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                aGI();
                aGG();
            }
        } else if (i2 == -1 && i == 11038) {
            String str = "";
            if (intent != null) {
                str = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
            }
            Intent intent2 = new Intent();
            intent2.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, str);
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGF() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aGH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void no(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(w.l.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGG() {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m9getInst().onUserChanged(getIntent());
        if (this.dZJ) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aVS != null) {
                this.aVS.cancel();
            }
            this.aVS = com.baidu.tbadk.core.a.a.pd().a(session.username, session.bduss, "", null, this.acr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aDA == null) {
            this.aDA = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.aDA.a(new l(this));
        }
        this.aDA.AG();
        this.aDA.i(accountData);
        this.aDA.AC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.k(this.mRootLayout, w.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGI() {
        if (this.mFrom == 3 && TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.fT().e(new m(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dZK == 1) {
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 2, false);
        }
        if (this.aDA != null) {
            this.aDA.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mRootLayout != null) {
            this.mRootLayout.removeAllViews();
        }
        aGJ();
        if (this.aVS != null) {
            this.aVS.cancel();
        }
        super.onDestroy();
    }

    public void aGJ() {
        if (this.dZO != null) {
            this.dZO.removeCallbacksAndMessages(null);
        }
        if (this.dZL != null) {
            this.dZL.removeAllViews();
        }
        if (this.dZI != null) {
            this.dZI.setAuthorizationListener(null);
            this.dZI.setSocialLoginHandler(null);
            this.dZI.setOnBackCallback(null);
            this.dZI.setOnFinishCallback(null);
            this.dZI.getSettings().setBuiltInZoomControls(true);
            this.dZI.setVisibility(8);
            com.baidu.adp.lib.g.h.fS().postDelayed(new n(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }
}
