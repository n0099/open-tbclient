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
import com.baidu.tbadk.core.data.bc;
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
    private View aqB;
    private BdAsyncTask<?, ?, ?> bbX;
    private SapiWebView eLV;
    private FrameLayout eLY;
    private TextView eLZ;
    private View eMa;
    private Handler eMb;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootLayout;
    private boolean eLW = false;
    private int mFrom = -1;
    private int eLX = -1;
    private d aHc = null;
    private final CustomMessageListener eMc = new CustomMessageListener(CmdConfigCustom.CMD_LOGIN_WEINXIN) { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc)) {
                bc bcVar = (bc) customResponsedMessage.getData();
                if (bcVar.Yy == 0) {
                    LoginActivity.this.aQp();
                } else {
                    LoginActivity.this.pw(bcVar.errorMsg);
                }
            }
        }
    };
    private final a.InterfaceC0058a adZ = new a.InterfaceC0058a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0058a
        public void cu(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(d.j.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0058a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            if (TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.k(accountData);
                return;
            }
            q(accountData);
            LoginActivity.this.aQs();
            if (LoginActivity.this.mFrom == 4) {
                LoginActivity.this.Mp();
            } else {
                LoginActivity.this.aQq();
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0058a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (j.hh() && LoginActivity.this.eLV != null) {
                LoginActivity.this.eLV.loadLogin();
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
            com.baidu.tbadk.browser.a.aw(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WEBVIEW_LOGIN, true));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.eLW = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        this.eLX = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        registerListener(this.eMc);
        setupViews();
    }

    protected void setupViews() {
        this.mRootLayout = (LinearLayout) findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.sapi_login_navi);
        this.aqB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aqB.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.login));
        this.eMa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eLZ = (TextView) this.eMa.findViewById(d.g.right_textview);
        this.eLZ.setText(getPageContext().getString(d.j.register));
        aj.c(this.eLZ, d.C0096d.navi_op_text, 1);
        this.eLZ.setOnClickListener(this);
        this.eLY = (FrameLayout) findViewById(d.g.webview_container);
        try {
            this.eLV = new SapiWebView(getPageContext().getPageActivity());
            this.eLY.removeAllViews();
            this.eLY.addView(this.eLV);
            com.baidu.tbadk.core.a.d.addCustomView(getPageContext().getPageActivity(), this.eLV);
            this.eLV.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    LoginActivity.this.finish();
                }
            });
            this.eLV.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess() {
                    com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                    LoginActivity.this.aQr();
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onFailed(int i, String str) {
                    com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_fail", i, str, new Object[0]);
                    if (TextUtils.isEmpty(str)) {
                        LoginActivity.this.showToast(d.j.data_load_error);
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
            this.eMb = new Handler() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
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
            this.eLV.setSocialLoginHandler(this.eMb);
            this.eLV.loadLogin();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqB) {
            finish();
        } else if (view == this.eLZ) {
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
        this.eLV.onAuthorizedResult(i, i2, intent);
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aQp();
            } else if (i2 == 230014 && intent != null) {
                pw(intent.getStringExtra("result_msg"));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                aQs();
                aQq();
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
    public void aQp() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aQr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(d.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        int i = 1;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.eLW) {
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
    public void aQr() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bbX != null) {
                this.bbX.cancel();
            }
            this.bbX = a.pf().a(session.username, session.bduss, "", null, this.adZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aHc == null) {
            this.aHc = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.aHc.a(new d.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.6
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void j(AccountData accountData2) {
                    b.b(accountData2);
                    TbadkCoreApplication.setCurrentAccount(accountData2, LoginActivity.this.getPageContext().getPageActivity());
                    LoginActivity.this.aQs();
                    LoginActivity.this.aQq();
                }
            });
        }
        this.aHc.Bg();
        this.aHc.i(accountData);
        this.aHc.Bc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.mRootLayout, d.C0096d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
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
        if (this.eLX == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.aHc != null) {
            this.aHc.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mRootLayout != null) {
            this.mRootLayout.removeAllViews();
        }
        aQt();
        if (this.bbX != null) {
            this.bbX.cancel();
        }
        super.onDestroy();
    }

    public void aQt() {
        if (this.eMb != null) {
            this.eMb.removeCallbacksAndMessages(null);
        }
        if (this.eLY != null) {
            this.eLY.removeAllViews();
        }
        if (this.eLV != null) {
            this.eLV.setAuthorizationListener(null);
            this.eLV.setSocialLoginHandler(null);
            this.eLV.setOnBackCallback(null);
            this.eLV.setOnFinishCallback(null);
            this.eLV.getSettings().setBuiltInZoomControls(true);
            this.eLV.setVisibility(8);
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (LoginActivity.this.eLV != null) {
                            LoginActivity.this.eLV.destroy();
                            LoginActivity.this.eLV = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp() {
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
