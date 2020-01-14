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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private int[] hFm;
    private String hFo;
    private ImageView hFp;
    protected int hFu;
    private BasePersonInfoAdapter jib;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] hFw = {R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
    private static final int[] jia = {R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
    private static final int[] hFy = {R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
    private static final int[] hFz = {1, 2, 3};
    private int ezf = -1;
    private int hFn = 0;
    private boolean mIsHost = false;
    private int jhX = 0;
    protected boolean jhY = false;
    protected String jhZ = "";
    HttpMessageListener jic = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.aw(BasePersonInfoActivity.this.cuk(), BasePersonInfoActivity.hFz[BasePersonInfoActivity.this.hFn]);
                    am.setNavbarIconSrc(BasePersonInfoActivity.this.hFp, BasePersonInfoActivity.jia[BasePersonInfoActivity.this.hFn], BasePersonInfoActivity.hFw[BasePersonInfoActivity.this.hFn]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.hFy[BasePersonInfoActivity.this.hFn]), R.drawable.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(R.string.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String cub();

    public abstract String cuc();

    public abstract String cud();

    public abstract String cue();

    public abstract String cuf();

    public abstract String cuj();

    public abstract int cuk();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.jhX = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.ezf = bundle.getInt("key_current_tab", 0);
            this.hFu = bundle.getInt("tb_request_code", 0);
            this.jhY = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.jhZ = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.ezf = getIntent().getIntExtra("key_current_tab", 0);
            this.hFu = getIntent().getIntExtra("tb_request_code", 0);
            this.jhY = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.jhX = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.jhZ = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.hFo = getPageContext().getString(R.string.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.hFo = getPageContext().getString(R.string.he);
                    break;
                case 2:
                    this.hFo = getPageContext().getString(R.string.she);
                    break;
                default:
                    this.hFo = getPageContext().getString(R.string.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        ap(bundle);
        registerListener(this.jic);
    }

    private void ap(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.base_person_navigation_bar);
        if (this.jhY) {
            if (this.hFu == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(cub(), this.hFo));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.jhY && BasePersonInfoActivity.this.hFu != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.c(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.hFu != 23003 && !this.jhY) {
            this.hFp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
            am.setNavbarIconSrc(this.hFp, jia[com.baidu.tbadk.core.a.e.ja(cuk()) - 1], hFw[com.baidu.tbadk.core.a.e.ja(cuk()) - 1]);
            this.hFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.hFn = com.baidu.tbadk.core.a.e.ja(BasePersonInfoActivity.this.cuk()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.cuk()) {
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
                    httpMessage.addParam("opt", str);
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.hFn + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.hFm = new int[]{0, 1};
        this.jib = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.ezf);
    }

    private void initTabSpec() {
        if (this.jib != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.jib.getItem(i2);
                int wJ = this.jib.wJ(i2);
                String cuc = cuc();
                if (wJ == 1) {
                    cuc = cud();
                }
                if (item != null) {
                    a(item, wJ, cuc);
                }
            }
            this.mTabHost.initViewPager(3);
        }
    }

    public NavigationBar bcw() {
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
            bVar.cUe = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void ci(int i, int i2) {
        if (!this.mIsHost && this.jib != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.jY(0).cUe;
            if (i <= 0) {
                fragmentTabIndicator.setText(cuc());
            } else {
                fragmentTabIndicator.setText(String.format(cue(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.jY(1).cUe;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(cud());
            } else {
                fragmentTabIndicator2.setText(String.format(cuf(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String bVQ() {
        return this.hFo;
    }

    public boolean bVR() {
        return this.mIsHost;
    }

    public boolean cug() {
        return this.jhY;
    }

    public int bVP() {
        return this.ezf == 0 ? 0 : 1;
    }

    public int cuh() {
        return this.jhX;
    }

    public String cui() {
        return this.jhZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.jhY && this.hFu != 23011) {
                com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.ezf);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.jhX);
        if (this.jhY && this.hFu != 23011) {
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
        if (i >= 0 && i < 2 && i != this.ezf) {
            this.ezf = i;
            if (!this.mIsHost && this.hFm[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), cuj(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.jib != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.jib.getCount()) {
                    Fragment item = this.jib.getItem(i3);
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
