package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lSg = null;
    private PersonBarModel lSh = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lRx && this.kgZ != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lSh = new PersonBarModel(getPageContext(), TQ());
        this.lSh.setSex(getSex());
        this.lSh.setId(getUid());
        this.lSh.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lSg == null) {
            this.lSg = new PersonBarAdapter(this, TQ());
        }
        return this.lSg;
    }

    public PersonBarModel drH() {
        return this.lSh;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String drp() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String drq() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String drr() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String drs() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String drt() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String drx() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dry() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c drR;
        super.onPageSelected(i);
        if (this.lSg != null && this.lSg.getItem(i) != null && (baseFragment = (BaseFragment) this.lSg.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (drR = ((PersonBarFragment) baseFragment).drR()) != null) {
            drR.la(false);
            drR.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kgZ;
    }
}
