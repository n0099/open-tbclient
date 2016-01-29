package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private q cXp = null;
    private ae cXq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cWu && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.cXq = new ae(getPageContext(), aen());
        this.cXq.setSex(getSex());
        this.cXq.setId(getUid());
        this.cXq.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cXp == null) {
            this.cXp = new q(this, aen());
        }
        return this.cXp;
    }

    public ae atq() {
        return this.cXq;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ata() {
        return getPageContext().getString(t.j.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atc() {
        return getPageContext().getString(t.j.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atd() {
        return getPageContext().getString(t.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ate() {
        return getPageContext().getString(t.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atf() {
        return getPageContext().getString(t.j.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atj() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int atk() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ad atA;
        super.onPageSelected(i);
        if (this.cXp != null && this.cXp.getItem(i) != null && (baseFragment = (BaseFragment) this.cXp.getItem(i)) != null && (baseFragment instanceof s) && (atA = ((s) baseFragment).atA()) != null) {
            atA.setEditState(false);
            atA.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
