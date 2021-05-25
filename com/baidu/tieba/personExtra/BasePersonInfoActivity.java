package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.l.f;
/* loaded from: classes5.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static final String CURRTABINDEX = "CurrTabIndex";
    public static final String KEY_PAGE_TYPE = "page_type";
    public static final int PAGE_TYPE_AMOUNT = 2;
    public static final int PAGE_TYPE_COMMON = 1;
    public static final int PAGE_TYPE_PERSONAL = 0;
    public static final int[] PRIVACY_IMAGE_LIST = {R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
    public static final int[] PRIVACY_IMAGE_LIST_BLACK = {R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
    public static final int[] PRIVACY_INFO_TEXT_LIST = {R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
    public static final int[] PRIVATESTATE = {1, 2, 3};
    public BasePersonInfoAdapter mAdapter;
    public NavigationBar mNavigationBar;
    public ImageView mPrivacyButton;
    public int mSex;
    public FragmentTabHost mTabHost;
    public int[] mTypes;
    public String mUid;
    public String mUtype;
    public int requestCode;
    public int mCurrTabIndex = -1;
    public int wantPrivcay = 0;
    public boolean mIsHost = false;
    public int likeBarCount = 0;
    public boolean mIsChooseBarMode = false;
    public String mSelectedBarId = "";
    public HttpMessageListener privacySetttingListenter = new c(CmdConfigHttp.SET_PRIVATE_CMD);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasePersonInfoActivity basePersonInfoActivity = BasePersonInfoActivity.this;
            if (basePersonInfoActivity.mIsChooseBarMode && basePersonInfoActivity.requestCode != 23011) {
                MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                d.a.m0.r.a0.b.g(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
            }
            BasePersonInfoActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasePersonInfoActivity basePersonInfoActivity = BasePersonInfoActivity.this;
            basePersonInfoActivity.wantPrivcay = f.a(basePersonInfoActivity.getPrivacyType()) % 3;
            int privacyType = BasePersonInfoActivity.this.getPrivacyType();
            String str = privacyType != 2 ? privacyType != 3 ? privacyType != 4 ? privacyType != 5 ? "" : "friend" : "post" : "group" : "like";
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
            httpMessage.addParam("opt", str);
            httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.wantPrivcay + 1));
            BasePersonInfoActivity.this.sendMessage(httpMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    f.c(BasePersonInfoActivity.this.getPrivacyType(), BasePersonInfoActivity.PRIVATESTATE[BasePersonInfoActivity.this.wantPrivcay]);
                    SkinManager.setNavbarIconSrc(BasePersonInfoActivity.this.mPrivacyButton, BasePersonInfoActivity.PRIVACY_IMAGE_LIST_BLACK[BasePersonInfoActivity.this.wantPrivcay], BasePersonInfoActivity.PRIVACY_IMAGE_LIST[BasePersonInfoActivity.this.wantPrivcay]);
                    BasePersonInfoActivity basePersonInfoActivity = BasePersonInfoActivity.this;
                    basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity.getPageContext().getString(BasePersonInfoActivity.PRIVACY_INFO_TEXT_LIST[BasePersonInfoActivity.this.wantPrivcay]), R.drawable.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity basePersonInfoActivity2 = BasePersonInfoActivity.this;
            basePersonInfoActivity2.showToast(basePersonInfoActivity2.getPageContext().getString(R.string.neterror));
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12151c = fragment;
        bVar.f12149a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setMinimumHeight(l.g(getActivity(), R.dimen.ds88));
        bVar.f12150b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initTabSpec() {
        if (this.mAdapter != null) {
            int i2 = this.mIsHost ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                Fragment item = this.mAdapter.getItem(i3);
                int c2 = this.mAdapter.c(i3);
                String noPersonalTabTitle = getNoPersonalTabTitle();
                if (c2 == 1) {
                    noPersonalTabTitle = getNoCommonTabTitle();
                }
                if (item != null) {
                    createAndAddTabSpec(item, c2, noPersonalTabTitle);
                }
            }
            this.mTabHost.k(3);
        }
    }

    private void initUI(Bundle bundle) {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.base_person_navigation_bar);
        this.mNavigationBar = navigationBar;
        if (!this.mIsChooseBarMode) {
            navigationBar.setCenterTextTitle(String.format(getNavigationBarTitle(), this.mUtype));
        } else if (this.requestCode == 23011) {
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.live_choose_bar));
        } else {
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.share_choose_bar_title));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        if (this.mIsHost && this.requestCode != 23003 && !this.mIsChooseBarMode) {
            ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
            this.mPrivacyButton = imageView;
            SkinManager.setNavbarIconSrc(imageView, PRIVACY_IMAGE_LIST_BLACK[f.a(getPrivacyType()) - 1], PRIVACY_IMAGE_LIST[f.a(getPrivacyType()) - 1]);
            this.mPrivacyButton.setOnClickListener(new b());
        }
        this.mTypes = new int[]{0, 1};
        this.mAdapter = createPersonInfoAdapter(this, this.mIsHost);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.base_person_tab_host);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.p();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.mCurrTabIndex);
    }

    public abstract BasePersonInfoAdapter createPersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String getCommonTabTitle();

    public int getCurrentPageType() {
        return this.mCurrTabIndex == 0 ? 0 : 1;
    }

    public abstract String getHisCommonEventText();

    public boolean getIsHost() {
        return this.mIsHost;
    }

    public int getLikeBarCount() {
        return this.likeBarCount;
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    public abstract String getNavigationBarTitle();

    public abstract String getNoCommonTabTitle();

    public abstract String getNoPersonalTabTitle();

    public abstract String getPersonalTabTitle();

    public abstract int getPrivacyType();

    public String getSelectedBarId() {
        return this.mSelectedBarId;
    }

    public int getSex() {
        return this.mSex;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtype() {
        return this.mUtype;
    }

    public boolean ismIsChooseBarMode() {
        return this.mIsChooseBarMode;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mTabHost.o(i2);
        if (this.mAdapter != null) {
            for (int i3 = 0; i3 < this.mAdapter.getCount(); i3++) {
                Fragment item = this.mAdapter.getItem(i3);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).onChangeSkinType(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.likeBarCount = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.mCurrTabIndex = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.mIsChooseBarMode = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.mSelectedBarId = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.mCurrTabIndex = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.mIsChooseBarMode = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.likeBarCount = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.mSelectedBarId = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        String str = this.mUid;
        if (str == null) {
            str = "";
        }
        this.mUid = str;
        if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mUtype = getPageContext().getString(R.string.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            int i2 = this.mSex;
            if (i2 == 1) {
                this.mUtype = getPageContext().getString(R.string.he);
            } else if (i2 != 2) {
                this.mUtype = getPageContext().getString(R.string.ta);
            } else {
                this.mUtype = getPageContext().getString(R.string.she);
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.privacySetttingListenter);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.mIsChooseBarMode && this.requestCode != 23011) {
                d.a.m0.r.a0.b.g(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (i2 < 0 || i2 >= 2 || i2 == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i2;
        if (this.mIsHost || this.mTypes[i2] != 1) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getContext(), getHisCommonEventText(), PrefetchEvent.STATE_CLICK, 1, new Object[0]);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.mCurrTabIndex);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.likeBarCount);
        if (this.mIsChooseBarMode && this.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    public void setLikeBarCount(int i2) {
        this.likeBarCount = i2;
    }

    public void updateTabTitle(int i2, int i3) {
        if (this.mIsHost || this.mAdapter == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.g(0).f12150b;
        if (i2 <= 0) {
            fragmentTabIndicator.setText(getNoPersonalTabTitle());
        } else {
            fragmentTabIndicator.setText(String.format(getPersonalTabTitle(), Integer.valueOf(i2)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.g(1).f12150b;
        if (i3 <= 0) {
            fragmentTabIndicator2.setText(getNoCommonTabTitle());
        } else {
            fragmentTabIndicator2.setText(String.format(getCommonTabTitle(), Integer.valueOf(i3)));
        }
    }
}
