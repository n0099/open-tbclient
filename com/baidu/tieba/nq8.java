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
/* loaded from: classes5.dex */
public class nq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final eq8 b;
    public e46 c;
    public e46 d;
    public e46 e;

    public nq8(MainTabActivity mainTabActivity, eq8 eq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, eq8Var};
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
        this.b = eq8Var;
    }

    public void a() {
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (e46Var = this.e) != null && e46Var.i()) {
            this.e.h();
        }
    }

    public void b() {
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (e46Var = this.d) != null && e46Var.i()) {
            this.d.h();
            this.d = null;
        }
    }

    public void c() {
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (e46Var = this.c) != null && e46Var.i()) {
            this.c.h();
            this.c = null;
        }
    }

    public void d() {
        eq8 eq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (eq8Var = this.b) != null && eq8Var.B() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            e46 e46Var = new e46(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = e46Var;
            e46Var.L(R.drawable.obfuscated_res_0x7f0802ee);
            this.e.l(2);
            this.e.o(32);
            this.e.M(true);
            this.e.Q(-fj.f(this.a, R.dimen.tbds10));
            this.e.C(R.color.CAM_X0101);
            this.e.p(R.dimen.tbds54);
            this.e.w(1);
            this.e.n(4000);
            this.e.F(fj.f(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            e46 e46Var = new e46(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = e46Var;
            e46Var.L(R.drawable.obfuscated_res_0x7f0802ee);
            this.c.l(2);
            this.c.o(32);
            this.c.M(true);
            this.c.Q(-fj.f(this.a, R.dimen.tbds10));
            this.c.C(R.color.CAM_X0101);
            this.c.p(R.dimen.tbds54);
            this.c.w(999);
            this.c.n(5000);
            this.c.F(fj.f(this.a, R.dimen.tbds44));
            this.c.U(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (e46Var = this.e) != null && !e46Var.i()) {
            e46 e46Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f059a);
            e46Var2.S(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
