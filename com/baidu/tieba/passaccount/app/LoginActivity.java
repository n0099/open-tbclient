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
/* loaded from: classes7.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private b fnD;
    private BdAsyncTask<?, ?, ?> gdJ;
    private WebAuthResult lxK;
    private Activity lxL;
    private String lxO;
    private String lxQ;
    private int lxR;
    private boolean lxS;
    private String mActivityId;
    private int lxJ = 1;
    private String lxM = null;
    private int lxN = -2;
    private boolean mClose = false;
    private int lxP = -1;
    private final a.InterfaceC0558a gef = new a.InterfaceC0558a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
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

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new aq("c12948").an("obj_type", LoginActivity.this.lxJ).dW(TiebaInitialize.Params.OBJ_URL, LoginActivity.this.lxO));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
                if (d.biF()) {
                    c.bha().bhb();
                    return;
                }
                return;
            }
            LoginActivity.this.i(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.lxL instanceof BaseSSOLoginActivity) {
                LoginActivity.this.lxL.finish();
            }
            LoginActivity.this.EU(0);
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
        cvh();
        dhB();
        dhC();
        TiebaStatic.log(new aq("c12947").dW(TiebaInitialize.Params.OBJ_URL, this.lxO));
    }

    private void cvh() {
        Intent intent = getIntent();
        this.mClose = intent.getBooleanExtra("close", false);
        this.lxP = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.lxO = intent.getStringExtra("url");
        this.lxR = intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0);
        this.lxQ = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.mActivityId = intent.getStringExtra("activity_id");
        this.lxS = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
    }

    protected void dhB() {
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
        PassManagerStatic.dhN();
        SapiConfiguration confignation2 = SapiAccountManager.getInstance().getConfignation();
        if (confignation2 != null && confignation2.fastLoginFeatureList != null) {
            confignation2.fastLoginFeatureList.clear();
            confignation2.fastLoginFeatureList.addAll(PassManagerStatic.dhL());
        }
        dhF();
        if (dhD()) {
            ET(this.lxR);
        } else {
            dbt();
        }
    }

    private void dhC() {
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
    }

    private boolean dhD() {
        return this.lxR == 1 || this.lxR == 2 || this.lxR == 3;
    }

    private void dbt() {
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
                LoginActivity.this.lxK = webAuthResult;
                LoginActivity.this.lxL = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.dhE();
                LoginActivity.this.lxN = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.lxN = -1;
                LoginActivity.this.EU(0);
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

    private void ET(int i) {
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
                LoginActivity.this.lxK = webAuthResult;
                LoginActivity.this.lxL = webAuthResult.activity;
                LoginActivity.this.dhE();
                LoginActivity.this.lxN = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.lxN = -1;
                LoginActivity.this.EU(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        };
        if (this.lxS) {
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
            if (this.lxK != null) {
                this.lxK.finishActivity();
            }
            EU(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.e.b.d(this.lxL, i, false);
        if (this.lxK != null) {
            this.lxK.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.lxN)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhE() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.gdJ != null) {
                this.gdJ.cancel();
            }
            this.gdJ = a.bkC().a(session.username, session.bduss, "", null, this.gef);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.isActivityCanShowDialogOrPopupWindow(this.lxL)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.lxL);
            this.mWaitingDialog.setTipString(str);
            this.mWaitingDialog.setCancelListener(onCancelListener);
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra(LoginActivityConfig.SOCIAL_TYPE, this.lxR);
        intent.putExtra("activity_id", this.mActivityId);
        intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.lxS);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.mC().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
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
        this.lxM = TbadkCoreApplication.getCurrentTbs();
        if (this.fnD == null) {
            this.fnD = new b(this.lxL);
            this.fnD.a(this.gef);
            this.fnD.b(new b.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.lxM);
                    if (LoginActivity.this.lxK != null) {
                        LoginActivity.this.lxK.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.fnD.bzi();
        this.fnD.setAccountData(accountData);
        this.fnD.bze();
    }

    private boolean dhF() {
        if (!at.isEmpty(this.lxQ)) {
            String AB = n.AB(this.lxQ);
            if (!at.isEmpty(AB) && n.Az(AB)) {
                if (SapiAccountManager.getInstance().getConfignation() != null) {
                    SapiAccountManager.getInstance().getConfignation().skin = AB;
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
        if (this.lxP == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.gdJ != null) {
            this.gdJ.cancel();
        }
        if (this.fnD != null) {
            this.fnD.onDestroy();
        }
        this.lxK = null;
        this.lxL = null;
        super.onDestroy();
    }
}
