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
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.switchs.LoginDefaultTypeSmsSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private String aUO;
    private BdAsyncTask<?, ?, ?> eXp;
    private b eiZ;
    private WebAuthResult jVh;
    private Activity jVi;
    private String jVl;
    private String jVn;
    private int jVo;
    private boolean jVp;
    private int jVg = 1;
    private String jVj = null;
    private int jVk = -2;
    private boolean mClose = false;
    private int jVm = -1;
    private final a.InterfaceC0478a eXM = new a.InterfaceC0478a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0478a
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

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0478a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new ao("c12948").ag("obj_type", LoginActivity.this.jVg).dk(TiebaInitialize.Params.OBJ_URL, LoginActivity.this.jVl));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0478a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.jVi instanceof BaseSSOLoginActivity) {
                LoginActivity.this.jVi.finish();
            }
            LoginActivity.this.AQ(0);
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
        bSm();
        cFA();
        cFB();
        TiebaStatic.log(new ao("c12947").dk(TiebaInitialize.Params.OBJ_URL, this.jVl));
    }

    private void bSm() {
        Intent intent = getIntent();
        this.mClose = intent.getBooleanExtra("close", false);
        this.jVm = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.jVl = intent.getStringExtra("url");
        this.jVo = intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0);
        this.jVn = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.aUO = intent.getStringExtra("activity_id");
        this.jVp = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
    }

    protected void cFA() {
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
        PassManagerStatic.cFM();
        SapiConfiguration confignation2 = SapiAccountManager.getInstance().getConfignation();
        if (confignation2 != null && confignation2.fastLoginFeatureList != null) {
            confignation2.fastLoginFeatureList.clear();
            confignation2.fastLoginFeatureList.addAll(PassManagerStatic.cFK());
        }
        cFE();
        if (cFC()) {
            AP(this.jVo);
        } else {
            cza();
        }
    }

    private void cFB() {
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
    }

    private boolean cFC() {
        return this.jVo == 1 || this.jVo == 2 || this.jVo == 3;
    }

    private void cza() {
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
                LoginActivity.this.jVh = webAuthResult;
                LoginActivity.this.jVi = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.cFD();
                LoginActivity.this.jVk = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.jVk = -1;
                LoginActivity.this.AQ(0);
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

    private void AP(int i) {
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
                LoginActivity.this.jVh = webAuthResult;
                LoginActivity.this.jVi = webAuthResult.activity;
                LoginActivity.this.cFD();
                LoginActivity.this.jVk = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.jVk = -1;
                LoginActivity.this.AQ(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        };
        if (this.jVp) {
            try {
                Field declaredField = passportSDK.getClass().getDeclaredField("webAuthListener");
                declaredField.setAccessible(true);
                declaredField.set(passportSDK, webAuthListener);
                Field declaredField2 = passportSDK.getClass().getDeclaredField("socialLoginDTO");
                declaredField2.setAccessible(true);
                declaredField2.set(passportSDK, webSocialLoginDTO);
                AbstractThirdPartyService thirdPartyService = passportSDK.getThirdPartyService();
                if (thirdPartyService != null) {
                    thirdPartyService.loadThirdPartyLogin(this, webSocialLoginDTO.socialType, 2002);
                    return;
                }
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
        int i = 1;
        p(accountData);
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.mClose) {
            if (this.jVh != null) {
                this.jVh.finishActivity();
            }
            AQ(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.e.b.c(this.jVi, i, false);
        if (this.jVh != null) {
            this.jVh.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.jVk)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFD() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.eXp != null) {
                this.eXp.cancel();
            }
            this.eXp = a.aPB().a(session.username, session.bduss, "", null, this.eXM);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.isActivityCanShowDialogOrPopupWindow(this.jVi)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.jVi);
            this.mWaitingDialog.setTipString(str);
            this.mWaitingDialog.setCancelListener(onCancelListener);
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AQ(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra(LoginActivityConfig.SOCIAL_TYPE, this.jVo);
        intent.putExtra("activity_id", this.aUO);
        intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.jVp);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.lu().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
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
        this.jVj = TbadkCoreApplication.getCurrentTbs();
        if (this.eiZ == null) {
            this.eiZ = new b(this.jVi);
            this.eiZ.a(this.eXM);
            this.eiZ.b(new b.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.jVj);
                    if (LoginActivity.this.jVh != null) {
                        LoginActivity.this.jVh.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.eiZ.bdz();
        this.eiZ.setAccountData(accountData);
        this.eiZ.bdv();
    }

    private boolean cFE() {
        if (!ar.isEmpty(this.jVn)) {
            String wx = n.wx(this.jVn);
            if (!ar.isEmpty(wx) && n.wv(wx)) {
                if (SapiAccountManager.getInstance().getConfignation() != null) {
                    SapiAccountManager.getInstance().getConfignation().skin = wx;
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
        if (this.jVm == 1) {
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 2, false);
        }
        if (this.eXp != null) {
            this.eXp.cancel();
        }
        if (this.eiZ != null) {
            this.eiZ.onDestroy();
        }
        this.jVh = null;
        this.jVi = null;
        super.onDestroy();
    }
}
