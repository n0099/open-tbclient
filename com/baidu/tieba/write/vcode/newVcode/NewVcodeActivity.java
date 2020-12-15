package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.f.b;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes3.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel fwu;
    private WriteData jgi = null;
    private int mPageType = 0;
    private NewWriteModel.d nYA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
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
                } else if (ahVar != null && writeData != null) {
                    NewVcodeActivity.this.mPageType = b.toInt("4", 0);
                    NewVcodeActivity.this.nYz.dYF();
                    NewVcodeActivity.this.nYz.onDestroy();
                    NewVcodeActivity.this.jgi = writeData;
                    NewVcodeActivity.this.jgi.setVcodeMD5(ahVar.getVcode_md5());
                    NewVcodeActivity.this.jgi.setVcodeUrl(ahVar.getVcode_pic_url());
                    NewVcodeActivity.this.jgi.setVcodeExtra(ahVar.bxM());
                    NewVcodeActivity.this.fwu.e(NewVcodeActivity.this.jgi);
                    NewVcodeActivity.this.nYz = NewVcodeActivity.this.dZy();
                    NewVcodeActivity.this.nYz.H(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.nYy.setPresenter(NewVcodeActivity.this.nYz);
                    NewVcodeActivity.this.nYz.start(NewVcodeActivity.this.nYB);
                }
            }
        }
    };
    private boolean nYB;
    private NewVcodeView nYy;
    private com.baidu.tieba.write.vcode.newVcode.a.b nYz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nYy = new NewVcodeView(this);
        if (bundle != null) {
            this.jgi = WriteData.fromDraftString(bundle.getString("model"));
            this.nYB = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.jgi = (WriteData) intent.getSerializableExtra("model");
            this.nYB = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.jgi == null) {
            finish();
            return;
        }
        this.fwu = new NewWriteModel(this);
        this.fwu.e(this.jgi);
        if (this.jgi.getWriteImagesInfo() != null) {
            this.fwu.yk(this.jgi.getWriteImagesInfo().size() > 0);
        }
        this.nYz = dZy();
        this.nYy.setPresenter(this.nYz);
        this.nYz.start(this.nYB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.write.vcode.newVcode.a.b dZy() {
        com.baidu.tieba.write.vcode.newVcode.a.b cVar;
        if (this.mPageType == b.toInt("5", 0)) {
            cVar = new a(this.nYy, this.fwu);
        } else {
            cVar = new c(this.nYy, this.fwu);
        }
        cVar.d(this.nYA);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jgi != null) {
            bundle.putString("model", this.jgi.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.nYB);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dZz();
        this.nYz.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void dZz() {
        if (this.jgi != null && this.jgi.getType() == 3) {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
        }
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
