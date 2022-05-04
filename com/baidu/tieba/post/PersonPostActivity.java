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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.repackage.a88;
import com.repackage.b88;
import com.repackage.c88;
import com.repackage.g88;
import com.repackage.kk8;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.vt4;
import com.repackage.xo;
/* loaded from: classes3.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.j, c88, a88 {
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPostActivity a;

        public a(PersonPostActivity personPostActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPostActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPostActivity a;

        public b(PersonPostActivity personPostActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPostActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.a.mRecycleBinRedTip.getVisibility() == 0 ? "1" : "2").param("obj_locate", 1));
                this.a.showRecycleBinRedTip(false);
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{PersonPostActivity.THREAD_RECYCLE_BIN_URL});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPostActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonPostActivity personPostActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostActivity, Integer.valueOf(i)};
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
            this.a = personPostActivity;
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
            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
        }
    }

    public PersonPostActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65538, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        bVar.b = fragmentTabIndicator;
        this.mTabHost.c(bVar);
    }

    private void initPersonPostTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            kk8.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, kk8.a("c/u/feed/userpost", 303002));
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
        for (int i = 0; i < count; i++) {
            Fragment item = this.mPersonPostAdapter.getItem(i);
            int b2 = this.mPersonPostAdapter.b(i);
            if (item != null) {
                if (b2 == 0) {
                    createAndAddTabSpec(item, 0, getPageContext().getString(R.string.obfuscated_res_0x7f0f0e2c));
                } else if (b2 == 1) {
                    createAndAddTabSpec(item, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0f8e));
                }
            }
        }
        this.mTabHost.o();
    }

    private void initUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, bundle) == null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b35));
            View view2 = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
            this.mBack = view2;
            view2.setOnClickListener(new a(this));
            RelativeLayout relativeLayout = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06d8, (View.OnClickListener) null);
            this.mRecycleBinLayout = relativeLayout;
            relativeLayout.setOnClickListener(new b(this));
            this.mRecycleBinTitle = (TextView) this.mRecycleBinLayout.findViewById(R.id.obfuscated_res_0x7f0921e5);
            this.mRecycleBinRedTip = (ImageView) this.mRecycleBinLayout.findViewById(R.id.obfuscated_res_0x7f090fef);
            if (vt4.k().h(vt4.o("key_person_post_recycle_bin_red_tip_show"), false)) {
                this.mRecycleBinRedTip.setVisibility(0);
            } else {
                this.mRecycleBinRedTip.setVisibility(8);
            }
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0917f7);
            this.mTypes = new int[]{0, 1};
            this.mPersonPostAdapter = new PersonPostAdapter(this);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091e30);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07019a));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070258));
            initTabSpec();
            ((RelativeLayout.LayoutParams) this.mTabHost.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070309), 0, 0);
            if (bundle != null) {
                this.mCurrTabIndex = bundle.getInt("CurrTabIndex");
            } else {
                this.mCurrTabIndex = 0;
            }
            this.mTabHost.setCurrentTab(this.mCurrTabIndex);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v75
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
                return getPageContext().getString(R.string.obfuscated_res_0x7f0f0e2b);
            }
            return String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e2a), getUtype());
        }
        return (String) invokeV.objValue;
    }

    public String getPortraitUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPortraitUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceModel)) == null) {
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
    public void onActivityResult(int i, int i2, Intent intent) {
        PersonPostAdapter personPostAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) || (personPostAdapter = this.mPersonPostAdapter) == null) {
            return;
        }
        int count = personPostAdapter.getCount();
        for (int i3 = 0; i3 < count; i3++) {
            Fragment item = this.mPersonPostAdapter.getItem(i3);
            if (item instanceof PersonThreadFragment) {
                item.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mNoNetworkView.c(getPageContext(), i);
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.mTabHost.s(i);
            if (this.mTabHost.getFragmentTabWidget() != null) {
                SkinManager.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), R.color.CAM_X0201);
            }
            SkinManager.setViewTextColor(this.mRecycleBinTitle, (int) R.color.CAM_X0105);
            this.mRecycleBinRedTip.setImageDrawable(SkinManager.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
            PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
            if (personPostAdapter != null) {
                int count = personPostAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.mPersonPostAdapter.getItem(i2);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).changeSkinType(i);
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
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
            }
            setContentView(R.layout.obfuscated_res_0x7f0d06d2);
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
                this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f0a99);
                this.isHost = true;
            } else {
                int intExtra = getIntent().getIntExtra("key_sex", 0);
                if (intExtra == 1) {
                    this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f0819);
                } else if (intExtra != 2) {
                    this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f131d);
                } else {
                    this.mUtype = getPageContext().getString(R.string.obfuscated_res_0x7f0f1157);
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
    public xo onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PersonPostAdapter personPostAdapter = this.mPersonPostAdapter;
            if (personPostAdapter != null) {
                PersonThreadFragment c2 = personPostAdapter.c();
                g88 L0 = c2 != null ? c2.L0() : null;
                if (L0 != null && L0.f() != null) {
                    return L0.f().getPreLoadHandle();
                }
            }
            return null;
        }
        return (xo) invokeV.objValue;
    }

    @Override // com.repackage.c88
    public void onNoNetRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.mPersonPostAdapter == null) {
            return;
        }
        for (int i = 0; i < this.mPersonPostAdapter.getCount(); i++) {
            if (this.mPersonPostAdapter.getItem(i) instanceof b88) {
                ((b88) this.mPersonPostAdapter.getItem(i)).Y();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || i < 0 || i >= 2 || i == this.mCurrTabIndex) {
            return;
        }
        this.mCurrTabIndex = i;
        int[] iArr = this.mTypes;
        if (iArr[i] == 0) {
            TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
        } else if (iArr[i] == 1) {
            TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
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

    @Override // com.repackage.a88
    public void showRecycleBinRedTip(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (imageView = this.mRecycleBinRedTip) == null) {
            return;
        }
        if (z && imageView.getVisibility() == 8) {
            this.mRecycleBinRedTip.setVisibility(0);
            vt4.k().u(vt4.o("key_person_post_recycle_bin_red_tip_show"), true);
        } else if (z || this.mRecycleBinRedTip.getVisibility() != 0) {
        } else {
            this.mRecycleBinRedTip.setVisibility(8);
            vt4.k().u(vt4.o("key_person_post_recycle_bin_red_tip_show"), false);
        }
    }
}
