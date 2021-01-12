package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
/* loaded from: classes8.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    private g lif;
    private String lig;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.lig = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
        } else if (getIntent() != null) {
            this.lig = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
            if (this.lig == null) {
                this.lig = "";
            }
        }
        initUI();
    }

    private void initUI() {
        this.lif = new g(getPageContext());
        this.lif.Nn(this.lig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lif != null) {
            this.lif.onChangeSkinType(i);
        }
    }
}
