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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] coa = {t.f.icon_pop_key_all_bg, t.f.icon_pop_key_f_bg, t.f.icon_pop_key_d_bg};
    private static final int[] cob = {t.j.info_privacy_all, t.j.info_privacy_friend, t.j.info_privacy_hide};
    private static final int[] coc = {1, 2, 3};
    private FragmentTabHost aXu;
    private int[] cnS;
    private String cnU;
    private ImageView cnW;
    private String dBb;
    private ImageView dBc;
    private g dBd;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wY;
    private int cnR = -1;
    int cnT = 0;
    private boolean cnV = false;
    private View ajA = null;
    HttpMessageListener dBe = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.jf()) {
            showToast(t.j.neterror);
        }
        setContentView(t.h.person_post_activity);
        this.dBb = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wY = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wY = this.wY == null ? "" : this.wY;
        if (this.wY.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.cnU = getPageContext().getString(t.j.me);
            this.cnV = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.cnU = getPageContext().getString(t.j.he);
                    break;
                case 2:
                    this.cnU = getPageContext().getString(t.j.she);
                    break;
                default:
                    this.cnU = getPageContext().getString(t.j.ta);
                    break;
            }
        }
        if (this.wY == null) {
            finish();
            return;
        }
        h(bundle);
        registerListener(this.dBe);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.dBd != null) {
            int count = this.dBd.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.dBd.getItem(i3);
                if (item instanceof v) {
                    ((v) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void h(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(t.j.person_post), this.cnU));
        this.ajA = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.ajA.setOnClickListener(new d(this));
        if (this.cnV) {
            this.cnW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_privacy, (View.OnClickListener) null);
            at.c(this.cnW, coa[com.baidu.tbadk.core.a.h.bB(4) - 1]);
            this.cnW.setOnClickListener(new e(this));
            this.dBc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_recycle_bin, (View.OnClickListener) null);
            at.c(this.dBc, t.f.icon_recycle_bin);
            this.dBc.setOnClickListener(new f(this));
        }
        this.cnS = new int[]{0, 1};
        this.dBd = new g(this);
        this.aXu = (FragmentTabHost) findViewById(t.g.tab_host);
        this.aXu.setup(getSupportFragmentManager());
        this.aXu.setTabWidgetBackgroundColor(getResources().getColor(t.d.maintab_bg));
        this.aXu.setOnPageChangeListener(this);
        ahD();
        if (bundle != null) {
            this.cnR = bundle.getInt("CurrTabIndex");
        } else {
            this.cnR = 0;
        }
        this.aXu.setCurrentTab(this.cnR);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.ZK = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.ayK = t.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.fontsize32));
            cVar.ZJ = fragmentTabIndicator;
            this.aXu.a(cVar);
        }
    }

    private void ahD() {
        if (this.dBd != null) {
            int count = this.dBd.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.dBd.getItem(i);
                int jY = this.dBd.jY(i);
                if (item != null) {
                    if (jY == 0) {
                        a(item, 0, String.format(getPageContext().getString(t.j.person_post_thread), this.cnU));
                    } else if (jY == 1) {
                        a(item, 1, String.format(getPageContext().getString(t.j.person_post_reply), this.cnU));
                    }
                }
            }
            this.aXu.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public String getUid() {
        return this.wY;
    }

    public String ahF() {
        return this.cnU;
    }

    public String getPortraitUrl() {
        return this.dBb;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cnR);
        super.onSaveInstanceState(bundle);
    }

    public String aCw() {
        if (this.cnV) {
            return getPageContext().getString(t.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(t.j.person_post_lv_empty_guest), ahF());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.cnR) {
            this.cnR = i;
            if (this.cnS[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.cnV ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.cnS[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.cnV ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aXu.onChangeSkinType(i);
        at.k(this.aXu, t.d.cp_bg_line_c);
        if (this.dBd != null) {
            int count = this.dBd.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dBd.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.dBd != null) {
            v aCx = this.dBd.aCx();
            ae aCC = aCx != null ? aCx.aCC() : null;
            if (aCC != null) {
                return aCC.QF();
            }
            return null;
        }
        return null;
    }
}
