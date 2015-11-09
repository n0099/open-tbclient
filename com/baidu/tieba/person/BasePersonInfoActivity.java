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
    private static final int[] bGh = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bGi = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bGj = {1, 2, 3};
    private int[] bGa;
    private String bGc;
    private ImageView bGd;
    private FragmentTabHost beK;
    private d cpr;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wq;
    private int bFZ = -1;
    private int bGb = 0;
    private boolean mIsHost = false;
    private int cpo = 0;
    protected boolean cpp = false;
    protected String cpq = "";
    HttpMessageListener cps = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String aiA();

    public abstract String aiE();

    public abstract int aiF();

    public abstract String aiw();

    public abstract String aix();

    public abstract String aiy();

    public abstract String aiz();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.activity_base_person_info);
        if (bundle != null) {
            this.wq = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cpo = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bFZ = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cpp = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cpq = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wq = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bFZ = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cpp = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cpo = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cpq = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wq = this.wq == null ? "" : this.wq;
        if (this.wq.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bGc = getPageContext().getString(i.h.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bGc = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bGc = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bGc = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wq)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cps);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.base_person_navigation_bar);
        if (this.cpp) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(i.h.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(i.h.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(aiw(), this.bGc));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.cpp) {
            this.bGd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.an.c(this.bGd, bGh[com.baidu.tbadk.core.a.h.br(aiF()) - 1]);
            this.bGd.setOnClickListener(new c(this));
        }
        this.bGa = new int[]{0, 1};
        this.cpr = a(this, this.mIsHost);
        this.beK = (FragmentTabHost) findViewById(i.f.base_person_tab_host);
        this.beK.setup(getSupportFragmentManager());
        this.beK.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.beK.setOnPageChangeListener(this);
        this.beK.reset();
        WY();
        if (this.mIsHost) {
            this.beK.getTabWrapper().setVisibility(8);
        }
        this.beK.setCurrentTab(this.bFZ);
    }

    private void WY() {
        if (this.cpr != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cpr.getItem(i2);
                int hI = this.cpr.hI(i2);
                String aix = aix();
                if (hI == 1) {
                    aix = aiy();
                }
                if (item != null) {
                    a(item, hI, aix);
                }
            }
            this.beK.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YK = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.atC = i.c.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YJ = fragmentTabIndicator;
            this.beK.a(bVar);
        }
    }

    public void aj(int i, int i2) {
        if (!this.mIsHost && this.cpr != null) {
            FragmentTabIndicator fragmentTabIndicator = this.beK.ce(0).YJ;
            if (i <= 0) {
                fragmentTabIndicator.setText(aix());
            } else {
                fragmentTabIndicator.setText(String.format(aiz(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.beK.ce(1).YJ;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(aiy());
            } else {
                fragmentTabIndicator2.setText(String.format(aiA(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wq;
    }

    public int getSex() {
        return this.mSex;
    }

    public String Xa() {
        return this.bGc;
    }

    public boolean Xb() {
        return this.mIsHost;
    }

    public boolean aiB() {
        return this.cpp;
    }

    public int WZ() {
        return this.bFZ == 0 ? 0 : 1;
    }

    public int aiC() {
        return this.cpo;
    }

    public String aiD() {
        return this.cpq;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cpp && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bFZ);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cpo);
        if (this.cpp && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bFZ) {
            this.bFZ = i;
            if (!this.mIsHost && this.bGa[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aiE(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.beK.onChangeSkinType(i);
        if (this.cpr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cpr.getCount()) {
                    Fragment item = this.cpr.getItem(i3);
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
