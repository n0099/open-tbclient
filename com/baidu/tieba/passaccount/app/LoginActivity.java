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
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.g.h;
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
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private BdAsyncTask<?, ?, ?> cXj;
    private c cfZ;
    private WebAuthResult hGC;
    private Activity hGD;
    private String hGH;
    private String hGJ;
    private int hGK;
    private String hGL;
    private boolean hGM;
    private int hGB = 1;
    private String hGE = null;
    private int hGF = -2;
    private boolean hGG = false;
    private int hGI = -1;
    private final a.InterfaceC0248a cXF = new a.InterfaceC0248a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0248a
        public void mm(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(R.string.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0248a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new an("c12948").P("obj_type", LoginActivity.this.hGB).bT("obj_url", LoginActivity.this.hGH));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0248a
        public void h(String str, int i, String str2) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.hGD instanceof BaseSSOLoginActivity) {
                LoginActivity.this.hGD.finish();
            }
            LoginActivity.this.xB(0);
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
        bSj();
        bSk();
        TiebaStatic.log(new an("c12947").bT("obj_url", this.hGH));
    }

    private void bSj() {
        Intent intent = getIntent();
        this.hGG = intent.getBooleanExtra("close", false);
        this.hGI = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.hGH = intent.getStringExtra("url");
        this.hGK = intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0);
        this.hGJ = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.hGL = intent.getStringExtra("activity_id");
        this.hGM = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
    }

    protected void bSk() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
        }
        MessageManager.getInstance().runTask(2921332, (Class) null);
        PassManagerStatic.bSv();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && confignation.fastLoginFeatureList != null) {
            confignation.fastLoginFeatureList.clear();
            confignation.fastLoginFeatureList.addAll(PassManagerStatic.bSt());
        }
        bSo();
        if (bSl()) {
            xA(this.hGK);
        } else {
            bSm();
        }
    }

    private boolean bSl() {
        return this.hGK == 1 || this.hGK == 2 || this.hGK == 3;
    }

    private void bSm() {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (d.hS().az("android_pass_login_sms_enable") == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.hGC = webAuthResult;
                LoginActivity.this.hGD = webAuthResult.activity;
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.bSn();
                LoginActivity.this.hGF = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.hGF = -1;
                LoginActivity.this.xB(0);
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

    private void xA(int i) {
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
                LoginActivity.this.hGC = webAuthResult;
                LoginActivity.this.hGD = webAuthResult.activity;
                LoginActivity.this.bSn();
                LoginActivity.this.hGF = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.hGF = -1;
                LoginActivity.this.xB(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        };
        if (this.hGM) {
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
        com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.hGG) {
            if (this.hGC != null) {
                this.hGC.finishActivity();
            }
            xB(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (b.ahU().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            b.ahU().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.f.b.c(this.hGD, i, false);
        if (this.hGC != null) {
            this.hGC.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.hGF)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSn() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.cXj != null) {
                this.cXj.cancel();
            }
            this.cXj = a.acj().a(session.username, session.bduss, "", null, this.cXF);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.t(this.hGD)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.hGD);
            this.mWaitingDialog.oU(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.en(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.em(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra(LoginActivityConfig.SOCIAL_TYPE, this.hGK);
        intent.putExtra("activity_id", this.hGL);
        intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.hGM);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.iL().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        });
        com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.cl(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        this.hGE = TbadkCoreApplication.getCurrentTbs();
        if (this.cfZ == null) {
            this.cfZ = new c(this.hGD);
            this.cfZ.a(this.cXF);
            this.cfZ.b(new c.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.hGE);
                    if (LoginActivity.this.hGC != null) {
                        LoginActivity.this.hGC.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.cfZ.aqF();
        this.cfZ.setAccountData(accountData);
        this.cfZ.aqB();
    }

    private boolean bSo() {
        if (!aq.isEmpty(this.hGJ)) {
            String nJ = m.nJ(this.hGJ);
            if (!aq.isEmpty(nJ) && m.nz(nJ)) {
                SapiAccountManager.getInstance().getConfignation().skin = nJ;
                return true;
            }
        }
        SapiAccountManager.getInstance().getConfignation().skin = "file:///android_asset/sapi_theme/style.css";
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hGI == 1) {
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 2, false);
        }
        if (this.cXj != null) {
            this.cXj.cancel();
        }
        if (this.cfZ != null) {
            this.cfZ.onDestroy();
        }
        this.hGC = null;
        this.hGD = null;
        super.onDestroy();
    }
}
