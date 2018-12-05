package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private int[] eWM;
    private String eWO;
    private ImageView eWP;
    protected int eWS;
    private BasePersonInfoAdapter gsR;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] eWU = {e.f.icon_pop_key_all_bg, e.f.icon_pop_key_f_bg, e.f.icon_pop_key_d_bg};
    private static final int[] gsQ = {e.f.icon_pop_key_all_bg_w, e.f.icon_pop_key_f_bg_w, e.f.icon_pop_key_d_bg_w};
    private static final int[] eWW = {e.j.info_privacy_all, e.j.info_privacy_friend, e.j.info_privacy_hide};
    private static final int[] eWX = {1, 2, 3};
    private int bZF = -1;
    private int eWN = 0;
    private boolean mIsHost = false;
    private int gsN = 0;
    protected boolean gsO = false;
    protected String gsP = "";
    HttpMessageListener gsS = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.w(BasePersonInfoActivity.this.boW(), BasePersonInfoActivity.eWX[BasePersonInfoActivity.this.eWN]);
                    al.a(BasePersonInfoActivity.this.eWP, BasePersonInfoActivity.gsQ[BasePersonInfoActivity.this.eWN], BasePersonInfoActivity.eWU[BasePersonInfoActivity.this.eWN]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.eWW[BasePersonInfoActivity.this.eWN]), e.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(e.j.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String boN();

    public abstract String boO();

    public abstract String boP();

    public abstract String boQ();

    public abstract String boR();

    public abstract String boV();

    public abstract int boW();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.gsN = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bZF = bundle.getInt("key_current_tab", 0);
            this.eWS = bundle.getInt("tb_request_code", 0);
            this.gsO = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.gsP = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bZF = getIntent().getIntExtra("key_current_tab", 0);
            this.eWS = getIntent().getIntExtra("tb_request_code", 0);
            this.gsO = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.gsN = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.gsP = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eWO = getPageContext().getString(e.j.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.eWO = getPageContext().getString(e.j.he);
                    break;
                case 2:
                    this.eWO = getPageContext().getString(e.j.she);
                    break;
                default:
                    this.eWO = getPageContext().getString(e.j.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        y(bundle);
        registerListener(this.gsS);
    }

    private void y(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.base_person_navigation_bar);
        if (this.gsO) {
            if (this.eWS == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(boN(), this.eWO));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.gsO && BasePersonInfoActivity.this.eWS != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.d(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.eWS != 23003 && !this.gsO) {
            this.eWP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_privacy, (View.OnClickListener) null);
            al.a(this.eWP, gsQ[com.baidu.tbadk.core.a.e.cz(boW()) - 1], eWU[com.baidu.tbadk.core.a.e.cz(boW()) - 1]);
            this.eWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.eWN = com.baidu.tbadk.core.a.e.cz(BasePersonInfoActivity.this.boW()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.boW()) {
                        case 2:
                            str = "like";
                            break;
                        case 3:
                            str = "group";
                            break;
                        case 4:
                            str = "post";
                            break;
                        case 5:
                            str = "friend";
                            break;
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                    httpMessage.addParam("opt", str);
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.eWN + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.eWM = new int[]{0, 1};
        this.gsR = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(e.g.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(e.d.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.bZF);
    }

    private void initTabSpec() {
        if (this.gsR != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.gsR.getItem(i2);
                int qp = this.gsR.qp(i2);
                String boO = boO();
                if (qp == 1) {
                    boO = boP();
                }
                if (item != null) {
                    a(item, qp, boO);
                }
            }
            this.mTabHost.dw(3);
        }
    }

    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.azz = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bdy = e.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0210e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.h(getActivity(), e.C0210e.ds88));
            bVar.azy = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void bp(int i, int i2) {
        if (!this.mIsHost && this.gsR != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.dz(0).azy;
            if (i <= 0) {
                fragmentTabIndicator.setText(boO());
            } else {
                fragmentTabIndicator.setText(String.format(boQ(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.dz(1).azy;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(boP());
            } else {
                fragmentTabIndicator2.setText(String.format(boR(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aTB() {
        return this.eWO;
    }

    public boolean aTC() {
        return this.mIsHost;
    }

    public boolean boS() {
        return this.gsO;
    }

    public int aTA() {
        return this.bZF == 0 ? 0 : 1;
    }

    public int boT() {
        return this.gsN;
    }

    public String boU() {
        return this.gsP;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.gsO && this.eWS != 23011) {
                com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bZF);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.gsN);
        if (this.gsO && this.eWS != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bZF) {
            this.bZF = i;
            if (!this.mIsHost && this.eWM[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), boV(), AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.gsR != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.gsR.getCount()) {
                    Fragment item = this.gsR.getItem(i3);
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
