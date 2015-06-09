package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private t bRB = null;
    private ai bRC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.bQP && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.bRC = new ai(getPageContext(), Us());
        this.bRC.setSex(getSex());
        this.bRC.setId(getUid());
        this.bRC.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bRB == null) {
            this.bRB = new t(this, Us());
        }
        return this.bRB;
    }

    public ai aed() {
        return this.bRC;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adO() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adP() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adQ() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adR() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adS() {
        return getPageContext().getString(com.baidu.tieba.t.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adW() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int adX() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ag aen;
        super.onPageSelected(i);
        if (this.bRB != null && this.bRB.getItem(i) != null && (baseFragment = (BaseFragment) this.bRB.getItem(i)) != null && (baseFragment instanceof v) && (aen = ((v) baseFragment).aen()) != null) {
            aen.setEditState(false);
            aen.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
