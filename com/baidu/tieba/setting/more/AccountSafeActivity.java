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
    private f cEV;
    private com.baidu.tieba.setting.model.b cEW;
    private String cEX;
    private String cEY;
    private com.baidu.adp.framework.listener.a cEZ = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cEV = new f(this);
        aoY();
        registerListener(this.cEZ);
        this.cEW = new com.baidu.tieba.setting.model.b();
        if (com.baidu.adp.lib.util.i.iL()) {
            this.cEW.aoQ();
        } else {
            showToast(i.h.neterror);
        }
    }

    private void aoY() {
        if (this.cEV != null && this.cEV.PB() != null) {
            this.cEV.PB().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoZ() {
        if (this.cEW != null && !this.cEW.isLoading()) {
            this.cEW.aoQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeLoadingDialog();
        if (this.cEW != null) {
            this.cEW.cancelLoadData();
        }
        if (this.cEV != null) {
            this.cEV.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cEV != null) {
            this.cEV.dE(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.voicelogin_lock_layout) {
            if (view.getId() == i.f.secure_mobil) {
                TiebaStatic.log("c10020");
                if (apa()) {
                    if (!TextUtils.isEmpty(this.cEY)) {
                        jZ(3);
                    } else {
                        jZ(1);
                    }
                }
            } else if (view.getId() == i.f.secure_email) {
                TiebaStatic.log("c10022");
                if (apa()) {
                    if (!TextUtils.isEmpty(this.cEX)) {
                        jZ(4);
                    } else {
                        jZ(2);
                    }
                }
            } else if (view.getId() == i.f.modify_pwd) {
                TiebaStatic.log("c10018");
                if (!com.baidu.adp.lib.util.i.iL()) {
                    showToast(i.h.neterror);
                } else {
                    jZ(0);
                }
            } else if (view.getId() == i.f.bar_record) {
                TiebaStatic.log("c10013");
                if (!com.baidu.adp.lib.util.i.iL()) {
                    showToast(i.h.neterror);
                } else {
                    ax.uX().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else {
                view.getId();
                int i = i.f.account_status;
            }
        }
    }

    private boolean apa() {
        if (!com.baidu.adp.lib.util.i.iL()) {
            showToast(i.h.neterror);
            return false;
        } else if (this.cEW != null && !this.cEW.isFinished()) {
            showToast(i.h.data_load_error);
            return false;
        } else {
            return true;
        }
    }

    private void jZ(int i) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SapiWebViewActivityConfig(getPageContext().getPageActivity(), 11039, i, SapiAccountManager.getInstance().getSession("bduss"), true)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11039 && i2 == -1) {
            aoZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ay(boolean z) {
            if (AccountSafeActivity.this.cEV != null && AccountSafeActivity.this.cEW != null && AccountSafeActivity.this.cEV.PB() != null) {
                if (z) {
                    if (!AccountSafeActivity.this.cEW.isFinished()) {
                        AccountSafeActivity.this.aoZ();
                        return;
                    }
                    return;
                }
                AccountSafeActivity.this.closeLoadingDialog();
            }
        }
    }
}
