package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes2.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    private NewWriteModel aDz;
    private b hbZ;
    private a hca;
    private AccessState hcb;
    private WriteData mWriteData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbZ = new b(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.hcb = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.mWriteData = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.mWriteData == null || this.hcb == null) {
                finish();
                return;
            }
            this.aDz = new NewWriteModel(this);
            this.aDz.setWriteData(this.mWriteData);
            if (this.mWriteData.getWriteImagesInfo() != null) {
                this.aDz.ng(this.mWriteData.getWriteImagesInfo().size() > 0);
            }
            this.hca = new a(this.hbZ, this.aDz);
            this.hbZ.c(this.hca);
            this.hca.start(bFd());
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
        if (this.mWriteData != null && this.mWriteData.getIsStory() == 1) {
            bk bkVar = new bk();
            bkVar.aaZ = this.mWriteData;
            bkVar.abd = this.hca.bFg();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_VCODE_CHECK_INFO, bkVar));
        }
        super.onDestroy();
        this.hbZ.onDestory();
    }

    public String bFd() {
        if (this.hcb == null || this.hcb.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.hcb.getToken(), this.hcb.getType(), this.hcb.getUserInfo().strMobile, this.hcb.getUserInfo().strEmail);
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
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    setResult(0, intent);
                    break;
            }
        }
        finish();
    }
}
