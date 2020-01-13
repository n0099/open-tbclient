package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jiB = null;
    private PersonBarModel jiC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jhT && this.hFu != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jiC = new PersonBarModel(getPageContext(), bVR());
        this.jiC.setSex(getSex());
        this.jiC.setId(getUid());
        this.jiC.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jiB == null) {
            this.jiB = new PersonBarAdapter(this, bVR());
        }
        return this.jiB;
    }

    public PersonBarModel cuq() {
        return this.jiC;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ctZ() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cua() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cub() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuc() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cud() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuh() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cui() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cuA;
        super.onPageSelected(i);
        if (this.jiB != null && this.jiB.getItem(i) != null && (baseFragment = (BaseFragment) this.jiB.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cuA = ((PersonBarFragment) baseFragment).cuA()) != null) {
            cuA.hv(false);
            cuA.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.hFu;
    }
}
