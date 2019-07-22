package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter imp = null;
    private PersonBarModel imq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ilv && this.gNR != 23011) {
            setSwipeBackEnabled(false);
        }
        this.imq = new PersonBarModel(getPageContext(), bFL());
        this.imq.setSex(getSex());
        this.imq.setId(getUid());
        this.imq.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.imp == null) {
            this.imp = new PersonBarAdapter(this, bFL());
        }
        return this.imp;
    }

    public PersonBarModel cbK() {
        return this.imq;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbr() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbs() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbt() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbu() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbv() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cbz() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cbA() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cbU;
        super.onPageSelected(i);
        if (this.imp != null && this.imp.getItem(i) != null && (baseFragment = (BaseFragment) this.imp.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cbU = ((PersonBarFragment) baseFragment).cbU()) != null) {
            cbU.gk(false);
            cbU.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.gNR;
    }
}
