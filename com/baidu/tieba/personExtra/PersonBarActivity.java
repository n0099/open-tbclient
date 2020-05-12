package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jVF = null;
    private PersonBarModel jVG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jUY && this.itd != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jVG = new PersonBarModel(getPageContext(), cin());
        this.jVG.setSex(getSex());
        this.jVG.setId(getUid());
        this.jVG.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jVF == null) {
            this.jVF = new PersonBarAdapter(this, cin());
        }
        return this.jVF;
    }

    public PersonBarModel cGQ() {
        return this.jVG;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGy() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGz() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGA() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGB() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGC() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cGG() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cGH() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cHa;
        super.onPageSelected(i);
        if (this.jVF != null && this.jVF.getItem(i) != null && (baseFragment = (BaseFragment) this.jVF.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cHa = ((PersonBarFragment) baseFragment).cHa()) != null) {
            cHa.iB(false);
            cHa.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.itd;
    }
}
