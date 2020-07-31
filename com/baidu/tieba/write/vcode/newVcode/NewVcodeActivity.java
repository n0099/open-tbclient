package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.b;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes3.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel eBQ;
    private NewVcodeView myv;
    private b myw;
    private boolean myy;
    private WriteData hRU = null;
    private int mPageType = 0;
    private NewWriteModel.d myx = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
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
                } else if (adVar != null && writeData != null) {
                    NewVcodeActivity.this.mPageType = com.baidu.adp.lib.f.b.toInt("4", 0);
                    NewVcodeActivity.this.myw.dur();
                    NewVcodeActivity.this.myw.onDestroy();
                    NewVcodeActivity.this.hRU = writeData;
                    NewVcodeActivity.this.hRU.setVcodeMD5(adVar.getVcode_md5());
                    NewVcodeActivity.this.hRU.setVcodeUrl(adVar.getVcode_pic_url());
                    NewVcodeActivity.this.hRU.setVcodeExtra(adVar.bep());
                    NewVcodeActivity.this.eBQ.d(NewVcodeActivity.this.hRU);
                    NewVcodeActivity.this.myw = NewVcodeActivity.this.dvk();
                    NewVcodeActivity.this.myw.D(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.myv.setPresenter(NewVcodeActivity.this.myw);
                    NewVcodeActivity.this.myw.start(NewVcodeActivity.this.myy);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.myv = new NewVcodeView(this);
        if (bundle != null) {
            this.hRU = WriteData.fromDraftString(bundle.getString("model"));
            this.myy = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.hRU = (WriteData) intent.getSerializableExtra("model");
            this.myy = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.hRU == null) {
            finish();
            return;
        }
        this.eBQ = new NewWriteModel(this);
        this.eBQ.d(this.hRU);
        if (this.hRU.getWriteImagesInfo() != null) {
            this.eBQ.vr(this.hRU.getWriteImagesInfo().size() > 0);
        }
        this.myw = dvk();
        this.myv.setPresenter(this.myw);
        this.myw.start(this.myy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b dvk() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.f.b.toInt("5", 0)) {
            cVar = new a(this.myv, this.eBQ);
        } else {
            cVar = new c(this.myv, this.eBQ);
        }
        cVar.d(this.myx);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hRU != null) {
            bundle.putString("model", this.hRU.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.myy);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dvl();
        this.myw.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void dvl() {
        if (this.hRU != null && this.hRU.getType() == 3) {
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
