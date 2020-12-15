package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes3.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    private NewWriteModel fwu;
    private WriteData jgi;
    private b nUC;
    private a nUD;
    private AccessState nUE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nUC = new b(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.nUE = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.jgi = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.jgi == null || this.nUE == null) {
                finish();
                return;
            }
            this.fwu = new NewWriteModel(this);
            this.fwu.e(this.jgi);
            if (this.jgi.getWriteImagesInfo() != null) {
                this.fwu.yk(this.jgi.getWriteImagesInfo().size() > 0);
            }
            this.nUD = new a(this.nUC, this.fwu);
            this.nUC.c(this.nUD);
            this.nUD.bv(dYD());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nUC.onDestory();
    }

    public String dYD() {
        if (this.nUE == null || this.nUE.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.nUE.getToken(), this.nUE.getType(), this.nUE.getUserInfo().strMobile, this.nUE.getUserInfo().strEmail);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    setResult(-1, intent);
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    setResult(0, intent);
                    break;
            }
        }
        finish();
    }
}
