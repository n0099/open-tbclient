package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.sf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static sf1 a(@NonNull be1 be1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, be1Var)) == null) {
            sf1.b bVar = new sf1.b(be1Var.e(), be1Var.g);
            bVar.t("rsplash");
            bVar.i(be1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(be1Var.f == 1);
            bVar.n(d(be1Var.m));
            bVar.B(be1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(be1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(be1Var.z);
            bVar.w(be1Var.A == 1);
            bVar.b(be1Var.B);
            bVar.p(be1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(be1Var.g() ? 47 : b() + 39);
            bVar.j(be1Var.H);
            bVar.l(be1Var.G);
            bVar.k(be1Var.I);
            bVar.v(be1Var.M);
            bVar.u(be1Var.N);
            return bVar.a();
        }
        return (sf1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? nd1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? nd1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return nd1.a().h();
            }
            return nd1.a().g();
        }
        return invokeI.intValue;
    }
}
