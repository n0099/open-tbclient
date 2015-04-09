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
    private FragmentTabHost aPD;
    private d bOO;
    private int[] blq;
    private String bls;
    private ImageView blu;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private static final int[] bly = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] blz = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] blA = {1, 2, 3};
    private int blp = -1;
    private int blr = 0;
    private boolean mIsHost = false;
    private int bOM = 0;
    protected boolean bON = false;
    HttpMessageListener bOP = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String acO();

    public abstract String acP();

    public abstract String acQ();

    public abstract String acR();

    public abstract String acS();

    public abstract String acV();

    public abstract int acW();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bOM = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.blp = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bON = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.blp = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bON = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.bOM = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bls = getPageContext().getString(com.baidu.tieba.y.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bls = getPageContext().getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.bls = getPageContext().getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.bls = getPageContext().getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.m.isEmpty(this.mUid)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bOP);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.base_person_navigation_bar);
        if (this.bON) {
            this.mNavigationBar.setTitleText(com.baidu.tieba.y.share_choose_bar_title);
        } else {
            this.mNavigationBar.setTitleText(String.format(acO(), this.bls));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.bON) {
            this.blu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.ba.c(this.blu, bly[com.baidu.tbadk.core.a.j.bl(acW()) - 1]);
            this.blu.setOnClickListener(new c(this));
        }
        this.blq = new int[]{0, 1};
        this.bOO = a(this, this.mIsHost);
        this.aPD = (FragmentTabHost) findViewById(com.baidu.tieba.v.base_person_tab_host);
        this.aPD.setup(getSupportFragmentManager());
        this.aPD.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.aPD.setOnPageChangeListener(this);
        this.aPD.reset();
        Tb();
        if (this.mIsHost) {
            this.aPD.getFragmentTabWidget().setVisibility(8);
        }
        this.aPD.setCurrentTab(this.blp);
    }

    private void Tb() {
        if (this.bOO != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bOO.getItem(i2);
                int gk = this.bOO.gk(i2);
                String acP = acP();
                if (gk == 1) {
                    acP = acQ();
                }
                if (item != null) {
                    a(item, gk, acP);
                }
            }
            this.aPD.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.SS = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.alT = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.SR = fragmentTabIndicator;
            this.aPD.a(bVar);
        }
    }

    public void R(int i, int i2) {
        if (!this.mIsHost && this.bOO != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aPD.bN(0).SR;
            if (i <= 0) {
                fragmentTabIndicator.setText(acP());
            } else {
                fragmentTabIndicator.setText(String.format(acR(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aPD.bN(1).SR;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(acQ());
            } else {
                fragmentTabIndicator2.setText(String.format(acS(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String Td() {
        return this.bls;
    }

    public boolean Te() {
        return this.mIsHost;
    }

    public boolean acT() {
        return this.bON;
    }

    public int Tc() {
        return this.blp == 0 ? 0 : 1;
    }

    public int acU() {
        return this.bOM;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bON) {
                com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.blp);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.bOM);
        if (this.bON) {
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
        if (i >= 0 && i < 2 && i != this.blp) {
            this.blp = i;
            if (!this.mIsHost && this.blq[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), acV(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aPD.onChangeSkinType(i);
        if (this.bOO != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bOO.getCount()) {
                    Fragment item = this.bOO.getItem(i3);
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
