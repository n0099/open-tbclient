package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter ina = null;
    private PersonBarModel inb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.imt && this.gNN != 23011) {
            setSwipeBackEnabled(false);
        }
        this.inb = new PersonBarModel(getPageContext(), bDw());
        this.inb.setSex(getSex());
        this.inb.setId(getUid());
        this.inb.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.ina == null) {
            this.ina = new PersonBarAdapter(this, bDw());
        }
        return this.ina;
    }

    public PersonBarModel bZP() {
        return this.inb;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZx() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZy() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZz() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZA() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZB() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZF() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bZG() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c bZZ;
        super.onPageSelected(i);
        if (this.ina != null && this.ina.getItem(i) != null && (baseFragment = (BaseFragment) this.ina.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bZZ = ((PersonBarFragment) baseFragment).bZZ()) != null) {
            bZZ.gc(false);
            bZZ.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gNN;
    }
}
