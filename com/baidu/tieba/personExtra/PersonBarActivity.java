package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter kRD = null;
    private PersonBarModel kRE = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kQU && this.jhS != 23011) {
            setSwipeBackEnabled(false);
        }
        this.kRE = new PersonBarModel(getPageContext(), cwL());
        this.kRE.setSex(getSex());
        this.kRE.setId(getUid());
        this.kRE.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.kRD == null) {
            this.kRD = new PersonBarAdapter(this, cwL());
        }
        return this.kRD;
    }

    public PersonBarModel cWn() {
        return this.kRE;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cVV() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cVW() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cVX() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cVY() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cVZ() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cWd() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cWe() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cWx;
        super.onPageSelected(i);
        if (this.kRD != null && this.kRD.getItem(i) != null && (baseFragment = (BaseFragment) this.kRD.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cWx = ((PersonBarFragment) baseFragment).cWx()) != null) {
            cWx.jO(false);
            cWx.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.jhS;
    }
}
