package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter inu = null;
    private PersonBarModel inv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.imA && this.gOJ != 23011) {
            setSwipeBackEnabled(false);
        }
        this.inv = new PersonBarModel(getPageContext(), bFZ());
        this.inv.setSex(getSex());
        this.inv.setId(getUid());
        this.inv.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.inu == null) {
            this.inu = new PersonBarAdapter(this, bFZ());
        }
        return this.inu;
    }

    public PersonBarModel ccc() {
        return this.inv;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbJ() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbK() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbL() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbM() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbN() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbR() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cbS() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c ccm;
        super.onPageSelected(i);
        if (this.inu != null && this.inu.getItem(i) != null && (baseFragment = (BaseFragment) this.inu.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (ccm = ((PersonBarFragment) baseFragment).ccm()) != null) {
            ccm.gk(false);
            ccm.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gOJ;
    }
}
