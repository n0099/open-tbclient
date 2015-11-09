package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private p cqk = null;
    private ad cql = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cpp && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.cql = new ad(getPageContext(), Xb());
        this.cql.setSex(getSex());
        this.cql.setId(getUid());
        this.cql.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cqk == null) {
            this.cqk = new p(this, Xb());
        }
        return this.cqk;
    }

    public ad aiL() {
        return this.cql;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiw() {
        return getPageContext().getString(i.h.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aix() {
        return getPageContext().getString(i.h.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiy() {
        return getPageContext().getString(i.h.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiz() {
        return getPageContext().getString(i.h.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiA() {
        return getPageContext().getString(i.h.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiE() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aiF() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ac aiV;
        super.onPageSelected(i);
        if (this.cqk != null && this.cqk.getItem(i) != null && (baseFragment = (BaseFragment) this.cqk.getItem(i)) != null && (baseFragment instanceof r) && (aiV = ((r) baseFragment).aiV()) != null) {
            aiV.setEditState(false);
            aiV.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
