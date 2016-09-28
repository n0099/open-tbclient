package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.c;
import com.baidu.tieba.write.vcode.newVcode.a.d;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private b avJ;
    private NewVcodeView gdR;
    private c gdS;
    private boolean gdU;
    private WriteData gbS = null;
    private int mPageType = 0;
    private b.d gdT = new b.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (sVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = com.baidu.adp.lib.h.b.g("4", 0);
                NewVcodeActivity.this.gdS.brW();
                NewVcodeActivity.this.gdS.onDestroy();
                NewVcodeActivity.this.gbS = writeData;
                NewVcodeActivity.this.gbS.setVcodeMD5(sVar.getVcode_md5());
                NewVcodeActivity.this.gbS.setVcodeUrl(sVar.getVcode_pic_url());
                NewVcodeActivity.this.gbS.setVcodeExtra(sVar.xX());
                NewVcodeActivity.this.avJ.d(NewVcodeActivity.this.gbS);
                NewVcodeActivity.this.gdS = NewVcodeActivity.this.bsM();
                NewVcodeActivity.this.gdS.o(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.gdR.setPresenter(NewVcodeActivity.this.gdS);
                NewVcodeActivity.this.gdS.lN(NewVcodeActivity.this.gdU);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gdR = new NewVcodeView(this);
        if (bundle != null) {
            this.gbS = (WriteData) bundle.getSerializable("model");
            this.gdU = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.gbS = (WriteData) intent.getSerializableExtra("model");
            this.gdU = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.gbS == null) {
            finish();
            return;
        }
        this.avJ = new b(this);
        this.avJ.d(this.gbS);
        if (this.gbS.getWriteImagesInfo() != null) {
            this.avJ.kQ(this.gbS.getWriteImagesInfo().size() > 0);
        }
        this.gdS = bsM();
        this.gdR.setPresenter(this.gdS);
        this.gdS.lN(this.gdU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bsM() {
        c dVar;
        if (this.mPageType == com.baidu.adp.lib.h.b.g("5", 0)) {
            dVar = new a(this.gdR, this.avJ);
        } else {
            dVar = new d(this.gdR, this.avJ);
        }
        dVar.c(this.gdT);
        return dVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.gbS);
        bundle.putBoolean("need_feed_back_button", this.gdU);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        brw();
        this.gdS.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void brw() {
        if (this.gbS != null && this.gbS.getType() == 3) {
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 200, false);
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
