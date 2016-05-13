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
    private static final int[] coX = {t.f.icon_pop_key_all_bg, t.f.icon_pop_key_f_bg, t.f.icon_pop_key_d_bg};
    private static final int[] coY = {t.j.info_privacy_all, t.j.info_privacy_friend, t.j.info_privacy_hide};
    private static final int[] coZ = {1, 2, 3};
    private FragmentTabHost aTo;
    private int[] coP;
    private String coR;
    private ImageView coT;
    private e dut;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mV;
    protected int requestCode;
    private int coO = -1;
    private int coQ = 0;
    private boolean bIW = false;
    private int duq = 0;
    protected boolean dur = false;
    protected String dus = "";
    HttpMessageListener duu = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract e a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String aBh();

    public abstract String aBi();

    public abstract String aBj();

    public abstract String aBk();

    public abstract String aBl();

    public abstract String aBp();

    public abstract int aBq();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.activity_base_person_info);
        if (bundle != null) {
            this.mV = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.duq = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.coO = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.dur = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.dus = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mV = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.coO = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.dur = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.duq = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.dus = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mV = this.mV == null ? "" : this.mV;
        if (this.mV.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.coR = getPageContext().getString(t.j.me);
            this.bIW = true;
        } else {
            this.bIW = false;
            switch (this.mSex) {
                case 1:
                    this.coR = getPageContext().getString(t.j.he);
                    break;
                case 2:
                    this.coR = getPageContext().getString(t.j.she);
                    break;
                default:
                    this.coR = getPageContext().getString(t.j.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.mV)) {
            finish();
            return;
        }
        i(bundle);
        registerListener(this.duu);
    }

    private void i(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.base_person_navigation_bar);
        if (this.dur) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(t.j.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(t.j.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(aBh(), this.coR));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        if (this.bIW && this.requestCode != 23003 && !this.dur) {
            this.coT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.at.c(this.coT, coX[com.baidu.tbadk.core.a.h.bn(aBq()) - 1]);
            this.coT.setOnClickListener(new d(this));
        }
        this.coP = new int[]{0, 1};
        this.dut = a(this, this.bIW);
        this.aTo = (FragmentTabHost) findViewById(t.g.base_person_tab_host);
        this.aTo.setup(getSupportFragmentManager());
        this.aTo.setTabWidgetBackgroundColor(getResources().getColor(t.d.maintab_bg));
        this.aTo.setOnPageChangeListener(this);
        this.aTo.reset();
        ahM();
        if (this.bIW) {
            this.aTo.getTabWrapper().setVisibility(8);
        }
        this.aTo.setCurrentTab(this.coO);
    }

    private void ahM() {
        if (this.dut != null) {
            int i = this.bIW ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.dut.getItem(i2);
                int jC = this.dut.jC(i2);
                String aBi = aBi();
                if (jC == 1) {
                    aBi = aBj();
                }
                if (item != null) {
                    a(item, jC, aBi);
                }
            }
            this.aTo.ch(3);
        }
    }

    public NavigationBar Rf() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.Vd = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auL = t.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds80));
            cVar.Vc = fragmentTabIndicator;
            this.aTo.a(cVar);
        }
    }

    public void au(int i, int i2) {
        if (!this.bIW && this.dut != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aTo.cl(0).Vc;
            if (i <= 0) {
                fragmentTabIndicator.setText(aBi());
            } else {
                fragmentTabIndicator.setText(String.format(aBk(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aTo.cl(1).Vc;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(aBj());
            } else {
                fragmentTabIndicator2.setText(String.format(aBl(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mV;
    }

    public int getSex() {
        return this.mSex;
    }

    public String ahO() {
        return this.coR;
    }

    public boolean ahP() {
        return this.bIW;
    }

    public boolean aBm() {
        return this.dur;
    }

    public int ahN() {
        return this.coO == 0 ? 0 : 1;
    }

    public int aBn() {
        return this.duq;
    }

    public String aBo() {
        return this.dus;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.dur && this.requestCode != 23011) {
                com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.coO);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.duq);
        if (this.dur && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.coO) {
            this.coO = i;
            if (!this.bIW && this.coP[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aBp(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aTo.onChangeSkinType(i);
        if (this.dut != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.dut.getCount()) {
                    Fragment item = this.dut.getItem(i3);
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
