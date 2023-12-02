package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.lu4;
import com.baidu.tieba.myCollection.CollectTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class rp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentTabHost a;
    public int b;
    public Fragment c;
    public final NavigationBar d;
    public final NoNetworkView e;
    public CollectTabActivity f;
    public boolean g;
    public List h;
    @NonNull
    public final d i;
    public final lu4.d j;
    public ViewPager.OnPageChangeListener k;

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;
        public final TextView c;
        public final ImageView d;
        public final /* synthetic */ rp9 e;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    UrlManager.getInstance().dealOneLink(this.a.b);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.e.d(false);
                    this.a.e.f.setSwipeBackEnabled(true);
                    this.a.f();
                }
            }
        }

        public d(@NonNull rp9 rp9Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp9Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rp9Var;
            this.a = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-usercenter/userPermission?permission=collect&customfullscreen=1&nonavigationbar=1";
            this.b = c();
            this.c = (TextView) view2.findViewById(R.id.right_textview);
            this.d = (ImageView) view2.findViewById(R.id.navigationBarBtnMore);
            d();
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setNavbarTitleColor(this.c, R.color.navi_op_text, R.color.navi_op_text_skin);
            }
        }

        @NonNull
        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", this.a);
                hashMap.put("openType", 1);
                hashMap.put("disableLoading", 1);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("page", "h5/openWebView");
                hashMap2.put(YunDialogManager.PAGE_PARAMS_KEY, hashMap);
                return UrlUtils.appendParam("tiebaapp://router/portal", "params", dx.a(DataExt.toJson(hashMap2)));
            }
            return (String) invokeV.objValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f();
                e(TbadkCoreApplication.getInst().getSkinType());
                this.c.setText(R.string.obfuscated_res_0x7f0f05bc);
                this.d.setOnClickListener(new a(this));
                this.c.setOnClickListener(new b(this));
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.d.setVisibility(0);
                this.c.setVisibility(8);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.d.setVisibility(8);
                this.c.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements lu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp9 a;

        @Override // com.baidu.tieba.lu4.d
        @NonNull
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "myCollectDeleteOn" : (String) invokeV.objValue;
        }

        public a(rp9 rp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp9Var;
        }

        @Override // com.baidu.tieba.lu4.c
        public void a(@NonNull String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("deleteOn") == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.a.d(true);
                        this.a.f.setSwipeBackEnabled(false);
                        this.a.i.g();
                    }
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp9 a;

        public b(rp9 rp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.j()) {
                    BdUtilHelper.showToast(this.a.f, "请先退出编辑状态");
                } else if (this.a.f != null) {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp9 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public c(rp9 rp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp9Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.o(i);
            this.a.d(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public rp9(CollectTabActivity collectTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collectTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.g = false;
        this.j = new a(this);
        this.k = new c(this);
        this.f = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.obfuscated_res_0x7f09246b);
        this.a = fragmentTabHost;
        fragmentTabHost.setup(this.f.getSupportFragmentManager());
        this.a.setOnPageChangeListener(this.k);
        this.d = (NavigationBar) this.f.findViewById(R.id.navigation_bar);
        this.e = (NoNetworkView) this.f.findViewById(R.id.view_no_network);
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.d.setCenterTextTitle(this.f.getPageContext().getString(R.string.my_mark));
        this.i = new d(this, this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d021c, this.f));
        this.d.onChangeSkinType(this.f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        k(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i.c.setEnabled(z);
            if (!z) {
                this.g = false;
                this.f.setSwipeBackEnabled(true);
                this.i.f();
            }
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            FragmentTabHost.c g = this.a.g(i);
            this.b = g.a;
            this.c = g.c;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.c;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.I2()) {
                    z = false;
                }
                n(collectFragment.I2());
                i = collectFragment.G2();
            } else {
                i = -1;
            }
            this.g = z;
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = R.color.navi_op_text;
            if (skinType != 2) {
                TextView textView = this.i.c;
                if (this.g) {
                    i2 = R.color.CAM_X0302;
                }
                SkinManager.setNavbarTitleColor(textView, i2, R.color.navi_op_text_skin);
            } else {
                SkinManager.setNavbarTitleColor(this.i.c, R.color.navi_op_text, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.g);
            bundle.putInt("fragment_type", i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public void i(ArrayList<FragmentDelegate> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            this.h = arrayList;
            this.a.s();
            for (int i = 0; i < arrayList.size(); i++) {
                FragmentDelegate fragmentDelegate = arrayList.get(i);
                if (fragmentDelegate != null && fragmentDelegate.isAvailable()) {
                    e(fragmentDelegate, (FragmentTabIndicator) fragmentDelegate.getTabIndicator(this.f.getPageContext().getPageActivity()));
                }
            }
            this.a.j(0);
            this.a.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.a.getFragmentTabWidget().setVisibility(8);
            }
            o(0);
        }
    }

    public final void e(FragmentDelegate fragmentDelegate, FragmentTabIndicator fragmentTabIndicator) {
        FragmentTabStructure fragmentTabStructure;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentDelegate, fragmentTabIndicator) != null) || (fragmentTabStructure = fragmentDelegate.getFragmentTabStructure()) == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        cVar.c = fragmentTabStructure.frag;
        cVar.a = fragmentTabStructure.type;
        fragmentTabIndicator.setText(fragmentTabStructure.textResId);
        fragmentTabIndicator.setTextSize(0, this.f.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        cVar.b = fragmentTabIndicator;
        cVar.d = fragmentDelegate;
        this.a.b(cVar);
    }

    public Fragment f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (Fragment) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ListUtils.getCount(this.h);
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            lu4.a().c(this.j);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            lu4.a().e(this.j);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.r(i);
            this.i.e(i);
            if (this.a.getTabWrapper() != null) {
                if (h() <= 1) {
                    this.a.getTabWrapper().setVisibility(8);
                } else {
                    this.a.getTabWrapper().setVisibility(0);
                }
            }
            this.d.onChangeSkinType(this.f.getPageContext(), i);
            this.e.onChangeSkinType(this.f.getPageContext(), i);
        }
    }
}
