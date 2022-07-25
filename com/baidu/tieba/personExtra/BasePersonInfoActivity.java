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
import com.repackage.gn4;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.tt4;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] q;
    public static final int[] r;
    public static final int[] s;
    public static final int[] t;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int c;
    public String d;
    public String e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public String j;
    public NavigationBar k;
    public ImageView l;
    public int m;
    public FragmentTabHost n;
    public BasePersonInfoAdapter o;
    public HttpMessageListener p;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                if (basePersonInfoActivity.i && basePersonInfoActivity.m != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                    tt4.g(this.a.getPageContext().getPageActivity(), 200, false);
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                basePersonInfoActivity.c = gn4.a(basePersonInfoActivity.P0()) % 3;
                int P0 = this.a.P0();
                String str = P0 != 2 ? P0 != 3 ? P0 != 4 ? P0 != 5 ? "" : "friend" : "post" : "group" : "like";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", str);
                httpMessage.addParam("val", String.valueOf(this.a.c + 1));
                this.a.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        gn4.c(this.a.P0(), BasePersonInfoActivity.t[this.a.c]);
                        SkinManager.setNavbarIconSrc(this.a.l, BasePersonInfoActivity.r[this.a.c], BasePersonInfoActivity.q[this.a.c]);
                        BasePersonInfoActivity basePersonInfoActivity = this.a;
                        basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity.getPageContext().getString(BasePersonInfoActivity.s[this.a.c]), R.drawable.obfuscated_res_0x7f080a85);
                        return;
                    }
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                BasePersonInfoActivity basePersonInfoActivity2 = this.a;
                basePersonInfoActivity2.showToast(basePersonInfoActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c17));
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
        q = new int[]{R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
        r = new int[]{R.drawable.obfuscated_res_0x7f0808c6, R.drawable.obfuscated_res_0x7f0808ca, R.drawable.obfuscated_res_0x7f0808c8};
        s = new int[]{R.string.obfuscated_res_0x7f0f08d8, R.string.obfuscated_res_0x7f0f08d9, R.string.obfuscated_res_0x7f0f08da};
        t = new int[]{1, 2, 3};
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
        this.a = -1;
        this.c = 0;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.j = "";
        this.p = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public abstract BasePersonInfoAdapter B0(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String C0();

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a == 0 ? 0 : 1 : invokeV.intValue;
    }

    public abstract String E0();

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : invokeV.intValue;
    }

    public NavigationBar H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (NavigationBar) invokeV.objValue;
    }

    public abstract String L0();

    public abstract String M0();

    public abstract String N0();

    public abstract String O0();

    public abstract int P0();

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f : invokeV.intValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final void V0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09032c);
            this.k = navigationBar;
            if (!this.i) {
                navigationBar.setCenterTextTitle(String.format(L0(), this.e));
            } else if (this.m == 23011) {
                navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f09d8));
            } else {
                navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f10f1));
            }
            this.k.showBottomLine();
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (this.g && this.m != 23003 && !this.i) {
                ImageView imageView = (ImageView) this.k.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08d8, (View.OnClickListener) null);
                this.l = imageView;
                SkinManager.setNavbarIconSrc(imageView, r[gn4.a(P0()) - 1], q[gn4.a(P0()) - 1]);
                this.l.setOnClickListener(new b(this));
            }
            this.b = new int[]{0, 1};
            this.o = B0(this, this.g);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f09032d);
            this.n = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.n.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
            this.n.setOnPageChangeListener(this);
            this.n.u();
            initTabSpec();
            if (this.g) {
                this.n.getTabWrapper().setVisibility(8);
            }
            this.n.setCurrentTab(this.a);
        }
    }

    public boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public void X0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) || this.g || this.o == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.n.j(0).b;
        if (i <= 0) {
            fragmentTabIndicator.setText(N0());
        } else {
            fragmentTabIndicator.setText(String.format(O0(), Integer.valueOf(i)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.n.j(1).b;
        if (i2 <= 0) {
            fragmentTabIndicator2.setText(M0());
        } else {
            fragmentTabIndicator2.setText(String.format(C0(), Integer.valueOf(i2)));
        }
    }

    public final void initTabSpec() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.o == null) {
            return;
        }
        int i = this.g ? 1 : 2;
        for (int i2 = 0; i2 < i; i2++) {
            Fragment item = this.o.getItem(i2);
            int c2 = this.o.c(i2);
            String N0 = N0();
            if (c2 == 1) {
                N0 = M0();
            }
            if (item != null) {
                z0(item, c2, N0);
            }
        }
        this.n.n(3);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.k.onChangeSkinType(getPageContext(), i);
            this.n.s(i);
            if (this.o != null) {
                for (int i2 = 0; i2 < this.o.getCount(); i2++) {
                    Fragment item = this.o.getItem(i2);
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
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002c);
            if (bundle != null) {
                this.d = bundle.getString("key_uid");
                this.f = bundle.getInt("key_sex", 0);
                this.h = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
                this.a = bundle.getInt("key_current_tab", 0);
                this.m = bundle.getInt("tb_request_code", 0);
                this.i = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
                this.j = bundle.getString("bar_id");
            } else if (getIntent() != null) {
                this.d = getIntent().getStringExtra("key_uid");
                this.f = getIntent().getIntExtra("key_sex", 0);
                this.a = getIntent().getIntExtra("key_current_tab", 0);
                this.m = getIntent().getIntExtra("tb_request_code", 0);
                this.i = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
                this.h = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
                this.j = getIntent().getStringExtra("bar_id");
            } else {
                finish();
            }
            String str = this.d;
            if (str == null) {
                str = "";
            }
            this.d = str;
            if (str.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f0a85);
                this.g = true;
            } else {
                this.g = false;
                int i = this.f;
                if (i == 1) {
                    this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f082b);
                } else if (i != 2) {
                    this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f1306);
                } else {
                    this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f1136);
                }
            }
            if (oi.isEmpty(this.d)) {
                finish();
                return;
            }
            V0(bundle);
            registerListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048597, this, i, keyEvent)) == null) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                if (this.i && this.m != 23011) {
                    tt4.g(getPageContext().getPageActivity(), 200, false);
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
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || i < 0 || i >= 2 || i == this.a) {
            return;
        }
        this.a = i;
        if (this.g || this.b[i] != 1) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getContext(), E0(), "click", 1, new Object[0]);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.a);
            bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.h);
            if (this.i && this.m != 23011) {
                MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                finish();
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public final void z0(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048602, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setMinimumHeight(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f070306));
        bVar.b = fragmentTabIndicator;
        this.n.c(bVar);
    }
}
