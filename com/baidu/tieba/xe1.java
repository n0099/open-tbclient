package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.jg1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xe1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static jg1 a(@NonNull bf1 bf1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bf1Var)) == null) {
            jg1.b bVar = new jg1.b(bf1Var.j(), bf1Var.g);
            bVar.u(IAdInterListener.AdProdType.PRODUCT_SPLASH);
            boolean z3 = false;
            if (bf1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.n(c());
            if (bf1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.p(z2);
            bVar.o(d(bf1Var.m));
            bVar.D(bf1Var.n * 1000);
            bVar.B(1);
            bVar.G(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.z(false);
            bVar.c(bf1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.C(72);
            bVar.A(30);
            bVar.F(68);
            bVar.E(30);
            bVar.h(17);
            bVar.r(bf1Var.z);
            if (bf1Var.A == 1) {
                z3 = true;
            }
            bVar.y(z3);
            bVar.b(bf1Var.B);
            bVar.q(bf1Var.f());
            bVar.s("跳转详情页或第三方应用");
            if (bf1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.t(b);
            bVar.k(bf1Var.H);
            bVar.m(bf1Var.G);
            bVar.l(bf1Var.e());
            bVar.j(bf1Var.X);
            bVar.x(bf1Var.i());
            bVar.w(bf1Var.h());
            bVar.v(bf1Var.g());
            return bVar.a();
        }
        return (jg1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return ne1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ne1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return ne1.a().h();
            }
            return ne1.a().g();
        }
        return invokeI.intValue;
    }
}
