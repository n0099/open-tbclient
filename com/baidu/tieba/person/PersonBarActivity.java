package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private s e = null;
    private af f = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.be.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new af(p());
        this.f.a(n());
        this.f.a(m());
        this.f.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.e == null) {
            this.e = new s(this, p());
        }
        return this.e;
    }

    public af w() {
        return this.f;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String g() {
        return getString(com.baidu.tieba.x.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String i() {
        return getString(com.baidu.tieba.x.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String j() {
        return getString(com.baidu.tieba.x.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String k() {
        return getString(com.baidu.tieba.x.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String l() {
        return getString(com.baidu.tieba.x.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String r() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int s() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.baidu.tbadk.core.d dVar;
        ad a;
        super.onPageSelected(i);
        if (this.e != null && this.e.getItem(i) != null && (dVar = (com.baidu.tbadk.core.d) this.e.getItem(i)) != null && (dVar instanceof u) && (a = ((u) dVar).a()) != null) {
            a.a(false);
            a.notifyDataSetChanged();
        }
    }
}
