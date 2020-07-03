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
/* loaded from: classes2.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private NewWriteModel evx;
    private NewVcodeView mqt;
    private b mqu;
    private boolean mqw;
    private WriteData hLV = null;
    private int mPageType = 0;
    private NewWriteModel.d mqv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
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
                    NewVcodeActivity.this.mqu.drb();
                    NewVcodeActivity.this.mqu.onDestroy();
                    NewVcodeActivity.this.hLV = writeData;
                    NewVcodeActivity.this.hLV.setVcodeMD5(adVar.getVcode_md5());
                    NewVcodeActivity.this.hLV.setVcodeUrl(adVar.getVcode_pic_url());
                    NewVcodeActivity.this.hLV.setVcodeExtra(adVar.bas());
                    NewVcodeActivity.this.evx.d(NewVcodeActivity.this.hLV);
                    NewVcodeActivity.this.mqu = NewVcodeActivity.this.drU();
                    NewVcodeActivity.this.mqu.D(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.mqt.setPresenter(NewVcodeActivity.this.mqu);
                    NewVcodeActivity.this.mqu.start(NewVcodeActivity.this.mqw);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mqt = new NewVcodeView(this);
        if (bundle != null) {
            this.hLV = WriteData.fromDraftString(bundle.getString("model"));
            this.mqw = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.hLV = (WriteData) intent.getSerializableExtra("model");
            this.mqw = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.hLV == null) {
            finish();
            return;
        }
        this.evx = new NewWriteModel(this);
        this.evx.d(this.hLV);
        if (this.hLV.getWriteImagesInfo() != null) {
            this.evx.uN(this.hLV.getWriteImagesInfo().size() > 0);
        }
        this.mqu = drU();
        this.mqt.setPresenter(this.mqu);
        this.mqu.start(this.mqw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b drU() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.f.b.toInt("5", 0)) {
            cVar = new a(this.mqt, this.evx);
        } else {
            cVar = new c(this.mqt, this.evx);
        }
        cVar.d(this.mqv);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hLV != null) {
            bundle.putString("model", this.hLV.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.mqw);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        drV();
        this.mqu.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void drV() {
        if (this.hLV != null && this.hLV.getType() == 3) {
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
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
