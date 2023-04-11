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
public class so9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final jo9 b;
    public ak6 c;
    public ak6 d;
    public ak6 e;

    public so9(MainTabActivity mainTabActivity, jo9 jo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, jo9Var};
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
        this.b = jo9Var;
    }

    public void a() {
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ak6Var = this.e) != null && ak6Var.e()) {
            this.e.d();
        }
    }

    public void b() {
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ak6Var = this.d) != null && ak6Var.e()) {
            this.d.d();
            this.d = null;
        }
    }

    public void c() {
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ak6Var = this.c) != null && ak6Var.e()) {
            this.c.d();
            this.c = null;
        }
    }

    public void d() {
        jo9 jo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jo9Var = this.b) != null && jo9Var.y() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            ak6 ak6Var = new ak6(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = ak6Var;
            ak6Var.C(R.drawable.bg_tip_blue_down);
            this.e.h(2);
            this.e.k(32);
            this.e.E(true);
            this.e.I(-ii.g(this.a, R.dimen.tbds10));
            this.e.t(R.color.CAM_X0101);
            this.e.l(R.dimen.tbds54);
            this.e.p(1);
            this.e.j(4000);
            this.e.w(ii.g(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            ak6 ak6Var = new ak6(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = ak6Var;
            ak6Var.C(R.drawable.bg_tip_blue_down);
            this.c.h(2);
            this.c.k(32);
            this.c.E(true);
            this.c.I(-ii.g(this.a, R.dimen.tbds10));
            this.c.t(R.color.CAM_X0101);
            this.c.l(R.dimen.tbds54);
            this.c.p(999);
            this.c.j(5000);
            this.c.w(ii.g(this.a, R.dimen.tbds44));
            this.c.M(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ak6Var = this.e) != null && !ak6Var.e()) {
            ak6 ak6Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f05bd);
            ak6Var2.K(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
