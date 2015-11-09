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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
/* loaded from: classes.dex */
public class AccountSafeActivity extends BaseActivity<AccountSafeActivity> {
    private f cNR;
    private com.baidu.tieba.setting.model.b cNS;
    private String cNT;
    private String cNU;
    private com.baidu.adp.framework.listener.a cNV = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cNR = new f(this);
        arY();
        registerListener(this.cNV);
        this.cNS = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iN()) {
            this.cNS.arQ();
        } else {
            showToast(i.h.neterror);
        }
    }

    private void arY() {
        if (this.cNR != null && this.cNR.PV() != null) {
            this.cNR.PV().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arZ() {
        if (this.cNS != null && !this.cNS.isLoading()) {
            this.cNS.arQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.cNS != null) {
            this.cNS.cancelLoadData();
        }
        if (this.cNR != null) {
            this.cNR.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cNR != null) {
            this.cNR.dF(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.voicelogin_lock_layout) {
            if (view.getId() == i.f.secure_mobil) {
                TiebaStatic.log("c10020");
                if (asa()) {
                    if (!TextUtils.isEmpty(this.cNU)) {
                        kO(3);
                    } else {
                        kO(1);
                    }
                }
            } else if (view.getId() == i.f.secure_email) {
                TiebaStatic.log("c10022");
                if (asa()) {
                    if (!TextUtils.isEmpty(this.cNT)) {
                        kO(4);
                    } else {
                        kO(2);
                    }
                }
            } else if (view.getId() == i.f.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iN()) {
                    showToast(i.h.neterror);
                } else {
                    kO(0);
                }
            } else if (view.getId() == i.f.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iN()) {
                    showToast(i.h.neterror);
                } else {
                    az.uX().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == i.f.account_status) {
                com.baidu.tbadk.browser.g.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    private boolean asa() {
        if (!com.baidu.adp.lib.util.i.iN()) {
            showToast(i.h.neterror);
            return false;
        } else if (this.cNS != null && !this.cNS.isFinished()) {
            showToast(i.h.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void kO(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            arZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ax(boolean z) {
            if (AccountSafeActivity.this.cNR != null && AccountSafeActivity.this.cNS != null && AccountSafeActivity.this.cNR.PV() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.cNS.isFinished()) {
                        AccountSafeActivity.this.arZ();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
