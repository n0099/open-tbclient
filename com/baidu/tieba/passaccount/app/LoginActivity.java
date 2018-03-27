package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.thirdparty.QQSSOLoginActivity;
/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private BdAsyncTask<?, ?, ?> bSb;
    private View bgB;
    private FrameLayout dRn;
    private SapiWebView fDV;
    private TextView fDY;
    private View fDZ;
    private Handler fEa;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootLayout;
    private boolean fDW = false;
    private int mFrom = -1;
    private int fDX = -1;
    private d bSa = null;
    private final CustomMessageListener fEb = new CustomMessageListener(2001338) { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc)) {
                bc bcVar = (bc) customResponsedMessage.getData();
                if (bcVar.aOi == 0) {
                    LoginActivity.this.aZs();
                } else {
                    LoginActivity.this.pZ(bcVar.errorMsg);
                }
            }
        }
    };
    private final a.InterfaceC0094a bSy = new a.InterfaceC0094a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
        public void cM(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(d.j.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            if (TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.j(accountData);
                return;
            }
            p(accountData);
            LoginActivity.this.aZv();
            if (LoginActivity.this.mFrom == 4) {
                LoginActivity.this.Up();
            } else {
                LoginActivity.this.aZt();
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (j.oJ() && LoginActivity.this.fDV != null) {
                LoginActivity.this.fDV.loadLogin();
            }
        }

        private void p(final AccountData accountData) {
            h.nt().d(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5.2
                @Override // java.lang.Runnable
                public void run() {
                    b.b(accountData);
                }
            });
            TbadkCoreApplication.setCurrentAccount(accountData, LoginActivity.this.getPageContext().getPageActivity());
            com.baidu.tbadk.browser.b.aH(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, true));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2921332, (Class) null);
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.fDW = intent.getBooleanExtra("close", false);
        this.mFrom = intent.getIntExtra("from", -1);
        this.fDX = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        registerListener(this.fEb);
        setupViews();
        adjustResizeForSoftInput();
    }

    protected void setupViews() {
        this.mRootLayout = (LinearLayout) findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.sapi_login_navi);
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bgB.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.login));
        this.fDZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.fDY = (TextView) this.fDZ.findViewById(d.g.right_textview);
        this.fDY.setText(getPageContext().getString(d.j.register));
        aj.e(this.fDY, d.C0141d.navi_op_text, 1);
        this.fDY.setOnClickListener(this);
        this.dRn = (FrameLayout) findViewById(d.g.webview_container);
        try {
            this.fDV = new SapiWebView(getPageContext().getPageActivity());
            this.dRn.removeAllViews();
            this.dRn.addView(this.fDV);
            com.baidu.tbadk.core.a.d.addCustomView(getPageContext().getPageActivity(), this.fDV);
            this.fDV.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    LoginActivity.this.finish();
                }
            });
            this.fDV.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess() {
                    com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                    LoginActivity.this.aZu();
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
            this.fEa = new Handler() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == SocialType.WEIXIN.getType()) {
                        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_weixin_start", 0, "", new Object[0]);
                        LoginActivity.this.sendMessage(new CustomMessage(2002001, new WXEntryActivityConfig(LoginActivity.this.getPageContext().getPageActivity(), 230016)));
                    } else if (message.what == SocialType.QQ_SSO.getType()) {
                        LoginActivity.this.startActivityForResult(new Intent(LoginActivity.this, QQSSOLoginActivity.class), 230012);
                    } else {
                        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_qq_start", 0, "", new Object[0]);
                        LoginActivity.this.sendMessage(new CustomMessage(2002001, new SocialLoginActivityConfig(LoginActivity.this.getPageContext().getPageActivity(), SocialType.getSocialType(message.what), 230012)));
                    }
                }
            };
            this.fDV.setSocialLoginHandler(this.fEa);
            this.fDV.loadLogin();
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
        if (view == this.bgB) {
            if (this.fDV != null && this.fDV.canGoBack()) {
                this.fDV.goBack();
            } else {
                finish();
            }
        } else if (view == this.fDY) {
            if (this.mFrom == 2) {
                finish();
            } else {
                sendMessage(new CustomMessage(2002001, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fDV != null) {
            this.fDV.onAuthorizedResult(i, i2, intent);
        }
        if (i == 230012 || i == 230016) {
            if (i2 == 230013) {
                aZs();
            } else if (i2 == 230014 && intent != null) {
                pZ(intent.getStringExtra("result_msg"));
            }
        } else if (i == 230015) {
            if (i2 == -1) {
                TiebaStatic.log("c10015");
                aZv();
                aZt();
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
    public void aZs() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_result", 0, "", "uname", session.username);
            if (TextUtils.isEmpty(session.username)) {
                sendMessage(new CustomMessage(2002001, new AccountBundingActivityConfig(getPageContext().getPageActivity(), 230015)));
                return;
            }
            TiebaStatic.log("c10015");
            aZu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(d.j.social_login_error);
        }
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZt() {
        int i = 1;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.fDW) {
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
            com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bSb != null) {
                this.bSb.cancel();
            }
            this.bSb = a.xv().a(session.username, session.bduss, "", null, this.bSy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.bSa == null) {
            this.bSa = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.bSa.a(new d.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.6
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void i(AccountData accountData2) {
                    b.b(accountData2);
                    TbadkCoreApplication.setCurrentAccount(accountData2, LoginActivity.this.getPageContext().getPageActivity());
                    LoginActivity.this.aZv();
                    LoginActivity.this.aZt();
                }
            });
        }
        this.bSa.Jj();
        this.bSa.h(accountData);
        this.bSa.Jf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.mRootLayout, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZv() {
        if (this.mFrom == 3 && TbadkCoreApplication.getInst().getIsFirstUse()) {
            h.nt().d(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.7
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
        if (this.fDX == 1) {
            com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), 2, false);
        }
        if (this.bSa != null) {
            this.bSa.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mRootLayout != null) {
            this.mRootLayout.removeAllViews();
        }
        aZw();
        if (this.bSb != null) {
            this.bSb.cancel();
        }
        super.onDestroy();
    }

    public void aZw() {
        if (this.fEa != null) {
            this.fEa.removeCallbacksAndMessages(null);
        }
        if (this.dRn != null) {
            this.dRn.removeAllViews();
        }
        if (this.fDV != null) {
            this.fDV.setAuthorizationListener(null);
            this.fDV.setSocialLoginHandler(null);
            this.fDV.setOnBackCallback(null);
            this.fDV.setOnFinishCallback(null);
            this.fDV.getSettings().setBuiltInZoomControls(true);
            this.fDV.setVisibility(8);
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (LoginActivity.this.fDV != null) {
                            LoginActivity.this.fDV.destroy();
                            LoginActivity.this.fDV = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_startApp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(2015001) != null) {
                sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fDV == null || !this.fDV.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.fDV.goBack();
        return true;
    }
}
