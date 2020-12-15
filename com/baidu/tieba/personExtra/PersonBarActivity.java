package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mmE = null;
    private PersonBarModel mmF = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mlV && this.kBe != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mmF = new PersonBarModel(getPageContext(), Yh());
        this.mmF.setSex(getSex());
        this.mmF.setId(getUid());
        this.mmF.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mmE == null) {
            this.mmE = new PersonBarAdapter(this, Yh());
        }
        return this.mmE;
    }

    public PersonBarModel dzc() {
        return this.mmF;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyK() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyL() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyM() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyN() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyO() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyS() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dyT() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dzm;
        super.onPageSelected(i);
        if (this.mmE != null && this.mmE.getItem(i) != null && (baseFragment = (BaseFragment) this.mmE.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dzm = ((PersonBarFragment) baseFragment).dzm()) != null) {
            dzm.lF(false);
            dzm.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kBe;
    }
}
