package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xj0 implements bk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ak0 f;
    public final dk0 g;
    public final ek0 h;

    public xj0() {
        dk0 dk0Var;
        ek0 ek0Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = tj0.c().a();
        synchronized (tj0.class) {
            dk0Var = (dk0) ServiceManager.getService(dk0.b);
            dk0Var = dk0Var == null ? dk0.c : dk0Var;
        }
        this.g = dk0Var;
        synchronized (tj0.class) {
            ek0Var = (ek0) ServiceManager.getService(ek0.d);
            ek0Var = ek0Var == null ? ek0.e : ek0Var;
        }
        this.h = ek0Var;
    }

    @Override // com.baidu.tieba.ak0
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f.A();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f.B();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ak0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f.b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f.c();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f.d();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f.e();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f.g();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f.h();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f.i();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ek0
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h.j();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ek0
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h.k();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f.l();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dk0
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g.m();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f.n();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ak0
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.f.o();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f.p();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String packageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.f.packageName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f.q();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.f.r();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.f.s();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.f.t();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ek0
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h.u();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    @NonNull
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f.v();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak0
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f.w();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ek0
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.h.x();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ek0
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.h.y();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ek0
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.h.z();
        }
        return (String) invokeV.objValue;
    }
}
