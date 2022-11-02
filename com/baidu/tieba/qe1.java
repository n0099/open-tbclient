package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.lg1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qe1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static lg1 a(@NonNull ue1 ue1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ue1Var)) == null) {
            lg1.b bVar = new lg1.b(ue1Var.f(), ue1Var.g);
            bVar.t("rsplash");
            boolean z3 = false;
            if (ue1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.m(c());
            if (ue1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.o(z2);
            bVar.n(d(ue1Var.m));
            bVar.B(ue1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(ue1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(ue1Var.z);
            if (ue1Var.A == 1) {
                z3 = true;
            }
            bVar.w(z3);
            bVar.b(ue1Var.B);
            bVar.p(ue1Var.e());
            bVar.r("跳转详情页或第三方应用");
            if (ue1Var.h()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.s(b);
            bVar.j(ue1Var.H);
            bVar.l(ue1Var.G);
            bVar.k(ue1Var.d());
            bVar.v(ue1Var.M);
            bVar.u(ue1Var.N);
            return bVar.a();
        }
        return (lg1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return ge1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ge1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return ge1.a().h();
            }
            return ge1.a().g();
        }
        return invokeI.intValue;
    }
}
