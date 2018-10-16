package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter glC = null;
    private PersonBarModel glD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gky && this.eOK != 23011) {
            setSwipeBackEnabled(false);
        }
        this.glD = new PersonBarModel(getPageContext(), aSn());
        this.glD.setSex(getSex());
        this.glD.setId(getUid());
        this.glD.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.glC == null) {
            this.glC = new PersonBarAdapter(this, aSn());
        }
        return this.glC;
    }

    public PersonBarModel bnT() {
        return this.glD;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnz() {
        return getPageContext().getString(e.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnA() {
        return getPageContext().getString(e.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnB() {
        return getPageContext().getString(e.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnC() {
        return getPageContext().getString(e.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnD() {
        return getPageContext().getString(e.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnH() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bnI() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bod;
        super.onPageSelected(i);
        if (this.glC != null && this.glC.getItem(i) != null && (baseFragment = (BaseFragment) this.glC.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bod = ((PersonBarFragment) baseFragment).bod()) != null) {
            bod.cY(false);
            bod.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.eOK;
    }
}
