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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] cdv = {t.f.icon_pop_key_all_bg, t.f.icon_pop_key_f_bg, t.f.icon_pop_key_d_bg};
    private static final int[] cdw = {t.j.info_privacy_all, t.j.info_privacy_friend, t.j.info_privacy_hide};
    private static final int[] cdx = {1, 2, 3};
    private FragmentTabHost aTI;
    private e cWw;
    private int[] cdn;
    private String cdp;
    private ImageView cdr;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wH;
    private int cdm = -1;
    private int cdo = 0;
    private boolean bDs = false;
    private int cWt = 0;
    protected boolean cWu = false;
    protected String cWv = "";
    HttpMessageListener cWx = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract e a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String ata();

    public abstract String atc();

    public abstract String atd();

    public abstract String ate();

    public abstract String atf();

    public abstract String atj();

    public abstract int atk();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.activity_base_person_info);
        if (bundle != null) {
            this.wH = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cWt = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cdm = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cWu = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cWv = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wH = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.cdm = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cWu = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cWt = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cWv = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wH = this.wH == null ? "" : this.wH;
        if (this.wH.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.cdp = getPageContext().getString(t.j.me);
            this.bDs = true;
        } else {
            this.bDs = false;
            switch (this.mSex) {
                case 1:
                    this.cdp = getPageContext().getString(t.j.he);
                    break;
                case 2:
                    this.cdp = getPageContext().getString(t.j.she);
                    break;
                default:
                    this.cdp = getPageContext().getString(t.j.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wH)) {
            finish();
            return;
        }
        f(bundle);
        registerListener(this.cWx);
    }

    private void f(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.base_person_navigation_bar);
        if (this.cWu) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(t.j.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(t.j.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(ata(), this.cdp));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        if (this.bDs && this.requestCode != 23003 && !this.cWu) {
            this.cdr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.ar.c(this.cdr, cdv[com.baidu.tbadk.core.a.h.bC(atk()) - 1]);
            this.cdr.setOnClickListener(new d(this));
        }
        this.cdn = new int[]{0, 1};
        this.cWw = a(this, this.bDs);
        this.aTI = (FragmentTabHost) findViewById(t.g.base_person_tab_host);
        this.aTI.setup(getSupportFragmentManager());
        this.aTI.setTabWidgetBackgroundColor(getResources().getColor(t.d.maintab_bg));
        this.aTI.setOnPageChangeListener(this);
        this.aTI.reset();
        aek();
        if (this.bDs) {
            this.aTI.getTabWrapper().setVisibility(8);
        }
        this.aTI.setCurrentTab(this.cdm);
    }

    private void aek() {
        if (this.cWw != null) {
            int i = this.bDs ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cWw.getItem(i2);
                int js = this.cWw.js(i2);
                String atc = atc();
                if (js == 1) {
                    atc = atd();
                }
                if (item != null) {
                    a(item, js, atc);
                }
            }
            this.aTI.initViewPager();
        }
    }

    public NavigationBar atb() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aay = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.ayd = t.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.fontsize32));
            cVar.aax = fragmentTabIndicator;
            this.aTI.a(cVar);
        }
    }

    public void ay(int i, int i2) {
        if (!this.bDs && this.cWw != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aTI.cA(0).aax;
            if (i <= 0) {
                fragmentTabIndicator.setText(atc());
            } else {
                fragmentTabIndicator.setText(String.format(ate(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aTI.cA(1).aax;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(atd());
            } else {
                fragmentTabIndicator2.setText(String.format(atf(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wH;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aem() {
        return this.cdp;
    }

    public boolean aen() {
        return this.bDs;
    }

    public boolean atg() {
        return this.cWu;
    }

    public int ael() {
        return this.cdm == 0 ? 0 : 1;
    }

    public int ath() {
        return this.cWt;
    }

    public String ati() {
        return this.cWv;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cWu && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cdm);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cWt);
        if (this.cWu && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.cdm) {
            this.cdm = i;
            if (!this.bDs && this.cdn[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), atj(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aTI.onChangeSkinType(i);
        if (this.cWw != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cWw.getCount()) {
                    Fragment item = this.cWw.getItem(i3);
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
