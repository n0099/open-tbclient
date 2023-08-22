package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.bl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static bl1 a(@NonNull tj1 tj1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tj1Var)) == null) {
            bl1.b bVar = new bl1.b(tj1Var.j(), tj1Var.g);
            bVar.u("rsplash");
            boolean z3 = false;
            if (tj1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.n(c());
            if (tj1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.p(z2);
            bVar.o(d(tj1Var.m));
            bVar.D(tj1Var.n * 1000);
            bVar.B(1);
            bVar.G(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.z(false);
            bVar.c(tj1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.C(72);
            bVar.A(30);
            bVar.F(68);
            bVar.E(30);
            bVar.h(17);
            bVar.r(tj1Var.z);
            if (tj1Var.A == 1) {
                z3 = true;
            }
            bVar.y(z3);
            bVar.b(tj1Var.B);
            bVar.q(tj1Var.f());
            bVar.s("跳转详情页或第三方应用");
            if (tj1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.t(b);
            bVar.k(tj1Var.H);
            bVar.m(tj1Var.G);
            bVar.l(tj1Var.e());
            bVar.j(tj1Var.X);
            bVar.x(tj1Var.i());
            bVar.w(tj1Var.h());
            bVar.v(tj1Var.g());
            return bVar.a();
        }
        return (bl1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return fj1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return fj1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return fj1.a().h();
            }
            return fj1.a().g();
        }
        return invokeI.intValue;
    }
}
