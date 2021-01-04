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
/* loaded from: classes8.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel fGa;
    private NewVcodeView obs;
    private b obt;
    private boolean obv;
    private WriteData jsI = null;
    private int mPageType = 0;
    private NewWriteModel.d obu = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
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
                    NewVcodeActivity.this.obt.dYj();
                    NewVcodeActivity.this.obt.onDestroy();
                    NewVcodeActivity.this.jsI = writeData;
                    NewVcodeActivity.this.jsI.setVcodeMD5(ahVar.getVcode_md5());
                    NewVcodeActivity.this.jsI.setVcodeUrl(ahVar.getVcode_pic_url());
                    NewVcodeActivity.this.jsI.setVcodeExtra(ahVar.bAg());
                    NewVcodeActivity.this.fGa.f(NewVcodeActivity.this.jsI);
                    NewVcodeActivity.this.obt = NewVcodeActivity.this.dYV();
                    NewVcodeActivity.this.obt.H(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.obs.setPresenter(NewVcodeActivity.this.obt);
                    NewVcodeActivity.this.obt.start(NewVcodeActivity.this.obv);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.obs = new NewVcodeView(this);
        if (bundle != null) {
            this.jsI = WriteData.fromDraftString(bundle.getString("model"));
            this.obv = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.jsI = (WriteData) intent.getSerializableExtra("model");
            this.obv = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.jsI == null) {
            finish();
            return;
        }
        this.fGa = new NewWriteModel(this);
        this.fGa.f(this.jsI);
        if (this.jsI.getWriteImagesInfo() != null) {
            this.fGa.yp(this.jsI.getWriteImagesInfo().size() > 0);
        }
        this.obt = dYV();
        this.obs.setPresenter(this.obt);
        this.obt.start(this.obv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b dYV() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.f.b.toInt("5", 0)) {
            cVar = new a(this.obs, this.fGa);
        } else {
            cVar = new c(this.obs, this.fGa);
        }
        cVar.d(this.obu);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jsI != null) {
            bundle.putString("model", this.jsI.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.obv);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dYW();
        this.obt.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void dYW() {
        if (this.jsI != null && this.jsI.getType() == 3) {
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
