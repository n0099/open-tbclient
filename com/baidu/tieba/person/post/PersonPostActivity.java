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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] boc = {com.baidu.tieba.p.icon_pop_key_all, com.baidu.tieba.p.icon_pop_key_f, com.baidu.tieba.p.icon_pop_key_d};
    private static final int[] bod = {com.baidu.tieba.t.info_privacy_all, com.baidu.tieba.t.info_privacy_friend, com.baidu.tieba.t.info_privacy_hide};
    private static final int[] boe = {1, 2, 3};
    private FragmentTabHost aRO;
    private String bTZ;
    private f bUa;
    private int[] bnV;
    private String bnX;
    private ImageView bnY;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bnU = -1;
    int bnW = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener bUb = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.k.iX()) {
            showToast(com.baidu.tieba.t.neterror);
        }
        setContentView(com.baidu.tieba.r.person_post_activity);
        this.bTZ = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bnX = getPageContext().getString(com.baidu.tieba.t.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bnX = getPageContext().getString(com.baidu.tieba.t.he);
                    break;
                case 2:
                    this.bnX = getPageContext().getString(com.baidu.tieba.t.she);
                    break;
                default:
                    this.bnX = getPageContext().getString(com.baidu.tieba.t.ta);
                    break;
            }
        }
        if (this.mUid == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bUb);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bUa != null) {
            int count = this.bUa.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bUa.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(com.baidu.tieba.t.person_post), this.bnX));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.isHost) {
            this.bnY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_privacy, (View.OnClickListener) null);
            ay.c(this.bnY, boc[com.baidu.tbadk.core.a.j.bi(4) - 1]);
            this.bnY.setOnClickListener(new e(this));
        }
        this.bnV = new int[]{0, 1};
        this.bUa = new f(this);
        this.aRO = (FragmentTabHost) findViewById(com.baidu.tieba.q.tab_host);
        this.aRO.setup(getSupportFragmentManager());
        this.aRO.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.n.maintab_bg));
        this.aRO.setOnPageChangeListener(this);
        Uo();
        if (bundle != null) {
            this.bnU = bundle.getInt("CurrTabIndex");
        } else {
            this.bnU = 0;
        }
        this.aRO.setCurrentTab(this.bnU);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.TC = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.amU = com.baidu.tieba.n.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.fontsize32));
            bVar.TB = fragmentTabIndicator;
            this.aRO.a(bVar);
        }
    }

    private void Uo() {
        if (this.bUa != null) {
            int count = this.bUa.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bUa.getItem(i);
                int gB = this.bUa.gB(i);
                if (item != null) {
                    if (gB == 0) {
                        a(item, 0, String.format(getPageContext().getString(com.baidu.tieba.t.person_post_thread), this.bnX));
                    } else if (gB == 1) {
                        a(item, 1, String.format(getPageContext().getString(com.baidu.tieba.t.person_post_reply), this.bnX));
                    }
                }
            }
            this.aRO.initViewPager();
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

    public String Uq() {
        return this.bnX;
    }

    public String getPortraitUrl() {
        return this.bTZ;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bnU);
        super.onSaveInstanceState(bundle);
    }

    public String aeM() {
        if (this.isHost) {
            return getPageContext().getString(com.baidu.tieba.t.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(com.baidu.tieba.t.person_post_lv_empty_guest), Uq());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bnU) {
            this.bnU = i;
            if (this.bnV[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bnV[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aRO.onChangeSkinType(i);
        ay.i(this.aRO, com.baidu.tieba.n.cp_bg_line_c);
        if (this.bUa != null) {
            int count = this.bUa.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bUa.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bUa != null) {
            t aeN = this.bUa.aeN();
            aa aeQ = aeN != null ? aeN.aeQ() : null;
            if (aeQ != null) {
                return aeQ.getBdListView();
            }
            return null;
        }
        return null;
    }
}
