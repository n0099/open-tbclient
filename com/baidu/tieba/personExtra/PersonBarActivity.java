package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter fGZ = null;
    private PersonBarModel fHa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fFZ && this.egO != 23011) {
            setSwipeBackEnabled(false);
        }
        this.fHa = new PersonBarModel(getPageContext(), aGl());
        this.fHa.setSex(getSex());
        this.fHa.setId(getUid());
        this.fHa.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fGZ == null) {
            this.fGZ = new PersonBarAdapter(this, aGl());
        }
        return this.fGZ;
    }

    public PersonBarModel bel() {
        return this.fHa;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdR() {
        return getPageContext().getString(d.k.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdS() {
        return getPageContext().getString(d.k.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdT() {
        return getPageContext().getString(d.k.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdU() {
        return getPageContext().getString(d.k.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdV() {
        return getPageContext().getString(d.k.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdZ() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bea() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bev;
        super.onPageSelected(i);
        if (this.fGZ != null && this.fGZ.getItem(i) != null && (baseFragment = (BaseFragment) this.fGZ.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bev = ((PersonBarFragment) baseFragment).bev()) != null) {
            bev.co(false);
            bev.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.egO;
    }
}
