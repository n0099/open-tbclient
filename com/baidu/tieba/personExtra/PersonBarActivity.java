package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter ipt = null;
    private PersonBarModel ipu = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ioA && this.gQD != 23011) {
            setSwipeBackEnabled(false);
        }
        this.ipu = new PersonBarModel(getPageContext(), bGN());
        this.ipu.setSex(getSex());
        this.ipu.setId(getUid());
        this.ipu.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.ipt == null) {
            this.ipt = new PersonBarAdapter(this, bGN());
        }
        return this.ipt;
    }

    public PersonBarModel ccQ() {
        return this.ipu;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ccx() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ccy() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ccz() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ccA() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ccB() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ccF() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int ccG() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cda;
        super.onPageSelected(i);
        if (this.ipt != null && this.ipt.getItem(i) != null && (baseFragment = (BaseFragment) this.ipt.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cda = ((PersonBarFragment) baseFragment).cda()) != null) {
            cda.gn(false);
            cda.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gQD;
    }
}
