package com.baidu.tieba;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ly4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public FragmentTabHost b;
    public final rg<hn> c;

    /* loaded from: classes5.dex */
    public class a extends rg<hn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly4 a;

        public a(ly4 ly4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ly4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(hn hnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, hnVar, str, i) == null) {
                super.onLoaded((a) hnVar, str, i);
                if (this.a.b == null || hnVar == null || !hnVar.w()) {
                    this.a.f();
                    return;
                }
                FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
                CustomViewPager fragmentViewPager = this.a.b.getFragmentViewPager();
                ViewGroup tabWrapper = this.a.b.getTabWrapper();
                if (fragmentTabWidget != null && fragmentViewPager != null) {
                    this.a.b.setNeedShowThemeStyle(false);
                    fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
                    SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
                    SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                    layoutParams.bottomMargin = xi.g(this.a.b.getContext(), R.dimen.tbds100);
                    fragmentViewPager.setLayoutParams(layoutParams);
                    fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(hnVar.p()));
                }
            }
        }
    }

    public ly4(FragmentTabHost fragmentTabHost, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentTabHost, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = new a(this);
        this.b = fragmentTabHost;
        this.a = i;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            sg.h().m(str, 10, this.c, c());
        }
    }

    public final BdUniqueId c() {
        InterceptResult invokeV;
        r9<?> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabHost fragmentTabHost = this.b;
            if (fragmentTabHost != null && fragmentTabHost.getContext() != null && (a2 = w9.a(this.b.getContext())) != null) {
                return a2.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void e(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) == null) && pair != null) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            boolean z = true;
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                z = false;
            }
            if (z && !TextUtils.isEmpty(str2)) {
                d(str2);
            } else if (!TextUtils.isEmpty(str)) {
                d(str);
            } else {
                f();
            }
        }
    }

    public final void f() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (fragmentTabHost = this.b) != null && fragmentTabHost.getFragmentTabWidget() != null) {
            this.b.getFragmentTabWidget().setBackGroundDrawableResId(this.a);
            SkinManager.setBackgroundColor(this.b.getFragmentTabWidget(), this.a);
            SkinManager.setBackgroundColor(this.b.getTabWrapper(), this.a);
        }
    }
}
