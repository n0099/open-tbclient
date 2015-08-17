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
    private static final int[] bBQ = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bBR = {i.C0057i.info_privacy_all, i.C0057i.info_privacy_friend, i.C0057i.info_privacy_hide};
    private static final int[] bBS = {1, 2, 3};
    private int[] bBJ;
    private String bBL;
    private ImageView bBM;
    private FragmentTabHost bdl;
    private String ckH;
    private e ckI;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wr;
    private int bBI = -1;
    int bBK = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener ckJ = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iO()) {
            showToast(i.C0057i.neterror);
        }
        setContentView(i.g.person_post_activity);
        this.ckH = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wr = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wr = this.wr == null ? "" : this.wr;
        if (this.wr.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bBL = getPageContext().getString(i.C0057i.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bBL = getPageContext().getString(i.C0057i.he);
                    break;
                case 2:
                    this.bBL = getPageContext().getString(i.C0057i.she);
                    break;
                default:
                    this.bBL = getPageContext().getString(i.C0057i.ta);
                    break;
            }
        }
        if (this.wr == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.ckJ);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ckI != null) {
            int count = this.ckI.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.ckI.getItem(i3);
                if (item instanceof p) {
                    ((p) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(i.C0057i.person_post), this.bBL));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new c(this));
        if (this.isHost) {
            this.bBM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            al.c(this.bBM, bBQ[com.baidu.tbadk.core.a.h.br(4) - 1]);
            this.bBM.setOnClickListener(new d(this));
        }
        this.bBJ = new int[]{0, 1};
        this.ckI = new e(this);
        this.bdl = (FragmentTabHost) findViewById(i.f.tab_host);
        this.bdl.setup(getSupportFragmentManager());
        this.bdl.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bdl.setOnPageChangeListener(this);
        VW();
        if (bundle != null) {
            this.bBI = bundle.getInt("CurrTabIndex");
        } else {
            this.bBI = 0;
        }
        this.bdl.setCurrentTab(this.bBI);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YD = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auG = i.c.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YC = fragmentTabIndicator;
            this.bdl.a(bVar);
        }
    }

    private void VW() {
        if (this.ckI != null) {
            int count = this.ckI.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.ckI.getItem(i);
                int hf = this.ckI.hf(i);
                if (item != null) {
                    if (hf == 0) {
                        a(item, 0, String.format(getPageContext().getString(i.C0057i.person_post_thread), this.bBL));
                    } else if (hf == 1) {
                        a(item, 1, String.format(getPageContext().getString(i.C0057i.person_post_reply), this.bBL));
                    }
                }
            }
            this.bdl.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public String getUid() {
        return this.wr;
    }

    public String VY() {
        return this.bBL;
    }

    public String getPortraitUrl() {
        return this.ckH;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bBI);
        super.onSaveInstanceState(bundle);
    }

    public String agF() {
        if (this.isHost) {
            return getPageContext().getString(i.C0057i.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(i.C0057i.person_post_lv_empty_guest), VY());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bBI) {
            this.bBI = i;
            if (this.bBJ[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bBJ[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bdl.onChangeSkinType(i);
        al.i(this.bdl, i.c.cp_bg_line_c);
        if (this.ckI != null) {
            int count = this.ckI.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ckI.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.ckI != null) {
            p agG = this.ckI.agG();
            v agI = agG != null ? agG.agI() : null;
            if (agI != null) {
                return agI.getBdListView();
            }
            return null;
        }
        return null;
    }
}
