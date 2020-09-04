package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lhC = null;
    private PersonBarModel lhD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lgT && this.jxa != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lhD = new PersonBarModel(getPageContext(), cHD());
        this.lhD.setSex(getSex());
        this.lhD.setId(getUid());
        this.lhD.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lhC == null) {
            this.lhC = new PersonBarAdapter(this, cHD());
        }
        return this.lhC;
    }

    public PersonBarModel dhl() {
        return this.lhD;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgT() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgU() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgV() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgW() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dgX() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dhb() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dhc() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dhv;
        super.onPageSelected(i);
        if (this.lhC != null && this.lhC.getItem(i) != null && (baseFragment = (BaseFragment) this.lhC.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dhv = ((PersonBarFragment) baseFragment).dhv()) != null) {
            dhv.ko(false);
            dhv.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.jxa;
    }
}
