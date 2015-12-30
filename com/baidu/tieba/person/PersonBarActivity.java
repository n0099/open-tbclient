package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private q cNV = null;
    private ae cNW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cNa && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.cNW = new ae(getPageContext(), abn());
        this.cNW.setSex(getSex());
        this.cNW.setId(getUid());
        this.cNW.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cNV == null) {
            this.cNV = new q(this, abn());
        }
        return this.cNV;
    }

    public ae aoz() {
        return this.cNW;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aok() {
        return getPageContext().getString(n.j.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aol() {
        return getPageContext().getString(n.j.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aom() {
        return getPageContext().getString(n.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aon() {
        return getPageContext().getString(n.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aoo() {
        return getPageContext().getString(n.j.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aos() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aot() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ad aoJ;
        super.onPageSelected(i);
        if (this.cNV != null && this.cNV.getItem(i) != null && (baseFragment = (BaseFragment) this.cNV.getItem(i)) != null && (baseFragment instanceof s) && (aoJ = ((s) baseFragment).aoJ()) != null) {
            aoJ.setEditState(false);
            aoJ.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
