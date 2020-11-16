package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lYu = null;
    private PersonBarModel lYv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lXL && this.knG != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lYv = new PersonBarModel(getPageContext(), VH());
        this.lYv.setSex(getSex());
        this.lYv.setId(getUid());
        this.lYv.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lYu == null) {
            this.lYu = new PersonBarAdapter(this, VH());
        }
        return this.lYu;
    }

    public PersonBarModel dtJ() {
        return this.lYv;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtr() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dts() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtt() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtu() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtv() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dtz() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dtA() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dtT;
        super.onPageSelected(i);
        if (this.lYu != null && this.lYu.getItem(i) != null && (baseFragment = (BaseFragment) this.lYu.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dtT = ((PersonBarFragment) baseFragment).dtT()) != null) {
            dtT.lk(false);
            dtT.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.knG;
    }
}
