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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bVo = {n.e.icon_pop_key_all_bg, n.e.icon_pop_key_f_bg, n.e.icon_pop_key_d_bg};
    private static final int[] bVp = {n.i.info_privacy_all, n.i.info_privacy_friend, n.i.info_privacy_hide};
    private static final int[] bVq = {1, 2, 3};
    private int[] bVh;
    private String bVj;
    private ImageView bVk;
    private FragmentTabHost blo;
    private String cQA;
    private f cQB;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String ww;
    private int bVg = -1;
    int bVi = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener cQC = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iP()) {
            showToast(n.i.neterror);
        }
        setContentView(n.g.person_post_activity);
        this.cQA = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.ww = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.ww = this.ww == null ? "" : this.ww;
        if (this.ww.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bVj = getPageContext().getString(n.i.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bVj = getPageContext().getString(n.i.he);
                    break;
                case 2:
                    this.bVj = getPageContext().getString(n.i.she);
                    break;
                default:
                    this.bVj = getPageContext().getString(n.i.ta);
                    break;
            }
        }
        if (this.ww == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cQC);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.cQB != null) {
            int count = this.cQB.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.cQB.getItem(i3);
                if (item instanceof u) {
                    ((u) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(n.i.person_post), this.bVj));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.isHost) {
            this.bVk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_item_privacy, (View.OnClickListener) null);
            as.c(this.bVk, bVo[com.baidu.tbadk.core.a.h.bu(4) - 1]);
            this.bVk.setOnClickListener(new e(this));
        }
        this.bVh = new int[]{0, 1};
        this.cQB = new f(this);
        this.blo = (FragmentTabHost) findViewById(n.f.tab_host);
        this.blo.setup(getSupportFragmentManager());
        this.blo.setTabWidgetBackgroundColor(getResources().getColor(n.c.maintab_bg));
        this.blo.setOnPageChangeListener(this);
        aae();
        if (bundle != null) {
            this.bVg = bundle.getInt("CurrTabIndex");
        } else {
            this.bVg = 0;
        }
        this.blo.setCurrentTab(this.bVg);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.Zw = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.avG = n.c.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.d.fontsize32));
            bVar.Zv = fragmentTabIndicator;
            this.blo.a(bVar);
        }
    }

    private void aae() {
        if (this.cQB != null) {
            int count = this.cQB.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.cQB.getItem(i);
                int iw = this.cQB.iw(i);
                if (item != null) {
                    if (iw == 0) {
                        a(item, 0, String.format(getPageContext().getString(n.i.person_post_thread), this.bVj));
                    } else if (iw == 1) {
                        a(item, 1, String.format(getPageContext().getString(n.i.person_post_reply), this.bVj));
                    }
                }
            }
            this.blo.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public String getUid() {
        return this.ww;
    }

    public String aag() {
        return this.bVj;
    }

    public String getPortraitUrl() {
        return this.cQA;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bVg);
        super.onSaveInstanceState(bundle);
    }

    public String aot() {
        if (this.isHost) {
            return getPageContext().getString(n.i.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(n.i.person_post_lv_empty_guest), aag());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bVg) {
            this.bVg = i;
            if (this.bVh[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bVh[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blo.onChangeSkinType(i);
        as.i(this.blo, n.c.cp_bg_line_c);
        if (this.cQB != null) {
            int count = this.cQB.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.cQB.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.cQB != null) {
            u aou = this.cQB.aou();
            ad aoz = aou != null ? aou.aoz() : null;
            if (aoz != null) {
                return aoz.getBdListView();
            }
            return null;
        }
        return null;
    }
}
