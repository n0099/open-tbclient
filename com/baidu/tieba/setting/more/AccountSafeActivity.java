package com.baidu.tieba.setting.more;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SapiWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AccountSafeActivity extends BaseActivity<AccountSafeActivity> {
    private String cwA;
    private String cwB;
    private com.baidu.adp.framework.listener.a cwC = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private f cwy;
    private com.baidu.tieba.setting.model.b cwz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cwy = new f(this);
        akR();
        registerListener(this.cwC);
        this.cwz = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iO()) {
            this.cwz.akJ();
        } else {
            showToast(i.C0057i.neterror);
        }
    }

    private void akR() {
        if (this.cwy != null && this.cwy.PA() != null) {
            this.cwy.PA().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akS() {
        if (this.cwz != null && !this.cwz.isLoading()) {
            this.cwz.akJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.cwz != null) {
            this.cwz.cancelLoadData();
        }
        if (this.cwy != null) {
            this.cwy.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cwy != null) {
            this.cwy.dw(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.voicelogin_lock_layout) {
            if (view.getId() == i.f.secure_mobil) {
                TiebaStatic.log("c10020");
                if (akT()) {
                    if (!TextUtils.isEmpty(this.cwB)) {
                        jp(3);
                    } else {
                        jp(1);
                    }
                }
            } else if (view.getId() == i.f.secure_email) {
                TiebaStatic.log("c10022");
                if (akT()) {
                    if (!TextUtils.isEmpty(this.cwA)) {
                        jp(4);
                    } else {
                        jp(2);
                    }
                }
            } else if (view.getId() == i.f.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iO()) {
                    showToast(i.C0057i.neterror);
                } else {
                    jp(0);
                }
            } else if (view.getId() == i.f.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iO()) {
                    showToast(i.C0057i.neterror);
                } else {
                    ax.uR().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else {
                view.getId();
                int i = i.f.account_status;
            }
        }
    }

    private boolean akT() {
        if (!com.baidu.adp.lib.util.i.iO()) {
            showToast(i.C0057i.neterror);
            return false;
        } else if (this.cwz != null && !this.cwz.isFinished()) {
            showToast(i.C0057i.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void jp(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            akS();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ay(boolean z) {
            if (AccountSafeActivity.this.cwy != null && AccountSafeActivity.this.cwz != null && AccountSafeActivity.this.cwy.PA() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.cwz.isFinished()) {
                        AccountSafeActivity.this.akS();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
