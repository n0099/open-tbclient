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
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private LinearLayout DF;
    private BdAsyncTask<?, ?, ?> aLs;
    private View afN;
    private View bmb;
    private FrameLayout dIA;
    private TextView dIB;
    private SapiWebView.VoiceLoginHandler dIC;
    private Handler dID;
    private SapiWebView dIy;
    private NavigationBar mNavigationBar;
    private boolean dIz = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j avg = null;
    private final CustomMessageListener dIE = new k(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0033a UB = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(u.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.dIz = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.dIE);
        setupViews();
    }

    protected void setupViews() {
        this.DF = (LinearLayout) findViewById(u.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.sapi_login_navi);
        this.afN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.afN.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.login));
        this.bmb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.dIB = (TextView) this.bmb.findViewById(u.g.right_textview);
        this.dIB.setText(getPageContext().getString(u.j.account_regedit));
        av.c(this.dIB, u.d.navi_op_text, 1);
        this.dIB.setOnClickListener(this);
        this.dIA = (FrameLayout) findViewById(u.g.webview_container);
        this.dIy = new SapiWebView(getPageContext().getPageActivity());
        this.dIA.removeAllViews();
        this.dIA.addView(this.dIy);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dIy);
        this.dIy.setOnFinishCallback(new o(this));
        this.dIy.setAuthorizationListener(new p(this));
        this.dIC = new q(this);
        this.dIy.setVoiceLoginHandler(this.dIC);
        this.dID = new r(this);
        this.dIy.setSocialLoginHandler(this.dID);
        this.dIy.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.afN) {
            finish();
        } else if (view == this.dIB) {
            if (this.mFrom == 2) {
                finish();
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
            }
        }
    }

    private void t(Intent intent) {
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
        t(intent);
        this.dIy.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aCP();
            } else if (i2 == 230014 && intent != null) {
                ng(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                Jb();
                aCN();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCP() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aCO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(u.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m9getInst().onUserChanged();
        if (this.dIz) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
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
    public void aCO() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aLs != null) {
                this.aLs.cancel();
            }
            this.aLs = com.baidu.tbadk.core.a.a.oe().a(session.username, session.bduss, "", this.UB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.avg == null) {
            this.avg = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.avg.a(new s(this));
        }
        this.avg.zw();
        this.avg.h(accountData);
        this.avg.zs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.DF, u.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jb() {
        if (this.mFrom == 3 && TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dN().b(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.avg != null) {
            this.avg.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.DF != null) {
            this.DF.removeAllViews();
        }
        aCQ();
        if (this.aLs != null) {
            this.aLs.cancel();
        }
        super.onDestroy();
    }

    public void aCQ() {
        if (this.dID != null) {
            this.dID.removeCallbacksAndMessages(null);
        }
        if (this.dIA != null) {
            this.dIA.removeAllViews();
        }
        if (this.dIy != null) {
            this.dIy.setAuthorizationListener(null);
            this.dIy.setVoiceLoginHandler(null);
            this.dIy.setSocialLoginHandler(null);
            this.dIy.setOnBackCallback(null);
            this.dIy.setOnFinishCallback(null);
            this.dIy.getSettings().setBuiltInZoomControls(true);
            this.dIy.setVisibility(8);
            com.baidu.adp.lib.h.h.dM().postDelayed(new u(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jc() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean Mf = com.baidu.tieba.c.a.Me().Mf();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null && Mf) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }
}
