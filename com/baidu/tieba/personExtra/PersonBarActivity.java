package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.b.i0.h2.c;
/* loaded from: classes3.dex */
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

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c i1;
        super.onPageSelected(i);
        PersonBarAdapter personBarAdapter = this.mAdapter;
        if (personBarAdapter == null || personBarAdapter.getItem(i) == null || (baseFragment = (BaseFragment) this.mAdapter.getItem(i)) == null || !(baseFragment instanceof PersonBarFragment) || (i1 = ((PersonBarFragment) baseFragment).i1()) == null) {
            return;
        }
        i1.f(false);
        i1.notifyDataSetChanged();
    }
}
