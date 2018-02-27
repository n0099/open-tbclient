package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private b glj = null;
    private PersonBarModel glk = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gkj && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.glk = new PersonBarModel(getPageContext(), aLp());
        this.glk.setSex(getSex());
        this.glk.setId(getUid());
        this.glk.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public a a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.glj == null) {
            this.glj = new b(this, aLp());
        }
        return this.glj;
    }

    public PersonBarModel bji() {
        return this.glk;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biP() {
        return getPageContext().getString(d.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biQ() {
        return getPageContext().getString(d.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biR() {
        return getPageContext().getString(d.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biS() {
        return getPageContext().getString(d.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biT() {
        return getPageContext().getString(d.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biX() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int biY() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        e bjs;
        super.onPageSelected(i);
        if (this.glj != null && this.glj.getItem(i) != null && (baseFragment = (BaseFragment) this.glj.getItem(i)) != null && (baseFragment instanceof d) && (bjs = ((d) baseFragment).bjs()) != null) {
            bjs.cX(false);
            bjs.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
