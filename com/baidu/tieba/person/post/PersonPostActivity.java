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
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bCx = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bCy = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bCz = {1, 2, 3};
    private int[] bCq;
    private String bCs;
    private ImageView bCt;
    private FragmentTabHost bdG;
    private String clC;
    private f clD;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wp;
    private int bCp = -1;
    int bCr = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener clE = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iL()) {
            showToast(i.h.neterror);
        }
        setContentView(i.g.person_post_activity);
        this.clC = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wp = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wp = this.wp == null ? "" : this.wp;
        if (this.wp.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bCs = getPageContext().getString(i.h.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bCs = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bCs = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bCs = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (this.wp == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.clE);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.clD != null) {
            int count = this.clD.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.clD.getItem(i3);
                if (item instanceof u) {
                    ((u) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(i.h.person_post), this.bCs));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.isHost) {
            this.bCt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            al.c(this.bCt, bCx[com.baidu.tbadk.core.a.h.br(4) - 1]);
            this.bCt.setOnClickListener(new e(this));
        }
        this.bCq = new int[]{0, 1};
        this.clD = new f(this);
        this.bdG = (FragmentTabHost) findViewById(i.f.tab_host);
        this.bdG.setup(getSupportFragmentManager());
        this.bdG.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bdG.setOnPageChangeListener(this);
        VY();
        if (bundle != null) {
            this.bCp = bundle.getInt("CurrTabIndex");
        } else {
            this.bCp = 0;
        }
        this.bdG.setCurrentTab(this.bCp);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YM = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.awo = i.c.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YL = fragmentTabIndicator;
            this.bdG.a(bVar);
        }
    }

    private void VY() {
        if (this.clD != null) {
            int count = this.clD.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.clD.getItem(i);
                int hp = this.clD.hp(i);
                if (item != null) {
                    if (hp == 0) {
                        a(item, 0, String.format(getPageContext().getString(i.h.person_post_thread), this.bCs));
                    } else if (hp == 1) {
                        a(item, 1, String.format(getPageContext().getString(i.h.person_post_reply), this.bCs));
                    }
                }
            }
            this.bdG.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public String getUid() {
        return this.wp;
    }

    public String Wa() {
        return this.bCs;
    }

    public String getPortraitUrl() {
        return this.clC;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bCp);
        super.onSaveInstanceState(bundle);
    }

    public String agV() {
        if (this.isHost) {
            return getPageContext().getString(i.h.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(i.h.person_post_lv_empty_guest), Wa());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bCp) {
            this.bCp = i;
            if (this.bCq[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bCq[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bdG.onChangeSkinType(i);
        al.h(this.bdG, i.c.cp_bg_line_c);
        if (this.clD != null) {
            int count = this.clD.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.clD.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.clD != null) {
            u agW = this.clD.agW();
            ab aha = agW != null ? agW.aha() : null;
            if (aha != null) {
                return aha.getBdListView();
            }
            return null;
        }
        return null;
    }
}
