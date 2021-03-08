package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tbadk.suspended.a;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.a.c;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes7.dex */
public class LoginDialogActivity extends SuspendedActivity implements a {
    private String ePK;
    private ViewGroup fEN;
    private BdAsyncTask<?, ?, ?> ghG;
    private final a.InterfaceC0561a gic = new a.InterfaceC0561a() { // from class: com.baidu.tieba.passaccount.app.LoginDialogActivity.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0561a
        public void onBeforeLogin(String str) {
            LoginDialogActivity.this.showLoading();
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0561a
        public void a(AccountData accountData) {
            LoginDialogActivity.this.closeLoadingDialog();
            LoginDialogActivity.this.q(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0561a
        public void onFailure(String str, int i, String str2) {
            LoginDialogActivity.this.closeLoadingDialog();
            LoginDialogActivity.this.showToast(str2);
        }
    };
    private com.baidu.tieba.passaccount.a.a lIp;
    private String lIq;
    private String lIr;
    private String lIs;
    private String operator;
    private String phoneNum;
    private String sign;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fEN = linearLayout;
        navigationBar.setVisibility(8);
        if (getIntent() == null) {
            finish();
        } else {
            initData();
            if (TextUtils.isEmpty(this.lIq)) {
                this.lIp = new b(this.phoneNum, this.operator, this.sign);
            } else {
                this.lIp = new c(this.lIq);
            }
            this.lIp.a(this, linearLayout);
        }
        return this;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bER() {
    }

    private void initData() {
        this.lIq = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
        this.phoneNum = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
        this.operator = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
        this.sign = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
        this.lIr = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_URL);
        this.ePK = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_LOCATE);
        this.lIs = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_TYPE);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEL() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
        this.fEN.setBackgroundResource(R.color.transparent);
        if (this.lIp != null) {
            this.lIp.rz(i);
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
        if (this.lIp != null) {
            return this.lIp.bEN();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.lIp != null) {
            this.lIp.onActivityResult(i, i2, intent);
        }
    }

    public void djV() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.ghG != null) {
                this.ghG.cancel();
            }
            this.ghG = com.baidu.tbadk.core.a.a.bkW().a(session.username, session.bduss, "", null, this.gic);
            return;
        }
        closeLoadingDialog();
        Fp(0);
    }

    public void showLoading() {
        if (getLoadingDialog() == null || !getLoadingDialog().isShowing()) {
            showLoadingDialog(getPageContext().getString(R.string.sapi_logining));
            getLoadingDialog().setCancelable(false);
            getLoadingDialog().setCanceledOnTouchOutside(false);
        }
    }

    public void Pd(String str) {
        if (getIntent() != null) {
            h.ao(this.ePK, this.lIs, str);
        }
    }

    public void Fp(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        setResult(i, intent);
        finish();
    }

    private void djX() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginDialogActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.passaccount.app.LoginDialogActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (!StringUtils.isNull(LoginDialogActivity.this.lIr)) {
                    bf.bsY().a(LoginDialogActivity.this.getPageContext(), new String[]{LoginDialogActivity.this.lIr});
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(AccountData accountData) {
        p(accountData);
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        Fp(-1);
        if (d.biT()) {
            com.baidu.tbadk.BdToken.c.bhp().bhq();
        }
        djX();
    }

    private void p(final AccountData accountData) {
        com.baidu.adp.lib.f.h.mB().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginDialogActivity.3
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
}
