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
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.k45;
import com.baidu.tieba.zv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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

    public abstract BasePersonInfoAdapter B1(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String C1();

    public abstract String F1();

    public abstract String J1();

    public abstract String K1();

    public abstract String L1();

    public abstract String M1();

    public abstract int N1();

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
        }
    }

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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                if (basePersonInfoActivity.i && basePersonInfoActivity.m != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                    k45.g(this.a.getPageContext().getPageActivity(), 200, false);
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
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                basePersonInfoActivity.c = zv4.a(basePersonInfoActivity.N1()) % 3;
                int N1 = this.a.N1();
                if (N1 != 2) {
                    if (N1 != 3) {
                        if (N1 != 4) {
                            if (N1 != 5) {
                                str = "";
                            } else {
                                str = "friend";
                            }
                        } else {
                            str = "post";
                        }
                    } else {
                        str = "group";
                    }
                } else {
                    str = "like";
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", str);
                httpMessage.addParam("val", String.valueOf(this.a.c + 1));
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
                        zv4.c(this.a.N1(), BasePersonInfoActivity.t[this.a.c]);
                        SkinManager.setNavbarIconSrc(this.a.l, BasePersonInfoActivity.r[this.a.c], BasePersonInfoActivity.q[this.a.c]);
                        BasePersonInfoActivity basePersonInfoActivity = this.a;
                        basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity.getPageContext().getString(BasePersonInfoActivity.s[this.a.c]), R.drawable.icon_toast_info);
                        return;
                    }
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                BasePersonInfoActivity basePersonInfoActivity2 = this.a;
                basePersonInfoActivity2.showToast(basePersonInfoActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d1b));
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
        r = new int[]{R.drawable.icon_pop_key_all_bg_w, R.drawable.icon_pop_key_f_bg_w, R.drawable.icon_pop_key_d_bg_w};
        s = new int[]{R.string.info_privacy_all, R.string.info_privacy_friend, R.string.info_privacy_hide};
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

    public final void initTabSpec() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.o != null) {
            if (this.g) {
                i = 1;
            } else {
                i = 2;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.o.getItem(i2);
                int c2 = this.o.c(i2);
                String L1 = L1();
                if (c2 == 1) {
                    L1 = K1();
                }
                if (item != null) {
                    A1(item, c2, L1);
                }
            }
            this.n.k(3);
        }
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == 0) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public NavigationBar I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public String O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public String Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final void A1(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048576, this, fragment, i, str) != null) || fragment == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        cVar.c = fragment;
        cVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setMinimumHeight(ii.g(getActivity(), R.dimen.obfuscated_res_0x7f070307));
        cVar.b = fragmentTabIndicator;
        this.n.b(cVar);
    }

    public final void R1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090353);
            this.k = navigationBar;
            if (this.i) {
                if (this.m == 23011) {
                    navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0ab3));
                } else {
                    navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f120e));
                }
            } else {
                navigationBar.setCenterTextTitle(String.format(J1(), this.e));
            }
            this.k.showBottomLine();
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (this.g && this.m != 23003 && !this.i) {
                ImageView imageView = (ImageView) this.k.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_privacy, (View.OnClickListener) null);
                this.l = imageView;
                SkinManager.setNavbarIconSrc(imageView, r[zv4.a(N1()) - 1], q[zv4.a(N1()) - 1]);
                this.l.setOnClickListener(new b(this));
            }
            this.b = new int[]{0, 1};
            this.o = B1(this, this.g);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f090354);
            this.n = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.n.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
            this.n.setOnPageChangeListener(this);
            this.n.t();
            initTabSpec();
            if (this.g) {
                this.n.getTabWrapper().setVisibility(8);
            }
            this.n.setCurrentTab(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002c);
            if (bundle != null) {
                this.d = bundle.getString("key_uid");
                this.f = bundle.getInt("key_sex", 0);
                this.h = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
                this.a = bundle.getInt(PersonBarActivityConfig.KEY_CURRENT_TAB, 0);
                this.m = bundle.getInt(PersonBarActivityConfig.REQUEST_CODE, 0);
                this.i = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
                this.j = bundle.getString("bar_id");
            } else if (getIntent() != null) {
                this.d = getIntent().getStringExtra("key_uid");
                this.f = getIntent().getIntExtra("key_sex", 0);
                this.a = getIntent().getIntExtra(PersonBarActivityConfig.KEY_CURRENT_TAB, 0);
                this.m = getIntent().getIntExtra(PersonBarActivityConfig.REQUEST_CODE, 0);
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
                this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f0b71);
                this.g = true;
            } else {
                this.g = false;
                int i = this.f;
                if (i != 1) {
                    if (i != 2) {
                        this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f1435);
                    } else {
                        this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f1254);
                    }
                } else {
                    this.e = getPageContext().getString(R.string.obfuscated_res_0x7f0f08e3);
                }
            }
            if (hi.isEmpty(this.d)) {
                finish();
                return;
            }
            R1(bundle);
            registerListener(this.p);
        }
    }

    public void T1(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) && !this.g && this.o != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.n.h(0).b;
            if (i <= 0) {
                fragmentTabIndicator.setText(L1());
            } else {
                fragmentTabIndicator.setText(String.format(M1(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.n.h(1).b;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(K1());
            } else {
                fragmentTabIndicator2.setText(String.format(C1(), Integer.valueOf(i2)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i) == null) && i >= 0 && i < 2 && i != this.a) {
            this.a = i;
            if (!this.g && this.b[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), F1(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.a);
            bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.h);
            if (this.i && this.m != 23011) {
                MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.FALSE));
                finish();
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, keyEvent)) == null) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                if (this.i && this.m != 23011) {
                    k45.g(getPageContext().getPageActivity(), 200, false);
                }
                finish();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
