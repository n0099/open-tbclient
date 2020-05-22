package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter kny = null;
    private PersonBarModel knz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kmR && this.iHJ != 23011) {
            setSwipeBackEnabled(false);
        }
        this.knz = new PersonBarModel(getPageContext(), coK());
        this.knz.setSex(getSex());
        this.knz.setId(getUid());
        this.knz.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.kny == null) {
            this.kny = new PersonBarAdapter(this, coK());
        }
        return this.kny;
    }

    public PersonBarModel cNP() {
        return this.knz;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNx() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNy() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNz() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNA() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNB() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNF() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cNG() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cNZ;
        super.onPageSelected(i);
        if (this.kny != null && this.kny.getItem(i) != null && (baseFragment = (BaseFragment) this.kny.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cNZ = ((PersonBarFragment) baseFragment).cNZ()) != null) {
            cNZ.iY(false);
            cNZ.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.iHJ;
    }
}
