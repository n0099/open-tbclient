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
    private f dtu;
    private com.baidu.tieba.setting.model.b dtv;
    private String dtw;
    private String dtx;
    private com.baidu.adp.framework.listener.a dty = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtu = new f(this);
        azC();
        registerListener(this.dty);
        this.dtv = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iQ()) {
            this.dtv.azv();
        } else {
            showToast(n.j.neterror);
        }
    }

    private void azC() {
        if (this.dtu != null && this.dtu.SD() != null) {
            this.dtu.SD().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azD() {
        if (this.dtv != null && !this.dtv.isLoading()) {
            this.dtv.azv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.dtv != null) {
            this.dtv.cancelLoadData();
        }
        if (this.dtu != null) {
            this.dtu.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dtu != null) {
            this.dtu.dO(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != n.g.voicelogin_lock_layout) {
            if (view.getId() == n.g.secure_mobil) {
                TiebaStatic.log("c10020");
                if (azE()) {
                    if (!TextUtils.isEmpty(this.dtx)) {
                        my(3);
                    } else {
                        my(1);
                    }
                }
            } else if (view.getId() == n.g.secure_email) {
                TiebaStatic.log("c10022");
                if (azE()) {
                    if (!TextUtils.isEmpty(this.dtw)) {
                        my(4);
                    } else {
                        my(2);
                    }
                }
            } else if (view.getId() == n.g.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iQ()) {
                    showToast(n.j.neterror);
                } else {
                    my(0);
                }
            } else if (view.getId() == n.g.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iQ()) {
                    showToast(n.j.neterror);
                } else {
                    bf.vn().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == n.g.account_status) {
                com.baidu.tbadk.browser.f.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    private boolean azE() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            showToast(n.j.neterror);
            return false;
        } else if (this.dtv != null && !this.dtv.isFinished()) {
            showToast(n.j.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void my(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            azD();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ax(boolean z) {
            if (AccountSafeActivity.this.dtu != null && AccountSafeActivity.this.dtv != null && AccountSafeActivity.this.dtu.SD() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.dtv.isFinished()) {
                        AccountSafeActivity.this.azD();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
