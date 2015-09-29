package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private p coD = null;
    private ad coE = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cnI && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.coE = new ad(getPageContext(), WK());
        this.coE.setSex(getSex());
        this.coE.setId(getUid());
        this.coE.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.coD == null) {
            this.coD = new p(this, WK());
        }
        return this.coD;
    }

    public ad aij() {
        return this.coE;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahU() {
        return getPageContext().getString(i.h.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahV() {
        return getPageContext().getString(i.h.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahW() {
        return getPageContext().getString(i.h.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahX() {
        return getPageContext().getString(i.h.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahY() {
        return getPageContext().getString(i.h.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aic() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aid() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ac ait;
        super.onPageSelected(i);
        if (this.coD != null && this.coD.getItem(i) != null && (baseFragment = (BaseFragment) this.coD.getItem(i)) != null && (baseFragment instanceof r) && (ait = ((r) baseFragment).ait()) != null) {
            ait.setEditState(false);
            ait.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
