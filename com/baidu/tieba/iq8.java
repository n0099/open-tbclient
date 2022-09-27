package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.a46;
import com.baidu.tieba.qp8;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class iq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final xp8 b;
    public x36 c;
    public x36 d;
    public x36 e;
    public final b f;
    public final a g;
    public final c h;

    /* loaded from: classes4.dex */
    public static class a extends PriorityOrganizer.Task implements qp8.a {
        public static /* synthetic */ Interceptable $ic;
        public static final String o;
        public transient /* synthetic */ FieldHolder $fh;
        public f45 m;
        @Nullable
        public qp8.a.InterfaceC0398a n;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-710123428, "Lcom/baidu/tieba/iq8$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-710123428, "Lcom/baidu/tieba/iq8$a;");
                    return;
                }
            }
            o = "key_home_operate_dialog_" + TbConfig.getBigAppVersion();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xh5.b(this.m);
                qp8.a.InterfaceC0398a interfaceC0398a = this.n;
                if (interfaceC0398a != null) {
                    interfaceC0398a.a(this.m);
                }
            }
        }

        public final boolean H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !ox4.k().h(o, true) : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.qp8.a
        public void a(@Nullable qp8.a.InterfaceC0398a interfaceC0398a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0398a) == null) {
                this.n = interfaceC0398a;
            }
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (H()) {
                    ox4.k().u("key_home_operate_dialog_show", true);
                    return true;
                }
                f45 homeOperateData = TbSingleton.getInstance().getHomeOperateData();
                this.m = homeOperateData;
                if (homeOperateData != null && homeOperateData.c()) {
                    ox4.k().u("key_home_operate_dialog_show", false);
                } else {
                    ox4.k().u("key_home_operate_dialog_show", true);
                }
                return this.m != null;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (H()) {
                    return false;
                }
                xh5.b(this.m);
                if (this.m.c()) {
                    if (!TextUtils.isEmpty(this.m.a()) && this.m.a().contains("not_show")) {
                        ox4.k().u("key_home_operate_dialog_show", true);
                        ox4.k().u(o, false);
                        return false;
                    }
                    qp8.a.InterfaceC0398a interfaceC0398a = this.n;
                    if (interfaceC0398a != null) {
                        return interfaceC0398a.b();
                    }
                    return false;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends PriorityOrganizer.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public x36 m;
        public final /* synthetic */ iq8 n;

        /* loaded from: classes4.dex */
        public class a implements a46.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.a46.c
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.u();
                }
            }
        }

        public b(iq8 iq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = iq8Var;
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xh5.b(this.m);
                this.m.z0(this.n.a.getString(R.string.obfuscated_res_0x7f0f140d), "SendHelpTipTask", true, false);
                this.m.e0(new a(this));
            }
        }

        public final boolean H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !UbsABTestHelper.isHomeTabModifyABTestA() : invokeV.booleanValue;
        }

        public void I() {
            x36 x36Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (x36Var = this.m) == null) {
                return;
            }
            x36Var.N();
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (H()) {
                    return true;
                }
                if (this.n.b == null || this.n.b.B() == null) {
                    return false;
                }
                FragmentTabWidget fragmentTabWidget = this.n.b.B().getFragmentTabWidget();
                if (fragmentTabWidget.getChildCount() < 2) {
                    return false;
                }
                x36 x36Var = new x36(this.n.a.getPageContext(), fragmentTabWidget.getChildAt(2));
                this.m = x36Var;
                x36Var.X(false);
                this.m.Y(true);
                this.m.q0(R.drawable.obfuscated_res_0x7f0802f0);
                this.m.Q(2);
                this.m.T(32);
                this.m.r0(true);
                this.m.v0(-ej.f(this.n.a, R.dimen.tbds10));
                this.m.u0(-ej.f(this.n.a, R.dimen.tbds3));
                this.m.h0(R.color.CAM_X0101);
                this.m.o0(R.dimen.T_X09);
                this.m.b0(1);
                this.m.S(4000);
                this.m.V(R.dimen.tbds90);
                int f = ej.f(this.n.a, R.dimen.obfuscated_res_0x7f070279);
                this.m.j0(f, 0, f, ej.f(this.n.a, R.dimen.obfuscated_res_0x7f0702f6));
                this.m.f0("SendHelpTipTask");
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (H()) {
                    return false;
                }
                xh5.b(this.m);
                return this.m.L();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends PriorityOrganizer.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public a46 m;
        public final /* synthetic */ iq8 n;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    try {
                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                        if (skinType == 4) {
                            str = "&skin=dart";
                        } else if (skinType == 1) {
                            str = "&skin=night";
                        } else {
                            str = "";
                        }
                        UrlManager.getInstance().dealOneLink(this.a.n.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1" + str + "&from=2"});
                    } catch (Exception e) {
                        BdLog.e("openPageByUrl fail:" + e.toString());
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a46.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.a46.c
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.u();
                }
            }
        }

        public c(iq8 iq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = iq8Var;
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xh5.b(this.m);
                this.m.V(this.n.a.getString(R.string.obfuscated_res_0x7f0f140e), "setVirtualImage", true, false);
                this.m.M(new b(this));
            }
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.n.b == null || this.n.b.B() == null) {
                    return false;
                }
                FragmentTabWidget fragmentTabWidget = this.n.b.B().getFragmentTabWidget();
                if (fragmentTabWidget.getChildCount() >= 4 && g48.a().c()) {
                    a46 a46Var = new a46(this.n.a.getPageContext(), fragmentTabWidget.getChildAt(4));
                    this.m = a46Var;
                    a46Var.R(R.drawable.obfuscated_res_0x7f0802f1);
                    this.m.G(2);
                    this.m.J(48);
                    this.m.S(true);
                    this.m.T(-ej.f(this.n.a, R.dimen.tbds62));
                    this.m.P(R.color.CAM_X0101);
                    this.m.Q(R.dimen.T_X09);
                    this.m.L(1);
                    this.m.I(3000);
                    this.m.N("setVirtualImage");
                    this.m.H(new a(this));
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                xh5.b(this.m);
                return (g48.a().b() != 1) && this.m.C();
            }
            return invokeV.booleanValue;
        }
    }

    public iq8(MainTabActivity mainTabActivity, xp8 xp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, xp8Var};
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
        this.b = xp8Var;
        this.f = new b(this);
        this.g = new a();
        c cVar = new c(this);
        this.h = cVar;
        PriorityOrganizer.s(this.f, this.g, cVar);
    }

    public void c() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (x36Var = this.e) != null && x36Var.O()) {
            this.e.N();
        }
    }

    public void d() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (x36Var = this.d) != null && x36Var.O()) {
            this.d.N();
            this.d = null;
        }
    }

    public void e() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (x36Var = this.c) != null && x36Var.O()) {
            this.c.N();
            this.c = null;
        }
    }

    public void f() {
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (xp8Var = this.b) == null || xp8Var.B() == null) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        x36 x36Var = new x36(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
        this.e = x36Var;
        x36Var.q0(R.drawable.obfuscated_res_0x7f0802ee);
        this.e.Q(2);
        this.e.T(32);
        this.e.r0(true);
        this.e.v0(-ej.f(this.a, R.dimen.tbds10));
        this.e.h0(R.color.CAM_X0101);
        this.e.U(R.dimen.tbds54);
        this.e.b0(1);
        this.e.S(4000);
        this.e.k0(ej.f(this.a, R.dimen.tbds44));
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        x36 x36Var = new x36(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
        this.c = x36Var;
        x36Var.q0(R.drawable.obfuscated_res_0x7f0802ee);
        this.c.Q(2);
        this.c.T(32);
        this.c.r0(true);
        this.c.v0(-ej.f(this.a, R.dimen.tbds10));
        this.c.h0(R.color.CAM_X0101);
        this.c.U(R.dimen.tbds54);
        this.c.b0(999);
        this.c.S(5000);
        this.c.k0(ej.f(this.a, R.dimen.tbds44));
        this.c.z0(str, "categoryUpdate", false, true);
    }

    @NonNull
    public qp8.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : (qp8.a) invokeV.objValue;
    }

    @NonNull
    public b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (b) invokeV.objValue;
    }

    @NonNull
    public c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : (c) invokeV.objValue;
    }

    public void k() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (x36Var = this.e) == null || x36Var.O()) {
            return;
        }
        x36 x36Var2 = this.e;
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f0592);
        x36Var2.x0(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.d0().v(this.f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            hs8 hs8Var = new hs8(this.a.getPageContext(), this.b, this.a);
            PriorityOrganizer.s(hs8Var, new is8(this.a.getPageContext(), this.b, this.a), new js8(this.a.getPageContext(), this.b, this.a, false));
            this.a.d0().v(hs8Var);
        }
    }
}
