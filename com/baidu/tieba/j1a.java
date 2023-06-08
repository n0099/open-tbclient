package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final a1a b;
    public or6 c;
    public or6 d;
    public or6 e;

    public j1a(MainTabActivity mainTabActivity, a1a a1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, a1aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = a1aVar;
    }

    public void a() {
        or6 or6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (or6Var = this.e) != null && or6Var.i()) {
            this.e.h();
        }
    }

    public void b() {
        or6 or6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (or6Var = this.d) != null && or6Var.i()) {
            this.d.h();
            this.d = null;
        }
    }

    public void c() {
        or6 or6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (or6Var = this.c) != null && or6Var.i()) {
            this.c.h();
            this.c = null;
        }
    }

    public void d() {
        a1a a1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (a1aVar = this.b) != null && a1aVar.y() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            or6 or6Var = new or6(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = or6Var;
            or6Var.L(R.drawable.bg_tip_blue_down);
            this.e.l(2);
            this.e.o(32);
            this.e.N(true);
            this.e.R(-vi.g(this.a, R.dimen.tbds10));
            this.e.C(R.color.CAM_X0101);
            this.e.p(R.dimen.tbds54);
            this.e.w(1);
            this.e.n(4000);
            this.e.F(vi.g(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            or6 or6Var = new or6(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = or6Var;
            or6Var.L(R.drawable.bg_tip_blue_down);
            this.c.l(2);
            this.c.o(32);
            this.c.N(true);
            this.c.R(-vi.g(this.a, R.dimen.tbds10));
            this.c.C(R.color.CAM_X0101);
            this.c.p(R.dimen.tbds54);
            this.c.w(999);
            this.c.n(5000);
            this.c.F(vi.g(this.a, R.dimen.tbds44));
            this.c.V(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        or6 or6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (or6Var = this.e) != null && !or6Var.i()) {
            or6 or6Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f0665);
            or6Var2.T(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
