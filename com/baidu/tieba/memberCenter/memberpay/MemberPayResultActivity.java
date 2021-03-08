package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
/* loaded from: classes8.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    private g lsC;
    private String lsD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.lsD = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
        } else if (getIntent() != null) {
            this.lsD = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
            if (this.lsD == null) {
                this.lsD = "";
            }
        }
        initUI();
    }

    private void initUI() {
        this.lsC = new g(getPageContext());
        this.lsC.Oj(this.lsD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lsC != null) {
            this.lsC.onChangeSkinType(i);
        }
    }
}
