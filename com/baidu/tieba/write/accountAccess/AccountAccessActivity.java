package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
    private NewWriteModel brT;
    private b hCR;
    private a hCS;
    private AccessState hCT;
    private WriteData mWriteData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hCR = new b(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.hCT = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            this.mWriteData = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            if (this.mWriteData == null || this.hCT == null) {
                finish();
                return;
            }
            this.brT = new NewWriteModel(this);
            this.brT.setWriteData(this.mWriteData);
            if (this.mWriteData.getWriteImagesInfo() != null) {
                this.brT.mH(this.mWriteData.getWriteImagesInfo().size() > 0);
            }
            this.hCS = new a(this.hCR, this.brT);
            this.hCR.c(this.hCS);
            this.hCS.start(bEZ());
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
            bkVar.aPu = this.mWriteData;
            bkVar.aPx = this.hCS.bFc();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_VCODE_CHECK_INFO, bkVar));
        }
        super.onDestroy();
        this.hCR.onDestory();
    }

    public String bEZ() {
        if (this.hCT == null || this.hCT.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", "http://tieba.baidu.com/mo/q/account/access", this.hCT.getToken(), this.hCT.getType(), this.hCT.getUserInfo().strMobile, this.hCT.getUserInfo().strEmail);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    setResult(-1, intent);
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    setResult(0, intent);
                    break;
            }
        }
        finish();
    }
}
