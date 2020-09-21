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
    private NewWriteModel ePk;
    private WriteData inl;
    private b mXa;
    private a mXb;
    private AccessState mXc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mXa = new b(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mXc = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.inl = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.inl == null || this.mXc == null) {
                finish();
                return;
            }
            this.ePk = new NewWriteModel(this);
            this.ePk.e(this.inl);
            if (this.inl.getWriteImagesInfo() != null) {
                this.ePk.wr(this.inl.getWriteImagesInfo().size() > 0);
            }
            this.mXb = new a(this.mXa, this.ePk);
            this.mXa.c(this.mXb);
            this.mXb.bs(dJP());
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
        this.mXa.onDestory();
    }

    public String dJP() {
        if (this.mXc == null || this.mXc.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.mXc.getToken(), this.mXc.getType(), this.mXc.getUserInfo().strMobile, this.mXc.getUserInfo().strEmail);
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
