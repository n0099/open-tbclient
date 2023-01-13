package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.qg1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ve1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static qg1 a(@NonNull ze1 ze1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ze1Var)) == null) {
            qg1.b bVar = new qg1.b(ze1Var.f(), ze1Var.g);
            bVar.t("rsplash");
            boolean z3 = false;
            if (ze1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.m(c());
            if (ze1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.o(z2);
            bVar.n(d(ze1Var.m));
            bVar.B(ze1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(ze1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(ze1Var.z);
            if (ze1Var.A == 1) {
                z3 = true;
            }
            bVar.w(z3);
            bVar.b(ze1Var.B);
            bVar.p(ze1Var.e());
            bVar.r("跳转详情页或第三方应用");
            if (ze1Var.h()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.s(b);
            bVar.j(ze1Var.H);
            bVar.l(ze1Var.G);
            bVar.k(ze1Var.d());
            bVar.v(ze1Var.M);
            bVar.u(ze1Var.N);
            return bVar.a();
        }
        return (qg1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return le1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return le1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return le1.a().h();
            }
            return le1.a().g();
        }
        return invokeI.intValue;
    }
}
