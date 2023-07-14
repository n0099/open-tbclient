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
/* loaded from: classes8.dex */
public class yfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final pfa b;
    public du6 c;
    public du6 d;
    public du6 e;

    public yfa(MainTabActivity mainTabActivity, pfa pfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
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
        this.b = pfaVar;
    }

    public void a() {
        du6 du6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (du6Var = this.e) != null && du6Var.i()) {
            this.e.h();
        }
    }

    public void b() {
        du6 du6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (du6Var = this.d) != null && du6Var.i()) {
            this.d.h();
            this.d = null;
        }
    }

    public void c() {
        du6 du6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (du6Var = this.c) != null && du6Var.i()) {
            this.c.h();
            this.c = null;
        }
    }

    public void d() {
        pfa pfaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pfaVar = this.b) != null && pfaVar.y() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            du6 du6Var = new du6(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = du6Var;
            du6Var.L(R.drawable.bg_tip_blue_down);
            this.e.l(2);
            this.e.o(32);
            this.e.N(true);
            this.e.R(-yi.g(this.a, R.dimen.tbds10));
            this.e.C(R.color.CAM_X0101);
            this.e.p(R.dimen.tbds54);
            this.e.w(1);
            this.e.n(4000);
            this.e.F(yi.g(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            du6 du6Var = new du6(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = du6Var;
            du6Var.L(R.drawable.bg_tip_blue_down);
            this.c.l(2);
            this.c.o(32);
            this.c.N(true);
            this.c.R(-yi.g(this.a, R.dimen.tbds10));
            this.c.C(R.color.CAM_X0101);
            this.c.p(R.dimen.tbds54);
            this.c.w(999);
            this.c.n(5000);
            this.c.F(yi.g(this.a, R.dimen.tbds44));
            this.c.V(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        du6 du6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (du6Var = this.e) != null && !du6Var.i()) {
            du6 du6Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f0672);
            du6Var2.T(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
