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
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private int[] jhK;
    private String jhM;
    private ImageView jhN;
    protected int jhS;
    private BasePersonInfoAdapter kQX;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] jhU = {R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
    private static final int[] kQW = {R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
    private static final int[] jhW = {R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
    private static final int[] jhX = {1, 2, 3};
    private int fMT = -1;
    private int jhL = 0;
    private boolean mIsHost = false;
    private int kQT = 0;
    protected boolean kQU = false;
    protected String kQV = "";
    HttpMessageListener kQY = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.aF(BasePersonInfoActivity.this.cWe(), BasePersonInfoActivity.jhX[BasePersonInfoActivity.this.jhL]);
                    ao.setNavbarIconSrc(BasePersonInfoActivity.this.jhN, BasePersonInfoActivity.kQW[BasePersonInfoActivity.this.jhL], BasePersonInfoActivity.jhU[BasePersonInfoActivity.this.jhL]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.jhW[BasePersonInfoActivity.this.jhL]), R.drawable.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(R.string.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String cVV();

    public abstract String cVW();

    public abstract String cVX();

    public abstract String cVY();

    public abstract String cVZ();

    public abstract String cWd();

    public abstract int cWe();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.kQT = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.fMT = bundle.getInt("key_current_tab", 0);
            this.jhS = bundle.getInt("tb_request_code", 0);
            this.kQU = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.kQV = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.fMT = getIntent().getIntExtra("key_current_tab", 0);
            this.jhS = getIntent().getIntExtra("tb_request_code", 0);
            this.kQU = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.kQT = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.kQV = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.jhM = getPageContext().getString(R.string.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.jhM = getPageContext().getString(R.string.he);
                    break;
                case 2:
                    this.jhM = getPageContext().getString(R.string.she);
                    break;
                default:
                    this.jhM = getPageContext().getString(R.string.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        ax(bundle);
        registerListener(this.kQY);
    }

    private void ax(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.base_person_navigation_bar);
        if (this.kQU) {
            if (this.jhS == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(cVV(), this.jhM));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.kQU && BasePersonInfoActivity.this.jhS != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.d(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.jhS != 23003 && !this.kQU) {
            this.jhN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
            ao.setNavbarIconSrc(this.jhN, kQW[com.baidu.tbadk.core.a.e.kF(cWe()) - 1], jhU[com.baidu.tbadk.core.a.e.kF(cWe()) - 1]);
            this.jhN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.jhL = com.baidu.tbadk.core.a.e.kF(BasePersonInfoActivity.this.cWe()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.cWe()) {
                        case 2:
                            str = "like";
                            break;
                        case 3:
                            str = TbEnum.ParamKey.GROUP;
                            break;
                        case 4:
                            str = "post";
                            break;
                        case 5:
                            str = "friend";
                            break;
                    }
                    HttpMessage httpMessage = new HttpMessage(1001506);
                    httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, str);
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.jhL + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.jhK = new int[]{0, 1};
        this.kQX = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.fMT);
    }

    private void initTabSpec() {
        if (this.kQX != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.kQX.getItem(i2);
                int zm = this.kQX.zm(i2);
                String cVW = cVW();
                if (zm == 1) {
                    cVW = cVX();
                }
                if (item != null) {
                    a(item, zm, cVW);
                }
            }
            this.mTabHost.initViewPager(3);
        }
    }

    public NavigationBar bAm() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.getDimens(getActivity(), R.dimen.ds88));
            bVar.dYX = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void cE(int i, int i2) {
        if (!this.mIsHost && this.kQX != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.lG(0).dYX;
            if (i <= 0) {
                fragmentTabIndicator.setText(cVW());
            } else {
                fragmentTabIndicator.setText(String.format(cVY(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.lG(1).dYX;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(cVX());
            } else {
                fragmentTabIndicator2.setText(String.format(cVZ(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String cwK() {
        return this.jhM;
    }

    public boolean cwL() {
        return this.mIsHost;
    }

    public boolean cWa() {
        return this.kQU;
    }

    public int cwJ() {
        return this.fMT == 0 ? 0 : 1;
    }

    public int cWb() {
        return this.kQT;
    }

    public String cWc() {
        return this.kQV;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.kQU && this.jhS != 23011) {
                com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.fMT);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.kQT);
        if (this.kQU && this.jhS != 23011) {
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
        if (i >= 0 && i < 2 && i != this.fMT) {
            this.fMT = i;
            if (!this.mIsHost && this.jhK[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), cWd(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.kQX != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.kQX.getCount()) {
                    Fragment item = this.kQX.getItem(i3);
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
