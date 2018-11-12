package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter gnc = null;
    private PersonBarModel gnd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.glY && this.eQd != 23011) {
            setSwipeBackEnabled(false);
        }
        this.gnd = new PersonBarModel(getPageContext(), aRK());
        this.gnd.setSex(getSex());
        this.gnd.setId(getUid());
        this.gnd.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gnc == null) {
            this.gnc = new PersonBarAdapter(this, aRK());
        }
        return this.gnc;
    }

    public PersonBarModel bno() {
        return this.gnd;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmU() {
        return getPageContext().getString(e.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmV() {
        return getPageContext().getString(e.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmW() {
        return getPageContext().getString(e.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmX() {
        return getPageContext().getString(e.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmY() {
        return getPageContext().getString(e.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnc() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bnd() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bny;
        super.onPageSelected(i);
        if (this.gnc != null && this.gnc.getItem(i) != null && (baseFragment = (BaseFragment) this.gnc.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bny = ((PersonBarFragment) baseFragment).bny()) != null) {
            bny.dp(false);
            bny.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.eQd;
    }
}
