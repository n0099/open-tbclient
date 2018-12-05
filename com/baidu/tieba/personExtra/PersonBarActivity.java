package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter gtS = null;
    private PersonBarModel gtT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gsO && this.eWS != 23011) {
            setSwipeBackEnabled(false);
        }
        this.gtT = new PersonBarModel(getPageContext(), aTC());
        this.gtT.setSex(getSex());
        this.gtT.setId(getUid());
        this.gtT.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gtS == null) {
            this.gtS = new PersonBarAdapter(this, aTC());
        }
        return this.gtS;
    }

    public PersonBarModel bph() {
        return this.gtT;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boN() {
        return getPageContext().getString(e.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boO() {
        return getPageContext().getString(e.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boP() {
        return getPageContext().getString(e.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boQ() {
        return getPageContext().getString(e.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boR() {
        return getPageContext().getString(e.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boV() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int boW() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bpr;
        super.onPageSelected(i);
        if (this.gtS != null && this.gtS.getItem(i) != null && (baseFragment = (BaseFragment) this.gtS.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bpr = ((PersonBarFragment) baseFragment).bpr()) != null) {
            bpr.dq(false);
            bpr.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.eWS;
    }
}
