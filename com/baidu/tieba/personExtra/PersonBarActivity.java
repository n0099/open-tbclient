package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter fWL = null;
    private PersonBarModel fWM = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fVH && this.ezK != 23011) {
            setSwipeBackEnabled(false);
        }
        this.fWM = new PersonBarModel(getPageContext(), aMK());
        this.fWM.setSex(getSex());
        this.fWM.setId(getUid());
        this.fWM.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fWL == null) {
            this.fWL = new PersonBarAdapter(this, aMK());
        }
        return this.fWL;
    }

    public PersonBarModel bih() {
        return this.fWM;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhN() {
        return getPageContext().getString(f.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhO() {
        return getPageContext().getString(f.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhP() {
        return getPageContext().getString(f.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhQ() {
        return getPageContext().getString(f.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhR() {
        return getPageContext().getString(f.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhV() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bhW() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bir;
        super.onPageSelected(i);
        if (this.fWL != null && this.fWL.getItem(i) != null && (baseFragment = (BaseFragment) this.fWL.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bir = ((PersonBarFragment) baseFragment).bir()) != null) {
            bir.cy(false);
            bir.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.ezK;
    }
}
