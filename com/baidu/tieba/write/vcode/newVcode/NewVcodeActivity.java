package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.b;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes2.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel aDk;
    private NewVcodeView gEs;
    private b gEt;
    private boolean mNeedFeedBackButton;
    private WriteData mWriteData = null;
    private int mPageType = 0;
    private NewWriteModel.d gEu = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (postWriteCallBackData != null && !z) {
                if (postWriteCallBackData.getErrorCode() == 220034) {
                    NewVcodeActivity.this.showToast(postWriteCallBackData.getErrorString());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(0, intent);
                    NewVcodeActivity.this.finish();
                } else if (qVar != null && writeData != null) {
                    NewVcodeActivity.this.mPageType = com.baidu.adp.lib.g.b.g("4", 0);
                    NewVcodeActivity.this.gEt.onPostThreadCancle();
                    NewVcodeActivity.this.gEt.onDestroy();
                    NewVcodeActivity.this.mWriteData = writeData;
                    NewVcodeActivity.this.mWriteData.setVcodeMD5(qVar.getVcode_md5());
                    NewVcodeActivity.this.mWriteData.setVcodeUrl(qVar.getVcode_pic_url());
                    NewVcodeActivity.this.mWriteData.setVcodeExtra(qVar.yB());
                    NewVcodeActivity.this.aDk.setWriteData(NewVcodeActivity.this.mWriteData);
                    NewVcodeActivity.this.gEt = NewVcodeActivity.this.byM();
                    NewVcodeActivity.this.gEt.showErrorOnStart(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.gEs.setPresenter(NewVcodeActivity.this.gEt);
                    NewVcodeActivity.this.gEt.start(NewVcodeActivity.this.mNeedFeedBackButton);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gEs = new NewVcodeView(this);
        if (bundle != null) {
            this.mWriteData = WriteData.fromDraftString(bundle.getString("model"));
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
        this.aDk = new NewWriteModel(this);
        this.aDk.setWriteData(this.mWriteData);
        if (this.mWriteData.getWriteImagesInfo() != null) {
            this.aDk.mM(this.mWriteData.getWriteImagesInfo().size() > 0);
        }
        this.gEt = byM();
        this.gEs.setPresenter(this.gEt);
        this.gEt.start(this.mNeedFeedBackButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b byM() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.g.b.g("5", 0)) {
            cVar = new a(this.gEs, this.aDk);
        } else {
            cVar = new c(this.gEs, this.aDk);
        }
        cVar.d(this.gEu);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mWriteData != null) {
            bundle.putString("model", this.mWriteData.toDraftString());
        }
        bundle.putBoolean("need_feed_back_button", this.mNeedFeedBackButton);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mWriteData != null && this.mWriteData.getIsStory() == 1) {
            bp bpVar = new bp();
            bpVar.aat = this.mWriteData;
            bpVar.aaw = this.gEt.bxM();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_VCODE_CHECK_INFO, bpVar));
        }
        super.onDestroy();
        bxb();
        this.gEt.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bxb() {
        if (this.mWriteData != null && this.mWriteData.getType() == 3) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
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
