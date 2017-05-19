package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.c;
import com.baidu.tieba.write.vcode.newVcode.a.d;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel aAP;
    private NewVcodeView fOY;
    private c fOZ;
    private boolean mNeedFeedBackButton;
    private WriteData mWriteData = null;
    private int mPageType = 0;
    private NewWriteModel.d fPa = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (qVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = b.g("4", 0);
                NewVcodeActivity.this.fOZ.onPostThreadCancle();
                NewVcodeActivity.this.fOZ.onDestroy();
                NewVcodeActivity.this.mWriteData = writeData;
                NewVcodeActivity.this.mWriteData.setVcodeMD5(qVar.getVcode_md5());
                NewVcodeActivity.this.mWriteData.setVcodeUrl(qVar.getVcode_pic_url());
                NewVcodeActivity.this.mWriteData.setVcodeExtra(qVar.xV());
                NewVcodeActivity.this.aAP.setWriteData(NewVcodeActivity.this.mWriteData);
                NewVcodeActivity.this.fOZ = NewVcodeActivity.this.bnb();
                NewVcodeActivity.this.fOZ.showErrorOnStart(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.fOY.setPresenter(NewVcodeActivity.this.fOZ);
                NewVcodeActivity.this.fOZ.start(NewVcodeActivity.this.mNeedFeedBackButton);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fOY = new NewVcodeView(this);
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
        this.aAP = new NewWriteModel(this);
        this.aAP.setWriteData(this.mWriteData);
        if (this.mWriteData.getWriteImagesInfo() != null) {
            this.aAP.lc(this.mWriteData.getWriteImagesInfo().size() > 0);
        }
        this.fOZ = bnb();
        this.fOY.setPresenter(this.fOZ);
        this.fOZ.start(this.mNeedFeedBackButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bnb() {
        c dVar;
        if (this.mPageType == b.g("5", 0)) {
            dVar = new a(this.fOY, this.aAP);
        } else {
            dVar = new d(this.fOY, this.aAP);
        }
        dVar.c(this.fPa);
        return dVar;
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
        super.onDestroy();
        blp();
        this.fOZ.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void blp() {
        if (this.mWriteData != null && this.mWriteData.getType() == 3) {
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 200, false);
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
