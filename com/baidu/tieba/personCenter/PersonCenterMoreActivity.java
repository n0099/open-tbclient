package com.baidu.tieba.personCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.f;
/* loaded from: classes.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    private f fhW;
    private Bundle fhX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE) != null) {
            this.fhX = getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(d.h.person_center_more_layout);
        this.fhW = new f(getPageContext(), this.fhX);
        this.fhW.initView();
    }
}
