package com.baidu.tieba.setting.more;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
/* loaded from: classes.dex */
public class AccountSafeActivity extends BaseActivity<AccountSafeActivity> {
    private f dmi;
    private com.baidu.tieba.setting.model.b dmj;
    private String dmk;
    private String dml;
    private com.baidu.adp.framework.listener.a dmm = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmi = new f(this);
        axw();
        registerListener(this.dmm);
        this.dmj = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iP()) {
            this.dmj.axo();
        } else {
            showToast(n.i.neterror);
        }
    }

    private void axw() {
        if (this.dmi != null && this.dmi.Sl() != null) {
            this.dmi.Sl().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axx() {
        if (this.dmj != null && !this.dmj.isLoading()) {
            this.dmj.axo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.dmj != null) {
            this.dmj.cancelLoadData();
        }
        if (this.dmi != null) {
            this.dmi.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dmi != null) {
            this.dmi.dU(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != n.f.voicelogin_lock_layout) {
            if (view.getId() == n.f.secure_mobil) {
                TiebaStatic.log("c10020");
                if (axy()) {
                    if (!TextUtils.isEmpty(this.dml)) {
                        lW(3);
                    } else {
                        lW(1);
                    }
                }
            } else if (view.getId() == n.f.secure_email) {
                TiebaStatic.log("c10022");
                if (axy()) {
                    if (!TextUtils.isEmpty(this.dmk)) {
                        lW(4);
                    } else {
                        lW(2);
                    }
                }
            } else if (view.getId() == n.f.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iP()) {
                    showToast(n.i.neterror);
                } else {
                    lW(0);
                }
            } else if (view.getId() == n.f.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iP()) {
                    showToast(n.i.neterror);
                } else {
                    bf.vD().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == n.f.account_status) {
                com.baidu.tbadk.browser.f.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    private boolean axy() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            showToast(n.i.neterror);
            return false;
        } else if (this.dmj != null && !this.dmj.isFinished()) {
            showToast(n.i.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void lW(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            axx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aA(boolean z) {
            if (AccountSafeActivity.this.dmi != null && AccountSafeActivity.this.dmj != null && AccountSafeActivity.this.dmi.Sl() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.dmj.isFinished()) {
                        AccountSafeActivity.this.axx();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
