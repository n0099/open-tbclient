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
public class xr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final or8 b;
    public p56 c;
    public p56 d;
    public p56 e;

    public xr8(MainTabActivity mainTabActivity, or8 or8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, or8Var};
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
        this.b = or8Var;
    }

    public void a() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p56Var = this.e) != null && p56Var.i()) {
            this.e.h();
        }
    }

    public void b() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (p56Var = this.d) != null && p56Var.i()) {
            this.d.h();
            this.d = null;
        }
    }

    public void c() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (p56Var = this.c) != null && p56Var.i()) {
            this.c.h();
            this.c = null;
        }
    }

    public void d() {
        or8 or8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (or8Var = this.b) != null && or8Var.B() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            p56 p56Var = new p56(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = p56Var;
            p56Var.L(R.drawable.obfuscated_res_0x7f0802ee);
            this.e.l(2);
            this.e.o(32);
            this.e.M(true);
            this.e.Q(-xi.g(this.a, R.dimen.tbds10));
            this.e.C(R.color.CAM_X0101);
            this.e.p(R.dimen.tbds54);
            this.e.w(1);
            this.e.n(4000);
            this.e.F(xi.g(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            p56 p56Var = new p56(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = p56Var;
            p56Var.L(R.drawable.obfuscated_res_0x7f0802ee);
            this.c.l(2);
            this.c.o(32);
            this.c.M(true);
            this.c.Q(-xi.g(this.a, R.dimen.tbds10));
            this.c.C(R.color.CAM_X0101);
            this.c.p(R.dimen.tbds54);
            this.c.w(999);
            this.c.n(5000);
            this.c.F(xi.g(this.a, R.dimen.tbds44));
            this.c.U(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (p56Var = this.e) != null && !p56Var.i()) {
            p56 p56Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f059d);
            p56Var2.S(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
