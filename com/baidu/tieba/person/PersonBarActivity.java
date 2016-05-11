package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private q dvn = null;
    private af dvo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dur && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.dvo = new af(getPageContext(), ahN());
        this.dvo.setSex(getSex());
        this.dvo.setId(getUid());
        this.dvo.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.dvn == null) {
            this.dvn = new q(this, ahN());
        }
        return this.dvn;
    }

    public af aBt() {
        return this.dvo;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBe() {
        return getPageContext().getString(t.j.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBf() {
        return getPageContext().getString(t.j.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBg() {
        return getPageContext().getString(t.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBh() {
        return getPageContext().getString(t.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBi() {
        return getPageContext().getString(t.j.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBm() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aBn() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ae aBD;
        super.onPageSelected(i);
        if (this.dvn != null && this.dvn.getItem(i) != null && (baseFragment = (BaseFragment) this.dvn.getItem(i)) != null && (baseFragment instanceof s) && (aBD = ((s) baseFragment).aBD()) != null) {
            aBD.setEditState(false);
            aBD.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
