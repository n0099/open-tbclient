package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private p cig = null;
    private ad cih = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.chs && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.cih = new ad(getPageContext(), VZ());
        this.cih.setSex(getSex());
        this.cih.setId(getUid());
        this.cih.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cig == null) {
            this.cig = new p(this, VZ());
        }
        return this.cig;
    }

    public ad afU() {
        return this.cih;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afF() {
        return getPageContext().getString(i.C0057i.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afG() {
        return getPageContext().getString(i.C0057i.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afH() {
        return getPageContext().getString(i.C0057i.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afI() {
        return getPageContext().getString(i.C0057i.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afJ() {
        return getPageContext().getString(i.C0057i.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afN() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int afO() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ac age;
        super.onPageSelected(i);
        if (this.cig != null && this.cig.getItem(i) != null && (baseFragment = (BaseFragment) this.cig.getItem(i)) != null && (baseFragment instanceof r) && (age = ((r) baseFragment).age()) != null) {
            age.setEditState(false);
            age.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
