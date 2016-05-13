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
        this.dvo = new af(getPageContext(), ahP());
        this.dvo.setSex(getSex());
        this.dvo.setId(getUid());
        this.dvo.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.dvn == null) {
            this.dvn = new q(this, ahP());
        }
        return this.dvn;
    }

    public af aBw() {
        return this.dvo;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBh() {
        return getPageContext().getString(t.j.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBi() {
        return getPageContext().getString(t.j.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBj() {
        return getPageContext().getString(t.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBk() {
        return getPageContext().getString(t.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBl() {
        return getPageContext().getString(t.j.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBp() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aBq() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ae aBG;
        super.onPageSelected(i);
        if (this.dvn != null && this.dvn.getItem(i) != null && (baseFragment = (BaseFragment) this.dvn.getItem(i)) != null && (baseFragment instanceof s) && (aBG = ((s) baseFragment).aBG()) != null) {
            aBG.setEditState(false);
            aBG.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
