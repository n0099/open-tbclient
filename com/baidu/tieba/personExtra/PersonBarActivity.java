package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jjz = null;
    private PersonBarModel jjA = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jiS && this.hHt != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jjA = new PersonBarModel(getPageContext(), bXs());
        this.jjA.setSex(getSex());
        this.jjA.setId(getUid());
        this.jjA.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jjz == null) {
            this.jjz = new PersonBarAdapter(this, bXs());
        }
        return this.jjz;
    }

    public PersonBarModel cvL() {
        return this.jjA;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvu() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvv() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvw() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvx() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvy() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvC() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cvD() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cvV;
        super.onPageSelected(i);
        if (this.jjz != null && this.jjz.getItem(i) != null && (baseFragment = (BaseFragment) this.jjz.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cvV = ((PersonBarFragment) baseFragment).cvV()) != null) {
            cvV.hC(false);
            cvV.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.hHt;
    }
}
