package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private t bPx = null;
    private ah bPy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.bON) {
            setSwipeBackEnabled(false);
        }
        this.bPy = new ah(getPageContext(), Te());
        this.bPy.setSex(getSex());
        this.bPy.setId(getUid());
        this.bPy.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bPx == null) {
            this.bPx = new t(this, Te());
        }
        return this.bPx;
    }

    public ah adc() {
        return this.bPy;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acO() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acP() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acQ() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acR() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acS() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acV() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int acW() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        af adm;
        super.onPageSelected(i);
        if (this.bPx != null && this.bPx.getItem(i) != null && (baseFragment = (BaseFragment) this.bPx.getItem(i)) != null && (baseFragment instanceof v) && (adm = ((v) baseFragment).adm()) != null) {
            adm.setEditState(false);
            adm.notifyDataSetChanged();
        }
    }
}
