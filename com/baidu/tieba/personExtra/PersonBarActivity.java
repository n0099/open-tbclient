package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter gxO = null;
    private PersonBarModel gxP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gwK && this.fax != 23011) {
            setSwipeBackEnabled(false);
        }
        this.gxP = new PersonBarModel(getPageContext(), aUP());
        this.gxP.setSex(getSex());
        this.gxP.setId(getUid());
        this.gxP.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gxO == null) {
            this.gxO = new PersonBarAdapter(this, aUP());
        }
        return this.gxO;
    }

    public PersonBarModel bqB() {
        return this.gxP;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bqh() {
        return getPageContext().getString(e.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bqi() {
        return getPageContext().getString(e.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bqj() {
        return getPageContext().getString(e.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bqk() {
        return getPageContext().getString(e.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bql() {
        return getPageContext().getString(e.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bqp() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bqq() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bqL;
        super.onPageSelected(i);
        if (this.gxO != null && this.gxO.getItem(i) != null && (baseFragment = (BaseFragment) this.gxO.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bqL = ((PersonBarFragment) baseFragment).bqL()) != null) {
            bqL.dt(false);
            bqL.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.fax;
    }
}
