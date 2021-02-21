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
    private NewWriteModel fDH;
    private NewVcodeView ohs;
    private b oht;
    private boolean ohv;
    private WriteData jtW = null;
    private int mPageType = 0;
    private NewWriteModel.d ohu = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
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
                    NewVcodeActivity.this.oht.dWO();
                    NewVcodeActivity.this.oht.onDestroy();
                    NewVcodeActivity.this.jtW = writeData;
                    NewVcodeActivity.this.jtW.setVcodeMD5(ahVar.getVcode_md5());
                    NewVcodeActivity.this.jtW.setVcodeUrl(ahVar.getVcode_pic_url());
                    NewVcodeActivity.this.jtW.setVcodeExtra(ahVar.bwF());
                    NewVcodeActivity.this.fDH.f(NewVcodeActivity.this.jtW);
                    NewVcodeActivity.this.oht = NewVcodeActivity.this.dXA();
                    NewVcodeActivity.this.oht.P(true, postWriteCallBackData.getErrorString());
                    NewVcodeActivity.this.ohs.setPresenter(NewVcodeActivity.this.oht);
                    NewVcodeActivity.this.oht.start(NewVcodeActivity.this.ohv);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ohs = new NewVcodeView(this);
        if (bundle != null) {
            this.jtW = WriteData.fromDraftString(bundle.getString("model"));
            this.ohv = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.jtW = (WriteData) intent.getSerializableExtra("model");
            this.ohv = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.jtW == null) {
            finish();
            return;
        }
        this.fDH = new NewWriteModel(this);
        this.fDH.f(this.jtW);
        if (this.jtW.getWriteImagesInfo() != null) {
            this.fDH.yE(this.jtW.getWriteImagesInfo().size() > 0);
        }
        this.oht = dXA();
        this.ohs.setPresenter(this.oht);
        this.oht.start(this.ohv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b dXA() {
        b cVar;
        if (this.mPageType == com.baidu.adp.lib.f.b.toInt("5", 0)) {
            cVar = new a(this.ohs, this.fDH);
        } else {
            cVar = new c(this.ohs, this.fDH);
        }
        cVar.d(this.ohu);
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jtW != null) {
            bundle.putString("model", this.jtW.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.ohv);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dXB();
        this.oht.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void dXB() {
        if (this.jtW != null && this.jtW.getType() == 3) {
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
