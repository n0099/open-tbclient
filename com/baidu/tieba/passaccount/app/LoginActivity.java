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
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tieba.e;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes6.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private a aMU;
    private BdAsyncTask<?, ?, ?> bAF;
    private WebAuthResult fPn;
    private Activity fPo;
    private String fPr;
    private boolean fPk = false;
    private int fPl = -1;
    private int fPm = 1;
    private String fPp = null;
    private int fPq = -2;
    private final a.InterfaceC0155a bBb = new a.InterfaceC0155a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0155a
        public void ec(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(e.j.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0155a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new am("c12948").x("obj_type", LoginActivity.this.fPm).aA("obj_url", LoginActivity.this.fPr));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0155a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.fPo instanceof BaseSSOLoginActivity) {
                LoginActivity.this.fPo.finish();
            }
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
        Intent intent = getIntent();
        this.fPk = intent.getBooleanExtra("close", false);
        this.fPl = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.fPr = intent.getStringExtra("url");
        bfJ();
        TiebaStatic.log(new am("c12947").aA("obj_url", this.fPr));
    }

    protected void bfJ() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
        }
        MessageManager.getInstance().runTask(2921332, (Class) null);
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (d.iQ().aO("android_pass_login_sms_enable") == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        PassManagerStatic.bfS();
        SapiAccountManager.getInstance().getConfignation().fastLoginFeatureList.clear();
        SapiAccountManager.getInstance().getConfignation().fastLoginFeatureList.addAll(PassManagerStatic.bfO());
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.fPn = webAuthResult;
                LoginActivity.this.fPo = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.bfK();
                LoginActivity.this.fPq = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.finish();
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.fPq = -1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        int i = 1;
        p(accountData);
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.fPk) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.e.b.d(this.fPo, i, false);
        }
        if (this.fPn != null) {
            this.fPn.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.fPq)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfK() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bAF != null) {
                this.bAF.cancel();
            }
            this.bAF = com.baidu.tbadk.core.a.a.xJ().a(session.username, session.bduss, "", null, this.bBb);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.q(this.fPo)) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.d(this.fPo);
            this.mWaitingDialog.gl(str);
            this.mWaitingDialog.d(onCancelListener);
            this.mWaitingDialog.bB(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.bA(true);
        }
    }

    private void p(final AccountData accountData) {
        h.jH().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.br(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        this.fPp = TbadkCoreApplication.getCurrentTbs();
        if (this.aMU == null) {
            this.aMU = new com.baidu.tbadk.coreExtra.view.a(this.fPo);
            this.aMU.a(this.bBb);
            this.aMU.b(new a.InterfaceC0165a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0165a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.fPp);
                    if (LoginActivity.this.fPn != null) {
                        LoginActivity.this.fPn.finishActivity();
                        LoginActivity.this.finish();
                    }
                }
            });
        }
        this.aMU.Kv();
        this.aMU.setAccountData(accountData);
        this.aMU.Kr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fPl == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.bAF != null) {
            this.bAF.cancel();
        }
        if (this.aMU != null) {
            this.aMU.onDestroy();
        }
        this.fPn = null;
        this.fPo = null;
        super.onDestroy();
    }
}
