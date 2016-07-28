package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a asZ;
    private c fPB;
    private a fPC;
    private AccessState fPD;
    private WriteData fPE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fPB = new c(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.fPD = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.fPE = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.fPE == null || this.fPD == null) {
                finish();
                return;
            }
            this.asZ = new com.baidu.tieba.tbadkCore.writeModel.a(this);
            this.asZ.d(this.fPE);
            if (this.fPE.getWriteImagesInfo() != null) {
                this.asZ.kB(this.fPE.getWriteImagesInfo().size() > 0);
            }
            this.fPC = new a(this.fPB, this.asZ);
            this.fPB.c(this.fPC);
            this.fPC.start(bmX());
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
        this.fPB.onDestory();
    }

    public String bmX() {
        if (this.fPD == null || this.fPD.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.fPD.getToken(), this.fPD.getType(), this.fPD.getUserInfo().strMobile, this.fPD.getUserInfo().strEmail);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12006:
                    setResult(-1, intent);
                    break;
            }
        }
        finish();
    }
}
