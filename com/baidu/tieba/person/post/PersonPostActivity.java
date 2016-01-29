package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] cdv = {t.f.icon_pop_key_all_bg, t.f.icon_pop_key_f_bg, t.f.icon_pop_key_d_bg};
    private static final int[] cdw = {t.j.info_privacy_all, t.j.info_privacy_friend, t.j.info_privacy_hide};
    private static final int[] cdx = {1, 2, 3};
    private FragmentTabHost aTI;
    private int[] cdn;
    private String cdp;
    private ImageView cdr;
    private String dgC;
    private ImageView dgD;
    private g dgE;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wH;
    private int cdm = -1;
    int cdo = 0;
    private boolean cdq = false;
    private View ajk = null;
    HttpMessageListener dgF = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iZ()) {
            showToast(t.j.neterror);
        }
        setContentView(t.h.person_post_activity);
        this.dgC = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wH = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wH = this.wH == null ? "" : this.wH;
        if (this.wH.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.cdp = getPageContext().getString(t.j.me);
            this.cdq = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.cdp = getPageContext().getString(t.j.he);
                    break;
                case 2:
                    this.cdp = getPageContext().getString(t.j.she);
                    break;
                default:
                    this.cdp = getPageContext().getString(t.j.ta);
                    break;
            }
        }
        if (this.wH == null) {
            finish();
            return;
        }
        f(bundle);
        registerListener(this.dgF);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.dgE != null) {
            int count = this.dgE.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.dgE.getItem(i3);
                if (item instanceof v) {
                    ((v) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void f(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(t.j.person_post), this.cdp));
        this.ajk = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.ajk.setOnClickListener(new d(this));
        if (this.cdq) {
            this.cdr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_privacy, (View.OnClickListener) null);
            ar.c(this.cdr, cdv[com.baidu.tbadk.core.a.h.bC(4) - 1]);
            this.cdr.setOnClickListener(new e(this));
            this.dgD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_recycle_bin, (View.OnClickListener) null);
            ar.c(this.dgD, t.f.icon_recycle_bin);
            this.dgD.setOnClickListener(new f(this));
        }
        this.cdn = new int[]{0, 1};
        this.dgE = new g(this);
        this.aTI = (FragmentTabHost) findViewById(t.g.tab_host);
        this.aTI.setup(getSupportFragmentManager());
        this.aTI.setTabWidgetBackgroundColor(getResources().getColor(t.d.maintab_bg));
        this.aTI.setOnPageChangeListener(this);
        aek();
        if (bundle != null) {
            this.cdm = bundle.getInt("CurrTabIndex");
        } else {
            this.cdm = 0;
        }
        this.aTI.setCurrentTab(this.cdm);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aay = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.ayd = t.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.fontsize32));
            cVar.aax = fragmentTabIndicator;
            this.aTI.a(cVar);
        }
    }

    private void aek() {
        if (this.dgE != null) {
            int count = this.dgE.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.dgE.getItem(i);
                int js = this.dgE.js(i);
                if (item != null) {
                    if (js == 0) {
                        a(item, 0, String.format(getPageContext().getString(t.j.person_post_thread), this.cdp));
                    } else if (js == 1) {
                        a(item, 1, String.format(getPageContext().getString(t.j.person_post_reply), this.cdp));
                    }
                }
            }
            this.aTI.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public String getUid() {
        return this.wH;
    }

    public String aem() {
        return this.cdp;
    }

    public String getPortraitUrl() {
        return this.dgC;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cdm);
        super.onSaveInstanceState(bundle);
    }

    public String auQ() {
        if (this.cdq) {
            return getPageContext().getString(t.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(t.j.person_post_lv_empty_guest), aem());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.cdm) {
            this.cdm = i;
            if (this.cdn[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.cdq ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.cdn[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.cdq ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aTI.onChangeSkinType(i);
        ar.k(this.aTI, t.d.cp_bg_line_c);
        if (this.dgE != null) {
            int count = this.dgE.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dgE.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.dgE != null) {
            v auR = this.dgE.auR();
            ae auW = auR != null ? auR.auW() : null;
            if (auW != null) {
                return auW.OQ();
            }
            return null;
        }
        return null;
    }
}
