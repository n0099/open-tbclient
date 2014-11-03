package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private m bBA = null;
    private z bBB = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bBB = new z(this, Az());
        this.bBB.setSex(getSex());
        this.bBB.setId(getUid());
        this.bBB.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bBA == null) {
            this.bBA = new m(this, Az());
        }
        return this.bBA;
    }

    public z ZJ() {
        return this.bBB;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zs() {
        return getString(com.baidu.tieba.y.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zt() {
        return getString(com.baidu.tieba.y.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zu() {
        return getString(com.baidu.tieba.y.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zv() {
        return getString(com.baidu.tieba.y.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zw() {
        return getString(com.baidu.tieba.y.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zy() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int Zz() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        x ZP;
        super.onPageSelected(i);
        if (this.bBA != null && this.bBA.getItem(i) != null && (baseFragment = (BaseFragment) this.bBA.getItem(i)) != null && (baseFragment instanceof o) && (ZP = ((o) baseFragment).ZP()) != null) {
            ZP.setEditState(false);
            ZP.notifyDataSetChanged();
        }
    }
}
