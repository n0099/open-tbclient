package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter gea = null;
    private PersonBarModel geb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gcW && this.eHb != 23011) {
            setSwipeBackEnabled(false);
        }
        this.geb = new PersonBarModel(getPageContext(), aOZ());
        this.geb.setSex(getSex());
        this.geb.setId(getUid());
        this.geb.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gea == null) {
            this.gea = new PersonBarAdapter(this, aOZ());
        }
        return this.gea;
    }

    public PersonBarModel bkI() {
        return this.geb;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bko() {
        return getPageContext().getString(e.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bkp() {
        return getPageContext().getString(e.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bkq() {
        return getPageContext().getString(e.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bkr() {
        return getPageContext().getString(e.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bks() {
        return getPageContext().getString(e.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bkw() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bkx() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bkS;
        super.onPageSelected(i);
        if (this.gea != null && this.gea.getItem(i) != null && (baseFragment = (BaseFragment) this.gea.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bkS = ((PersonBarFragment) baseFragment).bkS()) != null) {
            bkS.cP(false);
            bkS.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.eHb;
    }
}
