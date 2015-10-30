package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private p coO = null;
    private ad coP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cnT && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.coP = new ad(getPageContext(), WG());
        this.coP.setSex(getSex());
        this.coP.setId(getUid());
        this.coP.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.coO == null) {
            this.coO = new p(this, WG());
        }
        return this.coO;
    }

    public ad aif() {
        return this.coP;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahQ() {
        return getPageContext().getString(i.h.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahR() {
        return getPageContext().getString(i.h.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahS() {
        return getPageContext().getString(i.h.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahT() {
        return getPageContext().getString(i.h.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahU() {
        return getPageContext().getString(i.h.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahY() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int ahZ() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ac aip;
        super.onPageSelected(i);
        if (this.coO != null && this.coO.getItem(i) != null && (baseFragment = (BaseFragment) this.coO.getItem(i)) != null && (baseFragment instanceof r) && (aip = ((r) baseFragment).aip()) != null) {
            aip.setEditState(false);
            aip.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
