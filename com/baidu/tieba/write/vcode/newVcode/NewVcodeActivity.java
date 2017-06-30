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
    private NewWriteModel aBE;
    private NewVcodeView ghT;
    private c ghU;
    private boolean mNeedFeedBackButton;
    private WriteData mWriteData = null;
    private int mPageType = 0;
    private NewWriteModel.d ghV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (qVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = b.g("4", 0);
                NewVcodeActivity.this.ghU.onPostThreadCancle();
                NewVcodeActivity.this.ghU.onDestroy();
                NewVcodeActivity.this.mWriteData = writeData;
                NewVcodeActivity.this.mWriteData.setVcodeMD5(qVar.getVcode_md5());
                NewVcodeActivity.this.mWriteData.setVcodeUrl(qVar.getVcode_pic_url());
                NewVcodeActivity.this.mWriteData.setVcodeExtra(qVar.yf());
                NewVcodeActivity.this.aBE.setWriteData(NewVcodeActivity.this.mWriteData);
                NewVcodeActivity.this.ghU = NewVcodeActivity.this.bsY();
                NewVcodeActivity.this.ghU.showErrorOnStart(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.ghT.setPresenter(NewVcodeActivity.this.ghU);
                NewVcodeActivity.this.ghU.start(NewVcodeActivity.this.mNeedFeedBackButton);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghT = new NewVcodeView(this);
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
        this.aBE = new NewWriteModel(this);
        this.aBE.setWriteData(this.mWriteData);
        if (this.mWriteData.getWriteImagesInfo() != null) {
            this.aBE.lW(this.mWriteData.getWriteImagesInfo().size() > 0);
        }
        this.ghU = bsY();
        this.ghT.setPresenter(this.ghU);
        this.ghU.start(this.mNeedFeedBackButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bsY() {
        c dVar;
        if (this.mPageType == b.g("5", 0)) {
            dVar = new a(this.ghT, this.aBE);
        } else {
            dVar = new d(this.ghT, this.aBE);
        }
        dVar.d(this.ghV);
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
        bqX();
        this.ghU.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bqX() {
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
