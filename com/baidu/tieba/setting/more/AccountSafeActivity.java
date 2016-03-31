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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AccountSafeActivity extends BaseActivity<AccountSafeActivity> {
    private f ebS;
    private com.baidu.tieba.setting.model.b ebT;
    private String ebU;
    private String ebV;
    private com.baidu.adp.framework.listener.a ebW = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ebS = new f(this);
        aNt();
        registerListener(this.ebW);
        this.ebT = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.jf()) {
            this.ebT.aNm();
        } else {
            showToast(t.j.neterror);
        }
    }

    private void aNt() {
        if (this.ebS != null && this.ebS.WG() != null) {
            this.ebS.WG().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNu() {
        if (this.ebT != null && !this.ebT.isLoading()) {
            this.ebT.aNm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.ebT != null) {
            this.ebT.cancelLoadData();
        }
        if (this.ebS != null) {
            this.ebS.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ebS != null) {
            this.ebS.em(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != t.g.voicelogin_lock_layout) {
            if (view.getId() == t.g.secure_mobil) {
                TiebaStatic.log("c10020");
                if (aNv()) {
                    if (!TextUtils.isEmpty(this.ebV)) {
                        oP(3);
                    } else {
                        oP(1);
                    }
                }
            } else if (view.getId() == t.g.secure_email) {
                TiebaStatic.log("c10022");
                if (aNv()) {
                    if (!TextUtils.isEmpty(this.ebU)) {
                        oP(4);
                    } else {
                        oP(2);
                    }
                }
            } else if (view.getId() == t.g.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.jf()) {
                    showToast(t.j.neterror);
                } else {
                    oP(0);
                }
            } else if (view.getId() == t.g.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.jf()) {
                    showToast(t.j.neterror);
                } else {
                    bg.wM().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == t.g.account_status) {
                com.baidu.tbadk.browser.f.s(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    private boolean aNv() {
        if (!com.baidu.adp.lib.util.i.jf()) {
            showToast(t.j.neterror);
            return false;
        } else if (this.ebT != null && !this.ebT.isFinished()) {
            showToast(t.j.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void oP(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            aNu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aA(boolean z) {
            if (AccountSafeActivity.this.ebS != null && AccountSafeActivity.this.ebT != null && AccountSafeActivity.this.ebS.WG() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.ebT.isFinished()) {
                        AccountSafeActivity.this.aNu();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
