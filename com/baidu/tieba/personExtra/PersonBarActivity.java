package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mrN = null;
    private PersonBarModel mrO = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mrd && this.kGs != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mrO = new PersonBarModel(getPageContext(), Zq());
        this.mrO.setSex(getSex());
        this.mrO.setId(getUid());
        this.mrO.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mrN == null) {
            this.mrN = new PersonBarAdapter(this, Zq());
        }
        return this.mrN;
    }

    public PersonBarModel dyS() {
        return this.mrO;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyA() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyB() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyC() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyD() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyE() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyI() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dyJ() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dzc;
        super.onPageSelected(i);
        if (this.mrN != null && this.mrN.getItem(i) != null && (baseFragment = (BaseFragment) this.mrN.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dzc = ((PersonBarFragment) baseFragment).dzc()) != null) {
            dzc.mc(false);
            dzc.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kGs;
    }
}
