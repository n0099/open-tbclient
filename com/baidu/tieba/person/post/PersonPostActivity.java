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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bFB = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bFC = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bFD = {1, 2, 3};
    private int[] bFu;
    private String bFw;
    private ImageView bFx;
    private FragmentTabHost bdT;
    private String crg;
    private f crh;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wq;
    private int bFt = -1;
    int bFv = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener cri = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iM()) {
            showToast(i.h.neterror);
        }
        setContentView(i.g.person_post_activity);
        this.crg = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wq = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wq = this.wq == null ? "" : this.wq;
        if (this.wq.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bFw = getPageContext().getString(i.h.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bFw = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bFw = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bFw = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (this.wq == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cri);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.crh != null) {
            int count = this.crh.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.crh.getItem(i3);
                if (item instanceof u) {
                    ((u) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(i.h.person_post), this.bFw));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.isHost) {
            this.bFx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            am.c(this.bFx, bFB[com.baidu.tbadk.core.a.h.br(4) - 1]);
            this.bFx.setOnClickListener(new e(this));
        }
        this.bFu = new int[]{0, 1};
        this.crh = new f(this);
        this.bdT = (FragmentTabHost) findViewById(i.f.tab_host);
        this.bdT.setup(getSupportFragmentManager());
        this.bdT.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bdT.setOnPageChangeListener(this);
        WH();
        if (bundle != null) {
            this.bFt = bundle.getInt("CurrTabIndex");
        } else {
            this.bFt = 0;
        }
        this.bdT.setCurrentTab(this.bFt);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YE = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auN = i.c.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YD = fragmentTabIndicator;
            this.bdT.a(bVar);
        }
    }

    private void WH() {
        if (this.crh != null) {
            int count = this.crh.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.crh.getItem(i);
                int hv = this.crh.hv(i);
                if (item != null) {
                    if (hv == 0) {
                        a(item, 0, String.format(getPageContext().getString(i.h.person_post_thread), this.bFw));
                    } else if (hv == 1) {
                        a(item, 1, String.format(getPageContext().getString(i.h.person_post_reply), this.bFw));
                    }
                }
            }
            this.bdT.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public String getUid() {
        return this.wq;
    }

    public String WJ() {
        return this.bFw;
    }

    public String getPortraitUrl() {
        return this.crg;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bFt);
        super.onSaveInstanceState(bundle);
    }

    public String aiV() {
        if (this.isHost) {
            return getPageContext().getString(i.h.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(i.h.person_post_lv_empty_guest), WJ());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bFt) {
            this.bFt = i;
            if (this.bFu[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bFu[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bdT.onChangeSkinType(i);
        am.i(this.bdT, i.c.cp_bg_line_c);
        if (this.crh != null) {
            int count = this.crh.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.crh.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.crh != null) {
            u aiW = this.crh.aiW();
            ab ajb = aiW != null ? aiW.ajb() : null;
            if (ajb != null) {
                return ajb.getBdListView();
            }
            return null;
        }
        return null;
    }
}
