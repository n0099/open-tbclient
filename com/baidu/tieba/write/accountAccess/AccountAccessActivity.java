package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    private NewWriteModel aAP;
    private AccessState fMA;
    private c fMy;
    private a fMz;
    private WriteData mWriteData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMy = new c(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.fMA = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.mWriteData = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.mWriteData == null || this.fMA == null) {
                finish();
                return;
            }
            this.aAP = new NewWriteModel(this);
            this.aAP.setWriteData(this.mWriteData);
            if (this.mWriteData.getWriteImagesInfo() != null) {
                this.aAP.lo(this.mWriteData.getWriteImagesInfo().size() > 0);
            }
            this.fMz = new a(this.fMy, this.aAP);
            this.fMy.c(this.fMz);
            this.fMz.start(bnc());
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
        this.fMy.onDestory();
    }

    public String bnc() {
        if (this.fMA == null || this.fMA.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.fMA.getToken(), this.fMA.getType(), this.fMA.getUserInfo().strMobile, this.fMA.getUserInfo().strEmail);
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
