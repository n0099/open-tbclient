package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter ifX = null;
    private PersonBarModel ifY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ife && this.gHF != 23011) {
            setSwipeBackEnabled(false);
        }
        this.ifY = new PersonBarModel(getPageContext(), bDd());
        this.ifY.setSex(getSex());
        this.ifY.setId(getUid());
        this.ifY.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.ifX == null) {
            this.ifX = new PersonBarAdapter(this, bDd());
        }
        return this.ifX;
    }

    public PersonBarModel bYU() {
        return this.ifY;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYB() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYC() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYD() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYE() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYF() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYJ() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bYK() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c bZe;
        super.onPageSelected(i);
        if (this.ifX != null && this.ifX.getItem(i) != null && (baseFragment = (BaseFragment) this.ifX.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (bZe = ((PersonBarFragment) baseFragment).bZe()) != null) {
            bZe.gg(false);
            bZe.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gHF;
    }
}
