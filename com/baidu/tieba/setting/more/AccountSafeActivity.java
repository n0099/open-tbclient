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
    private f cMv;
    private com.baidu.tieba.setting.model.b cMw;
    private String cMx;
    private String cMy;
    private com.baidu.adp.framework.listener.a cMz = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cMv = new f(this);
        arw();
        registerListener(this.cMz);
        this.cMw = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iM()) {
            this.cMw.aro();
        } else {
            showToast(i.h.neterror);
        }
    }

    private void arw() {
        if (this.cMv != null && this.cMv.PD() != null) {
            this.cMv.PD().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arx() {
        if (this.cMw != null && !this.cMw.isLoading()) {
            this.cMw.aro();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.cMw != null) {
            this.cMw.cancelLoadData();
        }
        if (this.cMv != null) {
            this.cMv.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cMv != null) {
            this.cMv.dF(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.voicelogin_lock_layout) {
            if (view.getId() == i.f.secure_mobil) {
                TiebaStatic.log("c10020");
                if (ary()) {
                    if (!TextUtils.isEmpty(this.cMy)) {
                        kA(3);
                    } else {
                        kA(1);
                    }
                }
            } else if (view.getId() == i.f.secure_email) {
                TiebaStatic.log("c10022");
                if (ary()) {
                    if (!TextUtils.isEmpty(this.cMx)) {
                        kA(4);
                    } else {
                        kA(2);
                    }
                }
            } else if (view.getId() == i.f.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iM()) {
                    showToast(i.h.neterror);
                } else {
                    kA(0);
                }
            } else if (view.getId() == i.f.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iM()) {
                    showToast(i.h.neterror);
                } else {
                    az.uW().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == i.f.account_status) {
                com.baidu.tbadk.browser.g.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    private boolean ary() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            showToast(i.h.neterror);
            return false;
        } else if (this.cMw != null && !this.cMw.isFinished()) {
            showToast(i.h.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void kA(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            arx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ax(boolean z) {
            if (AccountSafeActivity.this.cMv != null && AccountSafeActivity.this.cMw != null && AccountSafeActivity.this.cMv.PD() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.cMw.isFinished()) {
                        AccountSafeActivity.this.arx();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
