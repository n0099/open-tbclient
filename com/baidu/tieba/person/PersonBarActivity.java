package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private r edF = null;
    private ag edG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ecI && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.edG = new ag(getPageContext(), aqc());
        this.edG.setSex(getSex());
        this.edG.setId(getUid());
        this.edG.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.edF == null) {
            this.edF = new r(this, aqc());
        }
        return this.edF;
    }

    public ag aKo() {
        return this.edG;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aJZ() {
        return getPageContext().getString(u.j.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKa() {
        return getPageContext().getString(u.j.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKb() {
        return getPageContext().getString(u.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKc() {
        return getPageContext().getString(u.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKd() {
        return getPageContext().getString(u.j.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKh() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aKi() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        af aKy;
        super.onPageSelected(i);
        if (this.edF != null && this.edF.getItem(i) != null && (baseFragment = (BaseFragment) this.edF.getItem(i)) != null && (baseFragment instanceof t) && (aKy = ((t) baseFragment).aKy()) != null) {
            aKy.setEditState(false);
            aKy.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
