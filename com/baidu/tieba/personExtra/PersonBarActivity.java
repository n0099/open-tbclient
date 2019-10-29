package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter inS = null;
    private PersonBarModel inT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ink && this.gOE != 23011) {
            setSwipeBackEnabled(false);
        }
        this.inT = new PersonBarModel(getPageContext(), bDy());
        this.inT.setSex(getSex());
        this.inT.setId(getUid());
        this.inT.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.inS == null) {
            this.inS = new PersonBarAdapter(this, bDy());
        }
        return this.inS;
    }

    public PersonBarModel bZR() {
        return this.inT;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZz() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZA() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZB() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZC() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZD() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bZH() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bZI() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cab;
        super.onPageSelected(i);
        if (this.inS != null && this.inS.getItem(i) != null && (baseFragment = (BaseFragment) this.inS.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cab = ((PersonBarFragment) baseFragment).cab()) != null) {
            cab.gc(false);
            cab.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gOE;
    }
}
