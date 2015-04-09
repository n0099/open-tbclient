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
    private FragmentTabHost aPD;
    private String bRu;
    private f bRv;
    private int[] blq;
    private String bls;
    private ImageView blu;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private static final int[] bly = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] blz = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] blA = {1, 2, 3};
    private int blp = -1;
    int blr = 0;
    private boolean blt = false;
    private View mBack = null;
    HttpMessageListener bRw = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(com.baidu.tieba.y.neterror);
        }
        setContentView(com.baidu.tieba.w.person_post_activity);
        this.bRu = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bls = getPageContext().getString(com.baidu.tieba.y.me);
            this.blt = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bls = getPageContext().getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.bls = getPageContext().getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.bls = getPageContext().getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (this.mUid == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bRw);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bRv != null) {
            int count = this.bRv.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bRv.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(com.baidu.tieba.y.person_post), this.bls));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.blt) {
            this.blu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            ba.c(this.blu, bly[com.baidu.tbadk.core.a.j.bl(4) - 1]);
            this.blu.setOnClickListener(new e(this));
        }
        this.blq = new int[]{0, 1};
        this.bRv = new f(this);
        this.aPD = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.aPD.setup(getSupportFragmentManager());
        this.aPD.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.aPD.setOnPageChangeListener(this);
        Tb();
        if (bundle != null) {
            this.blp = bundle.getInt("CurrTabIndex");
        } else {
            this.blp = 0;
        }
        this.aPD.setCurrentTab(this.blp);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.SS = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.alT = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.SR = fragmentTabIndicator;
            this.aPD.a(bVar);
        }
    }

    private void Tb() {
        if (this.bRv != null) {
            int count = this.bRv.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bRv.getItem(i);
                int gk = this.bRv.gk(i);
                if (item != null) {
                    if (gk == 0) {
                        a(item, 0, String.format(getPageContext().getString(com.baidu.tieba.y.person_post_thread), this.bls));
                    } else if (gk == 1) {
                        a(item, 1, String.format(getPageContext().getString(com.baidu.tieba.y.person_post_reply), this.bls));
                    }
                }
            }
            this.aPD.initViewPager();
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

    public String Td() {
        return this.bls;
    }

    public String adE() {
        return this.bRu;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.blp);
        super.onSaveInstanceState(bundle);
    }

    public String adF() {
        if (this.blt) {
            return getPageContext().getString(com.baidu.tieba.y.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(com.baidu.tieba.y.person_post_lv_empty_guest), Td());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.blp) {
            this.blp = i;
            if (this.blq[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.blt ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.blq[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.blt ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aPD.onChangeSkinType(i);
        ba.i(this.aPD, com.baidu.tieba.s.cp_bg_line_c);
        if (this.bRv != null) {
            int count = this.bRv.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bRv.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bRv != null) {
            t adG = this.bRv.adG();
            aa adK = adG != null ? adG.adK() : null;
            if (adK != null) {
                return adK.getBdListView();
            }
            return null;
        }
        return null;
    }
}
