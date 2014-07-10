package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private s d = null;
    private af e = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ay.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new af(p());
        this.e.a(n());
        this.e.a(m());
        this.e.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.d == null) {
            this.d = new s(this, p());
        }
        return this.d;
    }

    public af w() {
        return this.e;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String g() {
        return getString(com.baidu.tieba.y.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String i() {
        return getString(com.baidu.tieba.y.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String j() {
        return getString(com.baidu.tieba.y.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String k() {
        return getString(com.baidu.tieba.y.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String l() {
        return getString(com.baidu.tieba.y.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String r() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int s() {
        return 2;
    }
}
