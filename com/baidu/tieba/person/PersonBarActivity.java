package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private q drR = null;
    private ae drS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dqW && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.drS = new ae(getPageContext(), ahG());
        this.drS.setSex(getSex());
        this.drS.setId(getUid());
        this.drS.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.drR == null) {
            this.drR = new q(this, ahG());
        }
        return this.drR;
    }

    public ae aAW() {
        return this.drS;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAG() {
        return getPageContext().getString(t.j.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAI() {
        return getPageContext().getString(t.j.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAJ() {
        return getPageContext().getString(t.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAK() {
        return getPageContext().getString(t.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAL() {
        return getPageContext().getString(t.j.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAP() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aAQ() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ad aBg;
        super.onPageSelected(i);
        if (this.drR != null && this.drR.getItem(i) != null && (baseFragment = (BaseFragment) this.drR.getItem(i)) != null && (baseFragment instanceof s) && (aBg = ((s) baseFragment).aBg()) != null) {
            aBg.setEditState(false);
            aBg.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
