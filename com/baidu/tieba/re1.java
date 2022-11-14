package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.mg1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class re1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static mg1 a(@NonNull ve1 ve1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ve1Var)) == null) {
            mg1.b bVar = new mg1.b(ve1Var.f(), ve1Var.g);
            bVar.t("rsplash");
            boolean z3 = false;
            if (ve1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.m(c());
            if (ve1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.o(z2);
            bVar.n(d(ve1Var.m));
            bVar.B(ve1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(ve1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(ve1Var.z);
            if (ve1Var.A == 1) {
                z3 = true;
            }
            bVar.w(z3);
            bVar.b(ve1Var.B);
            bVar.p(ve1Var.e());
            bVar.r("跳转详情页或第三方应用");
            if (ve1Var.h()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.s(b);
            bVar.j(ve1Var.H);
            bVar.l(ve1Var.G);
            bVar.k(ve1Var.d());
            bVar.v(ve1Var.M);
            bVar.u(ve1Var.N);
            return bVar.a();
        }
        return (mg1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return he1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return he1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return he1.a().h();
            }
            return he1.a().g();
        }
        return invokeI.intValue;
    }
}
