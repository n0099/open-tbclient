package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter fWu = null;
    private PersonBarModel fWv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fVu && this.evV != 23011) {
            setSwipeBackEnabled(false);
        }
        this.fWv = new PersonBarModel(getPageContext(), aLM());
        this.fWv.setSex(getSex());
        this.fWv.setId(getUid());
        this.fWv.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fWu == null) {
            this.fWu = new PersonBarAdapter(this, aLM());
        }
        return this.fWu;
    }

    public PersonBarModel bjR() {
        return this.fWv;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjx() {
        return getPageContext().getString(d.k.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjy() {
        return getPageContext().getString(d.k.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjz() {
        return getPageContext().getString(d.k.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjA() {
        return getPageContext().getString(d.k.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjB() {
        return getPageContext().getString(d.k.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjF() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bjG() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bkb;
        super.onPageSelected(i);
        if (this.fWu != null && this.fWu.getItem(i) != null && (baseFragment = (BaseFragment) this.fWu.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bkb = ((PersonBarFragment) baseFragment).bkb()) != null) {
            bkb.cx(false);
            bkb.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.evV;
    }
}
