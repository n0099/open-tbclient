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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bCx = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bCy = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bCz = {1, 2, 3};
    private int[] bCq;
    private String bCs;
    private ImageView bCt;
    private FragmentTabHost bdG;
    private d cio;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wp;
    private int bCp = -1;
    private int bCr = 0;
    private boolean mIsHost = false;
    private int cil = 0;
    protected boolean cim = false;
    protected String cin = "";
    HttpMessageListener cip = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String afV();

    public abstract String afW();

    public abstract String afX();

    public abstract String afY();

    public abstract String afZ();

    public abstract String agd();

    public abstract int age();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.activity_base_person_info);
        if (bundle != null) {
            this.wp = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cil = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bCp = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cim = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cin = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wp = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bCp = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cim = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cil = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cin = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wp = this.wp == null ? "" : this.wp;
        if (this.wp.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bCs = getPageContext().getString(i.h.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bCs = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bCs = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bCs = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wp)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cip);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.base_person_navigation_bar);
        if (this.cim) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(i.h.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(i.h.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(afV(), this.bCs));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.cim) {
            this.bCt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.al.c(this.bCt, bCx[com.baidu.tbadk.core.a.h.br(age()) - 1]);
            this.bCt.setOnClickListener(new c(this));
        }
        this.bCq = new int[]{0, 1};
        this.cio = a(this, this.mIsHost);
        this.bdG = (FragmentTabHost) findViewById(i.f.base_person_tab_host);
        this.bdG.setup(getSupportFragmentManager());
        this.bdG.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bdG.setOnPageChangeListener(this);
        this.bdG.reset();
        VY();
        if (this.mIsHost) {
            this.bdG.getTabWrapper().setVisibility(8);
        }
        this.bdG.setCurrentTab(this.bCp);
    }

    private void VY() {
        if (this.cio != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cio.getItem(i2);
                int hp = this.cio.hp(i2);
                String afW = afW();
                if (hp == 1) {
                    afW = afX();
                }
                if (item != null) {
                    a(item, hp, afW);
                }
            }
            this.bdG.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YM = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.awo = i.c.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YL = fragmentTabIndicator;
            this.bdG.a(bVar);
        }
    }

    public void ag(int i, int i2) {
        if (!this.mIsHost && this.cio != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bdG.cc(0).YL;
            if (i <= 0) {
                fragmentTabIndicator.setText(afW());
            } else {
                fragmentTabIndicator.setText(String.format(afY(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bdG.cc(1).YL;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(afX());
            } else {
                fragmentTabIndicator2.setText(String.format(afZ(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wp;
    }

    public int getSex() {
        return this.mSex;
    }

    public String Wa() {
        return this.bCs;
    }

    public boolean Wb() {
        return this.mIsHost;
    }

    public boolean aga() {
        return this.cim;
    }

    public int VZ() {
        return this.bCp == 0 ? 0 : 1;
    }

    public int agb() {
        return this.cil;
    }

    public String agc() {
        return this.cin;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cim && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bCp);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cil);
        if (this.cim && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bCp) {
            this.bCp = i;
            if (!this.mIsHost && this.bCq[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), agd(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bdG.onChangeSkinType(i);
        if (this.cio != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cio.getCount()) {
                    Fragment item = this.cio.getItem(i3);
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
