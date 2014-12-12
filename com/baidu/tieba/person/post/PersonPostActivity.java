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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] biX;
    private static final int[] biY;
    private static final int[] biZ;
    private FragmentTabHost aIf;
    private String bHh;
    private f bHi;
    private int[] biP;
    private String biR;
    private ImageView biT;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int biO = -1;
    int biQ = 0;
    private boolean biS = false;
    private View mBack = null;
    HttpMessageListener bHj = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        ac.init();
        biX = new int[]{com.baidu.tieba.v.icon_pop_key_all, com.baidu.tieba.v.icon_pop_key_f, com.baidu.tieba.v.icon_pop_key_d};
        biY = new int[]{com.baidu.tieba.z.info_privacy_all, com.baidu.tieba.z.info_privacy_friend, com.baidu.tieba.z.info_privacy_hide};
        biZ = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.fg()) {
            showToast(com.baidu.tieba.z.neterror);
        }
        setContentView(com.baidu.tieba.x.person_post_activity);
        this.bHh = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.biR = getPageContext().getString(com.baidu.tieba.z.me);
            this.biS = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.biR = getPageContext().getString(com.baidu.tieba.z.he);
                    break;
                case 2:
                    this.biR = getPageContext().getString(com.baidu.tieba.z.she);
                    break;
                default:
                    this.biR = getPageContext().getString(com.baidu.tieba.z.ta);
                    break;
            }
        }
        if (this.mUid == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bHj);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bHi != null) {
            int count = this.bHi.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bHi.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(com.baidu.tieba.z.person_post), this.biR));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.biS) {
            this.biT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_privacy, (View.OnClickListener) null);
            ax.c(this.biT, biX[com.baidu.tbadk.core.account.o.bh(4) - 1]);
            this.biT.setOnClickListener(new e(this));
        }
        this.biP = new int[]{0, 1};
        this.bHi = new f(this);
        this.aIf = (FragmentTabHost) findViewById(com.baidu.tieba.w.tab_host);
        this.aIf.setup(getSupportFragmentManager());
        this.aIf.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.t.maintab_bg));
        this.aIf.setOnPageChangeListener(this);
        Rs();
        if (bundle != null) {
            this.biO = bundle.getInt("CurrTabIndex");
        } else {
            this.biO = 0;
        }
        this.aIf.setCurrentTab(this.biO);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GI = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.abR = com.baidu.tieba.t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize32));
            bVar.GH = fragmentTabIndicator;
            this.aIf.a(bVar);
        }
    }

    private void Rs() {
        if (this.bHi != null) {
            int count = this.bHi.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bHi.getItem(i);
                int go = this.bHi.go(i);
                if (item != null) {
                    if (go == 0) {
                        a(item, 0, String.format(getPageContext().getString(com.baidu.tieba.z.person_post_thread), this.biR));
                    } else if (go == 1) {
                        a(item, 1, String.format(getPageContext().getString(com.baidu.tieba.z.person_post_reply), this.biR));
                    }
                }
            }
            this.aIf.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public String getUid() {
        return this.mUid;
    }

    public String Ru() {
        return this.biR;
    }

    public String aaC() {
        return this.bHh;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.biO);
        super.onSaveInstanceState(bundle);
    }

    public String aaD() {
        if (this.biS) {
            return getPageContext().getString(com.baidu.tieba.z.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(com.baidu.tieba.z.person_post_lv_empty_guest), Ru());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.biO) {
            this.biO = i;
            if (this.biP[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.biS ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.biP[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.biS ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aIf.onChangeSkinType(i);
        ax.i(this.aIf, com.baidu.tieba.t.cp_bg_line_c);
        if (this.bHi != null) {
            int count = this.bHi.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bHi.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bHi != null) {
            t aaE = this.bHi.aaE();
            aa aaJ = aaE != null ? aaE.aaJ() : null;
            if (aaJ != null) {
                return aaJ.getBdListView();
            }
            return null;
        }
        return null;
    }
}
