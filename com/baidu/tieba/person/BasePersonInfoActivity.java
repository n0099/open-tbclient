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
    private static final int[] bFM = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bFN = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bFO = {1, 2, 3};
    private int[] bFF;
    private String bFH;
    private ImageView bFI;
    private FragmentTabHost bee;
    private d cnV;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wq;
    private int bFE = -1;
    private int bFG = 0;
    private boolean mIsHost = false;
    private int cnS = 0;
    protected boolean cnT = false;
    protected String cnU = "";
    HttpMessageListener cnW = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String ahQ();

    public abstract String ahR();

    public abstract String ahS();

    public abstract String ahT();

    public abstract String ahU();

    public abstract String ahY();

    public abstract int ahZ();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.activity_base_person_info);
        if (bundle != null) {
            this.wq = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cnS = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bFE = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cnT = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cnU = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wq = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bFE = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cnT = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cnS = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cnU = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wq = this.wq == null ? "" : this.wq;
        if (this.wq.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bFH = getPageContext().getString(i.h.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bFH = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bFH = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bFH = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wq)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cnW);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.base_person_navigation_bar);
        if (this.cnT) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(i.h.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(i.h.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(ahQ(), this.bFH));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.cnT) {
            this.bFI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.an.c(this.bFI, bFM[com.baidu.tbadk.core.a.h.br(ahZ()) - 1]);
            this.bFI.setOnClickListener(new c(this));
        }
        this.bFF = new int[]{0, 1};
        this.cnV = a(this, this.mIsHost);
        this.bee = (FragmentTabHost) findViewById(i.f.base_person_tab_host);
        this.bee.setup(getSupportFragmentManager());
        this.bee.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bee.setOnPageChangeListener(this);
        this.bee.reset();
        WD();
        if (this.mIsHost) {
            this.bee.getTabWrapper().setVisibility(8);
        }
        this.bee.setCurrentTab(this.bFE);
    }

    private void WD() {
        if (this.cnV != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cnV.getItem(i2);
                int hv = this.cnV.hv(i2);
                String ahR = ahR();
                if (hv == 1) {
                    ahR = ahS();
                }
                if (item != null) {
                    a(item, hv, ahR);
                }
            }
            this.bee.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YG = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auO = i.c.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YF = fragmentTabIndicator;
            this.bee.a(bVar);
        }
    }

    public void ah(int i, int i2) {
        if (!this.mIsHost && this.cnV != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bee.ce(0).YF;
            if (i <= 0) {
                fragmentTabIndicator.setText(ahR());
            } else {
                fragmentTabIndicator.setText(String.format(ahT(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bee.ce(1).YF;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(ahS());
            } else {
                fragmentTabIndicator2.setText(String.format(ahU(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wq;
    }

    public int getSex() {
        return this.mSex;
    }

    public String WF() {
        return this.bFH;
    }

    public boolean WG() {
        return this.mIsHost;
    }

    public boolean ahV() {
        return this.cnT;
    }

    public int WE() {
        return this.bFE == 0 ? 0 : 1;
    }

    public int ahW() {
        return this.cnS;
    }

    public String ahX() {
        return this.cnU;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cnT && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bFE);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cnS);
        if (this.cnT && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bFE) {
            this.bFE = i;
            if (!this.mIsHost && this.bFF[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), ahY(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bee.onChangeSkinType(i);
        if (this.cnV != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cnV.getCount()) {
                    Fragment item = this.cnV.getItem(i3);
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
