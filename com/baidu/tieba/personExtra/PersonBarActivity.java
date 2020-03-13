package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jjN = null;
    private PersonBarModel jjO = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jjg && this.hHH != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jjO = new PersonBarModel(getPageContext(), bXv());
        this.jjO.setSex(getSex());
        this.jjO.setId(getUid());
        this.jjO.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jjN == null) {
            this.jjN = new PersonBarAdapter(this, bXv());
        }
        return this.jjN;
    }

    public PersonBarModel cvO() {
        return this.jjO;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvx() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvy() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvz() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvA() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvB() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cvF() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cvG() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cvY;
        super.onPageSelected(i);
        if (this.jjN != null && this.jjN.getItem(i) != null && (baseFragment = (BaseFragment) this.jjN.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cvY = ((PersonBarFragment) baseFragment).cvY()) != null) {
            cvY.hC(false);
            cvY.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.hHH;
    }
}
