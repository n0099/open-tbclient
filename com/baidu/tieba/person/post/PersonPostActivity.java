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
    private static final int[] bZa = {n.f.icon_pop_key_all_bg, n.f.icon_pop_key_f_bg, n.f.icon_pop_key_d_bg};
    private static final int[] bZb = {n.j.info_privacy_all, n.j.info_privacy_friend, n.j.info_privacy_hide};
    private static final int[] bZc = {1, 2, 3};
    private int[] bYT;
    private String bYV;
    private ImageView bYW;
    private FragmentTabHost bpf;
    private String cVc;
    private f cVd;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wy;
    private int bYS = -1;
    int bYU = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener cVe = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iQ()) {
            showToast(n.j.neterror);
        }
        setContentView(n.h.person_post_activity);
        this.cVc = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wy = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wy = this.wy == null ? "" : this.wy;
        if (this.wy.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bYV = getPageContext().getString(n.j.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bYV = getPageContext().getString(n.j.he);
                    break;
                case 2:
                    this.bYV = getPageContext().getString(n.j.she);
                    break;
                default:
                    this.bYV = getPageContext().getString(n.j.ta);
                    break;
            }
        }
        if (this.wy == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cVe);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.cVd != null) {
            int count = this.cVd.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.cVd.getItem(i3);
                if (item instanceof u) {
                    ((u) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(n.j.person_post), this.bYV));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.isHost) {
            this.bYW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_item_privacy, (View.OnClickListener) null);
            as.c(this.bYW, bZa[com.baidu.tbadk.core.a.h.bn(4) - 1]);
            this.bYW.setOnClickListener(new e(this));
        }
        this.bYT = new int[]{0, 1};
        this.cVd = new f(this);
        this.bpf = (FragmentTabHost) findViewById(n.g.tab_host);
        this.bpf.setup(getSupportFragmentManager());
        this.bpf.setTabWidgetBackgroundColor(getResources().getColor(n.d.maintab_bg));
        this.bpf.setOnPageChangeListener(this);
        abk();
        if (bundle != null) {
            this.bYS = bundle.getInt("CurrTabIndex");
        } else {
            this.bYS = 0;
        }
        this.bpf.setCurrentTab(this.bYS);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aaa = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.axk = n.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.e.fontsize32));
            cVar.ZZ = fragmentTabIndicator;
            this.bpf.a(cVar);
        }
    }

    private void abk() {
        if (this.cVd != null) {
            int count = this.cVd.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.cVd.getItem(i);
                int iV = this.cVd.iV(i);
                if (item != null) {
                    if (iV == 0) {
                        a(item, 0, String.format(getPageContext().getString(n.j.person_post_thread), this.bYV));
                    } else if (iV == 1) {
                        a(item, 1, String.format(getPageContext().getString(n.j.person_post_reply), this.bYV));
                    }
                }
            }
            this.bpf.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public String getUid() {
        return this.wy;
    }

    public String abm() {
        return this.bYV;
    }

    public String getPortraitUrl() {
        return this.cVc;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bYS);
        super.onSaveInstanceState(bundle);
    }

    public String apD() {
        if (this.isHost) {
            return getPageContext().getString(n.j.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(n.j.person_post_lv_empty_guest), abm());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bYS) {
            this.bYS = i;
            if (this.bYT[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bYT[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bpf.onChangeSkinType(i);
        as.i(this.bpf, n.d.cp_bg_line_c);
        if (this.cVd != null) {
            int count = this.cVd.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.cVd.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.cVd != null) {
            u apE = this.cVd.apE();
            ad apJ = apE != null ? apE.apJ() : null;
            if (apJ != null) {
                return apJ.getBdListView();
            }
            return null;
        }
        return null;
    }
}
