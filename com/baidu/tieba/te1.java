package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.fg1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class te1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static fg1 a(@NonNull xe1 xe1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, xe1Var)) == null) {
            fg1.b bVar = new fg1.b(xe1Var.j(), xe1Var.g);
            bVar.u(IAdInterListener.AdProdType.PRODUCT_SPLASH);
            boolean z3 = false;
            if (xe1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.n(c());
            if (xe1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.p(z2);
            bVar.o(d(xe1Var.m));
            bVar.D(xe1Var.n * 1000);
            bVar.B(1);
            bVar.G(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.z(false);
            bVar.c(xe1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.C(72);
            bVar.A(30);
            bVar.F(68);
            bVar.E(30);
            bVar.h(17);
            bVar.r(xe1Var.z);
            if (xe1Var.A == 1) {
                z3 = true;
            }
            bVar.y(z3);
            bVar.b(xe1Var.B);
            bVar.q(xe1Var.f());
            bVar.s("跳转详情页或第三方应用");
            if (xe1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.t(b);
            bVar.k(xe1Var.H);
            bVar.m(xe1Var.G);
            bVar.l(xe1Var.e());
            bVar.j(xe1Var.X);
            bVar.x(xe1Var.i());
            bVar.w(xe1Var.h());
            bVar.v(xe1Var.g());
            return bVar.a();
        }
        return (fg1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return je1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return je1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return je1.a().h();
            }
            return je1.a().g();
        }
        return invokeI.intValue;
    }
}
