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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private int[] iZr;
    private String iZt;
    private ImageView iZu;
    protected int iZz;
    private BasePersonInfoAdapter kHW;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] iZB = {R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
    private static final int[] kHV = {R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
    private static final int[] iZD = {R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
    private static final int[] iZE = {1, 2, 3};
    private int fHy = -1;
    private int iZs = 0;
    private boolean mIsHost = false;
    private int kHS = 0;
    protected boolean kHT = false;
    protected String kHU = "";
    HttpMessageListener kHX = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.aE(BasePersonInfoActivity.this.cSn(), BasePersonInfoActivity.iZE[BasePersonInfoActivity.this.iZs]);
                    an.setNavbarIconSrc(BasePersonInfoActivity.this.iZu, BasePersonInfoActivity.kHV[BasePersonInfoActivity.this.iZs], BasePersonInfoActivity.iZB[BasePersonInfoActivity.this.iZs]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.iZD[BasePersonInfoActivity.this.iZs]), R.drawable.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(R.string.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String cSe();

    public abstract String cSf();

    public abstract String cSg();

    public abstract String cSh();

    public abstract String cSi();

    public abstract String cSm();

    public abstract int cSn();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.kHS = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.fHy = bundle.getInt("key_current_tab", 0);
            this.iZz = bundle.getInt("tb_request_code", 0);
            this.kHT = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.kHU = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.fHy = getIntent().getIntExtra("key_current_tab", 0);
            this.iZz = getIntent().getIntExtra("tb_request_code", 0);
            this.kHT = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.kHS = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.kHU = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.iZt = getPageContext().getString(R.string.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.iZt = getPageContext().getString(R.string.he);
                    break;
                case 2:
                    this.iZt = getPageContext().getString(R.string.she);
                    break;
                default:
                    this.iZt = getPageContext().getString(R.string.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        aw(bundle);
        registerListener(this.kHX);
    }

    private void aw(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.base_person_navigation_bar);
        if (this.kHT) {
            if (this.iZz == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(cSe(), this.iZt));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.kHT && BasePersonInfoActivity.this.iZz != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.c(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.iZz != 23003 && !this.kHT) {
            this.iZu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
            an.setNavbarIconSrc(this.iZu, kHV[com.baidu.tbadk.core.a.e.km(cSn()) - 1], iZB[com.baidu.tbadk.core.a.e.km(cSn()) - 1]);
            this.iZu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.iZs = com.baidu.tbadk.core.a.e.km(BasePersonInfoActivity.this.cSn()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.cSn()) {
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
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.iZs + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.iZr = new int[]{0, 1};
        this.kHW = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.fHy);
    }

    private void initTabSpec() {
        if (this.kHW != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.kHW.getItem(i2);
                int yN = this.kHW.yN(i2);
                String cSf = cSf();
                if (yN == 1) {
                    cSf = cSg();
                }
                if (item != null) {
                    a(item, yN, cSf);
                }
            }
            this.mTabHost.initViewPager(3);
        }
    }

    public NavigationBar bwV() {
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
            bVar.dSF = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void cB(int i, int i2) {
        if (!this.mIsHost && this.kHW != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.lm(0).dSF;
            if (i <= 0) {
                fragmentTabIndicator.setText(cSf());
            } else {
                fragmentTabIndicator.setText(String.format(cSh(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.lm(1).dSF;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(cSg());
            } else {
                fragmentTabIndicator2.setText(String.format(cSi(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String csH() {
        return this.iZt;
    }

    public boolean csI() {
        return this.mIsHost;
    }

    public boolean cSj() {
        return this.kHT;
    }

    public int csG() {
        return this.fHy == 0 ? 0 : 1;
    }

    public int cSk() {
        return this.kHS;
    }

    public String cSl() {
        return this.kHU;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.kHT && this.iZz != 23011) {
                com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.fHy);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.kHS);
        if (this.kHT && this.iZz != 23011) {
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
        if (i >= 0 && i < 2 && i != this.fHy) {
            this.fHy = i;
            if (!this.mIsHost && this.iZr[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), cSm(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.kHW != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.kHW.getCount()) {
                    Fragment item = this.kHW.getItem(i3);
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
