package com.baidu.tieba.post;

import android.content.Context;
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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.cn;
import com.baidu.tieba.hu9;
import com.baidu.tieba.iu9;
import com.baidu.tieba.ju9;
import com.baidu.tieba.nu9;
import com.baidu.tieba.personExtra.PersonExtraStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.zaa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.i, ju9, hu9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public NavigationBar g;
    public View h;
    public RelativeLayout i;
    public TextView j;
    public ImageView k;
    public NoNetworkView l;
    public FragmentTabHost m;
    public PersonPostAdapter n;
    public VoiceManager o;
    public int p;
    public final CustomMessageListener q;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView g1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a080" : (String) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (this.a.k.getVisibility() == 0) {
                    str = "1";
                } else {
                    str = "2";
                }
                TiebaStatic.log(param.param("obj_type", str).param("obj_locate", 1));
                this.a.m0(false);
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{PersonPostActivity.r});
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str)) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1174510410, "Lcom/baidu/tieba/post/PersonPostActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1174510410, "Lcom/baidu/tieba/post/PersonPostActivity;");
                return;
            }
        }
        r = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/recycle-station?noshare=1#/recycle-post";
    }

    public PersonPostActivity() {
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
        this.a = -1;
        this.f = false;
        this.h = null;
        this.q = new c(this, 2016493);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public cn onGetPreLoadListView() {
        InterceptResult invokeV;
        nu9 nu9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PersonPostAdapter personPostAdapter = this.n;
            if (personPostAdapter != null) {
                PersonThreadFragment c2 = personPostAdapter.c();
                if (c2 != null) {
                    nu9Var = c2.S1();
                } else {
                    nu9Var = null;
                }
                if (nu9Var != null && nu9Var.f() != null) {
                    return nu9Var.f().getPreLoadHandle();
                }
            }
            return null;
        }
        return (cn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            MessageManager.getInstance().registerListener(this.q);
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onResume(getPageContext());
            }
            if (this.p != TbadkCoreApplication.getInst().getSkinType()) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                this.p = skinType;
                onChangeSkinType(skinType);
            }
        }
    }

    @Override // com.baidu.tieba.ju9
    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.n != null) {
            for (int i = 0; i < this.n.getCount(); i++) {
                if (this.n.getItem(i) instanceof iu9) {
                    ((iu9) this.n.getItem(i)).Q0();
                }
            }
        }
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f) {
                return getPageContext().getString(R.string.obfuscated_res_0x7f0f1089);
            }
            return String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f1088), y1());
        }
        return (String) invokeV.objValue;
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            zaa.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, zaa.a("c/u/feed/userpost", 303002));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.a);
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onSaveInstanceState(getPageContext().getPageActivity());
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onDestory(getPageContext());
            }
            try {
                PersonExtraStatic.f();
                super.onDestroy();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.q);
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStart();
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStop();
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onStop(getPageContext());
            }
        }
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void A1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.p = TbadkCoreApplication.getInst().getSkinType();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.my_post));
            View view2 = (View) this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
            this.h = view2;
            view2.setOnClickListener(new a(this));
            RelativeLayout relativeLayout = (RelativeLayout) this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d07f4, (View.OnClickListener) null);
            this.i = relativeLayout;
            relativeLayout.setOnClickListener(new b(this));
            this.j = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092760);
            this.k = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f09122a);
            if (SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            this.l = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f091c22);
            this.b = new int[]{0, 1};
            this.n = new PersonPostAdapter(this);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f092347);
            this.m = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.m.setOnPageChangeListener(this);
            this.m.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07019a));
            this.m.getFragmentTabWidget().setDviderRectWidth(BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070258));
            initTabSpec();
            ((RelativeLayout.LayoutParams) this.m.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070420), 0, 0);
            if (bundle != null) {
                this.a = bundle.getInt("CurrTabIndex");
            } else {
                this.a = 0;
            }
            this.m.setCurrentTab(this.a);
        }
    }

    public final void initTabSpec() {
        PersonPostAdapter personPostAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (personPostAdapter = this.n) != null) {
            int count = personPostAdapter.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.n.getItem(i);
                int b2 = this.n.b(i);
                if (item != null) {
                    if (b2 == 0) {
                        u1(item, 0, getPageContext().getString(R.string.person_post_thread_new));
                    } else if (b2 == 1) {
                        u1(item, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f1223));
                    }
                }
            }
            this.m.l();
        }
    }

    @Override // com.baidu.tieba.hu9
    public void m0(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || (imageView = this.k) == null) {
            return;
        }
        if (z && imageView.getVisibility() == 8) {
            this.k.setVisibility(0);
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
        } else if (!z && this.k.getVisibility() == 0) {
            this.k.setVisibility(8);
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && i >= 0 && i < 2 && i != this.a) {
            this.a = i;
            int[] iArr = this.b;
            if (iArr[i] == 0) {
                Context context = getPageContext().getContext();
                if (this.f) {
                    str2 = "pp_my_thread";
                } else {
                    str2 = "pp_his_thread";
                }
                TiebaStatic.eventStat(context, str2, "click", 1, new Object[0]);
            } else if (iArr[i] == 1) {
                Context context2 = getPageContext().getContext();
                if (this.f) {
                    str = "pp_my_reply";
                } else {
                    str = "pp_his_reply";
                }
                TiebaStatic.eventStat(context2, str, "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        PersonPostAdapter personPostAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) && (personPostAdapter = this.n) != null) {
            int count = personPostAdapter.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.n.getItem(i3);
                if (item instanceof PersonThreadFragment) {
                    item.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g.onChangeSkinType(getPageContext(), i);
            this.l.onChangeSkinType(getPageContext(), i);
            this.m.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.m.s(i);
            if (this.m.getFragmentTabWidget() != null) {
                SkinManager.setBackgroundColor(this.m.getFragmentTabWidget(), R.color.CAM_X0201);
            }
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            this.k.setImageDrawable(SkinManager.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
            PersonPostAdapter personPostAdapter = this.n;
            if (personPostAdapter != null) {
                int count = personPostAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.n.getItem(i2);
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
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            z1();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e21);
            }
            setContentView(R.layout.obfuscated_res_0x7f0d07ee);
            VoiceManager z0 = z0();
            this.o = z0;
            if (z0 != null) {
                z0.onCreate(getPageContext());
            }
            this.e = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
            this.c = getIntent().getStringExtra("key_uid");
            getIntent().getIntExtra("key_sex", 0);
            String str = this.c;
            if (str == null) {
                str = "";
            }
            this.c = str;
            if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f0c56);
                this.f = true;
            } else {
                int intExtra = getIntent().getIntExtra("key_sex", 0);
                if (intExtra != 1) {
                    if (intExtra != 2) {
                        this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f15ad);
                    } else {
                        this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f13c9);
                    }
                } else {
                    this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f09ab);
                }
            }
            TbadkCoreApplication.isMyLive = false;
            if (this.c == null) {
                finish();
            } else {
                A1(bundle);
            }
        }
    }

    public final void u1(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048595, this, fragment, i, str) != null) || fragment == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        cVar.c = fragment;
        cVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.b = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        cVar.b = fragmentTabIndicator;
        this.m.b(cVar);
    }
}
