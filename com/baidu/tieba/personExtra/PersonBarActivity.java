package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter hNM = null;
    private PersonBarModel hNN = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.hMU && this.gqD != 23011) {
            setSwipeBackEnabled(false);
        }
        this.hNN = new PersonBarModel(getPageContext(), bvu());
        this.hNN.setSex(getSex());
        this.hNN.setId(getUid());
        this.hNN.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.hNM == null) {
            this.hNM = new PersonBarAdapter(this, bvu());
        }
        return this.hNM;
    }

    public PersonBarModel bQY() {
        return this.hNN;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQG() {
        return getPageContext().getString(d.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQH() {
        return getPageContext().getString(d.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQI() {
        return getPageContext().getString(d.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQJ() {
        return getPageContext().getString(d.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQK() {
        return getPageContext().getString(d.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQO() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bQP() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bRi;
        super.onPageSelected(i);
        if (this.hNM != null && this.hNM.getItem(i) != null && (baseFragment = (BaseFragment) this.hNM.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bRi = ((PersonBarFragment) baseFragment).bRi()) != null) {
            bRi.fJ(false);
            bRi.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gqD;
    }
}
