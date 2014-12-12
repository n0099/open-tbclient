package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private e bEU = null;
    private s bEV = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bEV = new s(getPageContext(), Rv());
        this.bEV.setSex(getSex());
        this.bEV.setId(getUid());
        this.bEV.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bEU == null) {
            this.bEU = new e(this, Rv());
        }
        return this.bEU;
    }

    public s ZX() {
        return this.bEV;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZM() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZN() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZO() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZP() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZQ() {
        return getPageContext().getString(com.baidu.tieba.z.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZT() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int ZU() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        q aah;
        super.onPageSelected(i);
        if (this.bEU != null && this.bEU.getItem(i) != null && (baseFragment = (BaseFragment) this.bEU.getItem(i)) != null && (baseFragment instanceof g) && (aah = ((g) baseFragment).aah()) != null) {
            aah.setEditState(false);
            aah.notifyDataSetChanged();
        }
    }
}
