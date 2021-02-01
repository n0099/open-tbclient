package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
/* loaded from: classes9.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    private g lqm;
    private String lqn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.lqn = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
        } else if (getIntent() != null) {
            this.lqn = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
            if (this.lqn == null) {
                this.lqn = "";
            }
        }
        initUI();
    }

    private void initUI() {
        this.lqm = new g(getPageContext());
        this.lqm.Oc(this.lqn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lqm != null) {
            this.lqm.onChangeSkinType(i);
        }
    }
}
