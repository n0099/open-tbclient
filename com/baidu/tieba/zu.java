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
public final class zu extends ds implements bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bt d;
    public final dt e;
    public final ht f;
    public final kt g;
    public final ft h;
    public final at i;
    public final gt j;
    public final cv k;
    public final kv l;

    public zu(bt btVar, dt dtVar, ht htVar, kt ktVar, ft ftVar, at atVar, gt gtVar, cv cvVar, kv kvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {btVar, dtVar, htVar, ktVar, ftVar, atVar, gtVar, cvVar, kvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = btVar;
        this.e = dtVar;
        this.f = htVar;
        this.g = ktVar;
        this.h = ftVar;
        this.i = atVar;
        this.j = gtVar;
        this.k = cvVar;
        this.l = kvVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zu(bt btVar, dt dtVar, ht htVar, kt ktVar, ft ftVar, at atVar, gt gtVar, cv cvVar, kv kvVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(btVar, dtVar, htVar, ktVar, ftVar, atVar, gtVar, r10, r11);
        dv dvVar;
        mv mvVar;
        if ((i & 128) != 0) {
            dvVar = new dv();
        } else {
            dvVar = cvVar;
        }
        if ((i & 256) != 0) {
            mvVar = new mv();
        } else {
            mvVar = kvVar;
        }
    }

    @Override // com.baidu.tieba.cs
    public gt a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (gt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs
    public ht b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ht) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs
    public at c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (at) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bv
    public cv d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (cv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs
    public kt e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (kt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bv
    public kv f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (kv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs
    public dt g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (dt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs
    public bt h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (bt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs
    public ft i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (ft) invokeV.objValue;
    }
}
