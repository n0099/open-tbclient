package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mmC = null;
    private PersonBarModel mmD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mlT && this.kBc != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mmD = new PersonBarModel(getPageContext(), Yh());
        this.mmD.setSex(getSex());
        this.mmD.setId(getUid());
        this.mmD.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mmC == null) {
            this.mmC = new PersonBarAdapter(this, Yh());
        }
        return this.mmC;
    }

    public PersonBarModel dzb() {
        return this.mmD;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyJ() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyK() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyL() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyM() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyN() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyR() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dyS() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dzl;
        super.onPageSelected(i);
        if (this.mmC != null && this.mmC.getItem(i) != null && (baseFragment = (BaseFragment) this.mmC.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dzl = ((PersonBarFragment) baseFragment).dzl()) != null) {
            dzl.lF(false);
            dzl.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kBc;
    }
}
