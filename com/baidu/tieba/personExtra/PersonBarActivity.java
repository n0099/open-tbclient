package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter fSs = null;
    private PersonBarModel fSt = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fRs && this.ese != 23011) {
            setSwipeBackEnabled(false);
        }
        this.fSt = new PersonBarModel(getPageContext(), aLg());
        this.fSt.setSex(getSex());
        this.fSt.setId(getUid());
        this.fSt.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fSs == null) {
            this.fSs = new PersonBarAdapter(this, aLg());
        }
        return this.fSs;
    }

    public PersonBarModel bjl() {
        return this.fSt;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biR() {
        return getPageContext().getString(d.k.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biS() {
        return getPageContext().getString(d.k.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biT() {
        return getPageContext().getString(d.k.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biU() {
        return getPageContext().getString(d.k.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biV() {
        return getPageContext().getString(d.k.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biZ() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bja() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bjv;
        super.onPageSelected(i);
        if (this.fSs != null && this.fSs.getItem(i) != null && (baseFragment = (BaseFragment) this.fSs.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bjv = ((PersonBarFragment) baseFragment).bjv()) != null) {
            bjv.ct(false);
            bjv.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.ese;
    }
}
