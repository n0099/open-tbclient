package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes6.dex */
public final class ru extends vr implements tu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ts d;
    public final vs e;
    public final zs f;
    public final ct g;
    public final xs h;
    public final ss i;
    public final ys j;
    public final uu k;
    public final cv l;

    public ru(ts tsVar, vs vsVar, zs zsVar, ct ctVar, xs xsVar, ss ssVar, ys ysVar, uu uuVar, cv cvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tsVar, vsVar, zsVar, ctVar, xsVar, ssVar, ysVar, uuVar, cvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = tsVar;
        this.e = vsVar;
        this.f = zsVar;
        this.g = ctVar;
        this.h = xsVar;
        this.i = ssVar;
        this.j = ysVar;
        this.k = uuVar;
        this.l = cvVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ru(ts tsVar, vs vsVar, zs zsVar, ct ctVar, xs xsVar, ss ssVar, ys ysVar, uu uuVar, cv cvVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tsVar, vsVar, zsVar, ctVar, xsVar, ssVar, ysVar, r10, r11);
        vu vuVar;
        ev evVar;
        if ((i & 128) != 0) {
            vuVar = new vu();
        } else {
            vuVar = uuVar;
        }
        if ((i & 256) != 0) {
            evVar = new ev();
        } else {
            evVar = cvVar;
        }
    }

    @Override // com.baidu.tieba.ur
    public ys a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ys) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ur
    public zs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (zs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ur
    public ss c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (ss) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tu
    public uu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (uu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ur
    public ct e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ct) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tu
    public cv f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (cv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ur
    public vs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (vs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ur
    public ts h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (ts) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ur
    public xs i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (xs) invokeV.objValue;
    }
}
