package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter gwJ = null;
    private PersonBarModel gwK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gvF && this.eZJ != 23011) {
            setSwipeBackEnabled(false);
        }
        this.gwK = new PersonBarModel(getPageContext(), aUp());
        this.gwK.setSex(getSex());
        this.gwK.setId(getUid());
        this.gwK.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gwJ == null) {
            this.gwJ = new PersonBarAdapter(this, aUp());
        }
        return this.gwJ;
    }

    public PersonBarModel bpS() {
        return this.gwK;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpy() {
        return getPageContext().getString(e.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpz() {
        return getPageContext().getString(e.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpA() {
        return getPageContext().getString(e.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpB() {
        return getPageContext().getString(e.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpC() {
        return getPageContext().getString(e.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpG() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bpH() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        b bqc;
        super.onPageSelected(i);
        if (this.gwJ != null && this.gwJ.getItem(i) != null && (baseFragment = (BaseFragment) this.gwJ.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bqc = ((PersonBarFragment) baseFragment).bqc()) != null) {
            bqc.dq(false);
            bqc.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.eZJ;
    }
}
