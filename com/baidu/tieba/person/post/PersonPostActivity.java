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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bkt;
    private static final int[] bku;
    private static final int[] bkv;
    private FragmentTabHost aJm;
    private String bIS;
    private e bIT;
    private int[] bkl;
    private String bkn;
    private ImageView bkp;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bkk = -1;
    int bkm = 0;
    private boolean bko = false;
    HttpMessageListener bIU = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        ab.init();
        bkt = new int[]{com.baidu.tieba.v.icon_pop_key_all, com.baidu.tieba.v.icon_pop_key_f, com.baidu.tieba.v.icon_pop_key_d};
        bku = new int[]{com.baidu.tieba.z.info_privacy_all, com.baidu.tieba.z.info_privacy_friend, com.baidu.tieba.z.info_privacy_hide};
        bkv = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.ff()) {
            showToast(com.baidu.tieba.z.neterror);
        }
        setContentView(com.baidu.tieba.x.person_post_activity);
        this.bIS = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bkn = getPageContext().getString(com.baidu.tieba.z.me);
            this.bko = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bkn = getPageContext().getString(com.baidu.tieba.z.he);
                    break;
                case 2:
                    this.bkn = getPageContext().getString(com.baidu.tieba.z.she);
                    break;
                default:
                    this.bkn = getPageContext().getString(com.baidu.tieba.z.ta);
                    break;
            }
        }
        if (this.mUid == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bIU);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bIT != null) {
            int count = this.bIT.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bIT.getItem(i3);
                if (item instanceof s) {
                    ((s) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(com.baidu.tieba.z.person_post), this.bkn));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        if (this.bko) {
            this.bkp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_privacy, (View.OnClickListener) null);
            bc.c(this.bkp, bkt[com.baidu.tbadk.core.account.o.bm(4) - 1]);
            this.bkp.setOnClickListener(new d(this));
        }
        this.bkl = new int[]{0, 1};
        this.bIT = new e(this);
        this.aJm = (FragmentTabHost) findViewById(com.baidu.tieba.w.tab_host);
        this.aJm.setup(getSupportFragmentManager());
        this.aJm.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.t.maintab_bg));
        this.aJm.setOnPageChangeListener(this);
        RJ();
        if (bundle != null) {
            this.bkk = bundle.getInt("CurrTabIndex");
        } else {
            this.bkk = 0;
        }
        this.aJm.setCurrentTab(this.bkk);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GP = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.acl = com.baidu.tieba.t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize32));
            bVar.GN = fragmentTabIndicator;
            this.aJm.a(bVar);
        }
    }

    private void RJ() {
        if (this.bIT != null) {
            int count = this.bIT.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bIT.getItem(i);
                int gx = this.bIT.gx(i);
                if (item != null) {
                    if (gx == 0) {
                        a(item, 0, String.format(getPageContext().getString(com.baidu.tieba.z.person_post_thread), this.bkn));
                    } else if (gx == 1) {
                        a(item, 1, String.format(getPageContext().getString(com.baidu.tieba.z.person_post_reply), this.bkn));
                    }
                }
            }
            this.aJm.initViewPager();
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

    public String RL() {
        return this.bkn;
    }

    public String abc() {
        return this.bIS;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkk);
        super.onSaveInstanceState(bundle);
    }

    public String abd() {
        if (this.bko) {
            return getPageContext().getString(com.baidu.tieba.z.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(com.baidu.tieba.z.person_post_lv_empty_guest), RL());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bkk) {
            this.bkk = i;
            if (this.bkl[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.bko ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bkl[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.bko ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aJm.onChangeSkinType(i);
        bc.i(this.aJm, com.baidu.tieba.t.cp_bg_line_c);
        if (this.bIT != null) {
            int count = this.bIT.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bIT.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bIT != null) {
            s abe = this.bIT.abe();
            z abj = abe != null ? abe.abj() : null;
            if (abj != null) {
                return abj.getBdListView();
            }
            return null;
        }
        return null;
    }
}
