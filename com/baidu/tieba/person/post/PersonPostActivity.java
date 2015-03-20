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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bli = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] blj = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] blk = {1, 2, 3};
    private FragmentTabHost aPm;
    private String bRe;
    private f bRf;
    private int[] bla;
    private String blc;
    private ImageView ble;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bkZ = -1;
    int blb = 0;
    private boolean bld = false;
    private View mBack = null;
    HttpMessageListener bRg = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(com.baidu.tieba.y.neterror);
        }
        setContentView(com.baidu.tieba.w.person_post_activity);
        this.bRe = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.blc = getPageContext().getString(com.baidu.tieba.y.me);
            this.bld = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.blc = getPageContext().getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.blc = getPageContext().getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.blc = getPageContext().getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (this.mUid == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bRg);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bRf != null) {
            int count = this.bRf.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bRf.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(com.baidu.tieba.y.person_post), this.blc));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.bld) {
            this.ble = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            ba.c(this.ble, bli[com.baidu.tbadk.core.a.j.bl(4) - 1]);
            this.ble.setOnClickListener(new e(this));
        }
        this.bla = new int[]{0, 1};
        this.bRf = new f(this);
        this.aPm = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.aPm.setup(getSupportFragmentManager());
        this.aPm.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.aPm.setOnPageChangeListener(this);
        SO();
        if (bundle != null) {
            this.bkZ = bundle.getInt("CurrTabIndex");
        } else {
            this.bkZ = 0;
        }
        this.aPm.setCurrentTab(this.bkZ);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.SQ = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.alL = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.SP = fragmentTabIndicator;
            this.aPm.a(bVar);
        }
    }

    private void SO() {
        if (this.bRf != null) {
            int count = this.bRf.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bRf.getItem(i);
                int gi = this.bRf.gi(i);
                if (item != null) {
                    if (gi == 0) {
                        a(item, 0, String.format(getPageContext().getString(com.baidu.tieba.y.person_post_thread), this.blc));
                    } else if (gi == 1) {
                        a(item, 1, String.format(getPageContext().getString(com.baidu.tieba.y.person_post_reply), this.blc));
                    }
                }
            }
            this.aPm.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public String getUid() {
        return this.mUid;
    }

    public String SQ() {
        return this.blc;
    }

    public String adp() {
        return this.bRe;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkZ);
        super.onSaveInstanceState(bundle);
    }

    public String adq() {
        if (this.bld) {
            return getPageContext().getString(com.baidu.tieba.y.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(com.baidu.tieba.y.person_post_lv_empty_guest), SQ());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bkZ) {
            this.bkZ = i;
            if (this.bla[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.bld ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bla[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.bld ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aPm.onChangeSkinType(i);
        ba.i(this.aPm, com.baidu.tieba.s.cp_bg_line_c);
        if (this.bRf != null) {
            int count = this.bRf.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bRf.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bRf != null) {
            t adr = this.bRf.adr();
            aa adv = adr != null ? adr.adv() : null;
            if (adv != null) {
                return adv.getBdListView();
            }
            return null;
        }
        return null;
    }
}
