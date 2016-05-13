package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private FragmentTabHost aTo;
    private int[] coP;
    private String coR;
    private ImageView coT;
    private String dEi;
    private ImageView dEj;
    private g dEl;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mV;
    private static final int[] coX = {t.f.icon_pop_key_all_bg, t.f.icon_pop_key_f_bg, t.f.icon_pop_key_d_bg};
    private static final int[] dEm = {t.f.icon_pop_key_all_bg_w, t.f.icon_pop_key_f_bg_w, t.f.icon_pop_key_d_bg_w};
    private static final int[] coY = {t.j.info_privacy_all, t.j.info_privacy_friend, t.j.info_privacy_hide};
    private static final int[] coZ = {1, 2, 3};
    private int coO = -1;
    int coQ = 0;
    private boolean coS = false;
    private View afm = null;
    private int dEk = 0;
    HttpMessageListener dEn = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(t.j.neterror);
        }
        setContentView(t.h.person_post_activity);
        this.dEi = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mV = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mV = this.mV == null ? "" : this.mV;
        if (this.mV.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.coR = getPageContext().getString(t.j.me);
            this.coS = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.coR = getPageContext().getString(t.j.he);
                    break;
                case 2:
                    this.coR = getPageContext().getString(t.j.she);
                    break;
                default:
                    this.coR = getPageContext().getString(t.j.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mV == null) {
            finish();
            return;
        }
        i(bundle);
        registerListener(this.dEn);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.dEl != null) {
            int count = this.dEl.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.dEl.getItem(i3);
                if (item instanceof v) {
                    ((v) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void i(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(t.j.person_post), this.coR));
        this.afm = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.afm.setOnClickListener(new d(this));
        if (this.coS) {
            this.coT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_privacy, (View.OnClickListener) null);
            int bn = com.baidu.tbadk.core.a.h.bn(4) - 1;
            at.a(this.coT, dEm[bn], coX[bn]);
            this.dEk = bn;
            this.coT.setOnClickListener(new e(this));
            this.dEj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_recycle_bin, (View.OnClickListener) null);
            at.a(this.dEj, t.f.icon_recycle_bin, t.f.icon_recycle_bin_w);
            this.dEj.setOnClickListener(new f(this));
        }
        this.coP = new int[]{0, 1};
        this.dEl = new g(this);
        this.aTo = (FragmentTabHost) findViewById(t.g.tab_host);
        this.aTo.setup(getSupportFragmentManager());
        this.aTo.setOnPageChangeListener(this);
        this.aTo.setTabWidgetViewHeight((int) getResources().getDimension(t.e.ds80));
        ahM();
        ((RelativeLayout.LayoutParams) this.aTo.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds98), 0, 0);
        if (bundle != null) {
            this.coO = bundle.getInt("CurrTabIndex");
        } else {
            this.coO = 0;
        }
        this.aTo.setCurrentTab(this.coO);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.Vd = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auL = t.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.fontsize32));
            cVar.Vc = fragmentTabIndicator;
            this.aTo.a(cVar);
        }
    }

    private void ahM() {
        if (this.dEl != null) {
            int count = this.dEl.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.dEl.getItem(i);
                int jC = this.dEl.jC(i);
                if (item != null) {
                    if (jC == 0) {
                        a(item, 0, String.format(getPageContext().getString(t.j.person_post_thread), this.coR));
                    } else if (jC == 1) {
                        a(item, 1, String.format(getPageContext().getString(t.j.person_post_reply), this.coR));
                    }
                }
            }
            this.aTo.sU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public String getUid() {
        return this.mV;
    }

    public String ahO() {
        return this.coR;
    }

    public String getPortraitUrl() {
        return this.dEi;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.coO);
        super.onSaveInstanceState(bundle);
    }

    public String aCR() {
        if (this.coS) {
            return getPageContext().getString(t.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(t.j.person_post_lv_empty_guest), ahO());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.coO) {
            this.coO = i;
            if (this.coP[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.coS ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.coP[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.coS ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aTo.setNeedShowThemeStyle(false);
        this.aTo.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.aTo.onChangeSkinType(i);
        at.a(this.dEj, t.f.icon_recycle_bin_w, t.f.icon_recycle_bin);
        at.a(this.coT, dEm[this.dEk], coX[this.dEk]);
        if (this.dEl != null) {
            int count = this.dEl.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dEl.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.dEl != null) {
            v aCT = this.dEl.aCT();
            ae aCY = aCT != null ? aCT.aCY() : null;
            if (aCY != null) {
                return aCY.PE();
            }
            return null;
        }
        return null;
    }
}
