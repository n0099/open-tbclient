package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import d.a.o0.w3.j.a;
import d.a.o0.w3.j.b;
/* loaded from: classes5.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    public static final String ACCOUNT_ACCESS_CANCEL = "http://tieba.baidu.com/account/access/cancel";
    public static final String ACCOUNT_ACCESS_FEEDBACK_HTTP = "http://tieba.baidu.com/account/access/feedback";
    public static final String ACCOUNT_ACCESS_FEEDBACK_HTTPS = "https://tieba.baidu.com/account/access/feedback";
    public static final String ACCOUNT_ACCESS_INPUT_FOCUS = "http://tieba.baidu.com/account/access/input_focus";
    public static final String ACCOUNT_ACCESS_URL = "http://tieba.baidu.com/mo/q/account/access";
    public static final String ACCOUNT_ACCESS_VALID_SUCCESS = "http://tieba.baidu.com/account/access/valid_success";
    public AccessState mAccessState;
    public a mPresenter;
    public b mView;
    public WriteData mWriteData;
    public NewWriteModel mWriteModel;

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    public String joinStrsForH5() {
        AccessState accessState = this.mAccessState;
        if (accessState == null || accessState.getUserInfo() == null) {
            return null;
        }
        return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", ACCOUNT_ACCESS_URL, this.mAccessState.getToken(), this.mAccessState.getType(), this.mAccessState.getUserInfo().strMobile, this.mAccessState.getUserInfo().strEmail);
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
        this.mView = new b(this);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mAccessState = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
        WriteData writeData = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
        this.mWriteData = writeData;
        if (writeData != null && this.mAccessState != null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.mWriteModel = newWriteModel;
            newWriteModel.j0(this.mWriteData);
            if (this.mWriteData.getWriteImagesInfo() != null) {
                this.mWriteModel.d0(this.mWriteData.getWriteImagesInfo().size() > 0);
            }
            a aVar = new a(this.mView, this.mWriteModel);
            this.mPresenter = aVar;
            this.mView.m(aVar);
            this.mPresenter.h(joinStrsForH5());
            return;
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mView.l();
    }
}
