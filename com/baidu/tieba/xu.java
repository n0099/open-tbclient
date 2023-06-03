package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes8.dex */
public final class xu extends bs implements zu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zs d;
    public final bt e;
    public final ft f;
    public final it g;
    public final dt h;
    public final ys i;
    public final et j;
    public final av k;
    public final iv l;

    public xu(zs zsVar, bt btVar, ft ftVar, it itVar, dt dtVar, ys ysVar, et etVar, av avVar, iv ivVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zsVar, btVar, ftVar, itVar, dtVar, ysVar, etVar, avVar, ivVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = zsVar;
        this.e = btVar;
        this.f = ftVar;
        this.g = itVar;
        this.h = dtVar;
        this.i = ysVar;
        this.j = etVar;
        this.k = avVar;
        this.l = ivVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ xu(zs zsVar, bt btVar, ft ftVar, it itVar, dt dtVar, ys ysVar, et etVar, av avVar, iv ivVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(zsVar, btVar, ftVar, itVar, dtVar, ysVar, etVar, r10, r11);
        bv bvVar;
        kv kvVar;
        if ((i & 128) != 0) {
            bvVar = new bv();
        } else {
            bvVar = avVar;
        }
        if ((i & 256) != 0) {
            kvVar = new kv();
        } else {
            kvVar = ivVar;
        }
    }

    @Override // com.baidu.tieba.as
    public et a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (et) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public ft b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ft) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public ys c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (ys) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zu
    public av d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (av) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public it e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (it) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zu
    public iv f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (iv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public bt g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (bt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public zs h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (zs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public dt i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (dt) invokeV.objValue;
    }
}
