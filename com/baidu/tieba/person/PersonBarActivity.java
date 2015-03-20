package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private t bPh = null;
    private ah bPi = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.bOx) {
            setSwipeBackEnabled(false);
        }
        this.bPi = new ah(getPageContext(), SR());
        this.bPi.setSex(getSex());
        this.bPi.setId(getUid());
        this.bPi.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bPh == null) {
            this.bPh = new t(this, SR());
        }
        return this.bPh;
    }

    public ah acN() {
        return this.bPi;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acz() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acA() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acB() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acC() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acD() {
        return getPageContext().getString(com.baidu.tieba.y.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acG() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int acH() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        af acX;
        super.onPageSelected(i);
        if (this.bPh != null && this.bPh.getItem(i) != null && (baseFragment = (BaseFragment) this.bPh.getItem(i)) != null && (baseFragment instanceof v) && (acX = ((v) baseFragment).acX()) != null) {
            acX.setEditState(false);
            acX.notifyDataSetChanged();
        }
    }
}
