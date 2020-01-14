package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jiG = null;
    private PersonBarModel jiH = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jhY && this.hFu != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jiH = new PersonBarModel(getPageContext(), bVR());
        this.jiH.setSex(getSex());
        this.jiH.setId(getUid());
        this.jiH.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jiG == null) {
            this.jiG = new PersonBarAdapter(this, bVR());
        }
        return this.jiG;
    }

    public PersonBarModel cus() {
        return this.jiH;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cub() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuc() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cud() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cue() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuf() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuj() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cuk() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cuC;
        super.onPageSelected(i);
        if (this.jiG != null && this.jiG.getItem(i) != null && (baseFragment = (BaseFragment) this.jiG.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cuC = ((PersonBarFragment) baseFragment).cuC()) != null) {
            cuC.hv(false);
            cuC.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.hFu;
    }
}
