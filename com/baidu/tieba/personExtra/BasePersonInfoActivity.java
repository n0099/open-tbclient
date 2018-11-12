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
    private int[] ePX;
    private String ePZ;
    private ImageView eQa;
    protected int eQd;
    private BasePersonInfoAdapter gmb;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] eQf = {e.f.icon_pop_key_all_bg, e.f.icon_pop_key_f_bg, e.f.icon_pop_key_d_bg};
    private static final int[] gma = {e.f.icon_pop_key_all_bg_w, e.f.icon_pop_key_f_bg_w, e.f.icon_pop_key_d_bg_w};
    private static final int[] eQh = {e.j.info_privacy_all, e.j.info_privacy_friend, e.j.info_privacy_hide};
    private static final int[] eQi = {1, 2, 3};
    private int bVN = -1;
    private int ePY = 0;
    private boolean mIsHost = false;
    private int glX = 0;
    protected boolean glY = false;
    protected String glZ = "";
    HttpMessageListener gmc = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.v(BasePersonInfoActivity.this.bnd(), BasePersonInfoActivity.eQi[BasePersonInfoActivity.this.ePY]);
                    al.a(BasePersonInfoActivity.this.eQa, BasePersonInfoActivity.gma[BasePersonInfoActivity.this.ePY], BasePersonInfoActivity.eQf[BasePersonInfoActivity.this.ePY]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.eQh[BasePersonInfoActivity.this.ePY]), e.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(e.j.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String bmU();

    public abstract String bmV();

    public abstract String bmW();

    public abstract String bmX();

    public abstract String bmY();

    public abstract String bnc();

    public abstract int bnd();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.glX = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bVN = bundle.getInt("key_current_tab", 0);
            this.eQd = bundle.getInt("tb_request_code", 0);
            this.glY = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.glZ = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bVN = getIntent().getIntExtra("key_current_tab", 0);
            this.eQd = getIntent().getIntExtra("tb_request_code", 0);
            this.glY = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.glX = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.glZ = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.ePZ = getPageContext().getString(e.j.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.ePZ = getPageContext().getString(e.j.he);
                    break;
                case 2:
                    this.ePZ = getPageContext().getString(e.j.she);
                    break;
                default:
                    this.ePZ = getPageContext().getString(e.j.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        v(bundle);
        registerListener(this.gmc);
    }

    private void v(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.base_person_navigation_bar);
        if (this.glY) {
            if (this.eQd == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(bmU(), this.ePZ));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.glY && BasePersonInfoActivity.this.eQd != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.d(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.eQd != 23003 && !this.glY) {
            this.eQa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_privacy, (View.OnClickListener) null);
            al.a(this.eQa, gma[com.baidu.tbadk.core.a.e.cl(bnd()) - 1], eQf[com.baidu.tbadk.core.a.e.cl(bnd()) - 1]);
            this.eQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.ePY = com.baidu.tbadk.core.a.e.cl(BasePersonInfoActivity.this.bnd()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.bnd()) {
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
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.ePY + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.ePX = new int[]{0, 1};
        this.gmb = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(e.g.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(e.d.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.bVN);
    }

    private void initTabSpec() {
        if (this.gmb != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.gmb.getItem(i2);
                int pV = this.gmb.pV(i2);
                String bmV = bmV();
                if (pV == 1) {
                    bmV = bmW();
                }
                if (item != null) {
                    a(item, pV, bmV);
                }
            }
            this.mTabHost.di(3);
        }
    }

    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.avZ = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.baa = e.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(e.C0200e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.h(getActivity(), e.C0200e.ds88));
            bVar.avY = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void br(int i, int i2) {
        if (!this.mIsHost && this.gmb != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.dl(0).avY;
            if (i <= 0) {
                fragmentTabIndicator.setText(bmV());
            } else {
                fragmentTabIndicator.setText(String.format(bmX(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.dl(1).avY;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(bmW());
            } else {
                fragmentTabIndicator2.setText(String.format(bmY(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aRJ() {
        return this.ePZ;
    }

    public boolean aRK() {
        return this.mIsHost;
    }

    public boolean bmZ() {
        return this.glY;
    }

    public int aRI() {
        return this.bVN == 0 ? 0 : 1;
    }

    public int bna() {
        return this.glX;
    }

    public String bnb() {
        return this.glZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.glY && this.eQd != 23011) {
                com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bVN);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.glX);
        if (this.glY && this.eQd != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bVN) {
            this.bVN = i;
            if (!this.mIsHost && this.ePX[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), bnc(), AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.gmb != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.gmb.getCount()) {
                    Fragment item = this.gmb.getItem(i3);
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
