package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.b;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes3.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel cFZ;
    private NewVcodeView jQM;
    private b jQN;
    private boolean jQP;
    private WriteData jNt = null;
    private int mPageType = 0;
    private NewWriteModel.d jQO = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
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
                } else if (yVar != null && writeData != null) {
                    NewVcodeActivity.this.mPageType = com.baidu.adp.lib.g.b.toInt("4", 0);
                    NewVcodeActivity.this.jQN.cxX();
                    NewVcodeActivity.this.jQN.onDestroy();
                    NewVcodeActivity.this.jNt = writeData;
                    NewVcodeActivity.this.jNt.setVcodeMD5(yVar.getVcode_md5());
                    NewVcodeActivity.this.jNt.setVcodeUrl(yVar.getVcode_pic_url());
                    NewVcodeActivity.this.jNt.setVcodeExtra(yVar.aps());
                    NewVcodeActivity.this.cFZ.d(NewVcodeActivity.this.jNt);
                    NewVcodeActivity.this.jQN = NewVcodeActivity.this.cyE();
                    NewVcodeActivity.this.jQN.A(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.jQM.setPresenter(NewVcodeActivity.this.jQN);
                    NewVcodeActivity.this.jQN.start(NewVcodeActivity.this.jQP);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jQM = new NewVcodeView(this);
        if (bundle != null) {
            this.jNt = WriteData.fromDraftString(bundle.getString("model"));
            this.jQP = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.jNt = (WriteData) intent.getSerializableExtra("model");
            this.jQP = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.jNt == null) {
            finish();
            return;
        }
        this.cFZ = new NewWriteModel(this);
        this.cFZ.d(this.jNt);
        if (this.jNt.getWriteImagesInfo() != null) {
            this.cFZ.qV(this.jNt.getWriteImagesInfo().size() > 0);
        }
        this.jQN = cyE();
        this.jQM.setPresenter(this.jQN);
        this.jQN.start(this.jQP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b cyE() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.g.b.toInt("5", 0)) {
            cVar = new a(this.jQM, this.cFZ);
        } else {
            cVar = new c(this.jQM, this.cFZ);
        }
        cVar.d(this.jQO);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jNt != null) {
            bundle.putString("model", this.jNt.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.jQP);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cxn();
        this.jQN.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void cxn() {
        if (this.jNt != null && this.jNt.getType() == 3) {
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 200, false);
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
