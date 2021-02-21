package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
/* loaded from: classes9.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    private g lqA;
    private String lqB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.lqB = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
        } else if (getIntent() != null) {
            this.lqB = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
            if (this.lqB == null) {
                this.lqB = "";
            }
        }
        initUI();
    }

    private void initUI() {
        this.lqA = new g(getPageContext());
        this.lqA.Od(this.lqB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lqA != null) {
            this.lqA.onChangeSkinType(i);
        }
    }
}
