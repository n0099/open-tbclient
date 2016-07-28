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
    private LinearLayout Ef;
    private BdAsyncTask<?, ?, ?> aMm;
    private View agC;
    private View bnK;
    private SapiWebView dUH;
    private FrameLayout dUJ;
    private TextView dUK;
    private SapiWebView.VoiceLoginHandler dUL;
    private Handler dUM;
    private NavigationBar mNavigationBar;
    private boolean dUI = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j avV = null;
    private final CustomMessageListener dUN = new k(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0033a Vl = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(u.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.dUI = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.dUN);
        setupViews();
    }

    protected void setupViews() {
        this.Ef = (LinearLayout) findViewById(u.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.sapi_login_navi);
        this.agC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.agC.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.login));
        this.bnK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.dUK = (TextView) this.bnK.findViewById(u.g.right_textview);
        this.dUK.setText(getPageContext().getString(u.j.account_regedit));
        av.c(this.dUK, u.d.navi_op_text, 1);
        this.dUK.setOnClickListener(this);
        this.dUJ = (FrameLayout) findViewById(u.g.webview_container);
        this.dUH = new SapiWebView(getPageContext().getPageActivity());
        this.dUJ.removeAllViews();
        this.dUJ.addView(this.dUH);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dUH);
        this.dUH.setOnFinishCallback(new o(this));
        this.dUH.setAuthorizationListener(new p(this));
        this.dUL = new q(this);
        this.dUH.setVoiceLoginHandler(this.dUL);
        this.dUM = new r(this);
        this.dUH.setSocialLoginHandler(this.dUM);
        this.dUH.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.agC) {
            finish();
        } else if (view == this.dUK) {
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
        this.dUH.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aFZ();
            } else if (i2 == 230014 && intent != null) {
                nR(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                Ja();
                aFX();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFZ() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aFY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(u.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFX() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m10getInst().onUserChanged();
        if (this.dUI) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
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
    public void aFY() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aMm != null) {
                this.aMm.cancel();
            }
            this.aMm = com.baidu.tbadk.core.a.a.nT().a(session.username, session.bduss, "", this.Vl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.avV == null) {
            this.avV = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.avV.a(new s(this));
        }
        this.avV.zw();
        this.avV.h(accountData);
        this.avV.zs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.l(this.Ef, u.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        if (this.mFrom == 3 && TbadkCoreApplication.m10getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dM().e(new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.avV != null) {
            this.avV.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Ef != null) {
            this.Ef.removeAllViews();
        }
        aGa();
        if (this.aMm != null) {
            this.aMm.cancel();
        }
        super.onDestroy();
    }

    public void aGa() {
        if (this.dUM != null) {
            this.dUM.removeCallbacksAndMessages(null);
        }
        if (this.dUJ != null) {
            this.dUJ.removeAllViews();
        }
        if (this.dUH != null) {
            this.dUH.setAuthorizationListener(null);
            this.dUH.setVoiceLoginHandler(null);
            this.dUH.setSocialLoginHandler(null);
            this.dUH.setOnBackCallback(null);
            this.dUH.setOnFinishCallback(null);
            this.dUH.getSettings().setBuiltInZoomControls(true);
            this.dUH.setVisibility(8);
            com.baidu.adp.lib.h.h.dL().postDelayed(new u(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jb() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m10getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean Me = com.baidu.tieba.c.a.Md().Me();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null && Me) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }
}
