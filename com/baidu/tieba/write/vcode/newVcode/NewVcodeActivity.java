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
    private b awg;
    private NewVcodeView gbI;
    private c gbJ;
    private boolean gbL;
    private WriteData fZJ = null;
    private int mPageType = 0;
    private b.d gbK = new b.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (sVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = com.baidu.adp.lib.h.b.g("4", 0);
                NewVcodeActivity.this.gbJ.brq();
                NewVcodeActivity.this.gbJ.onDestroy();
                NewVcodeActivity.this.fZJ = writeData;
                NewVcodeActivity.this.fZJ.setVcodeMD5(sVar.getVcode_md5());
                NewVcodeActivity.this.fZJ.setVcodeUrl(sVar.getVcode_pic_url());
                NewVcodeActivity.this.fZJ.setVcodeExtra(sVar.xU());
                NewVcodeActivity.this.awg.d(NewVcodeActivity.this.fZJ);
                NewVcodeActivity.this.gbJ = NewVcodeActivity.this.bsg();
                NewVcodeActivity.this.gbJ.o(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.gbI.setPresenter(NewVcodeActivity.this.gbJ);
                NewVcodeActivity.this.gbJ.lL(NewVcodeActivity.this.gbL);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gbI = new NewVcodeView(this);
        if (bundle != null) {
            this.fZJ = (WriteData) bundle.getSerializable("model");
            this.gbL = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.fZJ = (WriteData) intent.getSerializableExtra("model");
            this.gbL = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.fZJ == null) {
            finish();
            return;
        }
        this.awg = new b(this);
        this.awg.d(this.fZJ);
        if (this.fZJ.getWriteImagesInfo() != null) {
            this.awg.kN(this.fZJ.getWriteImagesInfo().size() > 0);
        }
        this.gbJ = bsg();
        this.gbI.setPresenter(this.gbJ);
        this.gbJ.lL(this.gbL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bsg() {
        c dVar;
        if (this.mPageType == com.baidu.adp.lib.h.b.g("5", 0)) {
            dVar = new a(this.gbI, this.awg);
        } else {
            dVar = new d(this.gbI, this.awg);
        }
        dVar.c(this.gbK);
        return dVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fZJ);
        bundle.putBoolean("need_feed_back_button", this.gbL);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bqQ();
        this.gbJ.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bqQ() {
        if (this.fZJ != null && this.fZJ.getType() == 3) {
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
