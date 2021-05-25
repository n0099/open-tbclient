package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.a.n0.i2.c;
/* loaded from: classes5.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    public PersonBarAdapter mAdapter = null;
    public PersonBarModel mModel = null;

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter createPersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mAdapter == null) {
            this.mAdapter = new PersonBarAdapter(this, getIsHost());
        }
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getCommonTabTitle() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getHisCommonEventText() {
        return "common_forum";
    }

    public PersonBarModel getModel() {
        return this.mModel;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNavigationBarTitle() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoCommonTabTitle() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoPersonalTabTitle() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getPersonalTabTitle() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int getPrivacyType() {
        return 2;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mIsChooseBarMode && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        PersonBarModel personBarModel = new PersonBarModel(getPageContext(), getIsHost());
        this.mModel = personBarModel;
        personBarModel.setSex(getSex());
        this.mModel.y(getUid());
        this.mModel.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        BaseFragment baseFragment;
        c h1;
        super.onPageSelected(i2);
        PersonBarAdapter personBarAdapter = this.mAdapter;
        if (personBarAdapter == null || personBarAdapter.getItem(i2) == null || (baseFragment = (BaseFragment) this.mAdapter.getItem(i2)) == null || !(baseFragment instanceof PersonBarFragment) || (h1 = ((PersonBarFragment) baseFragment).h1()) == null) {
            return;
        }
        h1.f(false);
        h1.notifyDataSetChanged();
    }
}
