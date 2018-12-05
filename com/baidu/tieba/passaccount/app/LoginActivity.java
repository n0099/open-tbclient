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
    private a aMS;
    private BdAsyncTask<?, ?, ?> bAC;
    private WebAuthResult fMv;
    private Activity fMw;
    private String fMz;
    private boolean fMs = false;
    private int fMt = -1;
    private int fMu = 1;
    private String fMx = null;
    private int fMy = -2;
    private final a.InterfaceC0155a bAY = new a.InterfaceC0155a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
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
            TiebaStatic.log(new am("c12948").x("obj_type", LoginActivity.this.fMu).aA("obj_url", LoginActivity.this.fMz));
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
            if (LoginActivity.this.fMw instanceof BaseSSOLoginActivity) {
                LoginActivity.this.fMw.finish();
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
        this.fMs = intent.getBooleanExtra("close", false);
        this.fMt = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.fMz = intent.getStringExtra("url");
        beY();
        TiebaStatic.log(new am("c12947").aA("obj_url", this.fMz));
    }

    protected void beY() {
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
        PassManagerStatic.bfh();
        SapiAccountManager.getInstance().getConfignation().fastLoginFeatureList.clear();
        SapiAccountManager.getInstance().getConfignation().fastLoginFeatureList.addAll(PassManagerStatic.bfd());
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.fMv = webAuthResult;
                LoginActivity.this.fMw = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.beZ();
                LoginActivity.this.fMy = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.finish();
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.fMy = -1;
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
        if (this.fMs) {
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
            com.baidu.tbadk.core.e.b.d(this.fMw, i, false);
        }
        if (this.fMv != null) {
            this.fMv.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.fMy)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beZ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bAC != null) {
                this.bAC.cancel();
            }
            this.bAC = com.baidu.tbadk.core.a.a.xJ().a(session.username, session.bduss, "", null, this.bAY);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.q(this.fMw)) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.d(this.fMw);
            this.mWaitingDialog.gk(str);
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
        this.fMx = TbadkCoreApplication.getCurrentTbs();
        if (this.aMS == null) {
            this.aMS = new com.baidu.tbadk.coreExtra.view.a(this.fMw);
            this.aMS.a(this.bAY);
            this.aMS.b(new a.InterfaceC0165a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0165a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.fMx);
                    if (LoginActivity.this.fMv != null) {
                        LoginActivity.this.fMv.finishActivity();
                        LoginActivity.this.finish();
                    }
                }
            });
        }
        this.aMS.Ku();
        this.aMS.setAccountData(accountData);
        this.aMS.Kq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fMt == 1) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        }
        if (this.bAC != null) {
            this.bAC.cancel();
        }
        if (this.aMS != null) {
            this.aMS.onDestroy();
        }
        this.fMv = null;
        this.fMw = null;
        super.onDestroy();
    }
}
