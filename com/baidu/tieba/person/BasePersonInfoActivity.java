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
    private static final int[] coa = {t.f.icon_pop_key_all_bg, t.f.icon_pop_key_f_bg, t.f.icon_pop_key_d_bg};
    private static final int[] cob = {t.j.info_privacy_all, t.j.info_privacy_friend, t.j.info_privacy_hide};
    private static final int[] coc = {1, 2, 3};
    private FragmentTabHost aXu;
    private int[] cnS;
    private String cnU;
    private ImageView cnW;
    private e dqY;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wY;
    private int cnR = -1;
    private int cnT = 0;
    private boolean bIP = false;
    private int dqV = 0;
    protected boolean dqW = false;
    protected String dqX = "";
    HttpMessageListener dqZ = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract e a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String aAG();

    public abstract String aAI();

    public abstract String aAJ();

    public abstract String aAK();

    public abstract String aAL();

    public abstract String aAP();

    public abstract int aAQ();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.activity_base_person_info);
        if (bundle != null) {
            this.wY = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.dqV = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cnR = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.dqW = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.dqX = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wY = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.cnR = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.dqW = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.dqV = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.dqX = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wY = this.wY == null ? "" : this.wY;
        if (this.wY.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.cnU = getPageContext().getString(t.j.me);
            this.bIP = true;
        } else {
            this.bIP = false;
            switch (this.mSex) {
                case 1:
                    this.cnU = getPageContext().getString(t.j.he);
                    break;
                case 2:
                    this.cnU = getPageContext().getString(t.j.she);
                    break;
                default:
                    this.cnU = getPageContext().getString(t.j.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wY)) {
            finish();
            return;
        }
        h(bundle);
        registerListener(this.dqZ);
    }

    private void h(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.base_person_navigation_bar);
        if (this.dqW) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(t.j.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(t.j.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(aAG(), this.cnU));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        if (this.bIP && this.requestCode != 23003 && !this.dqW) {
            this.cnW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.at.c(this.cnW, coa[com.baidu.tbadk.core.a.h.bB(aAQ()) - 1]);
            this.cnW.setOnClickListener(new d(this));
        }
        this.cnS = new int[]{0, 1};
        this.dqY = a(this, this.bIP);
        this.aXu = (FragmentTabHost) findViewById(t.g.base_person_tab_host);
        this.aXu.setup(getSupportFragmentManager());
        this.aXu.setTabWidgetBackgroundColor(getResources().getColor(t.d.maintab_bg));
        this.aXu.setOnPageChangeListener(this);
        this.aXu.reset();
        ahD();
        if (this.bIP) {
            this.aXu.getTabWrapper().setVisibility(8);
        }
        this.aXu.setCurrentTab(this.cnR);
    }

    private void ahD() {
        if (this.dqY != null) {
            int i = this.bIP ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.dqY.getItem(i2);
                int jY = this.dqY.jY(i2);
                String aAI = aAI();
                if (jY == 1) {
                    aAI = aAJ();
                }
                if (item != null) {
                    a(item, jY, aAI);
                }
            }
            this.aXu.initViewPager();
        }
    }

    public NavigationBar aAH() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.ZK = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.ayK = t.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.e.fontsize32));
            cVar.ZJ = fragmentTabIndicator;
            this.aXu.a(cVar);
        }
    }

    public void av(int i, int i2) {
        if (!this.bIP && this.dqY != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aXu.cD(0).ZJ;
            if (i <= 0) {
                fragmentTabIndicator.setText(aAI());
            } else {
                fragmentTabIndicator.setText(String.format(aAK(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aXu.cD(1).ZJ;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(aAJ());
            } else {
                fragmentTabIndicator2.setText(String.format(aAL(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wY;
    }

    public int getSex() {
        return this.mSex;
    }

    public String ahF() {
        return this.cnU;
    }

    public boolean ahG() {
        return this.bIP;
    }

    public boolean aAM() {
        return this.dqW;
    }

    public int ahE() {
        return this.cnR == 0 ? 0 : 1;
    }

    public int aAN() {
        return this.dqV;
    }

    public String aAO() {
        return this.dqX;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.dqW && this.requestCode != 23011) {
                com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cnR);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.dqV);
        if (this.dqW && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.cnR) {
            this.cnR = i;
            if (!this.bIP && this.cnS[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aAP(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aXu.onChangeSkinType(i);
        if (this.dqY != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.dqY.getCount()) {
                    Fragment item = this.dqY.getItem(i3);
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
