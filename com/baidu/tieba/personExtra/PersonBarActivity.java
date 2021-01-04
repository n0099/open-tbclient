package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mrO = null;
    private PersonBarModel mrP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mre && this.kGs != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mrP = new PersonBarModel(getPageContext(), Zp());
        this.mrP.setSex(getSex());
        this.mrP.setId(getUid());
        this.mrP.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mrO == null) {
            this.mrO = new PersonBarAdapter(this, Zp());
        }
        return this.mrO;
    }

    public PersonBarModel dyR() {
        return this.mrP;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyz() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyA() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyB() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyC() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyD() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyH() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dyI() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dzb;
        super.onPageSelected(i);
        if (this.mrO != null && this.mrO.getItem(i) != null && (baseFragment = (BaseFragment) this.mrO.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dzb = ((PersonBarFragment) baseFragment).dzb()) != null) {
            dzb.mc(false);
            dzb.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kGs;
    }
}
