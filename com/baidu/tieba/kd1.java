package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.ff1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ff1 a(@NonNull od1 od1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, od1Var)) == null) {
            ff1.b bVar = new ff1.b(od1Var.e(), od1Var.g);
            bVar.t("rsplash");
            bVar.i(od1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(od1Var.f == 1);
            bVar.n(d(od1Var.m));
            bVar.B(od1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(od1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(od1Var.z);
            bVar.w(od1Var.A == 1);
            bVar.b(od1Var.B);
            bVar.p(od1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(od1Var.g() ? 47 : b() + 39);
            bVar.j(od1Var.H);
            bVar.l(od1Var.G);
            bVar.k(od1Var.I);
            bVar.v(od1Var.M);
            bVar.u(od1Var.N);
            return bVar.a();
        }
        return (ff1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? ad1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? ad1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return ad1.a().h();
            }
            return ad1.a().g();
        }
        return invokeI.intValue;
    }
}
