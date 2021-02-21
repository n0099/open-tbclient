package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mwy = null;
    private PersonBarModel mwz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mvO && this.kKg != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mwz = new PersonBarModel(getPageContext(), Xg());
        this.mwz.setSex(getSex());
        this.mwz.setId(getUid());
        this.mwz.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mwy == null) {
            this.mwy = new PersonBarAdapter(this, Xg());
        }
        return this.mwy;
    }

    public PersonBarModel dxq() {
        return this.mwz;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwY() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwZ() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxa() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxb() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxc() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxg() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dxh() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dxA;
        super.onPageSelected(i);
        if (this.mwy != null && this.mwy.getItem(i) != null && (baseFragment = (BaseFragment) this.mwy.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dxA = ((PersonBarFragment) baseFragment).dxA()) != null) {
            dxA.mc(false);
            dxA.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kKg;
    }
}
