package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.b;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel aDW;
    private NewVcodeView gET;
    private b gEU;
    private boolean mNeedFeedBackButton;
    private WriteData mWriteData = null;
    private int mPageType = 0;
    private NewWriteModel.d gEV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (qVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = com.baidu.adp.lib.g.b.g("4", 0);
                NewVcodeActivity.this.gEU.onPostThreadCancle();
                NewVcodeActivity.this.gEU.onDestroy();
                NewVcodeActivity.this.mWriteData = writeData;
                NewVcodeActivity.this.mWriteData.setVcodeMD5(qVar.getVcode_md5());
                NewVcodeActivity.this.mWriteData.setVcodeUrl(qVar.getVcode_pic_url());
                NewVcodeActivity.this.mWriteData.setVcodeExtra(qVar.yy());
                NewVcodeActivity.this.aDW.setWriteData(NewVcodeActivity.this.mWriteData);
                NewVcodeActivity.this.gEU = NewVcodeActivity.this.bzm();
                NewVcodeActivity.this.gEU.showErrorOnStart(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.gET.setPresenter(NewVcodeActivity.this.gEU);
                NewVcodeActivity.this.gEU.start(NewVcodeActivity.this.mNeedFeedBackButton);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gET = new NewVcodeView(this);
        if (bundle != null) {
            this.mWriteData = (WriteData) bundle.getSerializable("model");
            this.mNeedFeedBackButton = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.mWriteData = (WriteData) intent.getSerializableExtra("model");
            this.mNeedFeedBackButton = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.mWriteData == null) {
            finish();
            return;
        }
        this.aDW = new NewWriteModel(this);
        this.aDW.setWriteData(this.mWriteData);
        if (this.mWriteData.getWriteImagesInfo() != null) {
            this.aDW.mF(this.mWriteData.getWriteImagesInfo().size() > 0);
        }
        this.gEU = bzm();
        this.gET.setPresenter(this.gEU);
        this.gEU.start(this.mNeedFeedBackButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b bzm() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.g.b.g("5", 0)) {
            cVar = new a(this.gET, this.aDW);
        } else {
            cVar = new c(this.gET, this.aDW);
        }
        cVar.d(this.gEV);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.mWriteData);
        bundle.putBoolean("need_feed_back_button", this.mNeedFeedBackButton);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mWriteData != null && this.mWriteData.getIsStory() == 1) {
            br brVar = new br();
            brVar.abo = this.mWriteData;
            brVar.abr = this.gEU.byk();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_VCODE_CHECK_INFO, brVar));
        }
        super.onDestroy();
        bxA();
        this.gEU.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bxA() {
        if (this.mWriteData != null && this.mWriteData.getType() == 3) {
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
        }
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
