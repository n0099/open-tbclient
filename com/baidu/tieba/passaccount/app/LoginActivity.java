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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private LinearLayout Nf;
    private View ajk;
    private SapiWebView cGo;
    private FrameLayout cGq;
    private TextView cGr;
    private View cGs;
    private SapiWebView.VoiceLoginHandler cGt;
    private Handler cGu;
    private NavigationBar mNavigationBar;
    private boolean cGp = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.j axI = null;
    private final CustomMessageListener cGv = new j(this, CmdConfigCustom.CMD_LOGIN_WEINXIN);
    private final a.InterfaceC0042a ZI = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.cGp = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        registerListener(this.cGv);
        setupViews();
    }

    protected void setupViews() {
        this.Nf = (LinearLayout) findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_login_navi);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ajk.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.login));
        this.cGs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.cGr = (TextView) this.cGs.findViewById(t.g.right_textview);
        this.cGr.setText(getPageContext().getString(t.j.account_regedit));
        ar.b(this.cGr, t.d.navi_op_text, 1);
        this.cGr.setOnClickListener(this);
        this.cGq = (FrameLayout) findViewById(t.g.webview_container);
        this.cGo = new SapiWebView(getPageContext().getPageActivity());
        this.cGq.removeAllViews();
        this.cGq.addView(this.cGo);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.cGo);
        this.cGo.setOnFinishCallback(new n(this));
        this.cGo.setAuthorizationListener(new o(this));
        this.cGt = new p(this);
        this.cGo.setVoiceLoginHandler(this.cGt);
        this.cGu = new q(this);
        this.cGo.setSocialLoginHandler(this.cGu);
        this.cGo.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajk) {
            finish();
        } else if (view == this.cGr) {
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
        this.cGo.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                anN();
            } else if (i2 == 230014 && intent != null) {
                ko(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                In();
                anL();
            }
        } else if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anN() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            anM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(t.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anL() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.cGp) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
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
    public void anM() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.rv().a(session.username, session.bduss, session.ptoken, this.ZI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.axI == null) {
            this.axI = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.axI.a(new r(this));
        }
        this.axI.AT();
        this.axI.h(accountData);
        this.axI.AP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.l(this.Nf, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void In() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hs().b(new s(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.axI != null) {
            this.axI.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Nf != null) {
            this.Nf.removeAllViews();
        }
        anO();
        super.onDestroy();
    }

    public void anO() {
        if (this.cGu != null) {
            this.cGu.removeCallbacksAndMessages(null);
        }
        if (this.cGq != null) {
            this.cGq.removeAllViews();
        }
        if (this.cGo != null) {
            this.cGo.setAuthorizationListener(null);
            this.cGo.setVoiceLoginHandler(null);
            this.cGo.setSocialLoginHandler(null);
            this.cGo.setOnBackCallback(null);
            this.cGo.setOnFinishCallback(null);
            this.cGo.getSettings().setBuiltInZoomControls(true);
            this.cGo.setVisibility(8);
            com.baidu.adp.lib.h.h.hr().postDelayed(new t(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean Ld = com.baidu.tieba.a.a.Lb().Ld();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null && Ld) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }
}
