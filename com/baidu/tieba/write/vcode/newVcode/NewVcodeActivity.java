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
    private a ask;
    private c fFA;
    private boolean fFD;
    private NewVcodeView fFz;
    private WriteData fFB = null;
    private int mPageType = 0;
    private a.d fFC = new a.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
            if (pVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = b.g("4", 0);
                NewVcodeActivity.this.fFA.bkV();
                NewVcodeActivity.this.fFA.onDestroy();
                NewVcodeActivity.this.fFB = writeData;
                NewVcodeActivity.this.fFB.setVcodeMD5(pVar.getVcode_md5());
                NewVcodeActivity.this.fFB.setVcodeUrl(pVar.getVcode_pic_url());
                NewVcodeActivity.this.fFB.setVcodeExtra(pVar.wK());
                NewVcodeActivity.this.ask.d(NewVcodeActivity.this.fFB);
                NewVcodeActivity.this.fFA = NewVcodeActivity.this.bkT();
                NewVcodeActivity.this.fFA.q(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.fFz.setPresenter(NewVcodeActivity.this.fFA);
                NewVcodeActivity.this.fFA.lh(NewVcodeActivity.this.fFD);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fFz = new NewVcodeView(this);
        if (bundle != null) {
            this.fFB = (WriteData) bundle.getSerializable("model");
            this.fFD = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.fFB = (WriteData) intent.getSerializableExtra("model");
            this.fFD = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.fFB == null) {
            finish();
            return;
        }
        this.ask = new a(this);
        this.ask.d(this.fFB);
        if (this.fFB.getWriteImagesInfo() != null) {
            this.ask.kn(this.fFB.getWriteImagesInfo().size() > 0);
        }
        this.fFA = bkT();
        this.fFz.setPresenter(this.fFA);
        this.fFA.lh(this.fFD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bkT() {
        c dVar;
        if (this.mPageType == b.g("5", 0)) {
            dVar = new com.baidu.tieba.write.vcode.newVcode.a.a(this.fFz, this.ask);
        } else {
            dVar = new d(this.fFz, this.ask);
        }
        dVar.c(this.fFC);
        return dVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fFB);
        bundle.putBoolean("need_feed_back_button", this.fFD);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bkU();
        this.fFA.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void bkU() {
        if (this.fFB != null && this.fFB.getType() == 3) {
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 200, false);
        }
    }
}
