package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.a.a;
import com.baidu.tieba.write.vcode.newVcode.a.c;
import com.baidu.tieba.write.vcode.newVcode.a.d;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private b avZ;
    private boolean fAb;
    private NewVcodeView fzY;
    private c fzZ;
    private WriteData fxS = null;
    private int mPageType = 0;
    private b.d fAa = new b.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            if (qVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = com.baidu.adp.lib.h.b.g("4", 0);
                NewVcodeActivity.this.fzZ.bli();
                NewVcodeActivity.this.fzZ.onDestroy();
                NewVcodeActivity.this.fxS = writeData;
                NewVcodeActivity.this.fxS.setVcodeMD5(qVar.getVcode_md5());
                NewVcodeActivity.this.fxS.setVcodeUrl(qVar.getVcode_pic_url());
                NewVcodeActivity.this.fxS.setVcodeExtra(qVar.xR());
                NewVcodeActivity.this.avZ.d(NewVcodeActivity.this.fxS);
                NewVcodeActivity.this.fzZ = NewVcodeActivity.this.bmd();
                NewVcodeActivity.this.fzZ.p(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.fzY.setPresenter(NewVcodeActivity.this.fzZ);
                NewVcodeActivity.this.fzZ.lB(NewVcodeActivity.this.fAb);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fzY = new NewVcodeView(this);
        if (bundle != null) {
            this.fxS = (WriteData) bundle.getSerializable("model");
            this.fAb = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.fxS = (WriteData) intent.getSerializableExtra("model");
            this.fAb = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.fxS == null) {
            finish();
            return;
        }
        this.avZ = new b(this);
        this.avZ.d(this.fxS);
        if (this.fxS.getWriteImagesInfo() != null) {
            this.avZ.la(this.fxS.getWriteImagesInfo().size() > 0);
        }
        this.fzZ = bmd();
        this.fzY.setPresenter(this.fzZ);
        this.fzZ.lB(this.fAb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bmd() {
        c dVar;
        if (this.mPageType == com.baidu.adp.lib.h.b.g("5", 0)) {
            dVar = new a(this.fzY, this.avZ);
        } else {
            dVar = new d(this.fzY, this.avZ);
        }
        dVar.c(this.fAa);
        return dVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fxS);
        bundle.putBoolean("need_feed_back_button", this.fAb);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bkD();
        this.fzZ.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void bkD() {
        if (this.fxS != null && this.fxS.getType() == 3) {
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
