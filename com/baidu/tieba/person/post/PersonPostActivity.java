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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private FragmentTabHost aWJ;
    private int[] cUe;
    private String cUg;
    private ImageView cUi;
    private String enb;
    private ImageView enc;
    private g enf;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mV;
    private static final int[] cUm = {u.f.icon_pop_key_all_bg, u.f.icon_pop_key_f_bg, u.f.icon_pop_key_d_bg};
    private static final int[] eng = {u.f.icon_pop_key_all_bg_w, u.f.icon_pop_key_f_bg_w, u.f.icon_pop_key_d_bg_w};
    private static final int[] cUo = {u.j.info_privacy_all, u.j.info_privacy_friend, u.j.info_privacy_hide};
    private static final int[] cUp = {1, 2, 3};
    private int cUd = -1;
    int cUf = 0;
    private boolean cUh = false;
    private View afN = null;
    private int ene = 0;
    HttpMessageListener enh = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.fr()) {
            showToast(u.j.neterror);
        }
        setContentView(u.h.person_post_activity);
        this.enb = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mV = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mV = this.mV == null ? "" : this.mV;
        if (this.mV.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.cUg = getPageContext().getString(u.j.me);
            this.cUh = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.cUg = getPageContext().getString(u.j.he);
                    break;
                case 2:
                    this.cUg = getPageContext().getString(u.j.she);
                    break;
                default:
                    this.cUg = getPageContext().getString(u.j.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mV == null) {
            finish();
            return;
        }
        j(bundle);
        registerListener(this.enh);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.enf != null) {
            int count = this.enf.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.enf.getItem(i3);
                if (item instanceof x) {
                    ((x) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void j(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(u.j.person_post), this.cUg));
        this.afN = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.afN.setOnClickListener(new d(this));
        if (this.cUh) {
            this.cUi = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_privacy, (View.OnClickListener) null);
            int bo = com.baidu.tbadk.core.a.h.bo(4) - 1;
            av.a(this.cUi, eng[bo], cUm[bo]);
            this.ene = bo;
            this.cUi.setOnClickListener(new e(this));
            this.enc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_recycle_bin, (View.OnClickListener) null);
            av.a(this.enc, u.f.icon_recycle_bin, u.f.icon_recycle_bin_w);
            this.enc.setOnClickListener(new f(this));
        }
        this.cUe = new int[]{0, 1};
        this.enf = new g(this);
        this.aWJ = (FragmentTabHost) findViewById(u.g.tab_host);
        this.aWJ.setup(getSupportFragmentManager());
        this.aWJ.setOnPageChangeListener(this);
        this.aWJ.setTabWidgetViewHeight((int) getResources().getDimension(u.e.ds80));
        apZ();
        ((RelativeLayout.LayoutParams) this.aWJ.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds98), 0, 0);
        if (bundle != null) {
            this.cUd = bundle.getInt("CurrTabIndex");
        } else {
            this.cUd = 0;
        }
        this.aWJ.setCurrentTab(this.cUd);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.Vt = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.avB = u.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.e.fontsize32));
            cVar.Vs = fragmentTabIndicator;
            this.aWJ.a(cVar);
        }
    }

    private void apZ() {
        if (this.enf != null) {
            int count = this.enf.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.enf.getItem(i);
                int le = this.enf.le(i);
                if (item != null) {
                    if (le == 0) {
                        a(item, 0, String.format(getPageContext().getString(u.j.person_post_thread), this.cUg));
                    } else if (le == 1) {
                        a(item, 1, String.format(getPageContext().getString(u.j.person_post_reply), this.cUg));
                    }
                }
            }
            this.aWJ.sR();
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

    public String aqb() {
        return this.cUg;
    }

    public String getPortraitUrl() {
        return this.enb;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cUd);
        super.onSaveInstanceState(bundle);
    }

    public String aLN() {
        if (this.cUh) {
            return getPageContext().getString(u.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(u.j.person_post_lv_empty_guest), aqb());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.cUd) {
            this.cUd = i;
            if (this.cUe[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.cUh ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.cUe[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.cUh ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aWJ.setNeedShowThemeStyle(false);
        this.aWJ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.aWJ.onChangeSkinType(i);
        av.a(this.enc, u.f.icon_recycle_bin_w, u.f.icon_recycle_bin);
        av.a(this.cUi, eng[this.ene], cUm[this.ene]);
        if (this.enf != null) {
            int count = this.enf.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.enf.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.enf != null) {
            x aLO = this.enf.aLO();
            ai aLT = aLO != null ? aLO.aLT() : null;
            if (aLT != null) {
                return aLT.Vi();
            }
            return null;
        }
        return null;
    }
}
