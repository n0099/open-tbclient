package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.fl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static fl1 a(@NonNull xj1 xj1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, xj1Var)) == null) {
            fl1.b bVar = new fl1.b(xj1Var.j(), xj1Var.g);
            bVar.u("rsplash");
            boolean z3 = false;
            if (xj1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.n(c());
            if (xj1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.p(z2);
            bVar.o(d(xj1Var.m));
            bVar.D(xj1Var.n * 1000);
            bVar.B(1);
            bVar.G(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.z(false);
            bVar.c(xj1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.C(72);
            bVar.A(30);
            bVar.F(68);
            bVar.E(30);
            bVar.h(17);
            bVar.r(xj1Var.z);
            if (xj1Var.A == 1) {
                z3 = true;
            }
            bVar.y(z3);
            bVar.b(xj1Var.B);
            bVar.q(xj1Var.f());
            bVar.s("跳转详情页或第三方应用");
            if (xj1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.t(b);
            bVar.k(xj1Var.H);
            bVar.m(xj1Var.G);
            bVar.l(xj1Var.e());
            bVar.j(xj1Var.X);
            bVar.x(xj1Var.i());
            bVar.w(xj1Var.h());
            bVar.v(xj1Var.g());
            return bVar.a();
        }
        return (fl1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return jj1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return jj1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return jj1.a().h();
            }
            return jj1.a().g();
        }
        return invokeI.intValue;
    }
}
