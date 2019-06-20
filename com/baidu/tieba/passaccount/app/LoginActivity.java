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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private BdAsyncTask<?, ?, ?> cUN;
    private c cdW;
    private WebAuthResult hxC;
    private Activity hxD;
    private String hxH;
    private String hxJ;
    private int hxK;
    private String hxL;
    private int hxB = 1;
    private String hxE = null;
    private int hxF = -2;
    private boolean hxG = false;
    private int hxI = -1;
    private final a.InterfaceC0237a cVj = new a.InterfaceC0237a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0237a
        public void ma(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(R.string.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0237a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new am("c12948").P("obj_type", LoginActivity.this.hxB).bT("obj_url", LoginActivity.this.hxH));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0237a
        public void h(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.hxD instanceof BaseSSOLoginActivity) {
                LoginActivity.this.hxD.finish();
            }
            LoginActivity.this.wT(0);
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
        bOy();
        bOz();
        TiebaStatic.log(new am("c12947").bT("obj_url", this.hxH));
    }

    private void bOy() {
        Intent intent = getIntent();
        this.hxG = intent.getBooleanExtra("close", false);
        this.hxI = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.hxH = intent.getStringExtra("url");
        this.hxK = intent.getIntExtra("social_type", 0);
        this.hxJ = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.hxL = intent.getStringExtra("activity_id");
    }

    protected void bOz() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
        }
        MessageManager.getInstance().runTask(2921332, (Class) null);
        PassManagerStatic.bOK();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && confignation.fastLoginFeatureList != null) {
            confignation.fastLoginFeatureList.clear();
            confignation.fastLoginFeatureList.addAll(PassManagerStatic.bOH());
        }
        bOD();
        if (bOA()) {
            wS(this.hxK);
        } else {
            bOB();
        }
    }

    private boolean bOA() {
        return this.hxK == 1 || this.hxK == 2 || this.hxK == 3;
    }

    private void bOB() {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (d.hI().ay("android_pass_login_sms_enable") == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.hxC = webAuthResult;
                LoginActivity.this.hxD = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.bOC();
                LoginActivity.this.hxF = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.hxF = -1;
                LoginActivity.this.wT(0);
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

    private void wS(int i) {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        if (i == 1) {
            webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
        } else if (i == 2) {
            webSocialLoginDTO.socialType = SocialType.WEIXIN;
        } else if (i == 3) {
            webSocialLoginDTO.socialType = SocialType.QQ_SSO;
        }
        passportSDK.loadThirdPartyLogin(new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.hxC = webAuthResult;
                LoginActivity.this.hxD = webAuthResult.activity;
                LoginActivity.this.bOC();
                LoginActivity.this.hxF = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.hxF = -1;
                LoginActivity.this.wT(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        }, webSocialLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        int i = 1;
        p(accountData);
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.hxG) {
            if (this.hxC != null) {
                this.hxC.finishActivity();
            }
            wT(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (b.agM().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            b.agM().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.e.b.c(this.hxD, i, false);
        if (this.hxC != null) {
            this.hxC.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.hxF)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOC() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.cUN != null) {
                this.cUN.cancel();
            }
            this.cUN = a.abg().a(session.username, session.bduss, "", null, this.cVj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.q(this.hxD)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.hxD);
            this.mWaitingDialog.ov(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.eg(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.ef(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wT(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra("social_type", this.hxK);
        intent.putExtra("activity_id", this.hxL);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.iC().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.ck(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        this.hxE = TbadkCoreApplication.getCurrentTbs();
        if (this.cdW == null) {
            this.cdW = new c(this.hxD);
            this.cdW.a(this.cVj);
            this.cdW.b(new c.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.hxE);
                    if (LoginActivity.this.hxC != null) {
                        LoginActivity.this.hxC.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.cdW.apm();
        this.cdW.setAccountData(accountData);
        this.cdW.aph();
    }

    private boolean bOD() {
        if (!ap.isEmpty(this.hxJ)) {
            String nv = m.nv(this.hxJ);
            if (!ap.isEmpty(nv) && m.nl(nv)) {
                SapiAccountManager.getInstance().getConfignation().skin = nv;
                return true;
            }
        }
        SapiAccountManager.getInstance().getConfignation().skin = "file:///android_asset/sapi_theme/style.css";
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hxI == 1) {
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 2, false);
        }
        if (this.cUN != null) {
            this.cUN.cancel();
        }
        if (this.cdW != null) {
            this.cdW.onDestroy();
        }
        this.hxC = null;
        this.hxD = null;
        super.onDestroy();
    }
}
