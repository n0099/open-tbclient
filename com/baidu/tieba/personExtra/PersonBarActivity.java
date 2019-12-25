package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter jeY = null;
    private PersonBarModel jeZ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jer && this.hBR != 23011) {
            setSwipeBackEnabled(false);
        }
        this.jeZ = new PersonBarModel(getPageContext(), bUI());
        this.jeZ.setSex(getSex());
        this.jeZ.setId(getUid());
        this.jeZ.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jeY == null) {
            this.jeY = new PersonBarAdapter(this, bUI());
        }
        return this.jeY;
    }

    public PersonBarModel ctj() {
        return this.jeZ;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String csS() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String csT() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String csU() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String csV() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String csW() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cta() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int ctb() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c ctt;
        super.onPageSelected(i);
        if (this.jeY != null && this.jeY.getItem(i) != null && (baseFragment = (BaseFragment) this.jeY.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (ctt = ((PersonBarFragment) baseFragment).ctt()) != null) {
            ctt.hq(false);
            ctt.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.hBR;
    }
}
