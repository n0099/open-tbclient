package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vcode.newVcode.a.c;
import com.baidu.tieba.write.vcode.newVcode.a.d;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private a asZ;
    private NewVcodeView fRD;
    private c fRE;
    private boolean fRG;
    private WriteData fPE = null;
    private int mPageType = 0;
    private a.d fRF = new a.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
            if (pVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = b.g("4", 0);
                NewVcodeActivity.this.fRE.bmZ();
                NewVcodeActivity.this.fRE.onDestroy();
                NewVcodeActivity.this.fPE = writeData;
                NewVcodeActivity.this.fPE.setVcodeMD5(pVar.getVcode_md5());
                NewVcodeActivity.this.fPE.setVcodeUrl(pVar.getVcode_pic_url());
                NewVcodeActivity.this.fPE.setVcodeExtra(pVar.wK());
                NewVcodeActivity.this.asZ.d(NewVcodeActivity.this.fPE);
                NewVcodeActivity.this.fRE = NewVcodeActivity.this.bnQ();
                NewVcodeActivity.this.fRE.p(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.fRD.setPresenter(NewVcodeActivity.this.fRE);
                NewVcodeActivity.this.fRE.lv(NewVcodeActivity.this.fRG);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRD = new NewVcodeView(this);
        if (bundle != null) {
            this.fPE = (WriteData) bundle.getSerializable("model");
            this.fRG = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.fPE = (WriteData) intent.getSerializableExtra("model");
            this.fRG = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.fPE == null) {
            finish();
            return;
        }
        this.asZ = new a(this);
        this.asZ.d(this.fPE);
        if (this.fPE.getWriteImagesInfo() != null) {
            this.asZ.kB(this.fPE.getWriteImagesInfo().size() > 0);
        }
        this.fRE = bnQ();
        this.fRD.setPresenter(this.fRE);
        this.fRE.lv(this.fRG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bnQ() {
        c dVar;
        if (this.mPageType == b.g("5", 0)) {
            dVar = new com.baidu.tieba.write.vcode.newVcode.a.a(this.fRD, this.asZ);
        } else {
            dVar = new d(this.fRD, this.asZ);
        }
        dVar.c(this.fRF);
        return dVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fPE);
        bundle.putBoolean("need_feed_back_button", this.fRG);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bnR();
        this.fRE.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bnR() {
        if (this.fPE != null && this.fPE.getType() == 3) {
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
