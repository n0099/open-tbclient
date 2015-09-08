package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private p cja = null;
    private ad cjb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cim && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.cjb = new ad(getPageContext(), Wb());
        this.cjb.setSex(getSex());
        this.cjb.setId(getUid());
        this.cjb.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cja == null) {
            this.cja = new p(this, Wb());
        }
        return this.cja;
    }

    public ad agk() {
        return this.cjb;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afV() {
        return getPageContext().getString(i.h.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afW() {
        return getPageContext().getString(i.h.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afX() {
        return getPageContext().getString(i.h.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afY() {
        return getPageContext().getString(i.h.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afZ() {
        return getPageContext().getString(i.h.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String agd() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int age() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ac agu;
        super.onPageSelected(i);
        if (this.cja != null && this.cja.getItem(i) != null && (baseFragment = (BaseFragment) this.cja.getItem(i)) != null && (baseFragment instanceof r) && (agu = ((r) baseFragment).agu()) != null) {
            agu.setEditState(false);
            agu.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
