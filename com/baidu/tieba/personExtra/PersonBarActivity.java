package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lFK = null;
    private PersonBarModel lFL = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lFb && this.jUz != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lFL = new PersonBarModel(getPageContext(), SR());
        this.lFL.setSex(getSex());
        this.lFL.setId(getUid());
        this.lFL.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lFK == null) {
            this.lFK = new PersonBarAdapter(this, SR());
        }
        return this.lFK;
    }

    public PersonBarModel doA() {
        return this.lFL;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String doi() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String doj() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dok() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dol() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dom() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String doq() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dor() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c doK;
        super.onPageSelected(i);
        if (this.lFK != null && this.lFK.getItem(i) != null && (baseFragment = (BaseFragment) this.lFK.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (doK = ((PersonBarFragment) baseFragment).doK()) != null) {
            doK.kN(false);
            doK.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.jUz;
    }
}
