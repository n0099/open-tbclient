package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.e46;
import com.baidu.tieba.fv4;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class os8 extends fv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final eq8 d;
    public final String e;
    public e46 f;

    /* loaded from: classes5.dex */
    public class a implements e46.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os8 a;

        public a(os8 os8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os8Var;
        }

        @Override // com.baidu.tieba.e46.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os8(MainTabActivity mainTabActivity, eq8 eq8Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, eq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = eq8Var;
        this.c = mainTabActivity;
        this.e = this.b.getString(R.string.obfuscated_res_0x7f0f1423);
    }

    @Override // com.baidu.tieba.fv4
    public void b() {
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (e46Var = this.f) != null) {
            e46Var.h();
        }
    }

    @Override // com.baidu.tieba.fv4
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e46 e46Var = this.f;
            if (e46Var == null) {
                c();
                return;
            }
            e46Var.z(new a(this));
            this.f.V(this.e, "SendHelpTipTask", true, false);
        }
    }

    @Override // com.baidu.tieba.fv4
    public void d(fv4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            eq8 eq8Var = this.d;
            if (eq8Var != null && eq8Var.B() != null) {
                FragmentTabWidget fragmentTabWidget = this.d.B().getFragmentTabWidget();
                if (fragmentTabWidget != null && fragmentTabWidget.getChildCount() > 2) {
                    e46 e46Var = new e46(this.c.getPageContext(), fragmentTabWidget.getChildAt(2));
                    this.f = e46Var;
                    e46Var.s(false);
                    this.f.t(true);
                    this.f.L(R.drawable.obfuscated_res_0x7f0802f0);
                    this.f.l(2);
                    this.f.o(32);
                    this.f.M(true);
                    this.f.Q(-fj.f(this.b, R.dimen.tbds10));
                    this.f.P(-fj.f(this.b, R.dimen.tbds3));
                    this.f.C(R.color.CAM_X0101);
                    this.f.J(R.dimen.T_X09);
                    this.f.w(1);
                    this.f.n(4000);
                    this.f.q(R.dimen.tbds90);
                    int f = fj.f(this.b, R.dimen.obfuscated_res_0x7f070279);
                    this.f.E(f, 0, f, fj.f(this.b, R.dimen.obfuscated_res_0x7f0702f6));
                    this.f.A("SendHelpTipTask");
                }
                e46 e46Var2 = this.f;
                if (e46Var2 == null) {
                    aVar.a(false);
                    return;
                } else if (!e46Var2.d()) {
                    aVar.a(false);
                    return;
                } else {
                    this.f.c(this.e, "SendHelpTipTask", true, false, aVar);
                    return;
                }
            }
            aVar.a(false);
        }
    }
}
