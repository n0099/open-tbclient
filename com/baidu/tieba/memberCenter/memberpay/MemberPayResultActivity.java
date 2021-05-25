package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
import d.a.n0.s1.f.g;
/* loaded from: classes3.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    public g memberPayResultView;
    public String payContent;

    private void initUI() {
        g gVar = new g(getPageContext());
        this.memberPayResultView = gVar;
        gVar.b(this.payContent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        g gVar = this.memberPayResultView;
        if (gVar != null) {
            gVar.d(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.payContent = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
        } else if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
            this.payContent = stringExtra;
            if (stringExtra == null) {
                this.payContent = "";
            }
        }
        initUI();
    }
}
