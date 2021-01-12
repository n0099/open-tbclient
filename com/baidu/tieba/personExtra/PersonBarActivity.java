package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter mni = null;
    private PersonBarModel mnj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mmy && this.kBN != 23011) {
            setSwipeBackEnabled(false);
        }
        this.mnj = new PersonBarModel(getPageContext(), Vx());
        this.mnj.setSex(getSex());
        this.mnj.setId(getUid());
        this.mnj.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mni == null) {
            this.mni = new PersonBarAdapter(this, Vx());
        }
        return this.mni;
    }

    public PersonBarModel dva() {
        return this.mnj;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String duI() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String duJ() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String duK() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String duL() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String duM() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String duQ() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int duR() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c dvk;
        super.onPageSelected(i);
        if (this.mni != null && this.mni.getItem(i) != null && (baseFragment = (BaseFragment) this.mni.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (dvk = ((PersonBarFragment) baseFragment).dvk()) != null) {
            dvk.lY(false);
            dvk.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.kBN;
    }
}
