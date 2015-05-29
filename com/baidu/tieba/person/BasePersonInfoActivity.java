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
    private static final int[] boc = {com.baidu.tieba.p.icon_pop_key_all, com.baidu.tieba.p.icon_pop_key_f, com.baidu.tieba.p.icon_pop_key_d};
    private static final int[] bod = {com.baidu.tieba.t.info_privacy_all, com.baidu.tieba.t.info_privacy_friend, com.baidu.tieba.t.info_privacy_hide};
    private static final int[] boe = {1, 2, 3};
    private FragmentTabHost aRO;
    private d bQQ;
    private int[] bnV;
    private String bnX;
    private ImageView bnY;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    protected int requestCode;
    private int bnU = -1;
    private int bnW = 0;
    private boolean mIsHost = false;
    private int bQN = 0;
    protected boolean bQO = false;
    protected String bQP = "";
    HttpMessageListener bQR = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String adN();

    public abstract String adO();

    public abstract String adP();

    public abstract String adQ();

    public abstract String adR();

    public abstract String adV();

    public abstract int adW();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bQN = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bnU = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bQO = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.bQP = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bnU = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bQO = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.bQN = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bQP = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bnX = getPageContext().getString(com.baidu.tieba.t.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bnX = getPageContext().getString(com.baidu.tieba.t.he);
                    break;
                case 2:
                    this.bnX = getPageContext().getString(com.baidu.tieba.t.she);
                    break;
                default:
                    this.bnX = getPageContext().getString(com.baidu.tieba.t.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.m.isEmpty(this.mUid)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bQR);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.base_person_navigation_bar);
        if (this.bQO) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(com.baidu.tieba.t.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(com.baidu.tieba.t.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(adN(), this.bnX));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.bQO) {
            this.bnY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.ay.c(this.bnY, boc[com.baidu.tbadk.core.a.j.bi(adW()) - 1]);
            this.bnY.setOnClickListener(new c(this));
        }
        this.bnV = new int[]{0, 1};
        this.bQQ = a(this, this.mIsHost);
        this.aRO = (FragmentTabHost) findViewById(com.baidu.tieba.q.base_person_tab_host);
        this.aRO.setup(getSupportFragmentManager());
        this.aRO.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.n.maintab_bg));
        this.aRO.setOnPageChangeListener(this);
        this.aRO.reset();
        Uo();
        if (this.mIsHost) {
            this.aRO.getFragmentTabWidget().setVisibility(8);
        }
        this.aRO.setCurrentTab(this.bnU);
    }

    private void Uo() {
        if (this.bQQ != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bQQ.getItem(i2);
                int gB = this.bQQ.gB(i2);
                String adO = adO();
                if (gB == 1) {
                    adO = adP();
                }
                if (item != null) {
                    a(item, gB, adO);
                }
            }
            this.aRO.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.TC = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.amU = com.baidu.tieba.n.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.fontsize32));
            bVar.TB = fragmentTabIndicator;
            this.aRO.a(bVar);
        }
    }

    public void T(int i, int i2) {
        if (!this.mIsHost && this.bQQ != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aRO.bQ(0).TB;
            if (i <= 0) {
                fragmentTabIndicator.setText(adO());
            } else {
                fragmentTabIndicator.setText(String.format(adQ(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aRO.bQ(1).TB;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(adP());
            } else {
                fragmentTabIndicator2.setText(String.format(adR(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String Uq() {
        return this.bnX;
    }

    public boolean Ur() {
        return this.mIsHost;
    }

    public boolean adS() {
        return this.bQO;
    }

    public int Up() {
        return this.bnU == 0 ? 0 : 1;
    }

    public int adT() {
        return this.bQN;
    }

    public String adU() {
        return this.bQP;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bQO && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bnU);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.bQN);
        if (this.bQO && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bnU) {
            this.bnU = i;
            if (!this.mIsHost && this.bnV[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), adV(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aRO.onChangeSkinType(i);
        if (this.bQQ != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bQQ.getCount()) {
                    Fragment item = this.bQQ.getItem(i3);
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
