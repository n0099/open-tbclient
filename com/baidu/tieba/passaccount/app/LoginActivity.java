package com.baidu.tieba.passaccount.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.c;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.switchs.LoginDefaultTypeSmsSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.lang.reflect.Field;
/* loaded from: classes21.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private String bkq;
    private BdAsyncTask<?, ?, ?> fQR;
    private b fbX;
    private WebAuthResult ljq;
    private Activity ljr;
    private String lju;
    private String ljw;
    private int ljx;
    private boolean ljy;
    private int ljp = 1;
    private String ljs = null;
    private int ljt = -2;
    private boolean mClose = false;
    private int ljv = -1;
    private final a.InterfaceC0574a fRo = new a.InterfaceC0574a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0574a
        public void onBeforeLogin(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(R.string.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0574a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new aq("c12948").al("obj_type", LoginActivity.this.ljp).dR(TiebaInitialize.Params.OBJ_URL, LoginActivity.this.lju));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
                if (d.bhS()) {
                    c.bgf().bgg();
                    return;
                }
                return;
            }
            LoginActivity.this.i(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0574a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.ljr instanceof BaseSSOLoginActivity) {
                LoginActivity.this.ljr.finish();
            }
            LoginActivity.this.Fv(0);
        }
    };

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoginActivityConfig.lastStartActivityTime = System.currentTimeMillis();
        csm();
        dgY();
        dgZ();
        TiebaStatic.log(new aq("c12947").dR(TiebaInitialize.Params.OBJ_URL, this.lju));
    }

    private void csm() {
        Intent intent = getIntent();
        this.mClose = intent.getBooleanExtra("close", false);
        this.ljv = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.lju = intent.getStringExtra("url");
        this.ljx = intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0);
        this.ljw = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.bkq = intent.getStringExtra("activity_id");
        this.ljy = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
    }

    protected void dgY() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
            confignation.setAgreeDangerousProtocol(true);
        }
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
        PassManagerStatic.dhk();
        SapiConfiguration confignation2 = SapiAccountManager.getInstance().getConfignation();
        if (confignation2 != null && confignation2.fastLoginFeatureList != null) {
            confignation2.fastLoginFeatureList.clear();
            confignation2.fastLoginFeatureList.addAll(PassManagerStatic.dhi());
        }
        dhc();
        if (dha()) {
            Fu(this.ljx);
        } else {
            daO();
        }
    }

    private void dgZ() {
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
    }

    private boolean dha() {
        return this.ljx == 1 || this.ljx == 2 || this.ljx == 3;
    }

    private void daO() {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (SwitchManager.getInstance().findType(LoginDefaultTypeSmsSwitch.SWITCH_NAME) == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.ljq = webAuthResult;
                LoginActivity.this.ljr = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.dhb();
                LoginActivity.this.ljt = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.ljt = -1;
                LoginActivity.this.Fv(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        }, webLoginDTO);
    }

    private void Fu(int i) {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        if (i == 1) {
            webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
        } else if (i == 2) {
            webSocialLoginDTO.socialType = SocialType.WEIXIN;
        } else if (i == 3) {
            webSocialLoginDTO.socialType = SocialType.QQ_SSO;
        }
        WebAuthListener webAuthListener = new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.ljq = webAuthResult;
                LoginActivity.this.ljr = webAuthResult.activity;
                LoginActivity.this.dhb();
                LoginActivity.this.ljt = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.ljt = -1;
                LoginActivity.this.Fv(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        };
        if (this.ljy) {
            try {
                Field declaredField = passportSDK.getClass().getDeclaredField("webAuthListener");
                declaredField.setAccessible(true);
                declaredField.set(passportSDK, webAuthListener);
                Field declaredField2 = passportSDK.getClass().getDeclaredField("socialLoginDTO");
                declaredField2.setAccessible(true);
                declaredField2.set(passportSDK, webSocialLoginDTO);
                passportSDK.loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                return;
            }
        }
        passportSDK.loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        int i = 2;
        p(accountData);
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.mClose) {
            if (this.ljq != null) {
                this.ljq.finishActivity();
            }
            Fv(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.e.b.d(this.ljr, i, false);
        if (this.ljq != null) {
            this.ljq.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.ljt)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhb() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.fQR != null) {
                this.fQR.cancel();
            }
            this.fQR = a.bjI().a(session.username, session.bduss, "", null, this.fRo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.isActivityCanShowDialogOrPopupWindow(this.ljr)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.ljr);
            this.mWaitingDialog.setTipString(str);
            this.mWaitingDialog.setCancelListener(onCancelListener);
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fv(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra(LoginActivityConfig.SOCIAL_TYPE, this.ljx);
        intent.putExtra("activity_id", this.bkq);
        intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.ljy);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.mZ().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        });
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.initCookie(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WEBVIEW_LOGIN, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        this.ljs = TbadkCoreApplication.getCurrentTbs();
        if (this.fbX == null) {
            this.fbX = new b(this.ljr);
            this.fbX.a(this.fRo);
            this.fbX.b(new b.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.ljs);
                    if (LoginActivity.this.ljq != null) {
                        LoginActivity.this.ljq.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.fbX.bxR();
        this.fbX.setAccountData(accountData);
        this.fbX.bxN();
    }

    private boolean dhc() {
        if (!at.isEmpty(this.ljw)) {
            String BI = n.BI(this.ljw);
            if (!at.isEmpty(BI) && n.BG(BI)) {
                if (SapiAccountManager.getInstance().getConfignation() != null) {
                    SapiAccountManager.getInstance().getConfignation().skin = BI;
                }
                return true;
            }
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            SapiAccountManager.getInstance().getConfignation().skin = "file:///android_asset/sapi_theme/style.css";
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ljv == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.fQR != null) {
            this.fQR.cancel();
        }
        if (this.fbX != null) {
            this.fbX.onDestroy();
        }
        this.ljq = null;
        this.ljr = null;
        super.onDestroy();
    }
}
