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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private int[] evP;
    private String evR;
    private ImageView evS;
    protected int evV;
    private BasePersonInfoAdapter fVx;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] evX = {d.f.icon_pop_key_all_bg, d.f.icon_pop_key_f_bg, d.f.icon_pop_key_d_bg};
    private static final int[] fVw = {d.f.icon_pop_key_all_bg_w, d.f.icon_pop_key_f_bg_w, d.f.icon_pop_key_d_bg_w};
    private static final int[] evZ = {d.k.info_privacy_all, d.k.info_privacy_friend, d.k.info_privacy_hide};
    private static final int[] ewa = {1, 2, 3};
    private int bFT = -1;
    private int evQ = 0;
    private boolean mIsHost = false;
    private int fVt = 0;
    protected boolean fVu = false;
    protected String fVv = "";
    HttpMessageListener fVy = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.t(BasePersonInfoActivity.this.bjG(), BasePersonInfoActivity.ewa[BasePersonInfoActivity.this.evQ]);
                    am.a(BasePersonInfoActivity.this.evS, BasePersonInfoActivity.fVw[BasePersonInfoActivity.this.evQ], BasePersonInfoActivity.evX[BasePersonInfoActivity.this.evQ]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.evZ[BasePersonInfoActivity.this.evQ]), d.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(d.k.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String bjA();

    public abstract String bjB();

    public abstract String bjF();

    public abstract int bjG();

    public abstract String bjx();

    public abstract String bjy();

    public abstract String bjz();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.fVt = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bFT = bundle.getInt("key_current_tab", 0);
            this.evV = bundle.getInt("tb_request_code", 0);
            this.fVu = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fVv = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bFT = getIntent().getIntExtra("key_current_tab", 0);
            this.evV = getIntent().getIntExtra("tb_request_code", 0);
            this.fVu = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fVt = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.fVv = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.evR = getPageContext().getString(d.k.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.evR = getPageContext().getString(d.k.he);
                    break;
                case 2:
                    this.evR = getPageContext().getString(d.k.she);
                    break;
                default:
                    this.evR = getPageContext().getString(d.k.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        r(bundle);
        registerListener(this.fVy);
    }

    private void r(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.base_person_navigation_bar);
        if (this.fVu) {
            if (this.evV == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(bjx(), this.evR));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.fVu && BasePersonInfoActivity.this.evV != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.c(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.evV != 23003 && !this.fVu) {
            this.evS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_privacy, (View.OnClickListener) null);
            am.a(this.evS, fVw[com.baidu.tbadk.core.a.e.bA(bjG()) - 1], evX[com.baidu.tbadk.core.a.e.bA(bjG()) - 1]);
            this.evS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.evQ = com.baidu.tbadk.core.a.e.bA(BasePersonInfoActivity.this.bjG()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.bjG()) {
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
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.evQ + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.evP = new int[]{0, 1};
        this.fVx = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(d.g.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(d.C0142d.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.bFT);
    }

    private void initTabSpec() {
        if (this.fVx != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.fVx.getItem(i2);
                int om = this.fVx.om(i2);
                String bjy = bjy();
                if (om == 1) {
                    bjy = bjz();
                }
                if (item != null) {
                    a(item, om, bjy);
                }
            }
            this.mTabHost.cy(3);
        }
    }

    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.aon = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aRz = d.C0142d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.e(getActivity(), d.e.ds88));
            bVar.aom = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void bg(int i, int i2) {
        if (!this.mIsHost && this.fVx != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.cB(0).aom;
            if (i <= 0) {
                fragmentTabIndicator.setText(bjy());
            } else {
                fragmentTabIndicator.setText(String.format(bjA(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.cB(1).aom;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(bjz());
            } else {
                fragmentTabIndicator2.setText(String.format(bjB(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aLL() {
        return this.evR;
    }

    public boolean aLM() {
        return this.mIsHost;
    }

    public boolean bjC() {
        return this.fVu;
    }

    public int aLK() {
        return this.bFT == 0 ? 0 : 1;
    }

    public int bjD() {
        return this.fVt;
    }

    public String bjE() {
        return this.fVv;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.fVu && this.evV != 23011) {
                com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bFT);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.fVt);
        if (this.fVu && this.evV != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bFT) {
            this.bFT = i;
            if (!this.mIsHost && this.evP[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), bjF(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.fVx != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.fVx.getCount()) {
                    Fragment item = this.fVx.getItem(i3);
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
