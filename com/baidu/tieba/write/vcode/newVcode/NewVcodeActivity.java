package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.a.m0.s.c.i0;
import d.a.n0.w3.s.a.a.a;
import d.a.n0.w3.s.a.a.b;
import d.a.n0.w3.s.a.a.c;
/* loaded from: classes5.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    public boolean mNeedFeedBackButton;
    public NewVcodeView mNewVcodeView;
    public b mPresenter;
    public NewWriteModel mWriteModel;
    public WriteData mWriteData = null;
    public int mPageType = 0;
    public NewWriteModel.g mDragVcodePresenterCallback = new NewWriteModel.g() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            if (postWriteCallBackData == null || z) {
                return;
            }
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
            } else if (i0Var == null || writeData == null) {
            } else {
                NewVcodeActivity.this.mPageType = d.a.c.e.m.b.d("4", 0);
                NewVcodeActivity.this.mPresenter.d();
                NewVcodeActivity.this.mPresenter.onDestroy();
                NewVcodeActivity.this.mWriteData = writeData;
                NewVcodeActivity.this.mWriteData.setVcodeMD5(i0Var.b());
                NewVcodeActivity.this.mWriteData.setVcodeUrl(i0Var.c());
                NewVcodeActivity.this.mWriteData.setVcodeExtra(i0Var.a());
                NewVcodeActivity.this.mWriteModel.f0(NewVcodeActivity.this.mWriteData);
                NewVcodeActivity newVcodeActivity = NewVcodeActivity.this;
                newVcodeActivity.mPresenter = newVcodeActivity.getVcodePresenterFromType();
                NewVcodeActivity.this.mPresenter.e(true, postWriteCallBackData.getErrorString());
                NewVcodeActivity.this.mNewVcodeView.setPresenter(NewVcodeActivity.this.mPresenter);
                NewVcodeActivity.this.mPresenter.a(NewVcodeActivity.this.mNeedFeedBackButton);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public b getVcodePresenterFromType() {
        b cVar;
        if (this.mPageType == d.a.c.e.m.b.d("5", 0)) {
            cVar = new a(this.mNewVcodeView, this.mWriteModel);
        } else {
            cVar = new c(this.mNewVcodeView, this.mWriteModel);
        }
        cVar.c(this.mDragVcodePresenterCallback);
        return cVar;
    }

    private void gotoMainTab() {
        WriteData writeData = this.mWriteData;
        if (writeData != null && writeData.getType() == 3) {
            d.a.m0.r.a0.b.g(getPageContext().getPageActivity(), 200, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 12006) {
                setResult(-1, intent);
            }
        } else if (i3 == 0 && i2 == 12006) {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mNewVcodeView = new NewVcodeView(this);
        if (bundle != null) {
            this.mWriteData = WriteData.fromDraftString(bundle.getString("model"));
            this.mNeedFeedBackButton = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
            this.mPageType = bundle.getInt("page_type");
        } else {
            Intent intent = getIntent();
            this.mWriteData = (WriteData) intent.getSerializableExtra("model");
            this.mNeedFeedBackButton = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
            this.mPageType = intent.getIntExtra("page_type", 0);
        }
        if (this.mWriteData == null) {
            finish();
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(this);
        this.mWriteModel = newWriteModel;
        newWriteModel.f0(this.mWriteData);
        if (this.mWriteData.getWriteImagesInfo() != null) {
            this.mWriteModel.Z(this.mWriteData.getWriteImagesInfo().size() > 0);
        }
        b vcodePresenterFromType = getVcodePresenterFromType();
        this.mPresenter = vcodePresenterFromType;
        this.mNewVcodeView.setPresenter(vcodePresenterFromType);
        this.mPresenter.a(this.mNeedFeedBackButton);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        gotoMainTab();
        this.mPresenter.onDestroy();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        WriteData writeData = this.mWriteData;
        if (writeData != null) {
            bundle.putString("model", writeData.toDraftString());
        }
        bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.mNeedFeedBackButton);
        bundle.putInt("page_type", this.mPageType);
        super.onSaveInstanceState(bundle);
    }
}
