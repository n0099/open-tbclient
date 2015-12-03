package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bVo = {n.e.icon_pop_key_all_bg, n.e.icon_pop_key_f_bg, n.e.icon_pop_key_d_bg};
    private static final int[] bVp = {n.i.info_privacy_all, n.i.info_privacy_friend, n.i.info_privacy_hide};
    private static final int[] bVq = {1, 2, 3};
    private int[] bVh;
    private String bVj;
    private ImageView bVk;
    private FragmentTabHost blo;
    private e cIM;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String ww;
    private int bVg = -1;
    private int bVi = 0;
    private boolean mIsHost = false;
    private int cIJ = 0;
    protected boolean cIK = false;
    protected String cIL = "";
    HttpMessageListener cIN = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract e a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String amZ();

    public abstract String ana();

    public abstract String anb();

    public abstract String anc();

    public abstract String and();

    public abstract String anh();

    public abstract int ani();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.activity_base_person_info);
        if (bundle != null) {
            this.ww = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cIJ = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bVg = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cIK = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cIL = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.ww = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bVg = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cIK = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cIJ = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cIL = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.ww = this.ww == null ? "" : this.ww;
        if (this.ww.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bVj = getPageContext().getString(n.i.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
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
        if (com.baidu.adp.lib.util.j.isEmpty(this.ww)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cIN);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.base_person_navigation_bar);
        if (this.cIK) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(n.i.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(n.i.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(amZ(), this.bVj));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.cIK) {
            this.bVk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.as.c(this.bVk, bVo[com.baidu.tbadk.core.a.h.bu(ani()) - 1]);
            this.bVk.setOnClickListener(new d(this));
        }
        this.bVh = new int[]{0, 1};
        this.cIM = a(this, this.mIsHost);
        this.blo = (FragmentTabHost) findViewById(n.f.base_person_tab_host);
        this.blo.setup(getSupportFragmentManager());
        this.blo.setTabWidgetBackgroundColor(getResources().getColor(n.c.maintab_bg));
        this.blo.setOnPageChangeListener(this);
        this.blo.reset();
        aae();
        if (this.mIsHost) {
            this.blo.getTabWrapper().setVisibility(8);
        }
        this.blo.setCurrentTab(this.bVg);
    }

    private void aae() {
        if (this.cIM != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cIM.getItem(i2);
                int iw = this.cIM.iw(i2);
                String ana = ana();
                if (iw == 1) {
                    ana = anb();
                }
                if (item != null) {
                    a(item, iw, ana);
                }
            }
            this.blo.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
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

    public void al(int i, int i2) {
        if (!this.mIsHost && this.cIM != null) {
            FragmentTabIndicator fragmentTabIndicator = this.blo.cm(0).Zv;
            if (i <= 0) {
                fragmentTabIndicator.setText(ana());
            } else {
                fragmentTabIndicator.setText(String.format(anc(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.blo.cm(1).Zv;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(anb());
            } else {
                fragmentTabIndicator2.setText(String.format(and(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.ww;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aag() {
        return this.bVj;
    }

    public boolean aah() {
        return this.mIsHost;
    }

    public boolean ane() {
        return this.cIK;
    }

    public int aaf() {
        return this.bVg == 0 ? 0 : 1;
    }

    public int anf() {
        return this.cIJ;
    }

    public String ang() {
        return this.cIL;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cIK && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bVg);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cIJ);
        if (this.cIK && this.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            finish();
        }
        super.onSaveInstanceState(bundle);
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
            if (!this.mIsHost && this.bVh[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), anh(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blo.onChangeSkinType(i);
        if (this.cIM != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cIM.getCount()) {
                    Fragment item = this.cIM.getItem(i3);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).onChangeSkinType(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
