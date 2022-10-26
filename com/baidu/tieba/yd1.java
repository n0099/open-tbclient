package com.baidu.tieba;

import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.tf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tf1 a(ce1 ce1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ce1Var)) == null) {
            tf1.b bVar = new tf1.b(ce1Var.e(), ce1Var.g);
            bVar.t("rsplash");
            boolean z3 = false;
            if (ce1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.m(c());
            if (ce1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.o(z2);
            bVar.n(d(ce1Var.m));
            bVar.B(ce1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(ce1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(ce1Var.z);
            if (ce1Var.A == 1) {
                z3 = true;
            }
            bVar.w(z3);
            bVar.b(ce1Var.B);
            bVar.p(ce1Var.d());
            bVar.r("跳转详情页或第三方应用");
            if (ce1Var.g()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.s(b);
            bVar.j(ce1Var.H);
            bVar.l(ce1Var.G);
            bVar.k(ce1Var.I);
            bVar.v(ce1Var.M);
            bVar.u(ce1Var.N);
            return bVar.a();
        }
        return (tf1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return od1.a().b();
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return od1.a().c();
        }
        return invokeV.intValue;
    }

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return od1.a().h();
            }
            return od1.a().g();
        }
        return invokeI.intValue;
    }
}
