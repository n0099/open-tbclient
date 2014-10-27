package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
/* loaded from: classes.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private m bBm = null;
    private z bBn = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bBn = new z(this, Ax());
        this.bBn.setSex(getSex());
        this.bBn.setId(getUid());
        this.bBn.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bBm == null) {
            this.bBm = new m(this, Ax());
        }
        return this.bBm;
    }

    public z ZH() {
        return this.bBn;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zp() {
        return getString(com.baidu.tieba.y.person_bar_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zq() {
        return getString(com.baidu.tieba.y.person_bar_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zr() {
        return getString(com.baidu.tieba.y.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zs() {
        return getString(com.baidu.tieba.y.person_bar_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zt() {
        return getString(com.baidu.tieba.y.person_bar_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zv() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int Zw() {
        return 2;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        x ZN;
        super.onPageSelected(i);
        if (this.bBm != null && this.bBm.getItem(i) != null && (baseFragment = (BaseFragment) this.bBm.getItem(i)) != null && (baseFragment instanceof o) && (ZN = ((o) baseFragment).ZN()) != null) {
            ZN.setEditState(false);
            ZN.notifyDataSetChanged();
        }
    }
}
