package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private t bRA = null;
    private ai bRB = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.bQO && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.bRB = new ai(getPageContext(), Ur());
        this.bRB.setSex(getSex());
        this.bRB.setId(getUid());
        this.bRB.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bRA == null) {
            this.bRA = new t(this, Ur());
        }
        return this.bRA;
    }

    public ai aec() {
        return this.bRB;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adN() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adO() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adP() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adQ() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adR() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adV() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int adW() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ag aem;
        super.onPageSelected(i);
        if (this.bRA != null && this.bRA.getItem(i) != null && (baseFragment = (BaseFragment) this.bRA.getItem(i)) != null && (baseFragment instanceof v) && (aem = ((v) baseFragment).aem()) != null) {
            aem.setEditState(false);
            aem.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
