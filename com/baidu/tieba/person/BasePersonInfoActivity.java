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
    private static final int[] bFB = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bFC = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bFD = {1, 2, 3};
    private int[] bFu;
    private String bFw;
    private ImageView bFx;
    private FragmentTabHost bdT;
    private d cnK;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wq;
    private int bFt = -1;
    private int bFv = 0;
    private boolean mIsHost = false;
    private int cnH = 0;
    protected boolean cnI = false;
    protected String cnJ = "";
    HttpMessageListener cnL = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String ahU();

    public abstract String ahV();

    public abstract String ahW();

    public abstract String ahX();

    public abstract String ahY();

    public abstract String aic();

    public abstract int aid();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.activity_base_person_info);
        if (bundle != null) {
            this.wq = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cnH = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bFt = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cnI = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cnJ = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wq = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bFt = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cnI = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cnH = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cnJ = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wq = this.wq == null ? "" : this.wq;
        if (this.wq.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bFw = getPageContext().getString(i.h.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bFw = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bFw = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bFw = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wq)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cnL);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.base_person_navigation_bar);
        if (this.cnI) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(i.h.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(i.h.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(ahU(), this.bFw));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.cnI) {
            this.bFx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.am.c(this.bFx, bFB[com.baidu.tbadk.core.a.h.br(aid()) - 1]);
            this.bFx.setOnClickListener(new c(this));
        }
        this.bFu = new int[]{0, 1};
        this.cnK = a(this, this.mIsHost);
        this.bdT = (FragmentTabHost) findViewById(i.f.base_person_tab_host);
        this.bdT.setup(getSupportFragmentManager());
        this.bdT.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bdT.setOnPageChangeListener(this);
        this.bdT.reset();
        WH();
        if (this.mIsHost) {
            this.bdT.getTabWrapper().setVisibility(8);
        }
        this.bdT.setCurrentTab(this.bFt);
    }

    private void WH() {
        if (this.cnK != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cnK.getItem(i2);
                int hv = this.cnK.hv(i2);
                String ahV = ahV();
                if (hv == 1) {
                    ahV = ahW();
                }
                if (item != null) {
                    a(item, hv, ahV);
                }
            }
            this.bdT.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YE = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auN = i.c.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YD = fragmentTabIndicator;
            this.bdT.a(bVar);
        }
    }

    public void ah(int i, int i2) {
        if (!this.mIsHost && this.cnK != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bdT.ce(0).YD;
            if (i <= 0) {
                fragmentTabIndicator.setText(ahV());
            } else {
                fragmentTabIndicator.setText(String.format(ahX(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bdT.ce(1).YD;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(ahW());
            } else {
                fragmentTabIndicator2.setText(String.format(ahY(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wq;
    }

    public int getSex() {
        return this.mSex;
    }

    public String WJ() {
        return this.bFw;
    }

    public boolean WK() {
        return this.mIsHost;
    }

    public boolean ahZ() {
        return this.cnI;
    }

    public int WI() {
        return this.bFt == 0 ? 0 : 1;
    }

    public int aia() {
        return this.cnH;
    }

    public String aib() {
        return this.cnJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cnI && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bFt);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cnH);
        if (this.cnI && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bFt) {
            this.bFt = i;
            if (!this.mIsHost && this.bFu[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aic(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bdT.onChangeSkinType(i);
        if (this.cnK != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cnK.getCount()) {
                    Fragment item = this.cnK.getItem(i3);
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
