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
    private static final int[] bku;
    private static final int[] bkv;
    private static final int[] bkw;
    private FragmentTabHost aJp;
    private String bIT;
    private e bIU;
    private int[] bkm;
    private String bko;
    private ImageView bkq;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bkl = -1;
    int bkn = 0;
    private boolean bkp = false;
    HttpMessageListener bIV = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        ab.init();
        bku = new int[]{com.baidu.tieba.v.icon_pop_key_all, com.baidu.tieba.v.icon_pop_key_f, com.baidu.tieba.v.icon_pop_key_d};
        bkv = new int[]{com.baidu.tieba.z.info_privacy_all, com.baidu.tieba.z.info_privacy_friend, com.baidu.tieba.z.info_privacy_hide};
        bkw = new int[]{1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.ff()) {
            showToast(com.baidu.tieba.z.neterror);
        }
        setContentView(com.baidu.tieba.x.person_post_activity);
        this.bIT = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bko = getPageContext().getString(com.baidu.tieba.z.me);
            this.bkp = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bko = getPageContext().getString(com.baidu.tieba.z.he);
                    break;
                case 2:
                    this.bko = getPageContext().getString(com.baidu.tieba.z.she);
                    break;
                default:
                    this.bko = getPageContext().getString(com.baidu.tieba.z.ta);
                    break;
            }
        }
        if (this.mUid == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bIV);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bIU != null) {
            int count = this.bIU.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bIU.getItem(i3);
                if (item instanceof s) {
                    ((s) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(com.baidu.tieba.z.person_post), this.bko));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        if (this.bkp) {
            this.bkq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_privacy, (View.OnClickListener) null);
            bc.c(this.bkq, bku[com.baidu.tbadk.core.account.o.bm(4) - 1]);
            this.bkq.setOnClickListener(new d(this));
        }
        this.bkm = new int[]{0, 1};
        this.bIU = new e(this);
        this.aJp = (FragmentTabHost) findViewById(com.baidu.tieba.w.tab_host);
        this.aJp.setup(getSupportFragmentManager());
        this.aJp.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.t.maintab_bg));
        this.aJp.setOnPageChangeListener(this);
        RO();
        if (bundle != null) {
            this.bkl = bundle.getInt("CurrTabIndex");
        } else {
            this.bkl = 0;
        }
        this.aJp.setCurrentTab(this.bkl);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GS = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.aco = com.baidu.tieba.t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize32));
            bVar.GR = fragmentTabIndicator;
            this.aJp.a(bVar);
        }
    }

    private void RO() {
        if (this.bIU != null) {
            int count = this.bIU.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bIU.getItem(i);
                int gx = this.bIU.gx(i);
                if (item != null) {
                    if (gx == 0) {
                        a(item, 0, String.format(getPageContext().getString(com.baidu.tieba.z.person_post_thread), this.bko));
                    } else if (gx == 1) {
                        a(item, 1, String.format(getPageContext().getString(com.baidu.tieba.z.person_post_reply), this.bko));
                    }
                }
            }
            this.aJp.initViewPager();
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

    public String RQ() {
        return this.bko;
    }

    public String abh() {
        return this.bIT;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkl);
        super.onSaveInstanceState(bundle);
    }

    public String abi() {
        if (this.bkp) {
            return getPageContext().getString(com.baidu.tieba.z.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(com.baidu.tieba.z.person_post_lv_empty_guest), RQ());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bkl) {
            this.bkl = i;
            if (this.bkm[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.bkp ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bkm[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.bkp ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aJp.onChangeSkinType(i);
        bc.i(this.aJp, com.baidu.tieba.t.cp_bg_line_c);
        if (this.bIU != null) {
            int count = this.bIU.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bIU.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bIU != null) {
            s abj = this.bIU.abj();
            z abo = abj != null ? abj.abo() : null;
            if (abo != null) {
                return abo.getBdListView();
            }
            return null;
        }
        return null;
    }
}
