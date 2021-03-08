package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter myA = null;
    private PersonBarModel myB = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mxQ && this.kMi != 23011) {
            setSwipeBackEnabled(false);
        }
        this.myB = new PersonBarModel(getPageContext(), Xj());
        this.myB.setSex(getSex());
        this.myB.setId(getUid());
        this.myB.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.myA == null) {
            this.myA = new PersonBarAdapter(this, Xj());
        }
        return this.myA;
    }

    public PersonBarModel dxz() {
        return this.myB;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxh() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxi() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxj() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxk() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxl() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxp() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dxq() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dxJ;
        super.onPageSelected(i);
        if (this.myA != null && this.myA.getItem(i) != null && (baseFragment = (BaseFragment) this.myA.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dxJ = ((PersonBarFragment) baseFragment).dxJ()) != null) {
            dxJ.mc(false);
            dxJ.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kMi;
    }
}
