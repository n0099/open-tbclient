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
import com.baidu.tieba.baa;
import com.baidu.tieba.dra;
import com.baidu.tieba.personExtra.PersonExtraStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.si;
import com.baidu.tieba.v9a;
import com.baidu.tieba.w9a;
import com.baidu.tieba.x9a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.j, x9a, v9a {
    public static /* synthetic */ Interceptable $ic;
    public static final String t;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public NavigationBar i;
    public View j;
    public RelativeLayout k;
    public TextView l;
    public ImageView m;
    public NoNetworkView n;
    public FragmentTabHost o;
    public PersonPostAdapter p;
    public VoiceManager q;
    public int r;
    public final CustomMessageListener s;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView J1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a080" : (String) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
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
                if (this.a.m.getVisibility() == 0) {
                    str = "1";
                } else {
                    str = "2";
                }
                TiebaStatic.log(param.param("obj_type", str).param("obj_locate", 1));
                this.a.W(false);
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{PersonPostActivity.t});
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
        t = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/recycle-station?noshare=1#/recycle-post";
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
        this.h = false;
        this.j = null;
        this.s = new c(this, 2016493);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public si onGetPreLoadListView() {
        InterceptResult invokeV;
        baa baaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PersonPostAdapter personPostAdapter = this.p;
            if (personPostAdapter != null) {
                PersonThreadFragment c2 = personPostAdapter.c();
                if (c2 != null) {
                    baaVar = c2.E2();
                } else {
                    baaVar = null;
                }
                if (baaVar != null && baaVar.f() != null) {
                    return baaVar.f().getPreLoadHandle();
                }
            }
            return null;
        }
        return (si) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            MessageManager.getInstance().registerListener(this.s);
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onResume(getPageContext());
            }
            if (this.r != TbadkCoreApplication.getInst().getSkinType()) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                this.r = skinType;
                onChangeSkinType(skinType);
            }
        }
    }

    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.h) {
                return getPageContext().getString(R.string.obfuscated_res_0x7f0f10cb);
            }
            return String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f10ca), t1());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x9a
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.p != null) {
            for (int i = 0; i < this.p.getCount(); i++) {
                if (this.p.getItem(i) instanceof w9a) {
                    ((w9a) this.p.getItem(i)).q1();
                }
            }
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            dra.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, dra.a("c/u/feed/userpost", 303002));
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
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.a);
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onSaveInstanceState(getPageContext().getPageActivity());
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.q == null) {
                this.q = VoiceManager.instance();
            }
            return this.q;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onDestory(getPageContext());
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.s);
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onStop(getPageContext());
            }
        }
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return TextUtils.equals(this.g, PersonPostActivityConfig.CALL_FROM_CREATIVE_WORK);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v9a
    public void W(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || (imageView = this.m) == null) {
            return;
        }
        if (z && imageView.getVisibility() == 8) {
            this.m.setVisibility(0);
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
        } else if (!z && this.m.getVisibility() == 0) {
            this.m.setVisibility(8);
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && i >= 0 && i < 2 && i != this.a) {
            this.a = i;
            int[] iArr = this.b;
            if (iArr[i] == 0) {
                Context context = getPageContext().getContext();
                if (this.h) {
                    str2 = "pp_my_thread";
                } else {
                    str2 = "pp_his_thread";
                }
                TiebaStatic.eventStat(context, str2, "click", 1, new Object[0]);
            } else if (iArr[i] == 1) {
                Context context2 = getPageContext().getContext();
                if (this.h) {
                    str = "pp_my_reply";
                } else {
                    str = "pp_his_reply";
                }
                TiebaStatic.eventStat(context2, str, "click", 1, new Object[0]);
            }
        }
    }

    public final void initTabSpec() {
        PersonPostAdapter personPostAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (personPostAdapter = this.p) != null) {
            int count = personPostAdapter.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.p.getItem(i);
                int b2 = this.p.b(i);
                if (item != null) {
                    if (b2 == 0) {
                        o1(item, 0, getPageContext().getString(R.string.person_post_thread_new));
                    } else if (b2 == 1) {
                        o1(item, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f126c));
                    }
                }
            }
            this.o.k();
        }
    }

    public final void o1(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048581, this, fragment, i, str) != null) || fragment == null) {
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
        this.o.b(cVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            PersonPostAdapter personPostAdapter = this.p;
            if (personPostAdapter != null) {
                int count = personPostAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    Fragment item = this.p.getItem(i3);
                    if (item instanceof PersonThreadFragment) {
                        item.onActivityResult(i, i2, intent);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.onChangeSkinType(getPageContext(), i);
            this.n.onChangeSkinType(getPageContext(), i);
            this.o.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.o.r(i);
            if (this.o.getFragmentTabWidget() != null) {
                SkinManager.setBackgroundColor(this.o.getFragmentTabWidget(), R.color.CAM_X0201);
            }
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            this.m.setImageDrawable(SkinManager.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
            PersonPostAdapter personPostAdapter = this.p;
            if (personPostAdapter != null) {
                int count = personPostAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.p.getItem(i2);
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            u1();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e61);
            }
            setContentView(R.layout.obfuscated_res_0x7f0d080e);
            VoiceManager X0 = X0();
            this.q = X0;
            if (X0 != null) {
                X0.onCreate(getPageContext());
            }
            this.e = getIntent().getStringExtra("key_portrait_url");
            this.f = getIntent().getStringExtra(PersonPostActivityConfig.KEY_NAV_TITLE);
            this.g = getIntent().getStringExtra("key_call_from");
            this.c = getIntent().getStringExtra("key_uid");
            getIntent().getIntExtra("key_sex", 0);
            String str = this.c;
            if (str == null) {
                str = "";
            }
            this.c = str;
            if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f0c94);
                this.h = true;
            } else {
                int intExtra = getIntent().getIntExtra("key_sex", 0);
                if (intExtra != 1) {
                    if (intExtra != 2) {
                        this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f15ff);
                    } else {
                        this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f1416);
                    }
                } else {
                    this.d = getPageContext().getString(R.string.obfuscated_res_0x7f0f09d4);
                }
            }
            TbadkCoreApplication.isMyLive = false;
            if (this.c == null) {
                finish();
            } else {
                w1(bundle);
            }
        }
    }

    public final void w1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            this.r = TbadkCoreApplication.getInst().getSkinType();
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.i = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.my_post));
            View view2 = (View) this.i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
            this.j = view2;
            view2.setOnClickListener(new a(this));
            RelativeLayout relativeLayout = (RelativeLayout) this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0814, (View.OnClickListener) null);
            this.k = relativeLayout;
            relativeLayout.setOnClickListener(new b(this));
            this.l = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0927e9);
            this.m = (ImageView) this.k.findViewById(R.id.obfuscated_res_0x7f09128a);
            if (SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            this.n = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f091ca2);
            this.b = new int[]{0, 1};
            this.p = new PersonPostAdapter(this);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f0923e7);
            this.o = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.o.setOnPageChangeListener(this);
            this.o.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07019a));
            this.o.getFragmentTabWidget().setDviderRectWidth(BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070258));
            initTabSpec();
            ((RelativeLayout.LayoutParams) this.o.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070420), 0, 0);
            if (bundle != null) {
                this.a = bundle.getInt("CurrTabIndex");
            } else {
                this.a = 0;
            }
            this.o.setCurrentTab(this.a);
            if (x1()) {
                this.i.setCenterTextTitle(this.f);
                this.o.setViewPagerScrollable(false);
                this.o.setTabWidgetViewHeight(0);
            }
        }
    }
}
