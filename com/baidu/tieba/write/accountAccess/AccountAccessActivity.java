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
    private com.baidu.tieba.tbadkCore.writeModel.b awg;
    private c fZG;
    private a fZH;
    private AccessState fZI;
    private WriteData fZJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fZG = new c(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.fZI = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.fZJ = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.fZJ == null || this.fZI == null) {
                finish();
                return;
            }
            this.awg = new com.baidu.tieba.tbadkCore.writeModel.b(this);
            this.awg.d(this.fZJ);
            if (this.fZJ.getWriteImagesInfo() != null) {
                this.awg.kN(this.fZJ.getWriteImagesInfo().size() > 0);
            }
            this.fZH = new a(this.fZG, this.awg);
            this.fZG.c(this.fZH);
            this.fZH.start(bro());
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
        this.fZG.onDestory();
    }

    public String bro() {
        if (this.fZI == null || this.fZI.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.fZI.getToken(), this.fZI.getType(), this.fZI.getUserInfo().strMobile, this.fZI.getUserInfo().strEmail);
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
