package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.id1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static id1 a(@NonNull rb1 rb1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rb1Var)) == null) {
            id1.b bVar = new id1.b(rb1Var.e(), rb1Var.g);
            bVar.t("rsplash");
            bVar.i(rb1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(rb1Var.f == 1);
            bVar.n(d(rb1Var.m));
            bVar.B(rb1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(rb1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(rb1Var.z);
            bVar.w(rb1Var.A == 1);
            bVar.b(rb1Var.B);
            bVar.p(rb1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(rb1Var.g() ? 47 : b() + 39);
            bVar.j(rb1Var.H);
            bVar.l(rb1Var.G);
            bVar.k(rb1Var.I);
            bVar.v(rb1Var.M);
            bVar.u(rb1Var.N);
            return bVar.a();
        }
        return (id1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? db1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? db1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return db1.a().h();
            }
            return db1.a().g();
        }
        return invokeI.intValue;
    }
}
