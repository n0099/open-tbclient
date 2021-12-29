package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.l.f;
import c.a.t0.y2.d;
import c.a.t0.y2.e;
import c.a.t0.y2.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CURRTABINDEX = "CurrTabIndex";
    public static final String KEY_PAGE_TYPE = "page_type";
    public static final int PAGE_TYPE_AMOUNT = 2;
    public static final int PAGE_TYPE_COMMON = 1;
    public static final int PAGE_TYPE_PERSONAL = 0;
    public static final int[] PRIVACY_IMAGE_LIST;
    public static final int[] PRIVACY_IMAGE_LIST_BLACK;
    public static final int[] PRIVACY_INFO_TEXT_LIST;
    public static final int[] PRIVATESTATE;
    public transient /* synthetic */ FieldHolder $fh;
    public int likeBarCount;
    public BasePersonInfoAdapter mAdapter;
    public int mCurrTabIndex;
    public boolean mIsChooseBarMode;
    public boolean mIsHost;
    public NavigationBar mNavigationBar;
    public ImageView mPrivacyButton;
    public String mSelectedBarId;
    public int mSex;
    public FragmentTabHost mTabHost;
    public int[] mTypes;
    public String mUid;
    public String mUtype;
    public HttpMessageListener privacySetttingListenter;
    public int requestCode;
    public int wantPrivcay;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BasePersonInfoActivity f48930e;

        public a(BasePersonInfoActivity basePersonInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePersonInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48930e = basePersonInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.f48930e;
                if (basePersonInfoActivity.mIsChooseBarMode && basePersonInfoActivity.requestCode != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                    c.a.s0.s.d0.b.g(this.f48930e.getPageContext().getPageActivity(), 200, false);
                }
                this.f48930e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BasePersonInfoActivity f48931e;

        public b(BasePersonInfoActivity basePersonInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePersonInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48931e = basePersonInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.f48931e;
                basePersonInfoActivity.wantPrivcay = f.a(basePersonInfoActivity.getPrivacyType()) % 3;
                int privacyType = this.f48931e.getPrivacyType();
                String str = privacyType != 2 ? privacyType != 3 ? privacyType != 4 ? privacyType != 5 ? "" : "friend" : "post" : "group" : "like";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", str);
                httpMessage.addParam("val", String.valueOf(this.f48931e.wantPrivcay + 1));
                this.f48931e.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BasePersonInfoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BasePersonInfoActivity basePersonInfoActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePersonInfoActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = basePersonInfoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage.isSuccess()) {
                    if (httpResponsedMessage.getError() == 0) {
                        f.c(this.a.getPrivacyType(), BasePersonInfoActivity.PRIVATESTATE[this.a.wantPrivcay]);
                        SkinManager.setNavbarIconSrc(this.a.mPrivacyButton, BasePersonInfoActivity.PRIVACY_IMAGE_LIST_BLACK[this.a.wantPrivcay], BasePersonInfoActivity.PRIVACY_IMAGE_LIST[this.a.wantPrivcay]);
                        BasePersonInfoActivity basePersonInfoActivity = this.a;
                        basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity.getPageContext().getString(BasePersonInfoActivity.PRIVACY_INFO_TEXT_LIST[this.a.wantPrivcay]), c.a.t0.y2.c.icon_toast_info);
                        return;
                    }
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                BasePersonInfoActivity basePersonInfoActivity2 = this.a;
                basePersonInfoActivity2.showToast(basePersonInfoActivity2.getPageContext().getString(g.neterror));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-706040554, "Lcom/baidu/tieba/personExtra/BasePersonInfoActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-706040554, "Lcom/baidu/tieba/personExtra/BasePersonInfoActivity;");
                return;
            }
        }
        PRIVACY_IMAGE_LIST = new int[]{c.a.t0.y2.c.icon_pop_key_all_bg, c.a.t0.y2.c.icon_pop_key_f_bg, c.a.t0.y2.c.icon_pop_key_d_bg};
        PRIVACY_IMAGE_LIST_BLACK = new int[]{c.a.t0.y2.c.icon_pop_key_all_bg_w, c.a.t0.y2.c.icon_pop_key_f_bg_w, c.a.t0.y2.c.icon_pop_key_d_bg_w};
        PRIVACY_INFO_TEXT_LIST = new int[]{g.info_privacy_all, g.info_privacy_friend, g.info_privacy_hide};
        PRIVATESTATE = new int[]{1, 2, 3};
    }

    public BasePersonInfoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrTabIndex = -1;
        this.wantPrivcay = 0;
        this.mIsHost = false;
        this.likeBarCount = 0;
        this.mIsChooseBarMode = false;
        this.mSelectedBarId = "";
        this.privacySetttingListenter = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65546, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f41700c = fragment;
        bVar.a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.dayTextColorResId = c.a.t0.y2.a.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(c.a.t0.y2.b.fontsize32));
        fragmentTabIndicator.setMinimumHeight(n.f(getActivity(), c.a.t0.y2.b.ds88));
        bVar.f41699b = fragmentTabIndicator;
        this.mTabHost.addTabSpec(bVar);
    }

    private void initTabSpec() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.mAdapter == null) {
            return;
        }
        int i2 = this.mIsHost ? 1 : 2;
        for (int i3 = 0; i3 < i2; i3++) {
            Fragment item = this.mAdapter.getItem(i3);
            int itemPageType = this.mAdapter.getItemPageType(i3);
            String noPersonalTabTitle = getNoPersonalTabTitle();
            if (itemPageType == 1) {
                noPersonalTabTitle = getNoCommonTabTitle();
            }
            if (item != null) {
                createAndAddTabSpec(item, itemPageType, noPersonalTabTitle);
            }
        }
        this.mTabHost.initViewPager(3);
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(d.base_person_navigation_bar);
            this.mNavigationBar = navigationBar;
            if (!this.mIsChooseBarMode) {
                navigationBar.setCenterTextTitle(String.format(getNavigationBarTitle(), this.mUtype));
            } else if (this.requestCode == 23011) {
                navigationBar.setCenterTextTitle(getPageContext().getString(g.live_choose_bar));
            } else {
                navigationBar.setCenterTextTitle(getPageContext().getString(g.share_choose_bar_title));
            }
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (this.mIsHost && this.requestCode != 23003 && !this.mIsChooseBarMode) {
                ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.widget_nb_item_privacy, (View.OnClickListener) null);
                this.mPrivacyButton = imageView;
                SkinManager.setNavbarIconSrc(imageView, PRIVACY_IMAGE_LIST_BLACK[f.a(getPrivacyType()) - 1], PRIVACY_IMAGE_LIST[f.a(getPrivacyType()) - 1]);
                this.mPrivacyButton.setOnClickListener(new b(this));
            }
            this.mTypes = new int[]{0, 1};
            this.mAdapter = createPersonInfoAdapter(this, this.mIsHost);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(d.base_person_tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(c.a.t0.y2.a.common_color_10002));
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.reset();
            initTabSpec();
            if (this.mIsHost) {
                this.mTabHost.getTabWrapper().setVisibility(8);
            }
            this.mTabHost.setCurrentTab(this.mCurrTabIndex);
        }
    }

    public abstract BasePersonInfoAdapter createPersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String getCommonTabTitle();

    public int getCurrentPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrTabIndex == 0 ? 0 : 1 : invokeV.intValue;
    }

    public abstract String getHisCommonEventText();

    public boolean getIsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIsHost : invokeV.booleanValue;
    }

    public int getLikeBarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.likeBarCount : invokeV.intValue;
    }

    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNavigationBar : (NavigationBar) invokeV.objValue;
    }

    public abstract String getNavigationBarTitle();

    public abstract String getNoCommonTabTitle();

    public abstract String getNoPersonalTabTitle();

    public abstract String getPersonalTabTitle();

    public abstract int getPrivacyType();

    public String getSelectedBarId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSelectedBarId : (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mSex : invokeV.intValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mUid : (String) invokeV.objValue;
    }

    public String getUtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mUtype : (String) invokeV.objValue;
    }

    public boolean ismIsChooseBarMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mIsChooseBarMode : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mTabHost.onChangeSkinType(i2);
            if (this.mAdapter != null) {
                for (int i3 = 0; i3 < this.mAdapter.getCount(); i3++) {
                    Fragment item = this.mAdapter.getItem(i3);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).onChangeSkinType(i2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(e.activity_base_person_info);
            if (bundle != null) {
                this.mUid = bundle.getString("key_uid");
                this.mSex = bundle.getInt("key_sex", 0);
                this.likeBarCount = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
                this.mCurrTabIndex = bundle.getInt("key_current_tab", 0);
                this.requestCode = bundle.getInt("tb_request_code", 0);
                this.mIsChooseBarMode = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
                this.mSelectedBarId = bundle.getString("bar_id");
            } else if (getIntent() != null) {
                this.mUid = getIntent().getStringExtra("key_uid");
                this.mSex = getIntent().getIntExtra("key_sex", 0);
                this.mCurrTabIndex = getIntent().getIntExtra("key_current_tab", 0);
                this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
                this.mIsChooseBarMode = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
                this.likeBarCount = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
                this.mSelectedBarId = getIntent().getStringExtra("bar_id");
            } else {
                finish();
            }
            String str = this.mUid;
            if (str == null) {
                str = "";
            }
            this.mUid = str;
            if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mUtype = getPageContext().getString(g.me);
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
                int i2 = this.mSex;
                if (i2 == 1) {
                    this.mUtype = getPageContext().getString(g.he);
                } else if (i2 != 2) {
                    this.mUtype = getPageContext().getString(g.ta);
                } else {
                    this.mUtype = getPageContext().getString(g.she);
                }
            }
            if (m.isEmpty(this.mUid)) {
                finish();
                return;
            }
            initUI(bundle);
            registerListener(this.privacySetttingListenter);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, keyEvent)) == null) {
            if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
                if (this.mIsChooseBarMode && this.requestCode != 23011) {
                    c.a.s0.s.d0.b.g(getPageContext().getPageActivity(), 200, false);
                }
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 < 0 || i2 >= 2 || i2 == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i2;
        if (this.mIsHost || this.mTypes[i2] != 1) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getContext(), getHisCommonEventText(), "click", 1, new Object[0]);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.mCurrTabIndex);
            bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.likeBarCount);
            if (this.mIsChooseBarMode && this.requestCode != 23011) {
                MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                finish();
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void setLikeBarCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.likeBarCount = i2;
        }
    }

    public void updateTabTitle(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) || this.mIsHost || this.mAdapter == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.getTabSpecByType(0).f41699b;
        if (i2 <= 0) {
            fragmentTabIndicator.setText(getNoPersonalTabTitle());
        } else {
            fragmentTabIndicator.setText(String.format(getPersonalTabTitle(), Integer.valueOf(i2)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.getTabSpecByType(1).f41699b;
        if (i3 <= 0) {
            fragmentTabIndicator2.setText(getNoCommonTabTitle());
        } else {
            fragmentTabIndicator2.setText(String.format(getCommonTabTitle(), Integer.valueOf(i3)));
        }
    }
}
