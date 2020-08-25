package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lhv = null;
    private PersonBarModel lhw = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lgM && this.jwU != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lhw = new PersonBarModel(getPageContext(), cHC());
        this.lhw.setSex(getSex());
        this.lhw.setId(getUid());
        this.lhw.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lhv == null) {
            this.lhv = new PersonBarAdapter(this, cHC());
        }
        return this.lhv;
    }

    public PersonBarModel dhk() {
        return this.lhw;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgS() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgT() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgU() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgV() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgW() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dha() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dhb() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dhu;
        super.onPageSelected(i);
        if (this.lhv != null && this.lhv.getItem(i) != null && (baseFragment = (BaseFragment) this.lhv.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dhu = ((PersonBarFragment) baseFragment).dhu()) != null) {
            dhu.km(false);
            dhu.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.jwU;
    }
}
