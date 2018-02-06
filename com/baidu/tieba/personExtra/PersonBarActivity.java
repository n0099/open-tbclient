package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    private b glu = null;
    private PersonBarModel glv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gku && this.requestCode != 23011) {
            setSwipeBackEnabled(false);
        }
        this.glv = new PersonBarModel(getPageContext(), aLq());
        this.glv.setSex(getSex());
        this.glv.setId(getUid());
        this.glv.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public a a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.glu == null) {
            this.glu = new b(this, aLq());
        }
        return this.glu;
    }

    public PersonBarModel bjj() {
        return this.glv;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biQ() {
        return getPageContext().getString(d.j.person_bar_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biR() {
        return getPageContext().getString(d.j.attention_bar);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biS() {
        return getPageContext().getString(d.j.person_bar_no_common_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biT() {
        return getPageContext().getString(d.j.person_bar_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biU() {
        return getPageContext().getString(d.j.person_bar_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biY() {
        return "common_forum";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int biZ() {
        return 2;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        e bjt;
        super.onPageSelected(i);
        if (this.glu != null && this.glu.getItem(i) != null && (baseFragment = (BaseFragment) this.glu.getItem(i)) != null && (baseFragment instanceof d) && (bjt = ((d) baseFragment).bjt()) != null) {
            bjt.cX(false);
            bjt.notifyDataSetChanged();
        }
    }

    public int getRequestCode() {
        return this.requestCode;
    }
}
