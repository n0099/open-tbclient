package com.baidu.tieba.post;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.e.m.e.q;
import b.a.r0.u2.d;
import b.a.r0.u2.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonExtraStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.j, d, b.a.r0.u2.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CURRTABINDEX = "CurrTabIndex";
    public static final String KEY_EMPTYVIEW_TXT = "key_empty_view_text";
    public static final int PAGE_TYPE_AMOUNT = 2;
    public static final int PAGE_TYPE_MYREPLY = 1;
    public static final int PAGE_TYPE_MYTHEME = 0;
    public static final String THREAD_RECYCLE_BIN_URL = "http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station?noshare=1#/recycle-post";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isHost;
    public View mBack;
    public int mCurrTabIndex;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetworkView;
    public PersonPostAdapter mPersonPostAdapter;
    public String mPortraitUrl;
    public RelativeLayout mRecycleBinLayout;
    public ImageView mRecycleBinRedTip;
    public TextView mRecycleBinTitle;
    public int mSex;
    public int mSkinType;
    public FragmentTabHost mTabHost;
    public final CustomMessageListener mToHotTopicListener;
    public int[] mTypes;
    public String mUid;
    public String mUtype;
    public VoiceManager mVoiceManager;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonPostActivity f54276e;

        public a(PersonPostActivity personPostActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54276e = personPostActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54276e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonPostActivity f54277e;

        public b(PersonPostActivity personPostActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54277e = personPostActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f54277e.mRecycleBinRedTip.getVisibility() == 0 ? "1" : "2").param("obj_locate", 1));
                this.f54277e.showRecycleBinRedTip(false);
                UrlManager.getInstance().dealOneLink(this.f54277e.getPageContext(), new String[]{PersonPostActivity.THREAD_RECYCLE_BIN_URL});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPostActivity f54278a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonPostActivity personPostActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostActivity, Integer.valueOf(i2)};
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
            this.f54278a = personPostActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f54278a.getPageContext(), new String[]{str});
        }
    }

    public PersonPostActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrTabIndex = -1;
        this.isHost = false;
        this.mBack = null;
        this.mToHotTopicListener = new c(this, 2016493);
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65538, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f46035c = fragment;
        bVar.f46033a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        bVar.f46034b = fragmentTabIndicator;
        this.mTabHost.addTabSpec(bVar);
    }

    private void initPersonPostTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            b.a.r0.m3.f0.a.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, b.a.r0.m3.f0.a.a("c/u/feed/userpost", 303002));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    private void initTabSpec() {
        PersonPostAdapter personPostAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (personPostAdapter = this.mPersonPostAdapter) == null) {
            return;
        }
        int count = personPostAdapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            Fragment item = this.mPersonPostAdapter.getItem(i2);
            int itemPageType = this.mPersonPostAdapter.getItemPageType(i2);
            if (item != null) {
                if (itemPageType == 0) {
                    createAndAddTabSpec(item, 0, getPageContext().getString(R.string.person_post_thread_new));
                } else if (itemPageType == 1) {
                    createAndAddTabSpec(item, 1, getPageContext().getString(R.string.reply));
                }
            }
        }
        this.mTabHost.initViewPagerWithNoType();
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bundle) == null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.my_post));
            View view = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
            this.mBack = view;
            view.setOnClickListener(new a(this));
            RelativeLayout relativeLayout = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
            this.mRecycleBinLayout = relativeLayout;
            relativeLayout.setOnClickListener(new b(this));
            this.mRecycleBinTitle = (TextView) this.mRecycleBinLayout.findViewById(R.id.tv_recycle_bin);
            this.mRecycleBinRedTip = (ImageView) this.mRecycleBinLayout.findViewById(R.id.iv_recycle_bin_red_tip);
            if (b.a.q0.s.e0.b.j().g(b.a.q0.s.e0.b.n("key_person_post_recycle_bin_red_tip_show"), false)) {
                this.mRecycleBinRedTip.setVisibility(0);
            } else {
                this.mRecycleBinRedTip.setVisibility(8);
            }
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.person_post_no_network_view);
            this.mTypes = new int[]{0, 1};
            this.mPersonPostAdapter = new PersonPostAdapter(this);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds100));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(l.g(getActivity(), R.dimen.ds64));
            initTabSpec();
            ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds88), 0, 0);
            if (bundle != null) {
                this.mCurrTabIndex = bundle.getInt("CurrTabIndex");
            } else {
                this.mCurrTabIndex = 0;
            }
            this.mTabHost.setCurrentTab(this.mCurrTabIndex);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a080" : (String) invokeV.objValue;
    }

    public String getEmptyViewText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.isHost) {
                return getPageContext().getString(R.string.person_post_lv_empty_host);
            }
            return String.format(getPageContext().getString(R.string.person_post_lv_empty_guest), getUtype());
        }
        return (String) invokeV.objValue;
    }

    public String getPortraitUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPortraitUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSex : invokeV.intValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUid : (String) invokeV.objValue;
    }

    public String getUtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUtype : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mVoiceManager == null) {
                this.mVoiceManager = VoiceManager.instance();
            }
            return this.mVoiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        PersonPostAdapter personPostAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) || (personPostAdapter = this.mPersonPostAdapter) == null) {
            return;
        }
        int count = personPostAdapter.getCount();
        for (int i4 = 0; i4 < count; i4++) {
            Fragment item = this.mPersonPostAdapter.getItem(i4);
            if (item instanceof PersonThreadFragment) {
                item.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i2);
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.mTabHost.onChangeSkinType(i2);
            if (this.mTabHost.getFragmentTabWidget() != null) {
                SkinManager.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
            }
            SkinManager.setViewTextColor(this.mRecycleBinTitle, R.color.CAM_X0105);
            this.mRecycleBinRedTip.setImageDrawable(SkinManager.getDrawable(i2, R.drawable.person_center_red_tip_shape));
            PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
            if (personPostAdapter != null) {
                int count = personPostAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    Fragment item = this.mPersonPostAdapter.getItem(i3);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).changeSkinType(i2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            initPersonPostTasks();
            if (!j.z()) {
                showToast(R.string.neterror);
            }
            setContentView(R.layout.person_post_activity);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            this.mPortraitUrl = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            String str = this.mUid;
            if (str == null) {
                str = "";
            }
            this.mUid = str;
            if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mUtype = getPageContext().getString(R.string.me);
                this.isHost = true;
            } else {
                int intExtra = getIntent().getIntExtra("key_sex", 0);
                if (intExtra == 1) {
                    this.mUtype = getPageContext().getString(R.string.he);
                } else if (intExtra != 2) {
                    this.mUtype = getPageContext().getString(R.string.ta);
                } else {
                    this.mUtype = getPageContext().getString(R.string.she);
                }
            }
            TbadkCoreApplication.isMyLive = false;
            if (this.mUid == null) {
                finish();
            } else {
                initUI(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            try {
                PersonExtraStatic.f();
                super.onDestroy();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
            if (personPostAdapter != null) {
                PersonThreadFragment personThreadFragment = personPostAdapter.getPersonThreadFragment();
                h personThreadView = personThreadFragment != null ? personThreadFragment.getPersonThreadView() : null;
                if (personThreadView != null && personThreadView.f() != null) {
                    return personThreadView.f().getPreLoadHandle();
                }
            }
            return null;
        }
        return (q) invokeV.objValue;
    }

    @Override // b.a.r0.u2.d
    public void onNoNetRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.mPersonPostAdapter == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mPersonPostAdapter.getCount(); i2++) {
            if (this.mPersonPostAdapter.getItem(i2) instanceof b.a.r0.u2.c) {
                ((b.a.r0.u2.c) this.mPersonPostAdapter.getItem(i2)).fetchDataOnNoNetRefresh();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 < 0 || i2 >= 2 || i2 == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i2;
        int[] iArr = this.mTypes;
        if (iArr[i2] == 0) {
            TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        } else if (iArr[i2] == 1) {
            TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            MessageManager.getInstance().registerListener(this.mToHotTopicListener);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                this.mSkinType = skinType;
                onChangeSkinType(skinType);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.mCurrTabIndex);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStop();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // b.a.r0.u2.b
    public void showRecycleBinRedTip(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (imageView = this.mRecycleBinRedTip) == null) {
            return;
        }
        if (z && imageView.getVisibility() == 8) {
            this.mRecycleBinRedTip.setVisibility(0);
            b.a.q0.s.e0.b.j().t(b.a.q0.s.e0.b.n("key_person_post_recycle_bin_red_tip_show"), true);
        } else if (z || this.mRecycleBinRedTip.getVisibility() != 0) {
        } else {
            this.mRecycleBinRedTip.setVisibility(8);
            b.a.q0.s.e0.b.j().t(b.a.q0.s.e0.b.n("key_person_post_recycle_bin_red_tip_show"), false);
        }
    }
}
