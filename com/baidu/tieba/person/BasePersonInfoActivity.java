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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private FragmentTabHost aWJ;
    private int[] cUe;
    private String cUg;
    private ImageView cUi;
    private e ecL;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mV;
    protected int requestCode;
    private static final int[] cUm = {u.f.icon_pop_key_all_bg, u.f.icon_pop_key_f_bg, u.f.icon_pop_key_d_bg};
    private static final int[] ecK = {u.f.icon_pop_key_all_bg_w, u.f.icon_pop_key_f_bg_w, u.f.icon_pop_key_d_bg_w};
    private static final int[] cUo = {u.j.info_privacy_all, u.j.info_privacy_friend, u.j.info_privacy_hide};
    private static final int[] cUp = {1, 2, 3};
    private int cUd = -1;
    private int cUf = 0;
    private boolean cgJ = false;
    private int ecH = 0;
    protected boolean ecI = false;
    protected String ecJ = "";
    HttpMessageListener ecM = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract e a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String aJZ();

    public abstract String aKa();

    public abstract String aKb();

    public abstract String aKc();

    public abstract String aKd();

    public abstract String aKh();

    public abstract int aKi();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.activity_base_person_info);
        if (bundle != null) {
            this.mV = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.ecH = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cUd = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.ecI = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.ecJ = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mV = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.cUd = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.ecI = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.ecH = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.ecJ = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mV = this.mV == null ? "" : this.mV;
        if (this.mV.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.cUg = getPageContext().getString(u.j.me);
            this.cgJ = true;
        } else {
            this.cgJ = false;
            switch (this.mSex) {
                case 1:
                    this.cUg = getPageContext().getString(u.j.he);
                    break;
                case 2:
                    this.cUg = getPageContext().getString(u.j.she);
                    break;
                default:
                    this.cUg = getPageContext().getString(u.j.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.mV)) {
            finish();
            return;
        }
        j(bundle);
        registerListener(this.ecM);
    }

    private void j(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(u.g.base_person_navigation_bar);
        if (this.ecI) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(u.j.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(u.j.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(aJZ(), this.cUg));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        if (this.cgJ && this.requestCode != 23003 && !this.ecI) {
            this.cUi = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.av.a(this.cUi, ecK[com.baidu.tbadk.core.a.h.bo(aKi()) - 1], cUm[com.baidu.tbadk.core.a.h.bo(aKi()) - 1]);
            this.cUi.setOnClickListener(new d(this));
        }
        this.cUe = new int[]{0, 1};
        this.ecL = a(this, this.cgJ);
        this.aWJ = (FragmentTabHost) findViewById(u.g.base_person_tab_host);
        this.aWJ.setup(getSupportFragmentManager());
        this.aWJ.setTabWidgetBackgroundColor(getResources().getColor(u.d.common_color_10002));
        this.aWJ.setOnPageChangeListener(this);
        this.aWJ.reset();
        apZ();
        if (this.cgJ) {
            this.aWJ.getTabWrapper().setVisibility(8);
        }
        this.aWJ.setCurrentTab(this.cUd);
    }

    private void apZ() {
        if (this.ecL != null) {
            int i = this.cgJ ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.ecL.getItem(i2);
                int le = this.ecL.le(i2);
                String aKa = aKa();
                if (le == 1) {
                    aKa = aKb();
                }
                if (item != null) {
                    a(item, le, aKa);
                }
            }
            this.aWJ.ci(3);
        }
    }

    public NavigationBar Wz() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.Vt = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.avB = u.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds80));
            cVar.Vs = fragmentTabIndicator;
            this.aWJ.a(cVar);
        }
    }

    public void aL(int i, int i2) {
        if (!this.cgJ && this.ecL != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aWJ.cm(0).Vs;
            if (i <= 0) {
                fragmentTabIndicator.setText(aKa());
            } else {
                fragmentTabIndicator.setText(String.format(aKc(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aWJ.cm(1).Vs;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(aKb());
            } else {
                fragmentTabIndicator2.setText(String.format(aKd(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mV;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aqb() {
        return this.cUg;
    }

    public boolean aqc() {
        return this.cgJ;
    }

    public boolean aKe() {
        return this.ecI;
    }

    public int aqa() {
        return this.cUd == 0 ? 0 : 1;
    }

    public int aKf() {
        return this.ecH;
    }

    public String aKg() {
        return this.ecJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.ecI && this.requestCode != 23011) {
                com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cUd);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.ecH);
        if (this.ecI && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.cUd) {
            this.cUd = i;
            if (!this.cgJ && this.cUe[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aKh(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aWJ.onChangeSkinType(i);
        if (this.ecL != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.ecL.getCount()) {
                    Fragment item = this.ecL.getItem(i3);
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }
}
