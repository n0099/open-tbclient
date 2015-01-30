package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private e bGF = null;
    private s bGG = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGG = new s(getPageContext(), RR());
        this.bGG.setSex(getSex());
        this.bGG.setId(getUid());
        this.bGG.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bGF == null) {
            this.bGF = new e(this, RR());
        }
        return this.bGF;
    }

    public s aaC() {
        return this.bGG;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aar() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aas() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aat() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aau() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aav() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aay() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aaz() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        q aaM;
        super.onPageSelected(i);
        if (this.bGF != null && this.bGF.getItem(i) != null && (baseFragment = (BaseFragment) this.bGF.getItem(i)) != null && (baseFragment instanceof g) && (aaM = ((g) baseFragment).aaM()) != null) {
            aaM.setEditState(false);
            aaM.notifyDataSetChanged();
        }
    }
}
