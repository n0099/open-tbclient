package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.m.f;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BasePersonInfoActivity a;

        public a(BasePersonInfoActivity basePersonInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePersonInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = basePersonInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                if (basePersonInfoActivity.mIsChooseBarMode && basePersonInfoActivity.requestCode != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                    c.a.o0.r.f0.b.g(this.a.getPageContext().getPageActivity(), 200, false);
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BasePersonInfoActivity a;

        public b(BasePersonInfoActivity basePersonInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePersonInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = basePersonInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                basePersonInfoActivity.wantPrivcay = f.a(basePersonInfoActivity.getPrivacyType()) % 3;
                int privacyType = this.a.getPrivacyType();
                String str = privacyType != 2 ? privacyType != 3 ? privacyType != 4 ? privacyType != 5 ? "" : "friend" : "post" : "group" : "like";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", str);
                httpMessage.addParam("val", String.valueOf(this.a.wantPrivcay + 1));
                this.a.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BasePersonInfoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BasePersonInfoActivity basePersonInfoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePersonInfoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                        basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity.getPageContext().getString(BasePersonInfoActivity.PRIVACY_INFO_TEXT_LIST[this.a.wantPrivcay]), R.drawable.obfuscated_res_0x7f080a68);
                        return;
                    }
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                BasePersonInfoActivity basePersonInfoActivity2 = this.a;
                basePersonInfoActivity2.showToast(basePersonInfoActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c15));
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
        PRIVACY_IMAGE_LIST = new int[]{R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
        PRIVACY_IMAGE_LIST_BLACK = new int[]{R.drawable.obfuscated_res_0x7f0808b6, R.drawable.obfuscated_res_0x7f0808ba, R.drawable.obfuscated_res_0x7f0808b8};
        PRIVACY_INFO_TEXT_LIST = new int[]{R.string.obfuscated_res_0x7f0f08d7, R.string.obfuscated_res_0x7f0f08d8, R.string.obfuscated_res_0x7f0f08d9};
        PRIVATESTATE = new int[]{1, 2, 3};
    }

    public BasePersonInfoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65546, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f29925c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.f30573h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setMinimumHeight(n.f(getActivity(), R.dimen.obfuscated_res_0x7f0702ff));
        bVar.f29924b = fragmentTabIndicator;
        this.mTabHost.c(bVar);
    }

    private void initTabSpec() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.mAdapter == null) {
            return;
        }
        int i = this.mIsHost ? 1 : 2;
        for (int i2 = 0; i2 < i; i2++) {
            Fragment item = this.mAdapter.getItem(i2);
            int c2 = this.mAdapter.c(i2);
            String noPersonalTabTitle = getNoPersonalTabTitle();
            if (c2 == 1) {
                noPersonalTabTitle = getNoCommonTabTitle();
            }
            if (item != null) {
                createAndAddTabSpec(item, c2, noPersonalTabTitle);
            }
        }
        this.mTabHost.n(3);
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090328);
            this.mNavigationBar = navigationBar;
            if (!this.mIsChooseBarMode) {
                navigationBar.setCenterTextTitle(String.format(getNavigationBarTitle(), this.mUtype));
            } else if (this.requestCode == 23011) {
                navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f09ee));
            } else {
                navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f110d));
            }
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (this.mIsHost && this.requestCode != 23003 && !this.mIsChooseBarMode) {
                ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08d1, (View.OnClickListener) null);
                this.mPrivacyButton = imageView;
                SkinManager.setNavbarIconSrc(imageView, PRIVACY_IMAGE_LIST_BLACK[f.a(getPrivacyType()) - 1], PRIVACY_IMAGE_LIST[f.a(getPrivacyType()) - 1]);
                this.mPrivacyButton.setOnClickListener(new b(this));
            }
            this.mTypes = new int[]{0, 1};
            this.mAdapter = createPersonInfoAdapter(this, this.mIsHost);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f090329);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.u();
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mTabHost.s(i);
            if (this.mAdapter != null) {
                for (int i2 = 0; i2 < this.mAdapter.getCount(); i2++) {
                    Fragment item = this.mAdapter.getItem(i2);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).onChangeSkinType(i);
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
            setContentView(R.layout.obfuscated_res_0x7f0d002b);
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
                this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f0a97);
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
                int i = this.mSex;
                if (i == 1) {
                    this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f0818);
                } else if (i != 2) {
                    this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f1316);
                } else {
                    this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f1150);
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
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i, keyEvent)) == null) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                if (this.mIsChooseBarMode && this.requestCode != 23011) {
                    c.a.o0.r.f0.b.g(getPageContext().getPageActivity(), 200, false);
                }
                finish();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || i < 0 || i >= 2 || i == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i;
        if (this.mIsHost || this.mTypes[i] != 1) {
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

    public void setLikeBarCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.likeBarCount = i;
        }
    }

    public void updateTabTitle(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) || this.mIsHost || this.mAdapter == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.j(0).f29924b;
        if (i <= 0) {
            fragmentTabIndicator.setText(getNoPersonalTabTitle());
        } else {
            fragmentTabIndicator.setText(String.format(getPersonalTabTitle(), Integer.valueOf(i)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.j(1).f29924b;
        if (i2 <= 0) {
            fragmentTabIndicator2.setText(getNoCommonTabTitle());
        } else {
            fragmentTabIndicator2.setText(String.format(getCommonTabTitle(), Integer.valueOf(i2)));
        }
    }
}
