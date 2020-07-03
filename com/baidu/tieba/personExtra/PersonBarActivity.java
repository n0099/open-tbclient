package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter kIC = null;
    private PersonBarModel kID = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kHT && this.iZz != 23011) {
            setSwipeBackEnabled(false);
        }
        this.kID = new PersonBarModel(getPageContext(), csI());
        this.kID.setSex(getSex());
        this.kID.setId(getUid());
        this.kID.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.kIC == null) {
            this.kIC = new PersonBarAdapter(this, csI());
        }
        return this.kIC;
    }

    public PersonBarModel cSw() {
        return this.kID;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cSe() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cSf() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cSg() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cSh() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cSi() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cSm() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cSn() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cSG;
        super.onPageSelected(i);
        if (this.kIC != null && this.kIC.getItem(i) != null && (baseFragment = (BaseFragment) this.kIC.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cSG = ((PersonBarFragment) baseFragment).cSG()) != null) {
            cSG.jk(false);
            cSG.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.iZz;
    }
}
