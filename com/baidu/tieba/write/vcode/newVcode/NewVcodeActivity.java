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
    private b awC;
    private NewVcodeView glv;
    private c glw;
    private boolean gly;
    private WriteData gjx = null;
    private int mPageType = 0;
    private b.d glx = new b.d() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            if (sVar != null && writeData != null && postWriteCallBackData != null && !z) {
                NewVcodeActivity.this.mPageType = com.baidu.adp.lib.h.b.g("4", 0);
                NewVcodeActivity.this.glw.bur();
                NewVcodeActivity.this.glw.onDestroy();
                NewVcodeActivity.this.gjx = writeData;
                NewVcodeActivity.this.gjx.setVcodeMD5(sVar.getVcode_md5());
                NewVcodeActivity.this.gjx.setVcodeUrl(sVar.getVcode_pic_url());
                NewVcodeActivity.this.gjx.setVcodeExtra(sVar.yd());
                NewVcodeActivity.this.awC.d(NewVcodeActivity.this.gjx);
                NewVcodeActivity.this.glw = NewVcodeActivity.this.bvh();
                NewVcodeActivity.this.glw.p(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.glv.setPresenter(NewVcodeActivity.this.glw);
                NewVcodeActivity.this.glw.mm(NewVcodeActivity.this.gly);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.glv = new NewVcodeView(this);
        if (bundle != null) {
            this.gjx = (WriteData) bundle.getSerializable("model");
            this.gly = bundle.getBoolean("need_feed_back_button");
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.gjx = (WriteData) intent.getSerializableExtra("model");
            this.gly = intent.getBooleanExtra("need_feed_back_button", true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.gjx == null) {
            finish();
            return;
        }
        this.awC = new b(this);
        this.awC.d(this.gjx);
        if (this.gjx.getWriteImagesInfo() != null) {
            this.awC.lp(this.gjx.getWriteImagesInfo().size() > 0);
        }
        this.glw = bvh();
        this.glv.setPresenter(this.glw);
        this.glw.mm(this.gly);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c bvh() {
        c dVar;
        if (this.mPageType == com.baidu.adp.lib.h.b.g("5", 0)) {
            dVar = new a(this.glv, this.awC);
        } else {
            dVar = new d(this.glv, this.awC);
        }
        dVar.c(this.glx);
        return dVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.gjx);
        bundle.putBoolean("need_feed_back_button", this.gly);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        btD();
        this.glw.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void btD() {
        if (this.gjx != null && this.gjx.getType() == 3) {
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
