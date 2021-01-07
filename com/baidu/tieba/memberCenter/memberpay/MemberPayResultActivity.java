package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
/* loaded from: classes9.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    private g lmK;
    private String lmL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.lmL = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
        } else if (getIntent() != null) {
            this.lmL = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
            if (this.lmL == null) {
                this.lmL = "";
            }
        }
        initUI();
    }

    private void initUI() {
        this.lmK = new g(getPageContext());
        this.lmK.Ov(this.lmL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lmK != null) {
            this.lmK.onChangeSkinType(i);
        }
    }
}
