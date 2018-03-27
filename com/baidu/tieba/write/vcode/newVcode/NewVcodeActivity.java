package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.b;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes2.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel btX;
    private NewVcodeView hHH;
    private b hHI;
    private boolean mNeedFeedBackButton;
    private WriteData mWriteData = null;
    private int mPageType = 0;
    private NewWriteModel.d hHJ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            if (postWriteCallBackData != null && !z) {
                if (postWriteCallBackData.getErrorCode() == 220015) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(0, intent);
                    NewVcodeActivity.this.finish();
                } else if (postWriteCallBackData.getErrorCode() == 220034) {
                    NewVcodeActivity.this.showToast(postWriteCallBackData.getErrorString());
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    NewVcodeActivity.this.setResult(0, intent2);
                    NewVcodeActivity.this.finish();
                } else if (tVar != null && writeData != null) {
                    NewVcodeActivity.this.mPageType = com.baidu.adp.lib.g.b.h("4", 0);
                    NewVcodeActivity.this.hHI.onPostThreadCancle();
                    NewVcodeActivity.this.hHI.onDestroy();
                    NewVcodeActivity.this.mWriteData = writeData;
                    NewVcodeActivity.this.mWriteData.setVcodeMD5(tVar.getVcode_md5());
                    NewVcodeActivity.this.mWriteData.setVcodeUrl(tVar.getVcode_pic_url());
                    NewVcodeActivity.this.mWriteData.setVcodeExtra(tVar.FY());
                    NewVcodeActivity.this.btX.setWriteData(NewVcodeActivity.this.mWriteData);
                    NewVcodeActivity.this.hHI = NewVcodeActivity.this.bHe();
                    NewVcodeActivity.this.hHI.showErrorOnStart(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.hHH.setPresenter(NewVcodeActivity.this.hHI);
                    NewVcodeActivity.this.hHI.start(NewVcodeActivity.this.mNeedFeedBackButton);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hHH = new NewVcodeView(this);
        if (bundle != null) {
            this.mWriteData = WriteData.fromDraftString(bundle.getString("model"));
            this.mNeedFeedBackButton = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.mWriteData = (WriteData) intent.getSerializableExtra("model");
            this.mNeedFeedBackButton = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.mWriteData == null) {
            finish();
            return;
        }
        this.btX = new NewWriteModel(this);
        this.btX.setWriteData(this.mWriteData);
        if (this.mWriteData.getWriteImagesInfo() != null) {
            this.btX.mT(this.mWriteData.getWriteImagesInfo().size() > 0);
        }
        this.hHI = bHe();
        this.hHH.setPresenter(this.hHI);
        this.hHI.start(this.mNeedFeedBackButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b bHe() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.g.b.h("5", 0)) {
            cVar = new a(this.hHH, this.btX);
        } else {
            cVar = new c(this.hHH, this.btX);
        }
        cVar.d(this.hHJ);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mWriteData != null) {
            bundle.putString("model", this.mWriteData.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.mNeedFeedBackButton);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mWriteData != null && this.mWriteData.getIsStory() == 1) {
            bk bkVar = new bk();
            bkVar.aQI = this.mWriteData;
            bkVar.aQL = this.hHI.bFU();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921051, bkVar));
        }
        super.onDestroy();
        bFj();
        this.hHI.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bFj() {
        if (this.mWriteData != null && this.mWriteData.getType() == 3) {
            com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), 200, false);
        }
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
