package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private e bGE = null;
    private s bGF = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGF = new s(getPageContext(), RM());
        this.bGF.setSex(getSex());
        this.bGF.setId(getUid());
        this.bGF.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bGE == null) {
            this.bGE = new e(this, RM());
        }
        return this.bGE;
    }

    public s aax() {
        return this.bGF;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aam() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aan() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aao() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aap() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aaq() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aat() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aau() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        q aaH;
        super.onPageSelected(i);
        if (this.bGE != null && this.bGE.getItem(i) != null && (baseFragment = (BaseFragment) this.bGE.getItem(i)) != null && (baseFragment instanceof g) && (aaH = ((g) baseFragment).aaH()) != null) {
            aaH.setEditState(false);
            aaH.notifyDataSetChanged();
        }
    }
}
