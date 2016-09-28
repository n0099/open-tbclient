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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private LinearLayout Gs;
    private BdAsyncTask<?, ?, ?> aSL;
    private View aiY;
    private View bzj;
    private SapiWebView eiH;
    private FrameLayout eiJ;
    private TextView eiK;
    private SapiWebView.VoiceLoginHandler eiL;
    private Handler eiM;
    private NavigationBar mNavigationBar;
    private boolean eiI = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j ayF = null;
    private final CustomMessageListener eiN = new k(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0033a Yl = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(r.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.eiI = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.eiN);
        setupViews();
    }

    protected void setupViews() {
        this.Gs = (LinearLayout) findViewById(r.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.sapi_login_navi);
        this.aiY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aiY.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(r.j.login));
        this.bzj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eiK = (TextView) this.bzj.findViewById(r.g.right_textview);
        this.eiK.setText(getPageContext().getString(r.j.account_regedit));
        av.c(this.eiK, r.d.navi_op_text, 1);
        this.eiK.setOnClickListener(this);
        this.eiJ = (FrameLayout) findViewById(r.g.webview_container);
        this.eiH = new SapiWebView(getPageContext().getPageActivity());
        this.eiJ.removeAllViews();
        this.eiJ.addView(this.eiH);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.eiH);
        this.eiH.setOnFinishCallback(new o(this));
        this.eiH.setAuthorizationListener(new p(this));
        this.eiL = new q(this);
        this.eiH.setVoiceLoginHandler(this.eiL);
        this.eiM = new r(this);
        this.eiH.setSocialLoginHandler(this.eiM);
        this.eiH.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiY) {
            finish();
        } else if (view == this.eiK) {
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
        this.eiH.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aLs();
            } else if (i2 == 230014 && intent != null) {
                oP(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                aLt();
                aLq();
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
    public void aLs() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aLr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(r.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLq() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m9getInst().onUserChanged();
        if (this.eiI) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
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
    public void aLr() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aSL != null) {
                this.aSL.cancel();
            }
            this.aSL = com.baidu.tbadk.core.a.a.oP().a(session.username, session.bduss, "", null, this.Yl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.ayF == null) {
            this.ayF = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.ayF.a(new s(this));
        }
        this.ayF.AO();
        this.ayF.i(accountData);
        this.ayF.AK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.Gs, r.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLt() {
        if (this.mFrom == 3 && TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.eH().e(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ayF != null) {
            this.ayF.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Gs != null) {
            this.Gs.removeAllViews();
        }
        aLu();
        if (this.aSL != null) {
            this.aSL.cancel();
        }
        super.onDestroy();
    }

    public void aLu() {
        if (this.eiM != null) {
            this.eiM.removeCallbacksAndMessages(null);
        }
        if (this.eiJ != null) {
            this.eiJ.removeAllViews();
        }
        if (this.eiH != null) {
            this.eiH.setAuthorizationListener(null);
            this.eiH.setVoiceLoginHandler(null);
            this.eiH.setSocialLoginHandler(null);
            this.eiH.setOnBackCallback(null);
            this.eiH.setOnFinishCallback(null);
            this.eiH.getSettings().setBuiltInZoomControls(true);
            this.eiH.setVisibility(8);
            com.baidu.adp.lib.h.h.eG().postDelayed(new u(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }
}
