package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.tieba.write.vcode.newVcode.a.b;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes3.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel fpI;
    private NewVcodeView nIP;
    private b nIQ;
    private boolean nIS;
    private WriteData iUy = null;
    private int mPageType = 0;
    private NewWriteModel.d nIR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
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
                    NewVcodeActivity.this.mPageType = com.baidu.adp.lib.f.b.toInt("4", 0);
                    NewVcodeActivity.this.nIQ.dTl();
                    NewVcodeActivity.this.nIQ.onDestroy();
                    NewVcodeActivity.this.iUy = writeData;
                    NewVcodeActivity.this.iUy.setVcodeMD5(ahVar.getVcode_md5());
                    NewVcodeActivity.this.iUy.setVcodeUrl(ahVar.getVcode_pic_url());
                    NewVcodeActivity.this.iUy.setVcodeExtra(ahVar.buW());
                    NewVcodeActivity.this.fpI.e(NewVcodeActivity.this.iUy);
                    NewVcodeActivity.this.nIQ = NewVcodeActivity.this.dUe();
                    NewVcodeActivity.this.nIQ.G(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.nIP.setPresenter(NewVcodeActivity.this.nIQ);
                    NewVcodeActivity.this.nIQ.start(NewVcodeActivity.this.nIS);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nIP = new NewVcodeView(this);
        if (bundle != null) {
            this.iUy = WriteData.fromDraftString(bundle.getString("model"));
            this.nIS = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.iUy = (WriteData) intent.getSerializableExtra("model");
            this.nIS = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.iUy == null) {
            finish();
            return;
        }
        this.fpI = new NewWriteModel(this);
        this.fpI.e(this.iUy);
        if (this.iUy.getWriteImagesInfo() != null) {
            this.fpI.xy(this.iUy.getWriteImagesInfo().size() > 0);
        }
        this.nIQ = dUe();
        this.nIP.setPresenter(this.nIQ);
        this.nIQ.start(this.nIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b dUe() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.f.b.toInt("5", 0)) {
            cVar = new a(this.nIP, this.fpI);
        } else {
            cVar = new c(this.nIP, this.fpI);
        }
        cVar.d(this.nIR);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.iUy != null) {
            bundle.putString("model", this.iUy.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.nIS);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dUf();
        this.nIQ.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void dUf() {
        if (this.iUy != null && this.iUy.getType() == 3) {
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
