package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jjB = null;
    private PersonBarModel jjC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jiU && this.hHv != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jjC = new PersonBarModel(getPageContext(), bXu());
        this.jjC.setSex(getSex());
        this.jjC.setId(getUid());
        this.jjC.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jjB == null) {
            this.jjB = new PersonBarAdapter(this, bXu());
        }
        return this.jjB;
    }

    public PersonBarModel cvN() {
        return this.jjC;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvw() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvx() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvy() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvz() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvA() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvE() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cvF() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cvX;
        super.onPageSelected(i);
        if (this.jjB != null && this.jjB.getItem(i) != null && (baseFragment = (BaseFragment) this.jjB.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cvX = ((PersonBarFragment) baseFragment).cvX()) != null) {
            cvX.hC(false);
            cvX.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.hHv;
    }
}
