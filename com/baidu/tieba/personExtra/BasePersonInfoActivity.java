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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private FragmentTabHost bgN;
    private int[] efE;
    private String efG;
    private ImageView efH;
    protected int efK;
    private BasePersonInfoAdapter fEZ;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private static final int[] efM = {d.f.icon_pop_key_all_bg, d.f.icon_pop_key_f_bg, d.f.icon_pop_key_d_bg};
    private static final int[] fEY = {d.f.icon_pop_key_all_bg_w, d.f.icon_pop_key_f_bg_w, d.f.icon_pop_key_d_bg_w};
    private static final int[] efO = {d.k.info_privacy_all, d.k.info_privacy_friend, d.k.info_privacy_hide};
    private static final int[] efP = {1, 2, 3};
    private int bvj = -1;
    private int efF = 0;
    private boolean mIsHost = false;
    private int fEV = 0;
    protected boolean fEW = false;
    protected String fEX = "";
    HttpMessageListener fFa = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.f.s(BasePersonInfoActivity.this.bea(), BasePersonInfoActivity.efP[BasePersonInfoActivity.this.efF]);
                    ak.a(BasePersonInfoActivity.this.efH, BasePersonInfoActivity.fEY[BasePersonInfoActivity.this.efF], BasePersonInfoActivity.efM[BasePersonInfoActivity.this.efF]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.efO[BasePersonInfoActivity.this.efF]), d.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(d.k.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String bdR();

    public abstract String bdS();

    public abstract String bdT();

    public abstract String bdU();

    public abstract String bdV();

    public abstract String bdZ();

    public abstract int bea();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.fEV = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bvj = bundle.getInt("key_current_tab", 0);
            this.efK = bundle.getInt("tb_request_code", 0);
            this.fEW = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fEX = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bvj = getIntent().getIntExtra("key_current_tab", 0);
            this.efK = getIntent().getIntExtra("tb_request_code", 0);
            this.fEW = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fEV = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.fEX = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.efG = getPageContext().getString(d.k.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.efG = getPageContext().getString(d.k.he);
                    break;
                case 2:
                    this.efG = getPageContext().getString(d.k.she);
                    break;
                default:
                    this.efG = getPageContext().getString(d.k.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        q(bundle);
        registerListener(this.fFa);
    }

    private void q(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.base_person_navigation_bar);
        if (this.fEW) {
            if (this.efK == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(bdR(), this.efG));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BasePersonInfoActivity.this.fEW && BasePersonInfoActivity.this.efK != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.c(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.efK != 23003 && !this.fEW) {
            this.efH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_privacy, (View.OnClickListener) null);
            ak.a(this.efH, fEY[com.baidu.tbadk.core.a.f.bz(bea()) - 1], efM[com.baidu.tbadk.core.a.f.bz(bea()) - 1]);
            this.efH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BasePersonInfoActivity.this.efF = com.baidu.tbadk.core.a.f.bz(BasePersonInfoActivity.this.bea()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.bea()) {
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
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.efF + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.efE = new int[]{0, 1};
        this.fEZ = a(this, this.mIsHost);
        this.bgN = (FragmentTabHost) findViewById(d.g.base_person_tab_host);
        this.bgN.setup(getSupportFragmentManager());
        this.bgN.setTabWidgetBackgroundColor(getResources().getColor(d.C0126d.common_color_10002));
        this.bgN.setOnPageChangeListener(this);
        this.bgN.reset();
        Or();
        if (this.mIsHost) {
            this.bgN.getTabWrapper().setVisibility(8);
        }
        this.bgN.setCurrentTab(this.bvj);
    }

    private void Or() {
        if (this.fEZ != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.fEZ.getItem(i2);
                int nU = this.fEZ.nU(i2);
                String bdS = bdS();
                if (nU == 1) {
                    bdS = bdT();
                }
                if (item != null) {
                    a(item, nU, bdS);
                }
            }
            this.bgN.cu(3);
        }
    }

    public NavigationBar Rg() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.afJ = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aIf = d.C0126d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.e(getActivity(), d.e.ds88));
            bVar.afI = fragmentTabIndicator;
            this.bgN.a(bVar);
        }
    }

    public void bg(int i, int i2) {
        if (!this.mIsHost && this.fEZ != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.bgN.cx(0).afI;
            if (i <= 0) {
                fragmentTabIndicator.setText(bdS());
            } else {
                fragmentTabIndicator.setText(String.format(bdU(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.bgN.cx(1).afI;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(bdT());
            } else {
                fragmentTabIndicator2.setText(String.format(bdV(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aGm() {
        return this.efG;
    }

    public boolean aGn() {
        return this.mIsHost;
    }

    public boolean bdW() {
        return this.fEW;
    }

    public int aGl() {
        return this.bvj == 0 ? 0 : 1;
    }

    public int bdX() {
        return this.fEV;
    }

    public String bdY() {
        return this.fEX;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.fEW && this.efK != 23011) {
                com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bvj);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.fEV);
        if (this.fEW && this.efK != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bvj) {
            this.bvj = i;
            if (!this.mIsHost && this.efE[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), bdZ(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bgN.onChangeSkinType(i);
        if (this.fEZ != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.fEZ.getCount()) {
                    Fragment item = this.fEZ.getItem(i3);
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
