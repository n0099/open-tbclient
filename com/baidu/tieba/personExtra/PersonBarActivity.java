package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter lqx = null;
    private PersonBarModel lqy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.lpO && this.jFC != 23011) {
            setSwipeBackEnabled(false);
        }
        this.lqy = new PersonBarModel(getPageContext(), cLj());
        this.lqy.setSex(getSex());
        this.lqy.setId(getUid());
        this.lqy.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lqx == null) {
            this.lqx = new PersonBarAdapter(this, cLj());
        }
        return this.lqx;
    }

    public PersonBarModel dkQ() {
        return this.lqy;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dky() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkz() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkA() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkB() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkC() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkG() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dkH() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dla;
        super.onPageSelected(i);
        if (this.lqx != null && this.lqx.getItem(i) != null && (baseFragment = (BaseFragment) this.lqx.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dla = ((PersonBarFragment) baseFragment).dla()) != null) {
            dla.kp(false);
            dla.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.jFC;
    }
}
