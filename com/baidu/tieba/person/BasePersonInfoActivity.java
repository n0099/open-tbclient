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
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bli = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] blj = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] blk = {1, 2, 3};
    private FragmentTabHost aPm;
    private d bOy;
    private int[] bla;
    private String blc;
    private ImageView ble;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int bkZ = -1;
    private int blb = 0;
    private boolean mIsHost = false;
    private int bOw = 0;
    protected boolean bOx = false;
    HttpMessageListener bOz = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String acA();

    public abstract String acB();

    public abstract String acC();

    public abstract String acD();

    public abstract String acG();

    public abstract int acH();

    public abstract String acz();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bOw = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bkZ = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bOx = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bkZ = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bOx = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.bOw = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.blc = getPageContext().getString(com.baidu.tieba.y.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.blc = getPageContext().getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.blc = getPageContext().getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.blc = getPageContext().getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.m.isEmpty(this.mUid)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bOz);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.base_person_navigation_bar);
        if (this.bOx) {
            this.mNavigationBar.setTitleText(com.baidu.tieba.y.share_choose_bar_title);
        } else {
            this.mNavigationBar.setTitleText(String.format(acz(), this.blc));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.bOx) {
            this.ble = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.ba.c(this.ble, bli[com.baidu.tbadk.core.a.j.bl(acH()) - 1]);
            this.ble.setOnClickListener(new c(this));
        }
        this.bla = new int[]{0, 1};
        this.bOy = a(this, this.mIsHost);
        this.aPm = (FragmentTabHost) findViewById(com.baidu.tieba.v.base_person_tab_host);
        this.aPm.setup(getSupportFragmentManager());
        this.aPm.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.aPm.setOnPageChangeListener(this);
        this.aPm.reset();
        SO();
        if (this.mIsHost) {
            this.aPm.getFragmentTabWidget().setVisibility(8);
        }
        this.aPm.setCurrentTab(this.bkZ);
    }

    private void SO() {
        if (this.bOy != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bOy.getItem(i2);
                int gi = this.bOy.gi(i2);
                String acA = acA();
                if (gi == 1) {
                    acA = acB();
                }
                if (item != null) {
                    a(item, gi, acA);
                }
            }
            this.aPm.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.SQ = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.alL = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.SP = fragmentTabIndicator;
            this.aPm.a(bVar);
        }
    }

    public void R(int i, int i2) {
        if (!this.mIsHost && this.bOy != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aPm.bN(0).SP;
            if (i <= 0) {
                fragmentTabIndicator.setText(acA());
            } else {
                fragmentTabIndicator.setText(String.format(acC(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aPm.bN(1).SP;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(acB());
            } else {
                fragmentTabIndicator2.setText(String.format(acD(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String SQ() {
        return this.blc;
    }

    public boolean SR() {
        return this.mIsHost;
    }

    public boolean acE() {
        return this.bOx;
    }

    public int SP() {
        return this.bkZ == 0 ? 0 : 1;
    }

    public int acF() {
        return this.bOw;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bOx) {
                com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkZ);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.bOw);
        if (this.bOx) {
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
        if (i >= 0 && i < 2 && i != this.bkZ) {
            this.bkZ = i;
            if (!this.mIsHost && this.bla[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), acG(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aPm.onChangeSkinType(i);
        if (this.bOy != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bOy.getCount()) {
                    Fragment item = this.bOy.getItem(i3);
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
