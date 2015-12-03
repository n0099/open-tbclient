package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private q cJF = null;
    private ae cJG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cIK && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.cJG = new ae(getPageContext(), aah());
        this.cJG.setSex(getSex());
        this.cJG.setId(getUid());
        this.cJG.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cJF == null) {
            this.cJF = new q(this, aah());
        }
        return this.cJF;
    }

    public ae ano() {
        return this.cJG;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String amZ() {
        return getPageContext().getString(n.i.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ana() {
        return getPageContext().getString(n.i.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String anb() {
        return getPageContext().getString(n.i.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String anc() {
        return getPageContext().getString(n.i.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String and() {
        return getPageContext().getString(n.i.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String anh() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int ani() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        ad any;
        super.onPageSelected(i);
        if (this.cJF != null && this.cJF.getItem(i) != null && (baseFragment = (BaseFragment) this.cJF.getItem(i)) != null && (baseFragment instanceof s) && (any = ((s) baseFragment).any()) != null) {
            any.setEditState(false);
            any.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
