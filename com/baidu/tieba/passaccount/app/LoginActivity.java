package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.atomData.AccountBundingActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.atomData.SocialLoginActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private BdAsyncTask<?, ?, ?> aYl;
    private View apM;
    private SapiWebView euE;
    private FrameLayout euH;
    private TextView euI;
    private View euJ;
    private Handler euK;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootLayout;
    private boolean euF = false;
    private int mFrom = -1;
    private int euG = -1;
    private d aFE = null;
    private final CustomMessageListener euL = new CustomMessageListener(CmdConfigCustom.CMD_LOGIN_WEINXIN) { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                if (bgVar.XU == 0) {
                    LoginActivity.this.aLV();
                } else {
                    LoginActivity.this.ov(bgVar.errorMsg);
                }
            }
        }
    };
    private final a.InterfaceC0044a adm = new a.InterfaceC0044a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
        public void co(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(d.l.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            if (TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.k(accountData);
                return;
            }
            q(accountData);
            LoginActivity.this.aLY();
            if (LoginActivity.this.mFrom == 4) {
                LoginActivity.this.Lq();
            } else {
                LoginActivity.this.aLW();
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (j.hh() && LoginActivity.this.euE != null) {
                LoginActivity.this.euE.loadLogin();
            }
        }

        private void q(final AccountData accountData) {
            h.fQ().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5.2
                @Override // java.lang.Runnable
                public void run() {
                    b.b(accountData);
                }
            });
            TbadkCoreApplication.setCurrentAccount(accountData, LoginActivity.this.getPageContext().getPageActivity());
            com.baidu.tbadk.browser.a.ax(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WEBVIEW_LOGIN, true));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.euF = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        this.euG = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        registerListener(this.euL);
        setupViews();
    }

    protected void setupViews() {
        this.mRootLayout = (LinearLayout) findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.sapi_login_navi);
        this.apM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.apM.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.l.login));
        this.euJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.navigation_right_button_layout, (View.OnClickListener) null);
        this.euI = (TextView) this.euJ.findViewById(d.h.right_textview);
        this.euI.setText(getPageContext().getString(d.l.register));
        aj.c(this.euI, d.e.navi_op_text, 1);
        this.euI.setOnClickListener(this);
        this.euH = (FrameLayout) findViewById(d.h.webview_container);
        this.euE = new SapiWebView(getPageContext().getPageActivity());
        this.euH.removeAllViews();
        this.euH.addView(this.euE);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.euE);
        this.euE.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                LoginActivity.this.finish();
            }
        });
        this.euE.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.aLX();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_fail", i, str, new Object[0]);
                if (TextUtils.isEmpty(str)) {
                    LoginActivity.this.showToast(d.l.data_load_error);
                } else {
                    LoginActivity.this.showToast(str);
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public boolean onForgetPwd() {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_forgetpwd", 0, "", new Object[0]);
                LoginActivity.this.startActivity(new Intent(LoginActivity.this.getPageContext().getPageActivity(), ForgetPwdActivity.class));
                return true;
            }
        });
        this.euK = new Handler() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == SocialType.WEIXIN.getType()) {
                    com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_weixin_start", 0, "", new Object[0]);
                    LoginActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WXEntryActivityConfig(LoginActivity.this.getPageContext().getPageActivity(), 230016)));
                    return;
                }
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_qq_start", 0, "", new Object[0]);
                LoginActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SocialLoginActivityConfig(LoginActivity.this.getPageContext().getPageActivity(), SocialType.getSocialType(message.what), 230012)));
            }
        };
        this.euE.setSocialLoginHandler(this.euK);
        this.euE.loadLogin();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.apM) {
            finish();
        } else if (view == this.euI) {
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
        this.euE.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aLV();
            } else if (i2 == 230014 && intent != null) {
                ov(intent.getStringExtra(SocialLoginActivityConfig.RESULT_MSG));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                aLY();
                aLW();
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
    public void aLV() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aLX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(d.l.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLW() {
        int i = 1;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.euF) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLX() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aYl != null) {
                this.aYl.cancel();
            }
            this.aYl = a.oU().a(session.username, session.bduss, "", null, this.adm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aFE == null) {
            this.aFE = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.aFE.a(new d.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.6
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void j(AccountData accountData2) {
                    b.b(accountData2);
                    TbadkCoreApplication.setCurrentAccount(accountData2, LoginActivity.this.getPageContext().getPageActivity());
                    LoginActivity.this.aLY();
                    LoginActivity.this.aLW();
                }
            });
        }
        this.aFE.AA();
        this.aFE.i(accountData);
        this.aFE.Aw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLY() {
        if (this.mFrom == 3 && TbadkCoreApplication.getInst().getIsFirstUse()) {
            h.fQ().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    TbadkCoreApplication.getInst().setUsed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.euG == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.aFE != null) {
            this.aFE.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mRootLayout != null) {
            this.mRootLayout.removeAllViews();
        }
        aLZ();
        if (this.aYl != null) {
            this.aYl.cancel();
        }
        super.onDestroy();
    }

    public void aLZ() {
        if (this.euK != null) {
            this.euK.removeCallbacksAndMessages(null);
        }
        if (this.euH != null) {
            this.euH.removeAllViews();
        }
        if (this.euE != null) {
            this.euE.setAuthorizationListener(null);
            this.euE.setSocialLoginHandler(null);
            this.euE.setOnBackCallback(null);
            this.euE.setOnFinishCallback(null);
            this.euE.getSettings().setBuiltInZoomControls(true);
            this.euE.setVisibility(8);
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (LoginActivity.this.euE != null) {
                            LoginActivity.this.euE.destroy();
                            LoginActivity.this.euE = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }
}
