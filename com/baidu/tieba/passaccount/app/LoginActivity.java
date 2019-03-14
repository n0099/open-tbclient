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
import com.baidu.tieba.d;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private c bVX;
    private BdAsyncTask<?, ?, ?> cMx;
    private int hgA;
    private String hgB;
    private WebAuthResult hgs;
    private Activity hgt;
    private String hgx;
    private String hgz;
    private int hgr = 1;
    private String hgu = null;
    private int hgv = -2;
    private boolean hgw = false;
    private int hgy = -1;
    private final a.InterfaceC0222a cMT = new a.InterfaceC0222a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0222a
        public void kV(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(d.j.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0222a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new am("c12948").T("obj_type", LoginActivity.this.hgr).bJ("obj_url", LoginActivity.this.hgx));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0222a
        public void e(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.hgt instanceof BaseSSOLoginActivity) {
                LoginActivity.this.hgt.finish();
            }
            LoginActivity.this.vS(0);
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
        bGN();
        bGO();
        TiebaStatic.log(new am("c12947").bJ("obj_url", this.hgx));
    }

    private void bGN() {
        Intent intent = getIntent();
        this.hgw = intent.getBooleanExtra("close", false);
        this.hgy = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.hgx = intent.getStringExtra("url");
        this.hgA = intent.getIntExtra("social_type", 0);
        this.hgz = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.hgB = intent.getStringExtra("activity_id");
    }

    protected void bGO() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
        }
        MessageManager.getInstance().runTask(2921332, (Class) null);
        PassManagerStatic.bGZ();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && confignation.fastLoginFeatureList != null) {
            confignation.fastLoginFeatureList.clear();
            confignation.fastLoginFeatureList.addAll(PassManagerStatic.bGW());
        }
        bGS();
        if (bGP()) {
            vR(this.hgA);
        } else {
            bGQ();
        }
    }

    private boolean bGP() {
        return this.hgA == 1 || this.hgA == 2 || this.hgA == 3;
    }

    private void bGQ() {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_pass_login_sms_enable") == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.hgs = webAuthResult;
                LoginActivity.this.hgt = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.bGR();
                LoginActivity.this.hgv = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.hgv = -1;
                LoginActivity.this.vS(0);
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

    private void vR(int i) {
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
                LoginActivity.this.hgs = webAuthResult;
                LoginActivity.this.hgt = webAuthResult.activity;
                LoginActivity.this.bGR();
                LoginActivity.this.hgv = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.hgv = -1;
                LoginActivity.this.vS(0);
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
        if (this.hgw) {
            if (this.hgs != null) {
                this.hgs.finishActivity();
            }
            vS(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.e.b.d(this.hgt, i, false);
        if (this.hgs != null) {
            this.hgs.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.hgv)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.cMx != null) {
                this.cMx.cancel();
            }
            this.cMx = a.WD().a(session.username, session.bduss, "", null, this.cMT);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.q(this.hgt)) {
            if (str == null) {
                str = getString(d.j.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.hgt);
            this.mWaitingDialog.nl(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.dK(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.dJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra("social_type", this.hgA);
        intent.putExtra("activity_id", this.hgB);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.jI().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.cF(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        this.hgu = TbadkCoreApplication.getCurrentTbs();
        if (this.bVX == null) {
            this.bVX = new c(this.hgt);
            this.bVX.a(this.cMT);
            this.bVX.b(new c.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.hgu);
                    if (LoginActivity.this.hgs != null) {
                        LoginActivity.this.hgs.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.bVX.akm();
        this.bVX.setAccountData(accountData);
        this.bVX.aki();
    }

    private boolean bGS() {
        if (!ap.isEmpty(this.hgz)) {
            String mn = m.mn(this.hgz);
            if (!ap.isEmpty(mn) && m.md(mn)) {
                SapiAccountManager.getInstance().getConfignation().skin = mn;
                return true;
            }
        }
        SapiAccountManager.getInstance().getConfignation().skin = "file:///android_asset/sapi_theme/style.css";
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hgy == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.cMx != null) {
            this.cMx.cancel();
        }
        if (this.bVX != null) {
            this.bVX.onDestroy();
        }
        this.hgs = null;
        this.hgt = null;
        super.onDestroy();
    }
}
