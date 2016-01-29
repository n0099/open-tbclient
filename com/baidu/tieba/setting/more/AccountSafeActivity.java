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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AccountSafeActivity extends BaseActivity<AccountSafeActivity> {
    private String dJA;
    private String dJB;
    private com.baidu.adp.framework.listener.a dJC = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private f dJy;
    private com.baidu.tieba.setting.model.b dJz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dJy = new f(this);
        aGJ();
        registerListener(this.dJC);
        this.dJz = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iZ()) {
            this.dJz.aGC();
        } else {
            showToast(t.j.neterror);
        }
    }

    private void aGJ() {
        if (this.dJy != null && this.dJy.UM() != null) {
            this.dJy.UM().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGK() {
        if (this.dJz != null && !this.dJz.isLoading()) {
            this.dJz.aGC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.dJz != null) {
            this.dJz.cancelLoadData();
        }
        if (this.dJy != null) {
            this.dJy.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dJy != null) {
            this.dJy.ej(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != t.g.voicelogin_lock_layout) {
            if (view.getId() == t.g.secure_mobil) {
                TiebaStatic.log("c10020");
                if (aGL()) {
                    if (!TextUtils.isEmpty(this.dJB)) {
                        nK(3);
                    } else {
                        nK(1);
                    }
                }
            } else if (view.getId() == t.g.secure_email) {
                TiebaStatic.log("c10022");
                if (aGL()) {
                    if (!TextUtils.isEmpty(this.dJA)) {
                        nK(4);
                    } else {
                        nK(2);
                    }
                }
            } else if (view.getId() == t.g.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iZ()) {
                    showToast(t.j.neterror);
                } else {
                    nK(0);
                }
            } else if (view.getId() == t.g.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iZ()) {
                    showToast(t.j.neterror);
                } else {
                    be.wt().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == t.g.account_status) {
                com.baidu.tbadk.browser.f.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    private boolean aGL() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            showToast(t.j.neterror);
            return false;
        } else if (this.dJz != null && !this.dJz.isFinished()) {
            showToast(t.j.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void nK(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            aGK();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ay(boolean z) {
            if (AccountSafeActivity.this.dJy != null && AccountSafeActivity.this.dJz != null && AccountSafeActivity.this.dJy.UM() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.dJz.isFinished()) {
                        AccountSafeActivity.this.aGK();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
