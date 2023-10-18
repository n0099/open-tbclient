package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes9.dex */
public final class zo extends dm implements bp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bn d;
    public final dn e;
    public final hn f;
    public final kn g;
    public final fn h;
    public final an i;
    public final gn j;
    public final cp k;
    public final kp l;

    public zo(bn bnVar, dn dnVar, hn hnVar, kn knVar, fn fnVar, an anVar, gn gnVar, cp cpVar, kp kpVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bnVar, dnVar, hnVar, knVar, fnVar, anVar, gnVar, cpVar, kpVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = bnVar;
        this.e = dnVar;
        this.f = hnVar;
        this.g = knVar;
        this.h = fnVar;
        this.i = anVar;
        this.j = gnVar;
        this.k = cpVar;
        this.l = kpVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zo(bn bnVar, dn dnVar, hn hnVar, kn knVar, fn fnVar, an anVar, gn gnVar, cp cpVar, kp kpVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bnVar, dnVar, hnVar, knVar, fnVar, anVar, gnVar, r10, r11);
        dp dpVar;
        mp mpVar;
        if ((i & 128) != 0) {
            dpVar = new dp();
        } else {
            dpVar = cpVar;
        }
        if ((i & 256) != 0) {
            mpVar = new mp();
        } else {
            mpVar = kpVar;
        }
    }

    @Override // com.baidu.tieba.cm
    public gn a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (gn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm
    public hn b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (hn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm
    public an c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (an) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bp
    public cp d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (cp) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm
    public kn e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (kn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bp
    public kp f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (kp) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm
    public dn g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (dn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm
    public bn h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (bn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm
    public fn i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (fn) invokeV.objValue;
    }
}
