package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lYc = null;
    private PersonBarModel lYd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lXt && this.kmW != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lYd = new PersonBarModel(getPageContext(), Wq());
        this.lYd.setSex(getSex());
        this.lYd.setId(getUid());
        this.lYd.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lYc == null) {
            this.lYc = new PersonBarAdapter(this, Wq());
        }
        return this.lYc;
    }

    public PersonBarModel duj() {
        return this.lYd;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtR() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtS() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtT() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtU() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtV() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtZ() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dua() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dut;
        super.onPageSelected(i);
        if (this.lYc != null && this.lYc.getItem(i) != null && (baseFragment = (BaseFragment) this.lYc.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dut = ((PersonBarFragment) baseFragment).dut()) != null) {
            dut.lj(false);
            dut.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kmW;
    }
}
