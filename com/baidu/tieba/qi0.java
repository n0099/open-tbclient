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
/* loaded from: classes5.dex */
public class qi0 implements ui0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ti0 f;
    public final wi0 g;
    public final xi0 h;

    public qi0() {
        wi0 wi0Var;
        xi0 xi0Var;
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
        this.f = mi0.c().a();
        synchronized (mi0.class) {
            wi0Var = (wi0) ServiceManager.getService(wi0.b);
            wi0Var = wi0Var == null ? wi0.c : wi0Var;
        }
        this.g = wi0Var;
        synchronized (mi0.class) {
            xi0Var = (xi0) ServiceManager.getService(xi0.d);
            xi0Var = xi0Var == null ? xi0.e : xi0Var;
        }
        this.h = xi0Var;
    }

    @Override // com.baidu.tieba.ti0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f.a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f.b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.c() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f.d() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f.e() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f.f() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f.g() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f.h() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi0
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h.i() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi0
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h.j() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f.k() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wi0
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g.l() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f.m() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f.n() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f.o() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f.p() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String packageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f.packageName() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f.q() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f.r() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi0
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h.s() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    @NonNull
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f.t() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f.u() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi0
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.h.v() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi0
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h.w() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f.x() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti0
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f.y() : invokeV.booleanValue;
    }
}
