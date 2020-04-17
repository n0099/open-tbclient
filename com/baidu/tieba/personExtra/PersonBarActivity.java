package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jVB = null;
    private PersonBarModel jVC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jUU && this.isX != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jVC = new PersonBarModel(getPageContext(), cio());
        this.jVC.setSex(getSex());
        this.jVC.setId(getUid());
        this.jVC.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jVB == null) {
            this.jVB = new PersonBarAdapter(this, cio());
        }
        return this.jVB;
    }

    public PersonBarModel cGS() {
        return this.jVC;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGA() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGB() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGC() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGD() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGE() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGI() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cGJ() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cHc;
        super.onPageSelected(i);
        if (this.jVB != null && this.jVB.getItem(i) != null && (baseFragment = (BaseFragment) this.jVB.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cHc = ((PersonBarFragment) baseFragment).cHc()) != null) {
            cHc.iB(false);
            cHc.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.isX;
    }
}
