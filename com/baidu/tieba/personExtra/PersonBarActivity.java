package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter hNz = null;
    private PersonBarModel hNA = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.hMH && this.gqr != 23011) {
            setSwipeBackEnabled(false);
        }
        this.hNA = new PersonBarModel(getPageContext(), bvr());
        this.hNA.setSex(getSex());
        this.hNA.setId(getUid());
        this.hNA.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.hNz == null) {
            this.hNz = new PersonBarAdapter(this, bvr());
        }
        return this.hNz;
    }

    public PersonBarModel bQU() {
        return this.hNA;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQC() {
        return getPageContext().getString(d.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQD() {
        return getPageContext().getString(d.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQE() {
        return getPageContext().getString(d.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQF() {
        return getPageContext().getString(d.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQG() {
        return getPageContext().getString(d.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQK() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bQL() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bRe;
        super.onPageSelected(i);
        if (this.hNz != null && this.hNz.getItem(i) != null && (baseFragment = (BaseFragment) this.hNz.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bRe = ((PersonBarFragment) baseFragment).bRe()) != null) {
            bRe.fJ(false);
            bRe.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gqr;
    }
}
