package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mwj = null;
    private PersonBarModel mwk = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mvz && this.kJS != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mwk = new PersonBarModel(getPageContext(), Xg());
        this.mwk.setSex(getSex());
        this.mwk.setId(getUid());
        this.mwk.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mwj == null) {
            this.mwj = new PersonBarAdapter(this, Xg());
        }
        return this.mwj;
    }

    public PersonBarModel dxj() {
        return this.mwk;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwR() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwS() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwT() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwU() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwV() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwZ() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dxa() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dxt;
        super.onPageSelected(i);
        if (this.mwj != null && this.mwj.getItem(i) != null && (baseFragment = (BaseFragment) this.mwj.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dxt = ((PersonBarFragment) baseFragment).dxt()) != null) {
            dxt.mc(false);
            dxt.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kJS;
    }
}
