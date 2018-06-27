package com.baidu.tieba.passaccount.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tieba.d;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private a aBd;
    private BdAsyncTask<?, ?, ?> blP;
    private WebAuthResult fpg;
    private Activity fph;
    private boolean fpd = false;
    private int fpe = -1;
    private int fpf = 1;
    private final a.InterfaceC0101a bmm = new a.InterfaceC0101a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0101a
        public void de(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(d.k.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0101a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new an("c12948").r("obj_type", LoginActivity.this.fpf));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0101a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.fph instanceof BaseSSOLoginActivity) {
                LoginActivity.this.fph.finish();
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
        this.fpd = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.fpe = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        aZU();
        TiebaStatic.log(new an("c12947"));
    }

    protected void aZU() {
        MessageManager.getInstance().runTask(2921332, (Class) null);
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        PassManagerStatic.switchNightMode();
        SapiAccountManager.getInstance().getConfignation().fastLoginFeatureList.clear();
        SapiAccountManager.getInstance().getConfignation().fastLoginFeatureList.addAll(PassManagerStatic.aZZ());
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.fpg = webAuthResult;
                LoginActivity.this.fph = webAuthResult.activity;
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.aZV();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.finish();
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
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
        if (this.fpd) {
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
            com.baidu.tbadk.core.e.b.c(this.fph, i, false);
        }
        if (this.fpg != null) {
            this.fpg.finishActivity();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZV() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.blP != null) {
                this.blP.cancel();
            }
            this.blP = com.baidu.tbadk.core.a.a.tA().a(session.username, session.bduss, "", null, this.bmm);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.n(this.fph)) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fph);
            this.mWaitingDialog.fm(str);
            this.mWaitingDialog.d(onCancelListener);
            this.mWaitingDialog.aP(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.aO(true);
        }
    }

    private void p(final AccountData accountData) {
        h.in().c(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.aB(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aBd == null) {
            this.aBd = new com.baidu.tbadk.coreExtra.view.a(this.fph);
            this.aBd.a(new a.InterfaceC0110a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0110a
                public void g(AccountData accountData2) {
                    LoginActivity.this.o(accountData2);
                }
            });
            this.aBd.b(new a.InterfaceC0110a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0110a
                public void g(AccountData accountData2) {
                    if (LoginActivity.this.fpg != null) {
                        LoginActivity.this.fpg.finishActivity();
                        LoginActivity.this.finish();
                    }
                }
            });
        }
        this.aBd.FR();
        this.aBd.setAccountData(accountData);
        this.aBd.FN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fpe == 1) {
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 2, false);
        }
        if (this.blP != null) {
            this.blP.cancel();
        }
        if (this.aBd != null) {
            this.aBd.onDestroy();
        }
        this.fpg = null;
        this.fph = null;
        super.onDestroy();
    }
}
