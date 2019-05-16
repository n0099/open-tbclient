package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter ifU = null;
    private PersonBarModel ifV = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ifb && this.gHE != 23011) {
            setSwipeBackEnabled(false);
        }
        this.ifV = new PersonBarModel(getPageContext(), bDa());
        this.ifV.setSex(getSex());
        this.ifV.setId(getUid());
        this.ifV.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.ifU == null) {
            this.ifU = new PersonBarAdapter(this, bDa());
        }
        return this.ifU;
    }

    public PersonBarModel bYR() {
        return this.ifV;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYy() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYz() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYA() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYB() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYC() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYG() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bYH() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c bZb;
        super.onPageSelected(i);
        if (this.ifU != null && this.ifU.getItem(i) != null && (baseFragment = (BaseFragment) this.ifU.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bZb = ((PersonBarFragment) baseFragment).bZb()) != null) {
            bZb.gg(false);
            bZb.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gHE;
    }
}
