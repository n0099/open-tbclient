package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private PersonBarAdapter koE = null;
    private PersonBarModel koF = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.knX && this.iIw != 23011) {
            setSwipeBackEnabled(false);
        }
        this.koF = new PersonBarModel(getPageContext(), coT());
        this.koF.setSex(getSex());
        this.koF.setId(getUid());
        this.koF.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.koE == null) {
            this.koE = new PersonBarAdapter(this, coT());
        }
        return this.koE;
    }

    public PersonBarModel cOf() {
        return this.koF;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNN() {
        return getPageContext().getString(R.string.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNO() {
        return getPageContext().getString(R.string.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNP() {
        return getPageContext().getString(R.string.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNQ() {
        return getPageContext().getString(R.string.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNR() {
        return getPageContext().getString(R.string.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cNV() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cNW() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        c cOp;
        super.onPageSelected(i);
        if (this.koE != null && this.koE.getItem(i) != null && (baseFragment = (BaseFragment) this.koE.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (cOp = ((PersonBarFragment) baseFragment).cOp()) != null) {
            cOp.iY(false);
            cOp.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.iIw;
    }
}
